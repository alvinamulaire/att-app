package com.att.domain.kanban;

import java.math.BigDecimal;

public class ResourceEfficiency {

    private String item;

    private String operation;

    private String resrce;

    private BigDecimal totalCompleteQty;

    private BigDecimal totalElapsedTime;

    private BigDecimal uph;

    private BigDecimal efficiency;

    private BigDecimal actualUph;

    public String getItem() {
        return item;
    }

    public void setItem( String item ) {
        this.item = item;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation( String operation ) {
        this.operation = operation;
    }

    public String getResrce() {
        return resrce;
    }

    public void setResrce( String resrce ) {
        this.resrce = resrce;
    }

    public BigDecimal getTotalCompleteQty() {
        return totalCompleteQty;
    }

    public void setTotalCompleteQty( BigDecimal totalCompleteQty ) {
        this.totalCompleteQty = totalCompleteQty;
    }

    public BigDecimal getTotalElapsedTime() {
        return totalElapsedTime;
    }

    public void setTotalElapsedTime( BigDecimal totalElapsedTime ) {
        this.totalElapsedTime = totalElapsedTime;
    }

    public BigDecimal getUph() {
        return uph;
    }

    public void setUph( BigDecimal uph ) {
        this.uph = uph;
    }

    public BigDecimal getEfficiency() {
        return efficiency;
    }

    public void setEfficiency( BigDecimal efficiency ) {
        this.efficiency = efficiency;
    }

    public BigDecimal getActualUph() {
        return actualUph;
    }

    public void setActualUph( BigDecimal actualUph ) {
        this.actualUph = actualUph;
    }
}
