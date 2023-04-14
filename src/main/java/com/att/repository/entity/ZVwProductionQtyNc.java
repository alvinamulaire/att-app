package com.att.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ZVwProductionQtyNc implements Serializable {
    private String date;

    private String shopOrder;

    private String ncCode;

    private String ncCodeDesc;

    private String site;

    private String actionCode;

    private String activity;

    private String userId;

    private String sfc;

    private String operation;

    private String operationRevision;

    private String operationDesc;

    private String item;

    private String itemRevision;

    private String itemDeac;

    private String router;

    private String routerRevision;

    private String stepId;

    private String resrce;

    private String workCenter;

    private BigDecimal qty;

    private String isRework;

    private static final long serialVersionUID = 1L;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShopOrder() {
        return shopOrder;
    }

    public void setShopOrder(String shopOrder) {
        this.shopOrder = shopOrder;
    }

    public String getNcCode() {
        return ncCode;
    }

    public void setNcCode(String ncCode) {
        this.ncCode = ncCode;
    }

    public String getNcCodeDesc() {
        return ncCodeDesc;
    }

    public void setNcCodeDesc(String ncCodeDesc) {
        this.ncCodeDesc = ncCodeDesc;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSfc() {
        return sfc;
    }

    public void setSfc(String sfc) {
        this.sfc = sfc;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperationRevision() {
        return operationRevision;
    }

    public void setOperationRevision(String operationRevision) {
        this.operationRevision = operationRevision;
    }

    public String getOperationDesc() {
        return operationDesc;
    }

    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc;
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

    public String getItemDeac() {
        return itemDeac;
    }

    public void setItemDeac(String itemDeac) {
        this.itemDeac = itemDeac;
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

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public String getResrce() {
        return resrce;
    }

    public void setResrce(String resrce) {
        this.resrce = resrce;
    }

    public String getWorkCenter() {
        return workCenter;
    }

    public void setWorkCenter(String workCenter) {
        this.workCenter = workCenter;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getIsRework() {
        return isRework;
    }

    public void setIsRework(String isRework) {
        this.isRework = isRework;
    }
}