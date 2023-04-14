package com.att.service.impl;

import com.att.converent.PrintConverter;
import com.att.domain.packaging.PackagingMaster;
import com.att.domain.print.AttPrintRequest;
import com.att.domain.print.AttPrintResponse;
import com.att.domain.print.PrintInfo;
import com.att.repository.AttPrintRepository;
import com.att.repository.PackagingRepository;
import com.att.repository.SnSerialNumberRepository;
import com.att.repository.entity.*;
import com.att.service.AttPrintService;
import com.businessobjects.visualization.internal.org.json.JSONException;
import com.businessobjects.visualization.internal.org.json.JSONObject;
import com.fw.mes.me.controller.activity.ActivityRepo;
import com.fw.mes.me.controller.customFields.CustomFieldsRepo;
import com.fw.mes.me.controller.sfc.SfcRepo;
import com.fw.mes.me.controller.site.SiteRepo;
import com.fw.mes.me.domain.print.PrintRequest;
import com.fw.mes.me.entity.ActivityOption;
import com.fw.mes.me.entity.CustomFields;
import com.fw.mes.me.entity.Sfc;
import com.fw.mes.me.sevice.PrintService;
import com.fw.mes.util.DateUtil;
import com.fw.mes.util.FwUtils;
import com.sap.me.demand.SFCBOHandle;
import com.sap.me.demand.ShopOrderBOHandle;
import com.sap.me.productdefinition.ItemBOHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AttPrintServiceImpl implements AttPrintService {

    @Autowired
    private SfcRepo sfcRepo;

    @Autowired
    private CustomFieldsRepo customFieldsRepo;

    @Autowired
    private PrintService printService;

    @Autowired
    private AttPrintRepository attPrintRepository;

    @Autowired
    private SnSerialNumberRepository snSerialNumberRepository;

    @Autowired
    private PackagingRepository packagingRepository;

    @Autowired
    private ActivityRepo activityRepo;

    @Autowired
    private SiteRepo siteRepo;

    @Override
    public void printTLSn( String site, String sfc, String printerName, String printType, String user, List<String> tlSnList ) throws JSONException {

        Sfc sfcInfo = sfcRepo.findSfc(new SFCBOHandle(site, sfc).getValue());
        CustomFields productType = customFieldsRepo.findCustomFields(sfcInfo.getItemBo(), "PRODUCT_TYPE");
        CustomFields yellowCard = customFieldsRepo.findCustomFields(sfcInfo.getItemBo(), "YELLOW_CARD");

        if (FwUtils.objIsEmpty(yellowCard) || FwUtils.isNullOrEmpty(yellowCard.getValue())) {
            FwUtils.getCustomException("tl.sn.error3");
        }

        Date createDateTime = DateUtil.getGmtTime();

        PrintRequest printRequest = new PrintRequest();
        printRequest.setTransactionId(FwUtils.getUid());
        printRequest.setPrintName(printerName);
        printRequest.setTemplatePath(yellowCard.getValue());
        printRequest.setPrintType("BARTENDER");
        printRequest.setLabelQty(1);
        for (String sn : tlSnList) {
            PrintRequest printRequestLog = new PrintRequest();
            printRequestLog.setTransactionId(FwUtils.getUid());
            printRequestLog.setPrintName(printerName);
            printRequestLog.setTemplatePath(yellowCard.getValue());
            printRequestLog.setPrintType("BARTENDER");
            printRequestLog.setLabelQty(1);
            JSONObject data = new JSONObject();
            data.put("PRODUCT_TYPE", FwUtils.objIsEmpty(productType) ? "" : productType.getValue());
            data.put("SFC", sfc);
            data.put("TL_SN", sn);
            printRequest.getPrintData().put(data);
            printRequestLog.getPrintData().put(data);
            savePrintLog(site, "1", printType, sn, printRequestLog.toPrintJson().toString(), user, createDateTime);
        }

        printService.print("", site, printRequest);
    }

    @Override
    public void savePrintLog( String site, String labelType, String printType, String keyValue, String requestContent, String user, Date createDateTime ) {
        ZLabelPrintLog zLabelPrintLog = new ZLabelPrintLog();
        zLabelPrintLog.setSid(FwUtils.getUid());
        zLabelPrintLog.setSite(site);
        zLabelPrintLog.setLabelType(labelType);
        zLabelPrintLog.setPrintType(printType);
        zLabelPrintLog.setKeyValue(keyValue);
        zLabelPrintLog.setRequestContent(requestContent);
        zLabelPrintLog.setCreatedDateTime(createDateTime);
        zLabelPrintLog.setCreatedUser(user);
        attPrintRepository.insertPrintLog(zLabelPrintLog);
    }

    @Override
    public void print( List<AttPrintRequest> requestList ) throws JSONException {
        AttPrintRequest request = requestList.get(0);
        if (FwUtils.isNullOrEmpty(request.getLabelType())) {
            return;
        }
        switch (request.getLabelType()) {
            case "0":
                printTLSn(requestList);
                break;
            case "1":
                //箱號
                printCarton(requestList);
                break;
            case "2":
                //棧板號
                printPallet(requestList);
                break;
            default:
                break;
        }
    }

    private void printPallet( List<AttPrintRequest> requestList ) throws JSONException {
        String site = requestList.get(0).getSite();
        String user = requestList.get(0).getUser();
        String printer = requestList.get(0).getPrinter();
        String activity = requestList.get(0).getActivity();
        List<String> palletList = requestList.stream().map(AttPrintRequest::getPallet).collect(Collectors.toList());
        PrintInfo printInfo = new PrintInfo();
        printInfo.setSite(site);
        printInfo.setUser(user);
        printInfo.setPrintName(printer);
        printInfo.setPallets(palletList);
        printInfo.setActivity(activity);
        printInfo.setPrintType("2");
        printPallet(printInfo);
    }

    private void printCarton( List<AttPrintRequest> requestList ) throws JSONException {
        String site = requestList.get(0).getSite();
        String user = requestList.get(0).getUser();
        String printer = requestList.get(0).getPrinter();
        List<String> cartonList = requestList.stream().map(AttPrintRequest::getCarton).collect(Collectors.toList());
        PrintInfo printInfo = new PrintInfo();
        printInfo.setSite(site);
        printInfo.setUser(user);
        printInfo.setPrintName(printer);
        printInfo.setCartons(cartonList);
        printInfo.setPrintType("2");
        printCarton(printInfo);
    }

    private void printTLSn( List<AttPrintRequest> requestList ) throws JSONException {
        String site = requestList.get(0).getSite();
        String printer = requestList.get(0).getPrinter();
        String user = requestList.get(0).getUser();
        Map<String, List<AttPrintRequest>> requestMap = requestList.stream().collect(Collectors.groupingBy(AttPrintRequest::getSfc));
        for (String sfc : requestMap.keySet()) {
            printTLSn(site, sfc, printer, "2", user, requestMap.get(sfc).stream().map(AttPrintRequest::getTlSn).collect(Collectors.toList()));
        }
    }

    @Override
    public List<AttPrintResponse> printInfo( AttPrintRequest request, String locale ) {
        if (FwUtils.isNullOrEmpty(request.getLabelType())) {
            return new ArrayList<>();
        }
        switch (request.getLabelType()) {
            case "0":
                //焊接碼
                return printInfoByTlSn(request);
            case "1":
                //箱號
                return printInfoByCarton(request, locale);
            case "2":
                //棧板號
                return printInfoByPallet(request, locale);
            default:
                return Arrays.asList();
        }
    }

    private List<AttPrintResponse> printInfoByPallet( AttPrintRequest request, String locale ) {
        List<AttPrintResponse> responseList = new ArrayList<>();
        ZVwPackPallet zVwPackPallet = new ZVwPackPallet();
        zVwPackPallet.setSite(request.getSite());
        zVwPackPallet.setSfc(request.getSfc());
        zVwPackPallet.setShopOrder(request.getShopOrder());
        zVwPackPallet.setMasterContainerNo(request.getPallet());
        List<ZVwPackPallet> zVwPackPalletList = packagingRepository.findPackPallet(zVwPackPallet, locale);
        Map<String, List<ZVwPackPallet>> map = zVwPackPalletList.stream().collect(Collectors.groupingBy(ZVwPackPallet::getMasterContainerNo));
        for (String palletNo : map.keySet()) {
            AttPrintResponse response = new AttPrintResponse();
            response.setPallet(palletNo);
            response.setShopOrder(map.get(palletNo).get(0).getShopOrder());
            responseList.add(response);
        }
        return responseList;
    }

    private List<AttPrintResponse> printInfoByCarton( AttPrintRequest request, String locale ) {
        List<AttPrintResponse> responseList = new ArrayList<>();
        ZVwPackCarton zVwPackCarton = new ZVwPackCarton();
        zVwPackCarton.setSite(request.getSite());
        zVwPackCarton.setPalletContainerNo(request.getPallet());
        zVwPackCarton.setCartonContainerNo(request.getCarton());
        zVwPackCarton.setSfc(request.getSfc());
        zVwPackCarton.setShopOrder(request.getShopOrder());
        List<ZVwPackCarton> zVwPackCartonList = packagingRepository.findPackCarton(zVwPackCarton, locale);
        Map<String, List<ZVwPackCarton>> map = zVwPackCartonList.stream().collect(Collectors.groupingBy(ZVwPackCarton::getCartonContainerNo));
        for (String cartonNo : map.keySet()) {
            AttPrintResponse response = new AttPrintResponse();
            response.setCarton(cartonNo);
            response.setShopOrder(map.get(cartonNo).get(0).getShopOrder());
            response.setPallet(map.get(cartonNo).get(0).getPalletContainerNo());
            responseList.add(response);
        }
        return responseList;
    }

    private List<AttPrintResponse> printInfoByTlSn( AttPrintRequest request ) {
        ZVwSfcSnRelation zVwSfcSnRelation = new ZVwSfcSnRelation();
        zVwSfcSnRelation.setSite(request.getSite());
        zVwSfcSnRelation.setSfc(request.getSfc());
        zVwSfcSnRelation.setSn(request.getTlSn());
        zVwSfcSnRelation.setSnType("1");
        zVwSfcSnRelation.setShopOrder(request.getShopOrder());
        List<ZVwSfcSnRelation> zVwSfcSnRelationList = snSerialNumberRepository.findZVwSfcSnRelation(zVwSfcSnRelation);
        return zVwSfcSnRelationList.stream().map(PrintConverter.INSTANCE::toResponseByTlSn).collect(Collectors.toList());
    }

    @Override
    public void printCarton( PrintInfo printInfo ) throws JSONException {
        String site = printInfo.getSite();
        PrintRequest printRequest = new PrintRequest();
        printRequest.setTransactionId(FwUtils.getUid());
        printRequest.setPrintName(printInfo.getPrintName());
        printRequest.setTemplatePath(printInfo.getPrintLabel());
        printRequest.setPrintType("BARTENDER");
        printRequest.setLabelQty(1);

        if (!FwUtils.isEmpty(printInfo.getCartons())) {
            for (String carton : printInfo.getCartons()) {
                ZPackMaster master = new ZPackMaster();
                master.setSite(site);
                master.setContainerNo(carton);
                ZPackMaster masterInfo = packagingRepository.getPackMaster(master);
                List<ZPackDetail> details = packagingRepository.getPackDetail(masterInfo.getSid());

                Sfc sfcInfo = sfcRepo.findById(site, details.get(0).getSfc());

                ShopOrderBOHandle shopOrderHandle = new ShopOrderBOHandle(sfcInfo.getShopOrderBo());
                ItemBOHandle itemHandle = new ItemBOHandle(sfcInfo.getItemBo());

                // 取得標籤, 只需取得一次
                if (FwUtils.isNullOrEmpty(printRequest.getTemplatePath())) {
                    CustomFields customFields = customFieldsRepo.findCustomFields(itemHandle.getValue(), "CARTON_LABEL");
                    if (FwUtils.objIsEmpty(customFields)) {
                        FwUtils.getCustomException("packaging.error12");
                    }
                    printRequest.setTemplatePath(customFields.getValue());
                }

                // REV
                String rev = "";
                CustomFields partRev = customFieldsRepo.findCustomFields(shopOrderHandle.getValue(), "PART_REV");
                if (!FwUtils.objIsEmpty(partRev)) {
                    rev = partRev.getValue();
                }

                JSONObject data = this.cartonObject(itemHandle.getItem(), rev, masterInfo.getMfgDate(), shopOrderHandle.getShopOrder(),
                        masterInfo.getExpDate(), carton, masterInfo.getDmxMfg1(), masterInfo.getDmxMfg2(), masterInfo.getDmxMfg3(),
                        masterInfo.getDmxExp1(), masterInfo.getDmxExp2(), masterInfo.getDmxExp3(), masterInfo.getIsMantissa());

                printRequest.getPrintData().put(data);

                this.savePrintLog(site, "2", printInfo.getPrintType(),
                        carton, printRequest.toPrintJson().toString(), printInfo.getUser(), DateUtil.getGmtTime());
            }
        } else {
            JSONObject data = this.cartonObject(printInfo.getItem(), printInfo.getRev(), printInfo.getMfgDate(), printInfo.getShopOrder(),
                    printInfo.getExpDate(), printInfo.getCarton(), printInfo.getDmxDate1(), printInfo.getDmxDate2(), printInfo.getDmxDate3(),
                    printInfo.getDmxExpDate1(), printInfo.getDmxExpDate2(), printInfo.getDmxExpDate3(), printInfo.getIsMantissa());
            printRequest.getPrintData().put(data);

            this.savePrintLog(site, "2", printInfo.getPrintType(),
                    printInfo.getCarton(), printRequest.toPrintJson().toString(), printInfo.getUser(), DateUtil.getGmtTime());
        }

        printService.print("", site, printRequest);
    }

    @Override
    public void printPallet( PrintInfo printInfo ) throws JSONException {
        PrintRequest printRequest = new PrintRequest();
        printRequest.setTransactionId(FwUtils.getUid());
        printRequest.setPrintName(printInfo.getPrintName());
        if (!FwUtils.isNullOrEmpty(printInfo.getPrintLabel())) {
            printRequest.setTemplatePath(printInfo.getPrintLabel());
        } else {
            if (!FwUtils.isNullOrEmpty(printInfo.getActivity())) {
                ActivityOption activityOption = activityRepo.findOption(printInfo.getActivity(), "PALLET_LABEL");

                if (FwUtils.objIsEmpty(activityOption)) {
                    FwUtils.getCustomException("packaging.error13");
                }

                if (FwUtils.isNullOrEmpty(activityOption.getSetting())) {
                    FwUtils.getCustomException("packaging.error13");
                }
                printRequest.setTemplatePath(activityOption.getSetting());
            }
        }
        printRequest.setPrintType("BARTENDER");
        printRequest.setLabelQty(1);

        for (String pallet : printInfo.getPallets()) {
            JSONObject data = new JSONObject();
            data.put("PALLET", pallet);
            printRequest.getPrintData().put(data);

            this.savePrintLog(printInfo.getSite(), "3", printInfo.getPrintType(),
                    pallet, printRequest.toPrintJson().toString(), printInfo.getUser(), DateUtil.getGmtTime());
        }

        printService.print("", printInfo.getSite(), printRequest);
    }

    @Override
    public List<String> findContainNoList( PackagingMaster request ) {
        String timeZone = siteRepo.getTimeZone(request.getSite());
        List<ZPackMaster> masterList = packagingRepository.getPackMaster(request.getSite(), request.getContainerName(), DateUtil.toGmtDate(request.getCloseDateStart(), timeZone), DateUtil.toGmtDate(request.getCloseDateEnd(), timeZone));
        return masterList.stream().map(ZPackMaster::getContainerNo).collect(Collectors.toList());
    }

    private JSONObject cartonObject( String item, String rev, String mfgDate, String shopOrder, String expDate, String carton,
                                     String dmxMfgDate1, String dmxMfgDate2, String dmxMfgDate3,
                                     String dmxExpDate1, String dmxExpDate2, String dmxExpDate3,
                                     String mantissa ) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ITEM", item);
        jsonObject.put("REV", rev);
        jsonObject.put("MFG_DATE", mfgDate);
        jsonObject.put("SHOP_ORDER", shopOrder);
        jsonObject.put("EXPIRATION_DATE", expDate);
        jsonObject.put("CARTON", carton);
        jsonObject.put("DMX_DATE_1", dmxMfgDate1);
        jsonObject.put("DMX_DATE_2", dmxMfgDate2);
        jsonObject.put("DMX_DATE_3", dmxMfgDate3);
        jsonObject.put("DMX_EXPIRATION_DATE_1", dmxExpDate1);
        jsonObject.put("DMX_EXPIRATION_DATE_2", dmxExpDate2);
        jsonObject.put("DMX_EXPIRATION_DATE_3", dmxExpDate3);
        jsonObject.put("IS_MANTISSA", "Y".equals(mantissa) ? "YES" : "");

        return jsonObject;
    }
}
