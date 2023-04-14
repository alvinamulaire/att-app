package com.att.service.impl;

import com.att.domain.returnMaterial.ReturnInventoryInfo;
import com.att.domain.returnMaterial.ReturnMaterialInfo;
import com.att.domain.returnMaterial.ReturnMaterialRequest;
import com.att.repository.ReturnMaterialRepository;
import com.att.repository.entity.*;
import com.att.service.ReturnMaterialService;
import com.fw.mes.me.controller.activity.ActivityRepo;
import com.fw.mes.me.controller.reasonCode.FwReasonCodeRepo;
import com.fw.mes.me.entity.ActivityOption;
import com.fw.mes.me.entity.ReasonCode;
import com.fw.mes.util.FwUtils;
import com.sap.me.common.ObjectReference;
import com.sap.me.demand.ShopOrderBOHandle;
import com.sap.me.extension.Services;
import com.sap.me.frame.domain.BusinessException;
import com.sap.me.inventory.InventoryServiceInterface;
import com.sap.me.inventory.InventoryValidateAndUpdateRequest;
import com.sap.me.plant.ResourceBOHandle;
import com.sap.me.plant.StorageLocationBOHandle;
import com.sap.me.productdefinition.ItemBOHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReturnMaterialServiceImpl implements ReturnMaterialService {

    @Autowired
    private ReturnMaterialRepository returnMaterialRepository;

    @Autowired
    private ActivityRepo activityRepo;

    @Autowired
    private FwReasonCodeRepo fwReasonCodeRepo;

    @Override
    public List<ReturnMaterialInfo> findReturnMaterialList( ReturnMaterialInfo returnMaterialInfo ) {
        String local = returnMaterialInfo.getLan().toLowerCase();
        List<ZVwReturnMaterial> viewReturnMaterialList = returnMaterialRepository.findViewReturnMaterial(returnMaterialInfo, local);
        return viewReturnMaterialList.stream()
                .map(viewReturnMaterial -> {
                    ReturnMaterialInfo info = new ReturnMaterialInfo();
                    info.setItem(viewReturnMaterial.getItem());
                    info.setItemRevision(viewReturnMaterial.getItemRevision());
                    info.setItemDesc(viewReturnMaterial.getItemDesc());
                    if (!FwUtils.isNullOrEmpty(viewReturnMaterial.getShopOrderLocBo())) {
                        info.setShopOrder(new ShopOrderBOHandle(viewReturnMaterial.getShopOrderLocBo()).getShopOrder());
                    }
                    info.setOriginalQty(viewReturnMaterial.getOriginalQty());
                    info.setQtyOnHand(viewReturnMaterial.getQtyOnHand());
                    info.setBatchNumber(viewReturnMaterial.getBatchNumber());
                    info.setMch1Lifnr(viewReturnMaterial.getMch1Lifnr());
                    info.setVendorLot(viewReturnMaterial.getVendorLot());
                    info.setMatDocNum(viewReturnMaterial.getMatDocNum());
                    info.setZbMfdate(viewReturnMaterial.getZbMfdate());
                    info.setZbExpdate(viewReturnMaterial.getZbExpdate());
                    info.setCentralStorageLocation(viewReturnMaterial.getCentralStorageLocation());
                    if (!FwUtils.isNullOrEmpty(viewReturnMaterial.getStorageLocationBo())) {
                        info.setStorage(new StorageLocationBOHandle(viewReturnMaterial.getStorageLocationBo()).getStorageLocation());
                    }
                    info.setInventoryId(viewReturnMaterial.getInventoryId());
                    info.setInventoryBo(viewReturnMaterial.getInventoryBo());
                    if (!FwUtils.isNullOrEmpty(viewReturnMaterial.getResourceLocBo())) {
                        info.setResource(new ResourceBOHandle(viewReturnMaterial.getResourceLocBo()).getResource());
                    }
                    return info;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ZVwInventoryItem> findItemByReturnMaterial( String site, String item, String local ) {
        return returnMaterialRepository.findItemByReturnMaterial(site, item, local);
    }

    @Override
    public List<ReturnMaterialInfo> findShopOrderByReturnMaterial( String site, String shopOrder, String local ) {
        List<ZVwInventoryShopOrder> list = returnMaterialRepository.findShopOrderByReturnMaterial(site, shopOrder, local);
        return list.stream()
                .map(obj -> {
                    ReturnMaterialInfo returnMaterialInfo = new ReturnMaterialInfo();
                    returnMaterialInfo.setShopOrder(obj.getShopOrder());
                    returnMaterialInfo.setItem(new ItemBOHandle(obj.getShopOrderPlannedItemBo()).getItem());
                    returnMaterialInfo.setItemDesc(obj.getItemDesc());
                    return returnMaterialInfo;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ZVwInventoryAssyData> findInventoryAssyDataByReturnMaterial( String site, String dataField ) {
        return returnMaterialRepository.findInventoryAssyDataByReturnMaterial(site, dataField).stream()
                .filter(FwUtils.distinctByKey(ZVwInventoryAssyData::getDataAttr))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReturnMaterialInfo> findStorageByReturnMaterial( String site ) {
        List<ZVwInventoryStorage> list = returnMaterialRepository.findStorageByReturnMaterial(site);
        return list.stream()
                .map(obj -> {
                    ReturnMaterialInfo returnMaterialInfo = new ReturnMaterialInfo();
                    returnMaterialInfo.setStorage(new StorageLocationBOHandle(obj.getStorageLocationBo()).getStorageLocation());
                    return returnMaterialInfo;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void returnMaterial( ReturnMaterialRequest returnMaterialRequest ) {
        InventoryServiceInterface inventoryServiceInterface =
                Services.getService("com.sap.me.inventory", "InventoryService", returnMaterialRequest.getSite());

        List<ReturnMaterialInfo> returnMaterialList = returnMaterialRequest.getReturnMaterialList();
        String reasonCodeRef = this.getReasonCode(returnMaterialRequest.getSite(), returnMaterialRequest.getActivity());

        for (ReturnMaterialInfo info : returnMaterialList) {
            try {
                ReturnInventoryInfo returnInventoryInfo =
                        new ReturnInventoryInfo(info.getInventoryBo(), info.getQtyOnHand().subtract(info.getReturnQty()), reasonCodeRef, "RETURN MATERIAL");

                this.validateAndUpdate(inventoryServiceInterface, returnInventoryInfo);
            } catch (BusinessException e) {
                FwUtils.getMeException(e);
            }
        }
    }

    public String getReasonCode( String site, String activity ) {
        ActivityOption activityOption = activityRepo.findOption(activity, "RETURN_CODE");
        if (!FwUtils.objIsEmpty(activityOption)) {
            String reasonCode = activityOption.getSetting();

            if (!FwUtils.isNullOrEmpty(reasonCode)) {
                // 現場庫存原因代碼
                List<ReasonCode> reasonCodes = fwReasonCodeRepo.getReasonCode(site, reasonCode, "I");
                if (FwUtils.isEmpty(reasonCodes)) {
                    FwUtils.getCustomException("returnMaterial.error1");
                }
                return reasonCodes.get(0).getHandle();
            }
        }
        return null;
    }

    @Transactional
    private void validateAndUpdate( InventoryServiceInterface inventoryServiceInterface, ReturnInventoryInfo returnInventoryInfo ) throws BusinessException {
        String inventoryBo = returnInventoryInfo.getInventoryBo();
        BigDecimal modifyQty = returnInventoryInfo.getModifyQty();
        String reasonCodeRef = returnInventoryInfo.getReasonCodeRef();
        String comments = returnInventoryInfo.getComments();

        com.sap.me.inventory.Inventory inventory = inventoryServiceInterface.findInventoryByRef(new ObjectReference(inventoryBo));

        InventoryValidateAndUpdateRequest request = new InventoryValidateAndUpdateRequest();
        request.setInventoryId(inventory.getInventoryId());
        request.setItemRef(inventory.getItemRef());
        request.setQuantityOnHand(modifyQty);
        request.getAssemblyDataList().addAll(inventory.getAssemblyDataList());
        request.setStorageLocationRef(inventory.getStorageLocationRef());
        request.setWorkCenterLocationRef(inventory.getWorkCenterLocRef());
        request.setOperationLocationRef(inventory.getOperationLocRef());
        request.setResourceLocationRef(inventory.getResourceLocRef());
        request.setShopOrderLocationRef(inventory.getShopOrderLocRef());
        request.setWorkCenterLocationReserve(inventory.isWorkCenterLocRes());
        request.setOperationLocationReserve(inventory.isOperationLocRes());
        request.setResourceLocationReserve(inventory.isResourceLocRes());
        request.setShopOrderLocationReserve(inventory.isShopOrderLocRes());
        request.setReasonCodeRef(reasonCodeRef);
        request.setComments(comments);
        request.setShopOrderSetByErp(inventory.isIsShopOrderSetByERP());

        request.setModifiedDateTime(inventory.getModifiedDateTime());
        inventoryServiceInterface.validateAndUpdate(request);
    }
}
