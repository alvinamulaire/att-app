package com.att.service.impl;

import com.att.domain.sn.SnRequest;
import com.att.domain.sn.SnResponse;
import com.att.repository.SnSerialNumberRepository;
import com.att.repository.entity.ZSfcSnRelation;
import com.att.service.AttPrintService;
import com.att.service.SnSerialNumberService;
import com.businessobjects.visualization.internal.org.json.JSONException;
import com.fw.mes.me.controller.activity.ActivityRepo;
import com.fw.mes.me.controller.customFields.CustomFieldsRepo;
import com.fw.mes.me.controller.item.ItemRepo;
import com.fw.mes.me.controller.sequence.SequenceRepo;
import com.fw.mes.me.controller.sfc.SfcRepo;
import com.fw.mes.me.domain.print.PrintRequest;
import com.fw.mes.me.entity.ActivityOption;
import com.fw.mes.me.entity.CustomFields;
import com.fw.mes.me.entity.Sfc;
import com.fw.mes.me.entity.ViewItemDesc;
import com.fw.mes.me.sevice.PrintService;
import com.fw.mes.me.sevice.RestService;
import com.fw.mes.util.DateUtil;
import com.fw.mes.util.FwUtils;
import com.sap.me.demand.SFCBOHandle;
import com.sap.me.demand.ShopOrderBOHandle;
import com.sap.me.productdefinition.ItemBOHandle;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SnSerialNumberServiceImpl implements SnSerialNumberService {

    @Autowired
    private SfcRepo sfcRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private CustomFieldsRepo customFieldsRepo;

    @Autowired
    private SequenceRepo sequenceRepo;

    @Autowired
    private SnSerialNumberRepository snSerialNumberRepository;

    @Autowired
    private PrintService printService;

    @Autowired
    private AttPrintService attPrintService;

    @Autowired
    private ActivityRepo activityRepo;

    @Override
    public SnResponse getSfcSnInfo( SnRequest snRequest ) {
        String site = snRequest.getSite();
        String sfc = snRequest.getSfc();
        String locale = snRequest.getLan().toLowerCase();

        Sfc sfcInfo = sfcRepo.findSfc(new SFCBOHandle(site, sfc).getValue());

        if (FwUtils.objIsEmpty(sfcInfo)) {
            FwUtils.getCustomException("sn.error1");
        }

        String item = new ItemBOHandle(sfcInfo.getItemBo()).getItem();
        ViewItemDesc itemInfo = itemRepo.findByItem(site, item, locale);

        SnResponse snResponse = new SnResponse();
        snResponse.setSfc(sfc);
        snResponse.setItem(item);
        snResponse.setItemDesc(itemInfo.getDescription());
        snResponse.setSfcQty(sfcInfo.getQty());

        return snResponse;
    }

    @Transactional
    @Override
    public void saveSn( SnRequest snRequest ) {
        ZSfcSnRelation zSfcSnRelation = new ZSfcSnRelation();
        zSfcSnRelation.setSid(FwUtils.getUid());
        zSfcSnRelation.setSite(snRequest.getSite());
        zSfcSnRelation.setSfc(snRequest.getSfc());
        zSfcSnRelation.setSn(snRequest.getSn());
        zSfcSnRelation.setSnType(snRequest.getSnType());
        zSfcSnRelation.setCreatedDateTime(DateUtil.getGmtTime());
        zSfcSnRelation.setCreatedUser(snRequest.getUser());
        zSfcSnRelation.setNewSn(snRequest.getNewSn());
        snSerialNumberRepository.saveSn(zSfcSnRelation);
    }


    @Override
    public SnResponse getTlSnInfo(SnRequest snRequest) {
        String site = snRequest.getSite();
        String sfc = snRequest.getSfc();
        String locale = snRequest.getLan().toLowerCase();

        Sfc sfcInfo = sfcRepo.findSfc(new SFCBOHandle(site, sfc).getValue());

        if (FwUtils.objIsEmpty(sfcInfo)) {
            FwUtils.getCustomException("sn.error1");
        }

        String item = new ItemBOHandle(sfcInfo.getItemBo()).getItem();
        ViewItemDesc itemInfo = itemRepo.findByItem(site, item, locale);

        CustomFields snType = customFieldsRepo.findCustomFields(sfcInfo.getShopOrderBo(),"SN_TYPE");

        SnResponse snResponse = new SnResponse();
        snResponse.setSfc(sfc);
        snResponse.setItem(item);
        snResponse.setItemDesc(itemInfo.getDescription());
        snResponse.setSfcQty(sfcInfo.getQty());
        snResponse.setShopOrder(new ShopOrderBOHandle(sfcInfo.getShopOrderBo()).getShopOrder());
        snResponse.setSnType(FwUtils.objIsEmpty(snType) ? "" : snType.getValue());
        return snResponse;
    }

    @Override
    @Transactional
    public List<String> createSn(SnRequest snRequest) throws JSONException {
        //焊接碼
        snRequest.setSnType("1");
        List<String> response = new ArrayList<>();
        SnResponse snResponse = getTlSnInfo(snRequest);

        //確認是否產生過焊接碼
        ZSfcSnRelation selectWhere = new ZSfcSnRelation();
        selectWhere.setSite(snRequest.getSite());
        selectWhere.setSfc(snRequest.getSfc());
        selectWhere.setSnType(snRequest.getSnType());
        if(!FwUtils.isEmpty(snSerialNumberRepository.getSnRelation(selectWhere))){
            FwUtils.getCustomException("tl.sn.error1",new Object[]{snRequest.getSfc()});
        }

        //確認標籤機
        String printerName = "";
        ActivityOption printerOption = activityRepo.findOption(snRequest.getActivity(),"PRINTER_NAME");
        if(!FwUtils.objIsEmpty(printerOption)&&!FwUtils.isNullOrEmpty(printerOption.getSetting())){
            printerName = printerOption.getSetting();
        }else {
            FwUtils.getCustomException("tl.sn.error2");
        }

        if(FwUtils.isNullOrEmpty(snResponse.getSnType())){
            FwUtils.getCustomException("tl.sn.error4");
        }

        String yyyy = DateUtil.dateToString(new Date(),"yyyy");
        String prefix = snResponse.getSnType() + DateUtil.dateToString(new Date(),"MM");
        String seqName = "TL" + snRequest.getSite() + prefix + yyyy;
        if(FwUtils.isEmpty(sequenceRepo.findSeq(seqName))){
            sequenceRepo.createSeq(seqName, "99999");
        }

        for (int i=0 ; i<snResponse.getSfcQty().intValue() ; i++){
            String nextVal = sequenceRepo.seqNextVal(seqName).stripTrailingZeros().toPlainString();
            String sn = prefix + "00000".substring(nextVal.length()) + nextVal;
            response.add(sn);
            snRequest.setSn(sn);
            saveSn(snRequest);
        }

        attPrintService.printTLSn(snRequest.getSite(), snRequest.getSfc(), printerName,"1", snRequest.getUser(), response);

        return response;
    }
}
