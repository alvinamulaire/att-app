package com.att.repository.entity;

import java.io.Serializable;

public class ZVwInventoryShopOrder implements Serializable {
    private String site;

    private String shopOrder;

    private String shopOrderPlannedItemBo;

    private String locale;

    private String itemDesc;

    private static final long serialVersionUID = 1L;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getShopOrder() {
        return shopOrder;
    }

    public void setShopOrder(String shopOrder) {
        this.shopOrder = shopOrder;
    }

    public String getShopOrderPlannedItemBo() {
        return shopOrderPlannedItemBo;
    }

    public void setShopOrderPlannedItemBo(String shopOrderPlannedItemBo) {
        this.shopOrderPlannedItemBo = shopOrderPlannedItemBo;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
}