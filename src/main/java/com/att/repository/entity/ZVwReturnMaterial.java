package com.att.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ZVwReturnMaterial implements Serializable {
    private String inventoryBo;

    private BigDecimal changeStamp;

    private String site;

    private String inventoryId;

    private String itemBo;

    private String inventoryContextGbo;

    private String description;

    private BigDecimal qtyOnHand;

    private String assyDataTypeBo;

    private BigDecimal usageCount;

    private BigDecimal maximumUsage;

    private String statusBo;

    private BigDecimal originalQty;

    private String workCenterLocBo;

    private String workCenterLocRes;

    private String operationLocBo;

    private String operationLocRes;

    private String resourceLocBo;

    private String resourceLocRes;

    private String shopOrderLocBo;

    private String shopOrderLocRes;

    private String shopOrderSetByErp;

    private Date receiveDateTime;

    private String originalUserBo;

    private String storageLocationBo;

    private String hasBeenUsed;

    private Date createdDateTime;

    private Date modifiedDateTime;

    private Date partitionDate;

    private String parentInventoryBo;

    private String erpInventory;

    private String item;

    private String itemRevision;

    private String itemDesc;

    private String batchNumber;

    private String mch1Lifnr;

    private String vendorLot;

    private String matDocNum;

    private String zbMfdate;

    private String zbExpdate;

    private String centralStorageLocation;

    private static final long serialVersionUID = 1L;

    public String getInventoryBo() {
        return inventoryBo;
    }

    public void setInventoryBo(String inventoryBo) {
        this.inventoryBo = inventoryBo;
    }

    public BigDecimal getChangeStamp() {
        return changeStamp;
    }

    public void setChangeStamp(BigDecimal changeStamp) {
        this.changeStamp = changeStamp;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getItemBo() {
        return itemBo;
    }

    public void setItemBo(String itemBo) {
        this.itemBo = itemBo;
    }

    public String getInventoryContextGbo() {
        return inventoryContextGbo;
    }

    public void setInventoryContextGbo(String inventoryContextGbo) {
        this.inventoryContextGbo = inventoryContextGbo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(BigDecimal qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public String getAssyDataTypeBo() {
        return assyDataTypeBo;
    }

    public void setAssyDataTypeBo(String assyDataTypeBo) {
        this.assyDataTypeBo = assyDataTypeBo;
    }

    public BigDecimal getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(BigDecimal usageCount) {
        this.usageCount = usageCount;
    }

    public BigDecimal getMaximumUsage() {
        return maximumUsage;
    }

    public void setMaximumUsage(BigDecimal maximumUsage) {
        this.maximumUsage = maximumUsage;
    }

    public String getStatusBo() {
        return statusBo;
    }

    public void setStatusBo(String statusBo) {
        this.statusBo = statusBo;
    }

    public BigDecimal getOriginalQty() {
        return originalQty;
    }

    public void setOriginalQty(BigDecimal originalQty) {
        this.originalQty = originalQty;
    }

    public String getWorkCenterLocBo() {
        return workCenterLocBo;
    }

    public void setWorkCenterLocBo(String workCenterLocBo) {
        this.workCenterLocBo = workCenterLocBo;
    }

    public String getWorkCenterLocRes() {
        return workCenterLocRes;
    }

    public void setWorkCenterLocRes(String workCenterLocRes) {
        this.workCenterLocRes = workCenterLocRes;
    }

    public String getOperationLocBo() {
        return operationLocBo;
    }

    public void setOperationLocBo(String operationLocBo) {
        this.operationLocBo = operationLocBo;
    }

    public String getOperationLocRes() {
        return operationLocRes;
    }

    public void setOperationLocRes(String operationLocRes) {
        this.operationLocRes = operationLocRes;
    }

    public String getResourceLocBo() {
        return resourceLocBo;
    }

    public void setResourceLocBo(String resourceLocBo) {
        this.resourceLocBo = resourceLocBo;
    }

    public String getResourceLocRes() {
        return resourceLocRes;
    }

    public void setResourceLocRes(String resourceLocRes) {
        this.resourceLocRes = resourceLocRes;
    }

    public String getShopOrderLocBo() {
        return shopOrderLocBo;
    }

    public void setShopOrderLocBo(String shopOrderLocBo) {
        this.shopOrderLocBo = shopOrderLocBo;
    }

    public String getShopOrderLocRes() {
        return shopOrderLocRes;
    }

    public void setShopOrderLocRes(String shopOrderLocRes) {
        this.shopOrderLocRes = shopOrderLocRes;
    }

    public String getShopOrderSetByErp() {
        return shopOrderSetByErp;
    }

    public void setShopOrderSetByErp(String shopOrderSetByErp) {
        this.shopOrderSetByErp = shopOrderSetByErp;
    }

    public Date getReceiveDateTime() {
        return receiveDateTime;
    }

    public void setReceiveDateTime(Date receiveDateTime) {
        this.receiveDateTime = receiveDateTime;
    }

    public String getOriginalUserBo() {
        return originalUserBo;
    }

    public void setOriginalUserBo(String originalUserBo) {
        this.originalUserBo = originalUserBo;
    }

    public String getStorageLocationBo() {
        return storageLocationBo;
    }

    public void setStorageLocationBo(String storageLocationBo) {
        this.storageLocationBo = storageLocationBo;
    }

    public String getHasBeenUsed() {
        return hasBeenUsed;
    }

    public void setHasBeenUsed(String hasBeenUsed) {
        this.hasBeenUsed = hasBeenUsed;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Date getModifiedDateTime() {
        return modifiedDateTime;
    }

    public void setModifiedDateTime(Date modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }

    public Date getPartitionDate() {
        return partitionDate;
    }

    public void setPartitionDate(Date partitionDate) {
        this.partitionDate = partitionDate;
    }

    public String getParentInventoryBo() {
        return parentInventoryBo;
    }

    public void setParentInventoryBo(String parentInventoryBo) {
        this.parentInventoryBo = parentInventoryBo;
    }

    public String getErpInventory() {
        return erpInventory;
    }

    public void setErpInventory(String erpInventory) {
        this.erpInventory = erpInventory;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemRevision() {
        return itemRevision;
    }

    public void setItemRevision(String itemRevision) {
        this.itemRevision = itemRevision;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getMch1Lifnr() {
        return mch1Lifnr;
    }

    public void setMch1Lifnr(String mch1Lifnr) {
        this.mch1Lifnr = mch1Lifnr;
    }

    public String getVendorLot() {
        return vendorLot;
    }

    public void setVendorLot(String vendorLot) {
        this.vendorLot = vendorLot;
    }

    public String getMatDocNum() {
        return matDocNum;
    }

    public void setMatDocNum(String matDocNum) {
        this.matDocNum = matDocNum;
    }

    public String getZbMfdate() {
        return zbMfdate;
    }

    public void setZbMfdate(String zbMfdate) {
        this.zbMfdate = zbMfdate;
    }

    public String getZbExpdate() {
        return zbExpdate;
    }

    public void setZbExpdate(String zbExpdate) {
        this.zbExpdate = zbExpdate;
    }

    public String getCentralStorageLocation() {
        return centralStorageLocation;
    }

    public void setCentralStorageLocation(String centralStorageLocation) {
        this.centralStorageLocation = centralStorageLocation;
    }
}