package com.att.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ZVwShopOrderPackingInfo implements Serializable {
    private String site;

    private String shopOrder;

    private String statusBo;

    private BigDecimal qtyToBuild;

    private String routerBo;

    private Date plannedStartDate;

    private Date plannedCompDate;

    private String value;

    private String sfc;

    private String sfcStatusBo;

    private String itemBo;

    private String item;

    private String itemDesc;

    private String sn;

    private String cartonNo;

    private String palletNo;

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

    public String getStatusBo() {
        return statusBo;
    }

    public void setStatusBo(String statusBo) {
        this.statusBo = statusBo;
    }

    public BigDecimal getQtyToBuild() {
        return qtyToBuild;
    }

    public void setQtyToBuild(BigDecimal qtyToBuild) {
        this.qtyToBuild = qtyToBuild;
    }

    public String getRouterBo() {
        return routerBo;
    }

    public void setRouterBo(String routerBo) {
        this.routerBo = routerBo;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getPlannedCompDate() {
        return plannedCompDate;
    }

    public void setPlannedCompDate(Date plannedCompDate) {
        this.plannedCompDate = plannedCompDate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSfc() {
        return sfc;
    }

    public void setSfc(String sfc) {
        this.sfc = sfc;
    }

    public String getSfcStatusBo() {
        return sfcStatusBo;
    }

    public void setSfcStatusBo(String sfcStatusBo) {
        this.sfcStatusBo = sfcStatusBo;
    }

    public String getItemBo() {
        return itemBo;
    }

    public void setItemBo(String itemBo) {
        this.itemBo = itemBo;
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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getCartonNo() {
        return cartonNo;
    }

    public void setCartonNo(String cartonNo) {
        this.cartonNo = cartonNo;
    }

    public String getPalletNo() {
        return palletNo;
    }

    public void setPalletNo(String palletNo) {
        this.palletNo = palletNo;
    }
}