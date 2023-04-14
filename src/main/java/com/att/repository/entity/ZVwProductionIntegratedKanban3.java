package com.att.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ZVwProductionIntegratedKanban3 implements Serializable {
    private String site;

    private String item;

    private String router;

    private String routerRevision;

    private String operation;

    private String stepId;

    private BigDecimal inQty;

    private BigDecimal qtyCompleted;

    private BigDecimal qtyScrapped;

    private static final long serialVersionUID = 1L;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public BigDecimal getInQty() {
        return inQty;
    }

    public void setInQty(BigDecimal inQty) {
        this.inQty = inQty;
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
}