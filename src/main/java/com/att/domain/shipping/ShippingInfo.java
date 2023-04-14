package com.att.domain.shipping;

import java.math.BigDecimal;

public class ShippingInfo {

    private String qcPlan;

    private String qcItem;

    private String sn;

    private String result;

    private BigDecimal centerValue;

    private BigDecimal maxValue;

    private BigDecimal minValue;

    private BigDecimal maxTol;

    private BigDecimal minTol;

    private String operation;

    private String memo;

    private Short points;

    public String getQcPlan() {
        return qcPlan;
    }

    public void setQcPlan( String qcPlan ) {
        this.qcPlan = qcPlan;
    }

    public String getQcItem() {
        return qcItem;
    }

    public void setQcItem( String qcItem ) {
        this.qcItem = qcItem;
    }

    public String getSn() {
        return sn;
    }

    public void setSn( String sn ) {
        this.sn = sn;
    }

    public String getResult() {
        return result;
    }

    public void setResult( String result ) {
        this.result = result;
    }

    public BigDecimal getCenterValue() {
        return centerValue;
    }

    public void setCenterValue( BigDecimal centerValue ) {
        this.centerValue = centerValue;
    }

    public BigDecimal getMaxValue() {
        return maxValue;
    }

    public void setMaxValue( BigDecimal maxValue ) {
        this.maxValue = maxValue;
    }

    public BigDecimal getMinValue() {
        return minValue;
    }

    public void setMinValue( BigDecimal minValue ) {
        this.minValue = minValue;
    }

    public BigDecimal getMaxTol() {
        return maxTol;
    }

    public void setMaxTol( BigDecimal maxTol ) {
        this.maxTol = maxTol;
    }

    public BigDecimal getMinTol() {
        return minTol;
    }

    public void setMinTol( BigDecimal minTol ) {
        this.minTol = minTol;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation( String operation ) {
        this.operation = operation;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo( String memo ) {
        this.memo = memo;
    }

    public Short getPoints() {
        return points;
    }

    public void setPoints( Short points ) {
        this.points = points;
    }
}
