package com.att.domain.nc;

import java.math.BigDecimal;

public class OperationNcInfo {

    private String operation;

    private BigDecimal reworkQty;

    private BigDecimal scrapQty;

    public String getOperation() {
        return operation;
    }

    public void setOperation( String operation ) {
        this.operation = operation;
    }

    public BigDecimal getReworkQty() {
        return reworkQty;
    }

    public void setReworkQty( BigDecimal reworkQty ) {
        this.reworkQty = reworkQty;
    }

    public BigDecimal getScrapQty() {
        return scrapQty;
    }

    public void setScrapQty( BigDecimal scrapQty ) {
        this.scrapQty = scrapQty;
    }
}
