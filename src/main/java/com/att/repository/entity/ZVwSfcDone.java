package com.att.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ZVwSfcDone implements Serializable {
    private String site;

    private String sfc;

    private String operationBo;

    private String resourceBo;

    private String item;

    private String itemDesc;

    private String shopOrder;

    private BigDecimal qtyInWork;

    private String batchNumber;

    private String productRank;

    private static final long serialVersionUID = 1L;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSfc() {
        return sfc;
    }

    public void setSfc(String sfc) {
        this.sfc = sfc;
    }

    public String getOperationBo() {
        return operationBo;
    }

    public void setOperationBo(String operationBo) {
        this.operationBo = operationBo;
    }

    public String getResourceBo() {
        return resourceBo;
    }

    public void setResourceBo(String resourceBo) {
        this.resourceBo = resourceBo;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getShopOrder() {
        return shopOrder;
    }

    public void setShopOrder(String shopOrder) {
        this.shopOrder = shopOrder;
    }

    public BigDecimal getQtyInWork() {
        return qtyInWork;
    }

    public void setQtyInWork(BigDecimal qtyInWork) {
        this.qtyInWork = qtyInWork;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getProductRank() {
        return productRank;
    }

    public void setProductRank(String productRank) {
        this.productRank = productRank;
    }
}