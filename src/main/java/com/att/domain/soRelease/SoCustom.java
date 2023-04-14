package com.att.domain.soRelease;

import com.fw.mes.me.domain.common.BaseInfo;

import java.math.BigDecimal;
import java.util.Date;

public class SoCustom extends BaseInfo {

    private String shopOrder;

    private String router;

    private String routerVer;

    private String bom;

    private String bomVer;

    private BigDecimal qtyToBuild;

    private BigDecimal releaseQty;

    private Date plannedStartDate;

    private String plannedStartDateStr;

    private Date plannedCompDate;

    private String plannedCompDateStr;

    private String plannedItem;

    private BigDecimal lotSize;

    private String itemVer;

    private String itemDesc;

    private String status;

    private String statusDescription;

    private String auart;

    private String partRev;

    private String build;

    private String productType;

    private String iso;

    private String auartValue;

    private boolean printRunCard;

    public String getShopOrder() {
        return shopOrder;
    }

    public void setShopOrder( String shopOrder ) {
        this.shopOrder = shopOrder;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter( String router ) {
        this.router = router;
    }

    public String getRouterVer() {
        return routerVer;
    }

    public void setRouterVer( String routerVer ) {
        this.routerVer = routerVer;
    }

    public String getBom() {
        return bom;
    }

    public void setBom( String bom ) {
        this.bom = bom;
    }

    public String getBomVer() {
        return bomVer;
    }

    public void setBomVer( String bomVer ) {
        this.bomVer = bomVer;
    }

    public BigDecimal getQtyToBuild() {
        return qtyToBuild;
    }

    public void setQtyToBuild( BigDecimal qtyToBuild ) {
        this.qtyToBuild = qtyToBuild;
    }

    public BigDecimal getReleaseQty() {
        return releaseQty;
    }

    public void setReleaseQty( BigDecimal releaseQty ) {
        this.releaseQty = releaseQty;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate( Date plannedStartDate ) {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getPlannedCompDate() {
        return plannedCompDate;
    }

    public void setPlannedCompDate( Date plannedCompDate ) {
        this.plannedCompDate = plannedCompDate;
    }

    public String getPlannedItem() {
        return plannedItem;
    }

    public void setPlannedItem( String plannedItem ) {
        this.plannedItem = plannedItem;
    }

    public BigDecimal getLotSize() {
        return lotSize;
    }

    public void setLotSize( BigDecimal lotSize ) {
        this.lotSize = lotSize;
    }

    public String getItemVer() {
        return itemVer;
    }

    public void setItemVer( String itemVer ) {
        this.itemVer = itemVer;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc( String itemDesc ) {
        this.itemDesc = itemDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription( String statusDescription ) {
        this.statusDescription = statusDescription;
    }

    public String getAuart() {
        return auart;
    }

    public void setAuart( String auart ) {
        this.auart = auart;
    }

    public String getPartRev() {
        return partRev;
    }

    public void setPartRev( String partRev ) {
        this.partRev = partRev;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild( String build ) {
        this.build = build;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType( String productType ) {
        this.productType = productType;
    }

    public String getIso() {
        return iso;
    }

    public void setIso( String iso ) {
        this.iso = iso;
    }

    public String getAuartValue() {
        return auartValue;
    }

    public void setAuartValue( String auartValue ) {
        this.auartValue = auartValue;
    }

    public String getPlannedStartDateStr() {
        return plannedStartDateStr;
    }

    public void setPlannedStartDateStr( String plannedStartDateStr ) {
        this.plannedStartDateStr = plannedStartDateStr;
    }

    public String getPlannedCompDateStr() {
        return plannedCompDateStr;
    }

    public void setPlannedCompDateStr( String plannedCompDateStr ) {
        this.plannedCompDateStr = plannedCompDateStr;
    }

    public boolean isPrintRunCard() {
        return printRunCard;
    }

    public void setPrintRunCard( boolean printRunCard ) {
        this.printRunCard = printRunCard;
    }
}
