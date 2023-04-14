package com.att.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ZVwProductionIntegratedKanban2 implements Serializable {
    private String site;

    private String item;

    private BigDecimal actualProductionKpi;

    private BigDecimal qtyStarted;

    private BigDecimal qtyCompleted;

    private BigDecimal qtyScrapped;

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

    public BigDecimal getActualProductionKpi() {
        return actualProductionKpi;
    }

    public void setActualProductionKpi(BigDecimal actualProductionKpi) {
        this.actualProductionKpi = actualProductionKpi;
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

    public BigDecimal getReworkQty() {
        return reworkQty;
    }

    public void setReworkQty(BigDecimal reworkQty) {
        this.reworkQty = reworkQty;
    }
}