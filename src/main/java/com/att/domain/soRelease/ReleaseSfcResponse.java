package com.att.domain.soRelease;

import java.math.BigDecimal;

public class ReleaseSfcResponse {

    private String item;

    private String shopOrder;

    private String sfc;

    private BigDecimal qty;

    private String router;

    private String operation;

    private String operationDesc;

    public String getItem() {
        return item;
    }

    public void setItem( String item ) {
        this.item = item;
    }

    public String getShopOrder() {
        return shopOrder;
    }

    public void setShopOrder( String shopOrder ) {
        this.shopOrder = shopOrder;
    }

    public String getSfc() {
        return sfc;
    }

    public void setSfc( String sfc ) {
        this.sfc = sfc;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty( BigDecimal qty ) {
        this.qty = qty;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter( String router ) {
        this.router = router;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation( String operation ) {
        this.operation = operation;
    }

    public String getOperationDesc() {
        return operationDesc;
    }

    public void setOperationDesc( String operationDesc ) {
        this.operationDesc = operationDesc;
    }
}
