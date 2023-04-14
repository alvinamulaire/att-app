package com.att.nwds.service.domain;

import java.math.BigDecimal;

public class RequestBase {

    private String site;

    private String sfcBo;

    private String operationBo;

    private String resourceBo;

    private BigDecimal requestQty;

    private String isInv;

    public String getSite() {
        return site;
    }

    public void setSite( String site ) {
        this.site = site;
    }

    public String getSfcBo() {
        return sfcBo;
    }

    public void setSfcBo( String sfcBo ) {
        this.sfcBo = sfcBo;
    }

    public String getOperationBo() {
        return operationBo;
    }

    public void setOperationBo( String operationBo ) {
        this.operationBo = operationBo;
    }

    public String getResourceBo() {
        return resourceBo;
    }

    public void setResourceBo( String resourceBo ) {
        this.resourceBo = resourceBo;
    }

    public BigDecimal getRequestQty() {
        return requestQty;
    }

    public void setRequestQty( BigDecimal requestQty ) {
        this.requestQty = requestQty;
    }

    public String getIsInv() {
        return isInv;
    }

    public void setIsInv( String isInv ) {
        this.isInv = isInv;
    }
}
