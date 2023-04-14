package com.att.nwds.service.domain;

import java.math.BigDecimal;
import java.util.List;

public class InvInfo {

    private String site;

    private String inventoryId;

    private String itemBo;

    private BigDecimal supplyQty;

    private String shopOrderBo;

    private List<String> shopOrderBoList;

    private boolean shopOrderLocRes;

    private String resourceBo;

    private boolean resourceLocRes;

    private String storageLocation;

    private List<String> componentList;

    public String getSite() {
        return site;
    }

    public void setSite( String site ) {
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

    public void setItemBo( String itemBo ) {
        this.itemBo = itemBo;
    }

    public BigDecimal getSupplyQty() {
        return supplyQty;
    }

    public void setSupplyQty( BigDecimal supplyQty ) {
        this.supplyQty = supplyQty;
    }

    public String getShopOrderBo() {
        return shopOrderBo;
    }

    public void setShopOrderBo( String shopOrderBo ) {
        this.shopOrderBo = shopOrderBo;
    }

    public List<String> getShopOrderBoList() {
        return shopOrderBoList;
    }

    public void setShopOrderBoList(List<String> shopOrderBoList) {
        this.shopOrderBoList = shopOrderBoList;
    }

    public boolean isShopOrderLocRes() {
        return shopOrderLocRes;
    }

    public void setShopOrderLocRes( boolean shopOrderLocRes ) {
        this.shopOrderLocRes = shopOrderLocRes;
    }

    public String getResourceBo() {
        return resourceBo;
    }

    public void setResourceBo( String resourceBo ) {
        this.resourceBo = resourceBo;
    }

    public boolean isResourceLocRes() {
        return resourceLocRes;
    }

    public void setResourceLocRes( boolean resourceLocRes ) {
        this.resourceLocRes = resourceLocRes;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation( String storageLocation ) {
        this.storageLocation = storageLocation;
    }

    public List<String> getComponentList() {
        return componentList;
    }

    public void setComponentList( List<String> componentList ) {
        this.componentList = componentList;
    }
}
