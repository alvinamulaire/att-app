package com.att.domain.productRack;

import com.fw.mes.me.domain.common.BaseInfo;

import java.math.BigDecimal;

public class ProductRackRequest extends BaseInfo {

    private String sfc;

    private String operation;

    private String resource;

    private String rack;

    private BigDecimal rackQty;

    public String getSfc() {
        return sfc;
    }

    public void setSfc( String sfc ) {
        this.sfc = sfc;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation( String operation ) {
        this.operation = operation;
    }

    public String getResource() {
        return resource;
    }

    public void setResource( String resource ) {
        this.resource = resource;
    }

    public String getRack() {
        return rack;
    }

    public void setRack( String rack ) {
        this.rack = rack;
    }

    public BigDecimal getRackQty() {
        return rackQty;
    }

    public void setRackQty( BigDecimal rackQty ) {
        this.rackQty = rackQty;
    }
}
