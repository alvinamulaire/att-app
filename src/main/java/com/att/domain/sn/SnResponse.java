package com.att.domain.sn;

import java.math.BigDecimal;

public class SnResponse {

    private String sfc;

    private BigDecimal sfcQty;

    private String item;

    private String itemDesc;

    private String shopOrder;

    private String snType;

    public String getSfc() {
        return sfc;
    }

    public void setSfc( String sfc ) {
        this.sfc = sfc;
    }

    public BigDecimal getSfcQty() {
        return sfcQty;
    }

    public void setSfcQty( BigDecimal sfcQty ) {
        this.sfcQty = sfcQty;
    }

    public String getItem() {
        return item;
    }

    public void setItem( String item ) {
        this.item = item;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc( String itemDesc ) {
        this.itemDesc = itemDesc;
    }

    public String getShopOrder() {
        return shopOrder;
    }

    public void setShopOrder(String shopOrder) {
        this.shopOrder = shopOrder;
    }

    public String getSnType() {
        return snType;
    }

    public void setSnType(String snType) {
        this.snType = snType;
    }
}
