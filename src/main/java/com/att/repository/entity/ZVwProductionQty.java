package com.att.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ZVwProductionQty implements Serializable {
    private String site;

    private String date;

    private String shopOrder;

    private String item;

    private String itemDesc;

    private String stepId;

    private String operation;

    private String operationDesc;

    private String isRework;

    private String erpOperation;

    private BigDecimal qtyStarted;

    private BigDecimal qtyCompleted;

    private BigDecimal qtyScrapped;

    private BigDecimal qtyDone;

    private String shopOrderType;

    private String router;

    private String routerRevision;

    private String routerDesc;

    private BigDecimal laborH;

    private BigDecimal laborM;

    private static final long serialVersionUID = 1L;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

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

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
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

    public String getIsRework() {
        return isRework;
    }

    public void setIsRework(String isRework) {
        this.isRework = isRework;
    }

    public String getErpOperation() {
        return erpOperation;
    }

    public void setErpOperation(String erpOperation) {
        this.erpOperation = erpOperation;
    }

    public BigDecimal getQtyStarted() {
        return qtyStarted;
    }

    public void setQtyStarted(BigDecimal qtyStarted) {
        this.qtyStarted = qtyStarted;
    }

    public BigDecimal getQtyCompleted() {
        return qtyCompleted;
    }

    public void setQtyCompleted(BigDecimal qtyCompleted) {
        this.qtyCompleted = qtyCompleted;
    }

    public BigDecimal getQtyScrapped() {
        return qtyScrapped;
    }

    public void setQtyScrapped(BigDecimal qtyScrapped) {
        this.qtyScrapped = qtyScrapped;
    }

    public BigDecimal getQtyDone() {
        return qtyDone;
    }

    public void setQtyDone(BigDecimal qtyDone) {
        this.qtyDone = qtyDone;
    }

    public String getShopOrderType() {
        return shopOrderType;
    }

    public void setShopOrderType(String shopOrderType) {
        this.shopOrderType = shopOrderType;
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

    public String getRouterDesc() {
        return routerDesc;
    }

    public void setRouterDesc(String routerDesc) {
        this.routerDesc = routerDesc;
    }

    public BigDecimal getLaborH() {
        return laborH;
    }

    public void setLaborH(BigDecimal laborH) {
        this.laborH = laborH;
    }

    public BigDecimal getLaborM() {
        return laborM;
    }

    public void setLaborM(BigDecimal laborM) {
        this.laborM = laborM;
    }
}