package com.att.service.impl;

import com.att.converent.PackagingConverter;
import com.att.domain.inpsec.InspecJobResultInfo;
import com.att.domain.packaging.*;
import com.att.domain.print.PrintInfo;
import com.att.repository.InspecRepository;
import com.att.repository.PackagingProductRepository;
import com.att.repository.PackagingRepository;
import com.att.repository.ShippingReportRepository;
import com.att.repository.entity.*;
import com.att.service.AttPrintService;
import com.att.service.PackagingService;
import com.businessobjects.visualization.internal.org.json.JSONException;
import com.fw.mes.me.controller.activity.ActivityRepo;
import com.fw.mes.me.controller.bom.BomRepo;
import com.fw.mes.me.controller.container.FwContainerRepo;
import com.fw.mes.me.controller.customFields.CustomFieldsRepo;
import com.fw.mes.me.controller.dcGroup.FwDcGroupRepo;
import com.fw.mes.me.controller.item.ItemRepo;
import com.fw.mes.me.controller.sequence.SequenceRepo;
import com.fw.mes.me.controller.sfc.SfcRepo;
import com.fw.mes.me.domain.container.ContainerInfo;
import com.fw.mes.me.entity.*;
import com.fw.mes.util.DateUtil;
import com.fw.mes.util.FwUtils;
import com.sap.me.demand.SFCBOHandle;
import com.sap.me.demand.ShopOrderBOHandle;
import com.sap.me.plant.ResourceBOHandle;
import com.sap.me.productdefinition.ItemBOHandle;
import com.sap.me.productdefinition.OperationBOHandle;
import com.sap.me.status.StatusBOHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class PackagingServiceImpl implements PackagingService {

    @Autowired
    private FwContainerRepo fwContainerRepo;

    @Autowired
    private PackagingRepository packagingRepository;

    @Autowired
    private SequenceRepo sequenceRepo;

    @Autowired
    private SfcRepo sfcRepo;

    @Autowired
    private CustomFieldsRepo customFieldsRepo;

    @Autowired
    private FwDcGroupRepo fwDcGroupRepo;

    @Autowired
    private AttPrintService attPrintService;

    @Autowired
    private ActivityRepo activityRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private BomRepo bomRepo;

    @Autowired
    private PackagingProductRepository packagingProductRepository;

    @Autowired
    private InspecRepository inspecRepository;

    @Autowired
    private ShippingReportRepository shippingReportRepository;

    @Override
    public List<ViewContainerPackingLevel> getContainer( ContainerInfo containerInfo ) {
        return fwContainerRepo.getContainerPackingLevelSeqZero(containerInfo);
    }

    @Transactional
    @Override
    public ZPackMaster createNewNumber( PackagingRequest packagingRequest ) {
        String site = packagingRequest.getSite();
        String user = packagingRequest.getUser();
        String container = packagingRequest.getContainerName();
        String type = packagingRequest.getContainerType();
        String yymmdd = DateUtil.dateToString(new Date(), "yyMMdd");
        String seqKey = "";
        String printName = packagingRequest.getPrintName();
        String printLabel = "";

        if (type.equals("C")) {
            seqKey = getCartonSeqKey(site, container, yymmdd);
        } else if (type.equals("P")) {
            // 檢查標籤
            ActivityOption activityOption = activityRepo.findOption(packagingRequest.getActivity(), "PALLET_LABEL");
            if (FwUtils.objIsEmpty(activityOption)) {
                FwUtils.getCustomException("packaging.error13");
            }

            if (FwUtils.isNullOrEmpty(activityOption.getSetting())) {
                FwUtils.getCustomException("packaging.error13");
            }

            printLabel = activityOption.getSetting();
            seqKey = getPalletSeqKey(site, container, yymmdd);
        }

        if (FwUtils.isEmpty(sequenceRepo.findSeq(seqKey))) {
            sequenceRepo.createSeq(seqKey, "9999");
        }

        int number = sequenceRepo.seqNextVal(seqKey).intValue();
        String key = getNo(container, yymmdd, number);

        ZPackMaster zPackMaster = new ZPackMaster();
        zPackMaster.setSid(FwUtils.getUid());
        zPackMaster.setSite(site);
        zPackMaster.setContainerName(container);
        zPackMaster.setContainerNo(key);
        zPackMaster.setContainerType(type);
        zPackMaster.setMaxQty(packagingRequest.getMaxQty());
        zPackMaster.setStatus("0");
        zPackMaster.setCreatedDateTime(DateUtil.getGmtTime());
        zPackMaster.setCreatedUser(user);

        packagingRepository.insertPackMaster(zPackMaster);

        if (type.equals("P")) {
            // 列印棧板標籤
            PrintInfo printInfo = new PrintInfo();
            printInfo.setSite(site);
            printInfo.setUser(user);
            printInfo.setPrintName(printName);
            printInfo.setPrintLabel(printLabel);
            printInfo.setPrintType("1");
            printInfo.setPallets(Collections.singletonList(key));
            try {
                attPrintService.printPallet(printInfo);
            } catch (JSONException e) {
            }
        }

        return zPackMaster;
    }

    @Override
    public PackagingResponse retrieve( PackagingRequest packagingRequest ) {
        String site = packagingRequest.getSite();
        String key = packagingRequest.getContainerNo();
        String type = packagingRequest.getContainerType();
        String prefix = packagingRequest.getPrefix();
        String locale = packagingRequest.getLan().toLowerCase();

        PackagingMaster master = this.getMasterInfo(site, key, type);
        List<PackagingDetail> details = this.getPackagingDetail(site, master.getSid(), type, locale);

        List<String> prefixList = new ArrayList<>();
        List<String> suffixList = new ArrayList<>();
        if ("Y".equals(prefix)) {
            if (!FwUtils.isEmpty(details)) {
                if (type.equals("C")) {
                    List<String> snList = details.stream()
                            .map(ZPackDetail::getSn)
                            .collect(Collectors.toList());
                    prefixList = this.getPrefixOrSuffixList(snList, "prefix");
                    suffixList = this.getPrefixOrSuffixList(snList, "suffix");
                } else {
                    List<String> cartonList = details.stream()
                            .map(ZPackDetail::getCartonNo)
                            .collect(Collectors.toList());

                    List<String> allSnList = this.getAllCartonSn(site, cartonList);
                    prefixList = this.getPrefixOrSuffixList(allSnList, "prefix");
                    suffixList = this.getPrefixOrSuffixList(allSnList, "suffix");
                }
            }
        }

        PackagingResponse packagingResponse = new PackagingResponse();
        packagingResponse.setMaster(master);
        packagingResponse.setDetail(details);
        // 已裝箱數
        packagingResponse.setPackedQty(details.size());
        packagingResponse.setPrefixList(prefixList);
        packagingResponse.setSuffixList(suffixList);

        return packagingResponse;
    }

    @Transactional
    @Override
    public void updateMaster( PackagingRequest packagingRequest ) {
        PackagingResponse response = this.retrieve(packagingRequest);

        ZPackMaster zPackMaster = new ZPackMaster();
        zPackMaster.setSid(response.getMaster().getSid());

        if (!FwUtils.isNullOrEmpty(packagingRequest.getStatus())) {
            zPackMaster.setStatus(packagingRequest.getStatus());
        }

        if (!FwUtils.objIsEmpty(packagingRequest.getWeight())) {
            zPackMaster.setWeight(packagingRequest.getWeight());
        }

        if (!FwUtils.isNullOrEmpty(packagingRequest.getShippingDate())) {
            zPackMaster.setShippingDate(packagingRequest.getShippingDate());
        }

        zPackMaster.setModifiedUser(packagingRequest.getUser());
        zPackMaster.setModifiedDateTime(DateUtil.getGmtTime());

        packagingRepository.updatePackMaster(zPackMaster);
    }

    @Override
    public PackagingResponse scanSfc( PackagingRequest packagingRequest ) {
        String site = packagingRequest.getSite();
        String sfc = packagingRequest.getSfc();
        String operation = packagingRequest.getOperation();
        String container = packagingRequest.getContainerName();
        packagingRequest.setContainerType("C");

        Sfc sfcInfo = sfcRepo.findById(site, sfc);

        if (FwUtils.objIsEmpty(sfcInfo)) {
            FwUtils.getCustomException("packaging.error3");
        }

        List<ViewSfcRoutingStep> sfcSteps = sfcRepo.getSfcStepInWork(site, sfc);
        if (FwUtils.isEmpty(sfcSteps)) {
            FwUtils.getCustomException("packaging.error5");
        }

        String sfcOperation = new OperationBOHandle(sfcSteps.get(0).getOperationBo()).getOperation();
        if (!operation.equals(sfcOperation)) {
            FwUtils.getCustomException("packaging.error4", new Object[]{ sfcOperation });
        }

        ContainerInfo containerInfo = new ContainerInfo();
        containerInfo.setSite(site);
        containerInfo.setName(container);
        List<ViewContainerPackingLevel> packingLevels = this.getContainer(containerInfo);
        String targetItem = packingLevels.get(0).getPackingLevelValue();

        if (!"*".equals(targetItem)) {
            String sfcItem = new ItemBOHandle(sfcInfo.getItemBo()).getItem();
            if (!sfcItem.equals(targetItem)) {
                FwUtils.getCustomException("packaging.error6");
            }
        }

        PackagingResponse packagingResponse = this.retrieve(packagingRequest);
        PackagingMaster master = packagingResponse.getMaster();

        List<PackagingDetail> details = packagingResponse.getDetail();
        if (!FwUtils.isEmpty(details)) {
            Sfc detailSfcInfo = sfcRepo.findById(site, details.get(0).getSfc());

            if (!sfcInfo.getShopOrderBo().equals(detailSfcInfo.getShopOrderBo())) {
                FwUtils.getCustomException("packaging.error7");
            }
        }

        PackagingResponse response = new PackagingResponse();
        // 此SFC已包裝數
        response.setSfcPackedQty(this.getSfcDetailCnt(site, sfc));
        // SFC數
        response.setSfcQty(sfcInfo.getQty().intValue());
        // 已裝箱數
        response.setPackedQty(details.size());
        response.setMaster(master);
        response.setDetail(details);

        return response;
    }

    @Transactional
    @Override
    public PackagingResponse scanSn( PackagingRequest packagingRequest ) {
        String site = packagingRequest.getSite();
        String user = packagingRequest.getUser();
        String key = packagingRequest.getContainerNo();
        String sfc = packagingRequest.getSfc();
        String resource = packagingRequest.getResource();
        String sn = packagingRequest.getSn();
        String batchNo = packagingRequest.getBatchNo();
        String prefix = packagingRequest.getPrefix();
        String locale = packagingRequest.getLan().toLowerCase();

        PackagingResponse res = this.scanSfc(packagingRequest);
        PackagingMaster master = res.getMaster();
        String masterId = master.getSid();
        List<PackagingDetail> details = res.getDetail();

        // 檢查裝箱數
        if (master.getMaxQty().intValue() <= details.size()) {
            FwUtils.getCustomException("packaging.error23");
        }

        Sfc sfcInfo = sfcRepo.findById(site, sfc);
        int sfcPackedQty = this.getSfcDetailCnt(site, sfc);

        // 檢查SFC已包裝數
        if (sfcInfo.getQty().intValue() <= sfcPackedQty) {
            FwUtils.getCustomException("packaging.error24");
        }

        // 檢查SFC是否合規
        String item = new ItemBOHandle(sfcInfo.getItemBo()).getItem();

        ZVwInspecItemDetail zVwInspecItemDetail = new ZVwInspecItemDetail();
        zVwInspecItemDetail.setSite(site);
        zVwInspecItemDetail.setItem(item);
        List<ZVwInspecItemDetail> inspecItemList = packagingProductRepository.getPackInspecDetail(zVwInspecItemDetail);

        if (!FwUtils.isEmpty(inspecItemList)) {
            inspecItemList.forEach(obj -> {
                String qcItem = obj.getQcItem();
                String qcItemSid = obj.getQcItemSid();

                // 找舊SN
                ZSfcSnRelation sfcSnRelation = new ZSfcSnRelation();
                sfcSnRelation.setSite(site);
                sfcSnRelation.setNewSn(sn);
                List<ZSfcSnRelation> snRelationList = shippingReportRepository.getSn(sfcSnRelation);

                String oldSn = "";
                if (!FwUtils.isEmpty(snRelationList)) {
                    oldSn = snRelationList.get(0).getSn();
                }
                List<String> snList = new ArrayList<>();
                snList.add(sn);
                if (!FwUtils.isNullOrEmpty(oldSn)) {
                    snList.add(oldSn);
                }

                // 檢查檢驗結果
                InspecJobResultInfo inspecJobResultInfo = new InspecJobResultInfo();
                inspecJobResultInfo.setSite(site);
                inspecJobResultInfo.setSnList(snList);
                inspecJobResultInfo.setQcItemSid(qcItemSid);
                List<ZVwQmsInspecJobResult> inspecJobResultList = inspecRepository.getInspecDetail(inspecJobResultInfo);

                if (FwUtils.isEmpty(inspecJobResultList)) {
                    FwUtils.getCustomException("packaging.error35", new Object[]{ qcItem });
                }

                // 取得最後一次的檢驗單
                ZVwQmsInspecJobResult jobResult = inspecJobResultList.get(0);
                String itemType = jobResult.getItemType();

                // 依照檢驗時間最大的JOB_DETAIL_BO重檢索取得SN檢驗結果
                ZVwQmsInspecJobResult zVwQmsInspecJobResult = new ZVwQmsInspecJobResult();
                zVwQmsInspecJobResult.setSite(site);
                zVwQmsInspecJobResult.setHandle(jobResult.getHandle());
                zVwQmsInspecJobResult.setSn(jobResult.getSn());
                inspecJobResultList = inspecRepository.getInspecDetail(zVwQmsInspecJobResult);

                // 檢查是否合格
                BigDecimal max = null;
                BigDecimal min = null;
                AtomicBoolean fail = new AtomicBoolean(false);
                AtomicReference<String> type = new AtomicReference<>("0");
                for (ZVwQmsInspecJobResult result : inspecJobResultList) {
                    BigDecimal inspecResult = result.getInspecResult();

                    if (FwUtils.objIsEmpty(inspecResult)) {
                        fail.set(true);
                        type.set("1");
                        break;
                    }

                    if ("0".equals(itemType)) {
                        // 計數
                        if (BigDecimal.ONE.compareTo(inspecResult) != 0) {
                            fail.set(true);
                            break;
                        }
                    } else if ("1".equals(itemType)) {
                        // 計量
                        max = jobResult.getMaxValue();
                        min = jobResult.getMinValue();

                        if ((!FwUtils.objIsEmpty(min) && min.compareTo(inspecResult) > 0) ||
                                (!FwUtils.objIsEmpty(max) && max.compareTo(inspecResult) < 0)) {
                            fail.set(true);
                            break;
                        }
                    }
                }

                if (fail.get()) {
                    String result = "";
                    if ("0".equals(type.get())) {
                        result = "NG";
                    }

                    if ("0".equals(itemType)) {
                        // 計數
                        FwUtils.getCustomException("packaging.error36", new Object[]{ qcItem, result });
                    } else if ("1".equals(itemType)) {
                        // 計量
                        if (!FwUtils.objIsEmpty(max) && !FwUtils.objIsEmpty(min)) {
                            // 上下限
                            FwUtils.getCustomException("packaging.error37", new Object[]{ qcItem, max, min, result });
                        } else {
                            if (!FwUtils.objIsEmpty(max) && FwUtils.objIsEmpty(min)) {
                                // 僅上限
                                FwUtils.getCustomException("packaging.error38", new Object[]{ qcItem, max, result });
                            } else if (FwUtils.objIsEmpty(max) && !FwUtils.objIsEmpty(min)) {
                                // 僅下限
                                FwUtils.getCustomException("packaging.error39", new Object[]{ qcItem, min, result });
                            }
                        }
                    }
                }
            });
        }

        // 檢查前後綴
        List<String> prefixList = new ArrayList<>();
        List<String> suffixList = new ArrayList<>();
        if ("Y".equals(prefix)) {
            if (sn.length() < 5) {
                FwUtils.getCustomException("packaging.error31");
            }

            String prefixSn = this.getPrefix(sn);
            String suffixSn = this.getSuffix(sn);
            if (!FwUtils.isEmpty(details)) {
                List<String> snList = details.stream()
                        .map(ZPackDetail::getSn)
                        .collect(Collectors.toList());

                prefixList = this.getPrefixOrSuffixList(snList, "prefix");
                int preSize = prefixList.size();

                if (preSize == 1) {
                    // 前綴檢查
                    if (!prefixList.get(0).equals(prefixSn)) {
                        FwUtils.getCustomException("packaging.error26");
                    }
                } else if (preSize > 1) {
                    FwUtils.getCustomException("packaging.error32");
                }

                // 後綴檢查
                suffixList = this.getPrefixOrSuffixList(snList, "suffix");
                if (suffixList.size() > 1) {
                    FwUtils.getCustomException("packaging.error33");
                }

                suffixList.forEach(suf -> {
                    if (!suf.equals(suffixSn)) {
                        FwUtils.getCustomException("packaging.error25");
                    }
                });
            } else {
                prefixList.add(prefixSn);
                suffixList.add(suffixSn);
            }
        }

        // 檢查庫存
        ZVwInventoryAssyData zVwInventoryAssyData = new ZVwInventoryAssyData();
        zVwInventoryAssyData.setSite(site);
        zVwInventoryAssyData.setResourceLocBo(new ResourceBOHandle(site, resource).getValue());
        zVwInventoryAssyData.setDataAttr(batchNo);
        List<ZVwInventoryAssyData> inventory = packagingRepository.getBatchInv(zVwInventoryAssyData);
        if (FwUtils.isEmpty(inventory)) {
            FwUtils.getCustomException("packaging.error8", new Object[]{ batchNo });
        }

        BigDecimal totalInHand = inventory.stream()
                .map(ZVwInventoryAssyData::getQtyOnHand)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        if (totalInHand.compareTo(BigDecimal.ZERO) <= 0) {
            FwUtils.getCustomException("packaging.error9", new Object[]{ batchNo });
        }

        // 檢查SFC BOM元件
        List<ZVwInventoryAssyData> distinctItemInv = inventory.stream()
                .filter(FwUtils.distinctByKey(ZVwInventoryAssyData::getItemBo))
                .collect(Collectors.toList());
        String invItem = new ItemBOHandle(distinctItemInv.get(0).getItemBo()).getItem();

        ViewSfcBomComponent viewSfcBomComponent = new ViewSfcBomComponent();
        viewSfcBomComponent.setSfcBo(sfcInfo.getHandle());
        viewSfcBomComponent.setComponentGbo(invItem);
        if (FwUtils.isEmpty(bomRepo.findBomComponentBySfcBo(viewSfcBomComponent))) {
            FwUtils.getCustomException("packaging.error10", new Object[]{ batchNo });
        }

        // 檢查SFC&SN
        ZPackDetail zPackDetail = new ZPackDetail();
        zPackDetail.setSite(site);
        zPackDetail.setSfc(sfc);
        zPackDetail.setSn(sn);
        List<ZPackDetail> snDetails = packagingRepository.getPackDetail(zPackDetail);
        if (!FwUtils.isEmpty(snDetails)) {
            String bindCarton = snDetails.get(0).getCartonNo();
            FwUtils.getCustomException("packaging.error11", new Object[]{ sfc, sn, bindCarton });
        }

        // 寫入箱內
        zPackDetail.setMasterSid(masterId);
        zPackDetail.setSid(FwUtils.getUid());
        zPackDetail.setBatchNo(batchNo);
        zPackDetail.setCreatedUser(user);
        zPackDetail.setCreatedDateTime(DateUtil.getGmtTime());
        packagingRepository.insertPackDetail(zPackDetail);

        PackagingResponse response = new PackagingResponse();
        // 此SFC已包裝數
        response.setSfcPackedQty(this.getSfcDetailCnt(site, sfc));
        // SFC數
        response.setSfcQty(sfcInfo.getQty().intValue());
        response.setMaster(master);
        // 取得新明細
        List<PackagingDetail> newDetails = this.getPackagingDetail(site, masterId, "C", locale);
        response.setDetail(newDetails);
        // 已裝箱數
        response.setPackedQty(newDetails.size());
        // 前後綴
        response.setPrefixList(prefixList);
        response.setSuffixList(suffixList);

        return response;
    }

    @Transactional
    @Override
    public PackagingResponse deleteDetail( PackagingRequest packagingRequest ) {
        String site = packagingRequest.getSite();
        String user = packagingRequest.getUser();
        String type = packagingRequest.getContainerType();
        String key = packagingRequest.getContainerNo();
        String prefix = packagingRequest.getPrefix();
        String locale = packagingRequest.getLan().toLowerCase();
        String sfcRequest = packagingRequest.getSfc();

        PackagingMaster master = this.getMasterInfo(site, key, type);
        String masterId = master.getSid();

        // 刪除SN或箱號
        for (PackagingDetail packagingDetail : packagingRequest.getDetailInfoList()) {
            String sfc = packagingDetail.getSfc();
            String sn = packagingDetail.getSn();
            String carton = packagingDetail.getCartonNo();

            ZPackDetail zPackDetail = new ZPackDetail();
            zPackDetail.setSite(site);
            zPackDetail.setMasterSid(masterId);
            if (type.equals("C")) {
                zPackDetail.setSfc(sfc);
                zPackDetail.setSn(sn);
            } else {
                zPackDetail.setCartonNo(carton);
            }
            ZPackDetail oriDetail = packagingRepository.getPackDetail(zPackDetail).get(0);
            packagingRepository.deletePackDetail(zPackDetail);

            // 紀錄Log
            ZPackDetailLog zPackDetailLog = PackagingConverter.INSTANCE.detailToLog(oriDetail);
            zPackDetailLog.setUnboxingDateTime(DateUtil.getGmtTime());
            zPackDetailLog.setUnboxingUser(user);
            packagingRepository.insertPackDetailLog(zPackDetailLog);
        }

        // 取得新明細
        List<PackagingDetail> newDetails = this.getPackagingDetail(site, masterId, type, locale);

        List<String> list = new ArrayList<>();
        if ("Y".equals(prefix)) {
            if (!FwUtils.isEmpty(newDetails)) {
                if (type.equals("C")) {
                    list = newDetails.stream()
                            .map(ZPackDetail::getSn)
                            .collect(Collectors.toList());
                } else {
                    List<String> cartonList = newDetails.stream()
                            .map(ZPackDetail::getCartonNo)
                            .collect(Collectors.toList());

                    list = this.getAllCartonSn(site, cartonList);
                }
            }
        }

        PackagingResponse response = new PackagingResponse();
        // 已裝箱數
        response.setPackedQty(newDetails.size());
        response.setMaster(master);
        response.setDetail(newDetails);
        response.setPrefixList(this.getPrefixOrSuffixList(list, "prefix"));
        response.setSuffixList(this.getPrefixOrSuffixList(list, "suffix"));

        if (!FwUtils.isNullOrEmpty(sfcRequest)) {
            Sfc sfcInfo = sfcRepo.findById(site, sfcRequest);
            // 此SFC已包裝數
            response.setSfcPackedQty(this.getSfcDetailCnt(site, sfcRequest));
            // SFC數
            response.setSfcQty(sfcInfo.getQty().intValue());
        }

        return response;
    }

    @Override
    public boolean preCompleteCarton( PackagingRequest packagingRequest ) {
        String site = packagingRequest.getSite();
        packagingRequest.setContainerType("C");

        PackagingResponse res = this.retrieve(packagingRequest);
        PackagingMaster master = res.getMaster();
        List<PackagingDetail> details = res.getDetail();

        // 沒有內容物，不可完成
        if (FwUtils.isEmpty(details)) {
            FwUtils.getCustomException("packaging.error14");
        }

        String sfc = details.get(0).getSfc();
        Sfc sfcInfo = sfcRepo.findById(site, sfc);

        String itemBO = sfcInfo.getItemBo();
        CustomFields customFields = customFieldsRepo.findCustomFields(itemBO, "CARTON_LABEL");

        if (FwUtils.objIsEmpty(customFields)) {
            FwUtils.getCustomException("packaging.error12");
        }

        if (FwUtils.isNullOrEmpty(customFields.getValue())) {
            FwUtils.getCustomException("packaging.error12");
        }

        int cnt = details.size();
        int max = master.getMaxQty().intValue();
        return cnt < max;
    }

    @Transactional
    @Override
    public void completeCarton( PackagingRequest packagingRequest ) {
        String site = packagingRequest.getSite();
        String user = packagingRequest.getUser();
        String key = packagingRequest.getContainerNo();
        boolean isMantissa = packagingRequest.isMantissa();

        // 列印資訊
        PrintInfo printInfo = new PrintInfo();
        printInfo.setSite(site);
        printInfo.setUser(user);
        printInfo.setPrintName(packagingRequest.getPrintName());
        printInfo.setPrintType("1");
        printInfo.setCarton(key);

        PackagingMaster master = this.getMasterInfo(site, key, "C");
        String masterId = master.getSid();

        List<ZPackDetail> details = packagingRepository.getPackDetail(masterId);

        List<String> batchList = details.stream()
                .map(ZPackDetail::getBatchNo).distinct()
                .collect(Collectors.toList());

        Map<String, String> mfDateMap = this.getParameterList(site, "ZB_MFDATE", batchList);
        Map<String, String> expDateMap = this.getParameterList(site, "ZB_EXPDATE", batchList);

        List<BatchDcInfo> batchDcInfoList = batchList.stream()
                .map(batch -> {
                    BatchDcInfo batchDcInfo = new BatchDcInfo();
                    if (!mfDateMap.isEmpty()) {
                        String mfValue = mfDateMap.get(batch);
                        if (!FwUtils.isNullOrEmpty(mfValue)) {
                            batchDcInfo.setMfDate(mfValue);
                        }
                    }

                    if (!expDateMap.isEmpty()) {
                        String expValue = expDateMap.get(batch);
                        if (!FwUtils.isNullOrEmpty(expValue)) {
                            batchDcInfo.setExpDate(expValue);
                        }
                    }
                    return batchDcInfo;
                })
                .sorted(Comparator.comparing(BatchDcInfo::getMfDate,
                                             Comparator.nullsFirst(Comparator.naturalOrder())).reversed())
                .collect(Collectors.toList());

        for (int i = 0; i < 3; i++) {
            String mf = null;
            String exp = null;

            if (i < batchDcInfoList.size()) {
                mf = batchDcInfoList.get(i).getMfDate();
                exp = batchDcInfoList.get(i).getExpDate();
            }

            if (mf != null && mf.length() >= 6) {
                mf = mf.substring(2, 6);
            }

            if (exp != null && exp.length() >= 6) {
                exp = exp.substring(2, 6);
            }

            // MFG1~3 & EXP1~3
            switch (i) {
                case 0:
                    master.setDmxMfg1(mf);
                    printInfo.setDmxDate1(mf);
                    master.setDmxExp1(exp);
                    printInfo.setDmxExpDate1(exp);
                    break;
                case 1:
                    master.setDmxMfg2(mf);
                    printInfo.setDmxDate2(mf);
                    master.setDmxExp2(exp);
                    printInfo.setDmxExpDate2(exp);
                    break;
                case 2:
                    master.setDmxMfg3(mf);
                    printInfo.setDmxDate3(mf);
                    master.setDmxExp3(exp);
                    printInfo.setDmxExpDate3(exp);
                    break;
            }
        }

        String sfc = details.get(0).getSfc();
        Sfc sfcInfo = sfcRepo.findById(site, sfc);
        String shopOrderBo = sfcInfo.getShopOrderBo();
        String shopOrder = new ShopOrderBOHandle(shopOrderBo).getShopOrder();
        String item = new ItemBOHandle(sfcInfo.getItemBo()).getItem();
        List<CustomFields> customFields = customFieldsRepo.findCustomFields(sfcInfo.getItemBo());

        // 更新狀態為1
        master.setStatus("1");
        // 製造日期
        Date now = new Date();
        String mfgDate = DateUtil.dateToString(now, "yyyy/MM/dd");
        master.setMfgDate(mfgDate);
        printInfo.setMfgDate(mfgDate);
        // 保存期限
        List<CustomFields> packExpDates = customFields.stream()
                .filter(f -> "PACK_EXP_DATE".equals(f.getAttribute()))
                .collect(Collectors.toList());

        String expDate;
        if (!FwUtils.isEmpty(packExpDates)) {
            String days = packExpDates.get(0).getValue();
            if (!FwUtils.isNullOrEmpty(days) && FwUtils.isNumeric(days)) {
                expDate = DateUtil.dateToString(DateUtil.addDay(now, Integer.parseInt(days)), "yyyy/MM/dd");
                master.setExpDate(expDate);
                printInfo.setExpDate(expDate);
            }
        }

        if (isMantissa) {
            // 尾數箱
            master.setIsMantissa("Y");
            printInfo.setIsMantissa("Y");
        }

        Date gmt = DateUtil.getGmtTime();
        master.setModifiedDateTime(gmt);
        master.setModifiedUser(user);
        master.setCloseDateTime(gmt);
        master.setCloseUser(user);
        packagingRepository.updatePackMaster(master);

        // 列印
        List<CustomFields> cartonLabels = customFields.stream()
                .filter(f -> "CARTON_LABEL".equals(f.getAttribute()))
                .collect(Collectors.toList());
        printInfo.setPrintLabel(cartonLabels.get(0).getValue());
        printInfo.setItem(item);
        printInfo.setShopOrder(shopOrder);

        CustomFields partRev = customFieldsRepo.findCustomFields(shopOrderBo, "PART_REV");
        if (!FwUtils.objIsEmpty(partRev) && !FwUtils.isNullOrEmpty(partRev.getValue())) {
            printInfo.setRev(partRev.getValue());
        }

        try {
            attPrintService.printCarton(printInfo);
        } catch (JSONException e) {
        }
    }

    @Override
    public PackagingResponse scanCarton( PackagingRequest packagingRequest ) {
        String site = packagingRequest.getSite();
        String user = packagingRequest.getUser();
        String key = packagingRequest.getContainerNo();
        String carton = packagingRequest.getCartonNo();
        String operation = packagingRequest.getOperation();
        String prefix = packagingRequest.getPrefix();
        String locale = packagingRequest.getLan().toLowerCase();

        // 棧板
        packagingRequest.setContainerType("P");
        PackagingResponse res = this.retrieve(packagingRequest);
        PackagingMaster master = res.getMaster();
        String masterId = master.getSid();
        List<PackagingDetail> details = res.getDetail();

        // 檢查裝棧數
        if (master.getMaxQty().intValue() == details.size()) {
            FwUtils.getCustomException("packaging.error20");
        }

        // 檢查箱號
        ZPackMaster cartonMasterInfo = this.getMasterInfo(site, carton, "C");

        String cartonStatus = cartonMasterInfo.getStatus();
        if (!cartonStatus.equals("1")) {
            FwUtils.getCustomException("packaging.error16");
        }

        // 檢查箱號是否已裝棧板
        ZPackDetail packDetail = new ZPackDetail();
        packDetail.setSite(site);
        packDetail.setCartonNo(carton);
        if (!FwUtils.isEmpty(packagingRepository.getPackDetail(packDetail))) {
            FwUtils.getCustomException("packaging.error30");
        }

        String cartonMasterId = cartonMasterInfo.getSid();
        List<ZPackDetail> cartonDetails = packagingRepository.getPackDetail(cartonMasterId);
        List<String> snList = cartonDetails.stream()
                .map(ZPackDetail::getSn)
                .collect(Collectors.toList());

        // 檢查SFC
        List<String> sfcList = cartonDetails.stream()
                .map(ZPackDetail::getSfc)
                .distinct()
                .collect(Collectors.toList());

        sfcList.forEach(sfc -> {
            List<ViewSfcRoutingStep> sfcSteps = sfcRepo.getSfcStepInWork(site, sfc);
            if (FwUtils.isEmpty(sfcSteps)) {
                FwUtils.getCustomException("packaging.error18", new Object[]{ sfc });
            }

            String sfcOperation = new OperationBOHandle(sfcSteps.get(0).getOperationBo()).getOperation();
            if (!sfcOperation.equals(operation)) {
                FwUtils.getCustomException("packaging.error17", new Object[]{ sfc, sfcOperation });
            }
        });

        List<String> preSnList = new ArrayList<>();
        List<String> sufSnList = new ArrayList<>();
        List<String> prefixList = new ArrayList<>();
        List<String> suffixList = new ArrayList<>();
        if (!FwUtils.isEmpty(details)) {
            // 檢查容器&物料
            ZPackMaster targetCartonInfo = this.getMasterInfo(site, details.get(0).getCartonNo(), "C");
            List<ZPackDetail> targetCartonDetail = packagingRepository.getPackDetail(targetCartonInfo.getSid());

            if (!targetCartonInfo.getContainerName().equals(cartonMasterInfo.getContainerName())) {
                FwUtils.getCustomException("packaging.error19");
            }

            Sfc targetSfc = sfcRepo.findById(site, targetCartonDetail.get(0).getSfc());
            Sfc sfcInfo = sfcRepo.findById(site, sfcList.get(0));

            if (!targetSfc.getItemBo().equals(sfcInfo.getItemBo())) {
                FwUtils.getCustomException("packaging.error21");
            }

            if ("Y".equals(prefix)) {
                snList.forEach(sn -> {
                    // 檢查碼數
                    if (sn.length() < 5) {
                        FwUtils.getCustomException("packaging.error31");
                    }
                });

                // 前後綴
                preSnList = this.getPrefixOrSuffixList(snList, "prefix");
                sufSnList = this.getPrefixOrSuffixList(snList, "suffix");

                // 檢查前後綴
                List<String> cartonList = details.stream()
                        .map(ZPackDetail::getCartonNo)
                        .collect(Collectors.toList());
                List<String> targetSnList = this.getAllCartonSn(site, cartonList);
                prefixList = this.getPrefixOrSuffixList(targetSnList, "prefix");
                suffixList = this.getPrefixOrSuffixList(targetSnList, "suffix");

                int prefixSize = prefixList.size();
                int preSnSize = preSnList.size();
                if (prefixSize == 1) {
                    // 只有一組
                    if (preSnSize > 1) {
                        // 刷入箱號有兩個前綴
                        if (!preSnList.contains(prefixList.get(0))) {
                            // 兩個前綴不包含在原本規則
                            FwUtils.getCustomException("packaging.error29");
                        } else {
                            // 在規則內加入新前綴(或不增加)
                            for (String pre : preSnList) {
                                if (!pre.equals(prefixList.get(0))) {
                                    prefixList.add(pre);
                                }
                            }
                        }
                    } else {
                        if (!prefixList.get(0).equals(preSnList.get(0))) {
                            prefixList.addAll(preSnList);
                        }
                    }
                } else if (prefixSize == 2) {
                    // 一組以上
                    if (preSnSize == 1) {
                        if (!prefixList.contains(preSnList.get(0))) {
                            FwUtils.getCustomException("packaging.error28");
                        }
                    } else {
                        if (!prefixList.equals(preSnList)) {
                            FwUtils.getCustomException("packaging.error28");
                        }
                    }
                } else if (prefixSize >= 3) {
                    FwUtils.getCustomException("packaging.error29");
                }

                if (suffixList.size() > 1) {
                    FwUtils.getCustomException("packaging.error34");
                }

                if (!suffixList.equals(sufSnList)) {
                    FwUtils.getCustomException("packaging.error27");
                }
            }
        } else {
            prefixList = preSnList;
            suffixList = sufSnList;
        }

        ZPackDetail zPackDetail = new ZPackDetail();
        zPackDetail.setSid(FwUtils.getUid());
        zPackDetail.setSite(site);
        zPackDetail.setCartonNo(carton);
        zPackDetail.setMasterSid(masterId);
        zPackDetail.setCreatedDateTime(DateUtil.getGmtTime());
        zPackDetail.setCreatedUser(user);
        packagingRepository.insertPackDetail(zPackDetail);

        List<PackagingDetail> newDetails = this.getPackagingDetail(site, masterId, "P", locale);

        PackagingResponse response = new PackagingResponse();
        response.setMaster(master);
        response.setDetail(newDetails);
        response.setPackedQty(newDetails.size());
        response.setPrefixList(prefixList);
        response.setSuffixList(suffixList);

        return response;
    }

    @Override
    public boolean preCompletePallet( PackagingRequest packagingRequest ) {
        packagingRequest.setContainerType("P");
        PackagingResponse res = this.retrieve(packagingRequest);
        PackagingMaster master = res.getMaster();
        List<PackagingDetail> details = res.getDetail();

        if (FwUtils.isEmpty(details)) {
            FwUtils.getCustomException("packaging.error22");
        }

        return master.getMaxQty().intValue() > details.size();
    }

    @Override
    public void completePallet( PackagingRequest packagingRequest ) {
        String site = packagingRequest.getSite();
        String user = packagingRequest.getUser();
        String key = packagingRequest.getContainerNo();
        boolean isMantissa = packagingRequest.isMantissa();

        ZPackMaster zPackMaster = this.getMasterInfo(site, key, "P");
        zPackMaster.setStatus("1");
        zPackMaster.setCloseDateTime(DateUtil.getGmtTime());
        zPackMaster.setCloseUser(user);
        zPackMaster.setModifiedDateTime(DateUtil.getGmtTime());
        zPackMaster.setModifiedUser(user);
        if (isMantissa) {
            zPackMaster.setIsMantissa("Y");
        }

        packagingRepository.updatePackMaster(zPackMaster);
    }

    @Override
    public ViewContainerPackingLevel getContainerInfo( ContainerInfo containerInfo ) {
        ContainerInfo c = new ContainerInfo();
        c.setSite(containerInfo.getSite());
        c.setName(containerInfo.getName());
        List<Container> containers = fwContainerRepo.getContainer(c);

        if (FwUtils.isEmpty(containers)) {
            FwUtils.getCustomException("packaging.error40");
        }

        String handle = containers.get(0).getHandle();
        String status = new StatusBOHandle(containers.get(0).getStatusBo()).getStatus();

        if (!"201".equals(status)) {
            FwUtils.getCustomException("packaging.error41");
        }

        CustomFields customFields = customFieldsRepo.findCustomFields(handle, "CONTAINER_TYPE");

        if (FwUtils.objIsEmpty(customFields) || !"C".equals(customFields.getValue())) {
            FwUtils.getCustomException("packaging.error42");
        }

        return fwContainerRepo.getContainerPackingLevelSeqZero(containerInfo).get(0);
    }

    private Map<String, String> getParameterList( String site, String measureName, List<String> batchList ) {
        // 取得DC
        List<DcGroup> dcGroups = fwDcGroupRepo.getDcGroup(site, "PRODUCT_DATE");
        String dcGroupBo = dcGroups.get(0).getHandle();

        Map<String, String> map = new HashMap<>();
        for (String batch : batchList) {
            String sfcBo = new SFCBOHandle(site, batch).getValue();

            ViewParametricMeasure parameterMF = new ViewParametricMeasure();
            parameterMF.setDcGroupBo(dcGroupBo);
            parameterMF.setParaContextGbo(sfcBo);
            parameterMF.setMeasureName(measureName);
            List<ViewParametricMeasure> measures = fwDcGroupRepo.getParametricMeasure(parameterMF);
            if (!FwUtils.isEmpty(measures)) {
                String value = measures.get(0).getActual();
                if (!FwUtils.isNullOrEmpty(value)) {
                    map.put(batch, value);
                }
            }
        }

        return map;
    }

    private String getCartonSeqKey( String site, String container, String yymmdd ) {
        return "CARTON" + site + container + yymmdd;
    }

    private String getPalletSeqKey( String site, String container, String yymmdd ) {
        return "PALLET" + site + container + yymmdd;
    }

    private String getNo( String container, String yymmdd, int number ) {
        return container + yymmdd + "-" + String.format("%04d", number);
    }

    private ZPackMaster setMaster( String site, String containerNo, String containerType ) {
        ZPackMaster zPackMaster = new ZPackMaster();
        zPackMaster.setSite(site);
        zPackMaster.setContainerNo(containerNo);
        zPackMaster.setContainerType(containerType);
        return zPackMaster;
    }

    private PackagingMaster getMasterInfo( String site, String containerNo, String containerType ) {
        ZPackMaster zPackMaster = packagingRepository.getPackMaster(this.setMaster(site, containerNo, containerType));

        if (FwUtils.objIsEmpty(zPackMaster)) {
            if (containerType.equals("C")) {
                FwUtils.getCustomException("packaging.error1");
            } else {
                FwUtils.getCustomException("packaging.error2");
            }
        }

        PackagingMaster master = PackagingConverter.INSTANCE.daoToMaster(zPackMaster);

        ContainerInfo containerInfo = new ContainerInfo();
        containerInfo.setSite(site);
        containerInfo.setName(master.getContainerName());
        List<Container> containers = fwContainerRepo.getContainer(containerInfo);
        if (!FwUtils.isEmpty(containers)) {
            master.setContainerDesc(containers.get(0).getDescription());
        }
        return master;
    }

    private int getSfcDetailCnt( String site, String sfc ) {
        ZPackDetail packDetail = new ZPackDetail();
        packDetail.setSite(site);
        packDetail.setSfc(sfc);
        List<ZPackDetail> sfcDetails = packagingRepository.getPackDetail(packDetail);

        // 此SFC已包裝數
        return sfcDetails.size();
    }

    private List<PackagingDetail> getPackagingDetail( String site, String masterSid, String type, String locale ) {
        List<PackagingDetail> details = PackagingConverter.INSTANCE
                .daoToDomain(packagingRepository.getPackDetail(masterSid));

        String sfc = "";
        String item = "";
        String itemDesc = "";
        if (!FwUtils.isEmpty(details)) {
            if (type.equals("C")) {
                // 箱
                sfc = details.get(0).getSfc();
            } else {
                // 棧板
                String carton = details.get(0).getCartonNo();
                ZPackMaster cartonMaster = this.getMasterInfo(site, carton, "C");
                List<ZPackDetail> cartonDetail = packagingRepository.getPackDetail(cartonMaster.getSid());

                if (!FwUtils.isEmpty(cartonDetail)) {
                    sfc = cartonDetail.get(0).getSfc();
                }

                details = details.stream()
                        .peek(obj -> {
                            PackagingMaster cartonInfo = this.getMasterInfo(site, obj.getCartonNo(), "C");
                            obj.setCartonQty(packagingRepository.cntPackDetail(cartonInfo.getSid()));
                        })
                        .collect(Collectors.toList());
            }

            Sfc sfcInfo = sfcRepo.findById(site, sfc);
            item = new ItemBOHandle(sfcInfo.getItemBo()).getItem();

            ViewItemDesc viewItemDesc = itemRepo.findByItemCurrentVer(site, item, locale);
            if (!FwUtils.objIsEmpty(viewItemDesc)) {
                itemDesc = viewItemDesc.getDescription();
            }

            String finalItem = item;
            String finalItemDesc = itemDesc;
            details.forEach(obj -> {
                obj.setItem(finalItem);
                obj.setItemDesc(finalItemDesc);
            });
        }

        return details;
    }

    private String getPrefix( String number ) {
        return number.substring(0, 3);
    }

    private String getSuffix( String number ) {
        int length = number.length();
        return number.substring(length - 5, length);
    }

    private List<String> getPrefixOrSuffixList( List<String> list, String type ) {
        if ("prefix".equals(type)) {
            return list.stream()
                    .map(this::getPrefix)
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());
        }

        return list.stream()
                .map(this::getSuffix)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private List<String> getAllCartonSn( String site, List<String> cartonList ) {
        PackagingMaster packagingMaster = new PackagingMaster();
        packagingMaster.setSite(site);
        packagingMaster.setCartonList(cartonList);
        List<ZPackMaster> masterList = packagingRepository.getPackMaster(packagingMaster);

        List<String> masterIdList = masterList.stream()
                .map(ZPackMaster::getSid)
                .collect(Collectors.toList());

        return packagingRepository.getPackDetail(masterIdList).stream()
                .map(ZPackDetail::getSn)
                .collect(Collectors.toList());
    }
}
