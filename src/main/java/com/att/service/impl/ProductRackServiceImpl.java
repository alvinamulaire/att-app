package com.att.service.impl;

import com.att.converent.ProductRackConverter;
import com.att.domain.productRack.ProductRackRequest;
import com.att.domain.productRack.ProductRackResponse;
import com.att.repository.ProductRackRepository;
import com.att.repository.entity.ZMaterialShelfState;
import com.att.repository.entity.ZMaterialShelfStateLog;
import com.att.service.ProductRackService;
import com.fw.mes.me.controller.operation.OperationRepo;
import com.fw.mes.me.controller.resource.ResourceRepo;
import com.fw.mes.me.controller.sfc.SfcRepo;
import com.fw.mes.me.entity.Resrce;
import com.fw.mes.me.entity.Sfc;
import com.fw.mes.me.entity.ViewOperationDesc;
import com.fw.mes.me.entity.ViewSfcRoutingStep;
import com.fw.mes.util.DateUtil;
import com.fw.mes.util.FwUtils;
import com.sap.me.demand.SFCBOHandle;
import com.sap.me.productdefinition.OperationBOHandle;
import com.sap.me.status.StatusBOHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductRackServiceImpl implements ProductRackService {

    @Autowired
    private SfcRepo sfcRepo;

    @Autowired
    private OperationRepo operationRepo;

    @Autowired
    private ResourceRepo resourceRepo;

    @Autowired
    private ProductRackRepository productRackRepository;

    @Override
    public ProductRackResponse productRetrieval( ProductRackRequest productRackRequest ) {
        String site = productRackRequest.getSite();
        String locale = productRackRequest.getLan().toLowerCase();
        String sfc = productRackRequest.getSfc();
        String sfcBo = new SFCBOHandle(site, sfc).getValue();
        String operation = productRackRequest.getOperation();
        String resource = productRackRequest.getResource();

        Sfc sfcInfo = sfcRepo.findSfc(sfcBo);
        if (FwUtils.objIsEmpty(sfcInfo)) {
            FwUtils.getCustomException("product.error1");
        }
        String status = new StatusBOHandle(sfcInfo.getStatusBo()).getStatus();

        if (!status.equals("403")) {
            FwUtils.getCustomException("product.error2");
        }

        BigDecimal qtyInWork = BigDecimal.ZERO;
        List<ViewSfcRoutingStep> sfcSteps = sfcRepo.getSfcStepGreaterThanZero(site, sfc);
        if (!FwUtils.isEmpty(sfcSteps)) {
            // 取出當站數量
            sfcSteps = sfcSteps.stream()
                    .filter(f -> {
                        String inOperation = new OperationBOHandle(f.getOperationBo()).getOperation();
                        return operation.equals(inOperation);
                    })
                    .collect(Collectors.toList());

            if (FwUtils.isEmpty(sfcSteps)) {
                FwUtils.getCustomException("product.error3");
            }

            qtyInWork = sfcSteps.get(0).getQtyInWork();
            if (qtyInWork.compareTo(BigDecimal.ZERO) == 0) {
                FwUtils.getCustomException("product.error3");
            }
        }

        // 作業站描述
        List<ViewOperationDesc> operationList = operationRepo.findByCurrentRevision(site, operation, locale);

        String operationDesc = "";
        if (!FwUtils.isEmpty(operationList)) {
            operationDesc = operationList.get(0).getDescription();
        }

        // 資源描述
        List<Resrce> resrceList = resourceRepo.findById(site, resource);

        String resourceDesc = "";
        if (!FwUtils.isEmpty(resrceList)) {
            resourceDesc = resrceList.get(0).getDescription();
        }

        // 查詢料架
        ZMaterialShelfState zMaterialShelfState = new ZMaterialShelfState();
        zMaterialShelfState.setSite(site);
        zMaterialShelfState.setSfc(sfc);
        List<ZMaterialShelfState> shelfList = productRackRepository.getShelf(zMaterialShelfState);

        BigDecimal rackQty = BigDecimal.ZERO;
        if (!FwUtils.isEmpty(shelfList)) {
            rackQty = shelfList.stream()
                    .map(ZMaterialShelfState::getQty)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        ProductRackResponse productRackResponse = ProductRackConverter.INSTANCE.reqToRes(productRackRequest);
        productRackResponse.setSfcQty(qtyInWork);
        productRackResponse.setOperationDesc(operationDesc);
        productRackResponse.setResourceDesc(resourceDesc);
        productRackResponse.setShelfList(shelfList);
        productRackResponse.setRackQty(rackQty);

        return productRackResponse;
    }

    @Transactional
    @Override
    public void already( ProductRackRequest productRackRequest ) {
        String site = productRackRequest.getSite();
        String user = productRackRequest.getUser();
        String sfc = productRackRequest.getSfc();
        String operation = productRackRequest.getOperation();
        String resource = productRackRequest.getResource();
        String rack = productRackRequest.getRack();
        BigDecimal rackQty = productRackRequest.getRackQty();

        ZMaterialShelfState zMaterialShelfState = new ZMaterialShelfState();
        zMaterialShelfState.setSite(site);
        zMaterialShelfState.setShelfNo(rack);
        List<ZMaterialShelfState> shelfStates = productRackRepository.getShelf(zMaterialShelfState);
        if (!FwUtils.isEmpty(shelfStates)) {
            FwUtils.getCustomException("product.error4", new Object[]{ rack, shelfStates.get(0).getSfc() });
        }

        zMaterialShelfState.setSid(FwUtils.getUid());
        zMaterialShelfState.setSfc(sfc);
        zMaterialShelfState.setOperation(operation);
        zMaterialShelfState.setResource(resource);
        zMaterialShelfState.setQty(rackQty);
        zMaterialShelfState.setPutonUser(user);
        zMaterialShelfState.setPutonDateTime(DateUtil.getGmtTime());
        productRackRepository.insertShelf(zMaterialShelfState);
    }

    @Transactional
    @Override
    public void goOff( List<ProductRackRequest> productRackRequest ) {
        for (ProductRackRequest request : productRackRequest) {
            String site = request.getSite();
            String user = request.getUser();
            String rack = request.getRack();

            ZMaterialShelfState zMaterialShelfState = new ZMaterialShelfState();
            zMaterialShelfState.setSite(site);
            zMaterialShelfState.setShelfNo(rack);
            List<ZMaterialShelfState> shelfStates = productRackRepository.getShelf(zMaterialShelfState);
            String sid = shelfStates.get(0).getSid();

            ZMaterialShelfStateLog log = ProductRackConverter.INSTANCE.stateToLog(shelfStates.get(0));
            log.setTakeoffUser(user);
            log.setTakeoffDateTime(DateUtil.getGmtTime());

            productRackRepository.deleteShelf(sid);
            productRackRepository.insertShelfLog(log);
        }
    }
}
