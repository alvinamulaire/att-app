package com.att.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ZVwSoCustom implements Serializable {
    private String site;

    private String shopOrder;

    private String plannedBomBo;

    private String plannedBomRevision;

    private String bomBo;

    private String bomRevision;

    private String plannedRouterBo;

    private String plannedRouterRevision;

    private String routerBo;

    private String routerRevision;

    private BigDecimal qtyToBuild;

    private BigDecimal releaseQty;

    private Date plannedStartDate;

    private Date plannedCompDate;

    private String plannedItem;

    private BigDecimal lotSize;

    private String itemVer;

    private String itemDesc;

    private String plannedItemBomBo;

    private String plannedItemBom;

    private String plannedItemBomRevision;

    private String plannedItemRouterBo;

    private String plannedItemRouter;

    private String plannedItemRouterRevision;

    private String status;

    private String statusDescription;

    private String auart;

    private String partRev;

    private String build;

    private String productType;

    private String iso;

    private String auartValue;

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

    public String getPlannedBomBo() {
        return plannedBomBo;
    }

    public void setPlannedBomBo(String plannedBomBo) {
        this.plannedBomBo = plannedBomBo;
    }

    public String getPlannedBomRevision() {
        return plannedBomRevision;
    }

    public void setPlannedBomRevision(String plannedBomRevision) {
        this.plannedBomRevision = plannedBomRevision;
    }

    public String getBomBo() {
        return bomBo;
    }

    public void setBomBo(String bomBo) {
        this.bomBo = bomBo;
    }

    public String getBomRevision() {
        return bomRevision;
    }

    public void setBomRevision(String bomRevision) {
        this.bomRevision = bomRevision;
    }

    public String getPlannedRouterBo() {
        return plannedRouterBo;
    }

    public void setPlannedRouterBo(String plannedRouterBo) {
        this.plannedRouterBo = plannedRouterBo;
    }

    public String getPlannedRouterRevision() {
        return plannedRouterRevision;
    }

    public void setPlannedRouterRevision(String plannedRouterRevision) {
        this.plannedRouterRevision = plannedRouterRevision;
    }

    public String getRouterBo() {
        return routerBo;
    }

    public void setRouterBo(String routerBo) {
        this.routerBo = routerBo;
    }

    public String getRouterRevision() {
        return routerRevision;
    }

    public void setRouterRevision(String routerRevision) {
        this.routerRevision = routerRevision;
    }

    public BigDecimal getQtyToBuild() {
        return qtyToBuild;
    }

    public void setQtyToBuild(BigDecimal qtyToBuild) {
        this.qtyToBuild = qtyToBuild;
    }

    public BigDecimal getReleaseQty() {
        return releaseQty;
    }

    public void setReleaseQty(BigDecimal releaseQty) {
        this.releaseQty = releaseQty;
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

    public String getPlannedItem() {
        return plannedItem;
    }

    public void setPlannedItem(String plannedItem) {
        this.plannedItem = plannedItem;
    }

    public BigDecimal getLotSize() {
        return lotSize;
    }

    public void setLotSize(BigDecimal lotSize) {
        this.lotSize = lotSize;
    }

    public String getItemVer() {
        return itemVer;
    }

    public void setItemVer(String itemVer) {
        this.itemVer = itemVer;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getPlannedItemBomBo() {
        return plannedItemBomBo;
    }

    public void setPlannedItemBomBo(String plannedItemBomBo) {
        this.plannedItemBomBo = plannedItemBomBo;
    }

    public String getPlannedItemBom() {
        return plannedItemBom;
    }

    public void setPlannedItemBom(String plannedItemBom) {
        this.plannedItemBom = plannedItemBom;
    }

    public String getPlannedItemBomRevision() {
        return plannedItemBomRevision;
    }

    public void setPlannedItemBomRevision(String plannedItemBomRevision) {
        this.plannedItemBomRevision = plannedItemBomRevision;
    }

    public String getPlannedItemRouterBo() {
        return plannedItemRouterBo;
    }

    public void setPlannedItemRouterBo(String plannedItemRouterBo) {
        this.plannedItemRouterBo = plannedItemRouterBo;
    }

    public String getPlannedItemRouter() {
        return plannedItemRouter;
    }

    public void setPlannedItemRouter(String plannedItemRouter) {
        this.plannedItemRouter = plannedItemRouter;
    }

    public String getPlannedItemRouterRevision() {
        return plannedItemRouterRevision;
    }

    public void setPlannedItemRouterRevision(String plannedItemRouterRevision) {
        this.plannedItemRouterRevision = plannedItemRouterRevision;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getAuart() {
        return auart;
    }

    public void setAuart(String auart) {
        this.auart = auart;
    }

    public String getPartRev() {
        return partRev;
    }

    public void setPartRev(String partRev) {
        this.partRev = partRev;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getAuartValue() {
        return auartValue;
    }

    public void setAuartValue(String auartValue) {
        this.auartValue = auartValue;
    }
}