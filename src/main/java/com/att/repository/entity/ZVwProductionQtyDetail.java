package com.att.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ZVwProductionQtyDetail implements Serializable {
    private String site;

    private String shopOrder;

    private String router;

    private String routerRevision;

    private String sfc;

    private String actionCode;

    private String actionCodeDesc;

    private String workCenter;

    private String workCenterDesc;

    private String operation;

    private String operationDesc;

    private String resrce;

    private String resrceDesc;

    private Date dateTime;

    private String userId;

    private BigDecimal qty;

    private String parentSfc;

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

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }

    public String getRouterRevision() {
        return routerRevision;
    }

    public void setRouterRevision(String routerRevision) {
        this.routerRevision = routerRevision;
    }

    public String getSfc() {
        return sfc;
    }

    public void setSfc(String sfc) {
        this.sfc = sfc;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getActionCodeDesc() {
        return actionCodeDesc;
    }

    public void setActionCodeDesc(String actionCodeDesc) {
        this.actionCodeDesc = actionCodeDesc;
    }

    public String getWorkCenter() {
        return workCenter;
    }

    public void setWorkCenter(String workCenter) {
        this.workCenter = workCenter;
    }

    public String getWorkCenterDesc() {
        return workCenterDesc;
    }

    public void setWorkCenterDesc(String workCenterDesc) {
        this.workCenterDesc = workCenterDesc;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperationDesc() {
        return operationDesc;
    }

    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc;
    }

    public String getResrce() {
        return resrce;
    }

    public void setResrce(String resrce) {
        this.resrce = resrce;
    }

    public String getResrceDesc() {
        return resrceDesc;
    }

    public void setResrceDesc(String resrceDesc) {
        this.resrceDesc = resrceDesc;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getParentSfc() {
        return parentSfc;
    }

    public void setParentSfc(String parentSfc) {
        this.parentSfc = parentSfc;
    }
}