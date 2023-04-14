package com.att.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ZVwProductionIntegratedKanban1 implements Serializable {
    private String site;

    private String item;

    private BigDecimal inQty;

    private BigDecimal holdQty;

    private BigDecimal reworkQty;

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

    public BigDecimal getInQty() {
        return inQty;
    }

    public void setInQty(BigDecimal inQty) {
        this.inQty = inQty;
    }

    public BigDecimal getHoldQty() {
        return holdQty;
    }

    public void setHoldQty(BigDecimal holdQty) {
        this.holdQty = holdQty;
    }

    public BigDecimal getReworkQty() {
        return reworkQty;
    }

    public void setReworkQty(BigDecimal reworkQty) {
        this.reworkQty = reworkQty;
    }
}