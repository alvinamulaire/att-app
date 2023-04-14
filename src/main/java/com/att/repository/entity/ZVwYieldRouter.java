package com.att.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ZVwYieldRouter implements Serializable {
    private String sid;

    private String site;

    private String item;

    private String router;

    private String routerRevision;

    private String operation;

    private BigDecimal planYield;

    private BigDecimal stdLabor;

    private Date createdDateTime;

    private String createdUser;

    private String routerDesc;

    private String routerType;

    private String operationDesc;

    private String stepId;

    private static final long serialVersionUID = 1L;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

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

    public BigDecimal getPlanYield() {
        return planYield;
    }

    public void setPlanYield(BigDecimal planYield) {
        this.planYield = planYield;
    }

    public BigDecimal getStdLabor() {
        return stdLabor;
    }

    public void setStdLabor(BigDecimal stdLabor) {
        this.stdLabor = stdLabor;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getRouterDesc() {
        return routerDesc;
    }

    public void setRouterDesc(String routerDesc) {
        this.routerDesc = routerDesc;
    }

    public String getRouterType() {
        return routerType;
    }

    public void setRouterType(String routerType) {
        this.routerType = routerType;
    }

    public String getOperationDesc() {
        return operationDesc;
    }

    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc;
    }

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }
}