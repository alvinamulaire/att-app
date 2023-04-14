package com.att.domain.kanban;

import java.math.BigDecimal;

public class ResourceStatusInfo {

    private String resource;

    private String status;

    private int resourceQty;

    private String resourceDesc;

    private BigDecimal efficiency;
    private BigDecimal yield;
    private BigDecimal utilizationRate;
    private BigDecimal oee;
    private BigDecimal uph;
    private BigDecimal hpu;

    public String getResource() {
        return resource;
    }

    public void setResource( String resource ) {
        this.resource = resource;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public int getResourceQty() {
        return resourceQty;
    }

    public void setResourceQty( int resourceQty ) {
        this.resourceQty = resourceQty;
    }

    public BigDecimal getEfficiency() {
        return efficiency;
    }

    public void setEfficiency( BigDecimal efficiency ) {
        this.efficiency = efficiency;
    }

    public BigDecimal getYield() {
        return yield;
    }

    public void setYield( BigDecimal yield ) {
        this.yield = yield;
    }

    public BigDecimal getUtilizationRate() {
        return utilizationRate;
    }

    public void setUtilizationRate( BigDecimal utilizationRate ) {
        this.utilizationRate = utilizationRate;
    }

    public BigDecimal getOee() {
        return oee;
    }

    public void setOee( BigDecimal oee ) {
        this.oee = oee;
    }

    public BigDecimal getUph() {
        return uph;
    }

    public void setUph( BigDecimal uph ) {
        this.uph = uph;
    }

    public BigDecimal getHpu() {
        return hpu;
    }

    public void setHpu( BigDecimal hpu ) {
        this.hpu = hpu;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc( String resourceDesc ) {
        this.resourceDesc = resourceDesc;
    }
}
