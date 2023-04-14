package com.att.domain.yield;

import java.math.BigDecimal;

public class YieldDetailInfo {

    private String router;

    private String routerVer;

    private String operation;

    private BigDecimal planYield;

    private BigDecimal stdLabor;

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

    public String getOperation() {
        return operation;
    }

    public void setOperation( String operation ) {
        this.operation = operation;
    }

    public BigDecimal getPlanYield() {
        return planYield;
    }

    public void setPlanYield( BigDecimal planYield ) {
        this.planYield = planYield;
    }

    public BigDecimal getStdLabor() {
        return stdLabor;
    }

    public void setStdLabor( BigDecimal stdLabor ) {
        this.stdLabor = stdLabor;
    }
}
