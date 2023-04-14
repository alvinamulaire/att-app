package com.att.service.impl;

import com.att.domain.sfc.SfcDoneRequest;
import com.att.domain.sfc.SfcDoneResponse;
import com.att.domain.sfcDone.SfcDoneInfo;
import com.att.repository.SfcDoneRepository;
import com.att.repository.entity.ZVwSfcDone;
import com.att.service.SfcDoneService;
import com.fw.mes.me.controller.dcGroup.FwDcGroupRepo;
import com.fw.mes.me.controller.item.ItemRepo;
import com.fw.mes.me.controller.operation.OperationRepo;
import com.fw.mes.me.controller.resource.ResourceRepo;
import com.fw.mes.me.controller.sfc.SfcRepo;
import com.fw.mes.me.entity.*;
import com.fw.mes.util.FwUtils;
import com.sap.me.demand.SFCBOHandle;
import com.sap.me.extension.Services;
import com.sap.me.frame.domain.BusinessException;
import com.sap.me.plant.ResourceBOHandle;
import com.sap.me.productdefinition.ItemBOHandle;
import com.sap.me.productdefinition.OperationBOHandle;
import com.sap.me.production.CompleteSfcBasicRequest;
import com.sap.me.production.CompleteSfcBatchRequest;
import com.sap.me.production.SfcCompleteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SfcDoneServiceImpl implements SfcDoneService {

    @Autowired
    private SfcDoneRepository sfcDoneRepository;

    @Autowired
    private OperationRepo operationRepo;

    @Autowired
    private ResourceRepo resourceRepo;

    @Autowired
    private FwDcGroupRepo fwDcGroupRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private SfcRepo sfcRepo;

    @Override
    public SfcDoneResponse findSfcDoneList( SfcDoneRequest sfcDoneRequest, String locale ) {
        SfcDoneResponse response = new SfcDoneResponse();
        List<ViewOperationDesc> viewOperationDescList = operationRepo.findByCurrentRevision(sfcDoneRequest.getSite(), sfcDoneRequest.getOperation(), locale);
        if (!FwUtils.isEmpty(viewOperationDescList)) {
            response.setOperationDesc(viewOperationDescList.get(0).getDescription());
        }
        List<Resrce> resrceList = resourceRepo.findById(sfcDoneRequest.getSite(), sfcDoneRequest.getResource());
        if (!FwUtils.isEmpty(resrceList)) {
            response.setResourceDesc(resrceList.get(0).getDescription());
        }
        ZVwSfcDone zVwSfcDone = new ZVwSfcDone();
        zVwSfcDone.setSite(sfcDoneRequest.getSite());
        zVwSfcDone.setOperationBo(new OperationBOHandle(sfcDoneRequest.getSite(), sfcDoneRequest.getOperation(), "#").getValue());
        zVwSfcDone.setResourceBo(new ResourceBOHandle(sfcDoneRequest.getSite(), sfcDoneRequest.getResource()).getValue());
        for (String sfc : sfcDoneRequest.getSfcList()) {
            zVwSfcDone.setSfc(sfc);
            response.getzVwSfcDoneList().addAll(sfcDoneRepository.findSfcDoneInfo(zVwSfcDone, locale));
        }

        return response;
    }

    @Override
    public List<SfcDoneInfo> sfcDone( List<SfcDoneInfo> sfcDoneList ) {
        String site = sfcDoneList.get(0).getSite();
        try {
            SfcCompleteServiceInterface sfcCompleteService = Services.getService("com.sap.me.production", "SfcCompleteService", site);
            CompleteSfcBatchRequest sfcBatchRequest = new CompleteSfcBatchRequest();

            for (SfcDoneInfo sfcDone : sfcDoneList) {
                String sfc = sfcDone.getSfc();
                BigDecimal qty = sfcDone.getQty();
                BigDecimal inWorkQty = sfcDone.getQtyInWork();

                if (FwUtils.objIsEmpty(qty)) {
                    FwUtils.getCustomException("sfc.done.error1", new Object[]{ sfc });
                }

                if (qty.compareTo(inWorkQty) > 0) {
                    FwUtils.getCustomException("sfc.done.error2", new Object[]{ sfc });
                }

                if (qty.compareTo(BigDecimal.ZERO) == 0) {
                    FwUtils.getCustomException("sfc.done.error5", new Object[]{ sfc });
                }

                // 取得物料數量限制
                Sfc sfcInfo = sfcRepo.findById(site, sfc);
                String item = new ItemBOHandle(sfcInfo.getItemBo()).getItem();
                List<Item> items = itemRepo.findCurrentItem(site, item);
                String qtyRestriction = items.get(0).getQuantityRestriction();
                switch (qtyRestriction) {
                    case "O":
                        if (qty.compareTo(BigDecimal.ONE) != 0) {
                            FwUtils.getCustomException("sfc.done.error3", new Object[]{ sfc });
                        }
                        break;
                    case "W":
                        if (!FwUtils.isPositiveInt(qty.stripTrailingZeros().toPlainString())) {
                            FwUtils.getCustomException("sfc.done.error4", new Object[]{ sfc });
                        }
                        break;
                    default:
                        break;
                }

                CompleteSfcBasicRequest sfcBasicRequest = new CompleteSfcBasicRequest();
                String sfcBo = new SFCBOHandle(sfcDone.getSite(), sfcDone.getSfc()).getValue();
                sfcBasicRequest.setSfcRef(sfcBo);
                sfcBasicRequest.setOperationRef(sfcDone.getOperationBo());
                sfcBasicRequest.setResourceRef(sfcDone.getResourceBo());
                sfcBasicRequest.setQuantity(qty);
                sfcBatchRequest.getCompleteSfcList().add(sfcBasicRequest);
            }
            sfcCompleteService.completeSfcBatch(sfcBatchRequest);
        } catch (BusinessException e) {
            FwUtils.getMeException(e);
        }

        //檢索batch_number、product_rank
        sfcDoneList.forEach(x -> {
            ViewParametricMeasure batchNumberMeasure = new ViewParametricMeasure();
            batchNumberMeasure.setSite(site);
            batchNumberMeasure.setMeasureGroup("BATCH_NUMBER");
            batchNumberMeasure.setMeasureName("BATCH_NUMBER");
            batchNumberMeasure.setParaContextGbo(new SFCBOHandle(site, x.getSfc()).getValue());
            List<ViewParametricMeasure> batchNumberList = fwDcGroupRepo.getParametricMeasure(batchNumberMeasure);
            if (!FwUtils.isEmpty(batchNumberList)) {
                x.setBatchNumber(batchNumberList.get(0).getActual());
            }
            ViewParametricMeasure rankMeasure = new ViewParametricMeasure();
            rankMeasure.setSite(site);
            rankMeasure.setMeasureGroup("PRODUCT_RANK");
            rankMeasure.setMeasureName("RANK");
            rankMeasure.setParaContextGbo(new SFCBOHandle(site, x.getSfc()).getValue());
            List<ViewParametricMeasure> rankList = fwDcGroupRepo.getParametricMeasure(rankMeasure);
            if (!FwUtils.isEmpty(rankList)) {
                x.setProductRank(rankList.get(0).getActual());
            }
        });
        return sfcDoneList;
    }
}
