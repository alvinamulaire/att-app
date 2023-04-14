package com.att.domain.nc;

import java.math.BigDecimal;

public class NcResponse extends NcRequest {

    private String operationDesc;

    private String resourceDesc;

    private BigDecimal inWorkQty;

    public String getOperationDesc() {
        return operationDesc;
    }

    public void setOperationDesc( String operationDesc ) {
        this.operationDesc = operationDesc;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc( String resourceDesc ) {
        this.resourceDesc = resourceDesc;
    }

    public BigDecimal getInWorkQty() {
        return inWorkQty;
    }

    public void setInWorkQty( BigDecimal inWorkQty ) {
        this.inWorkQty = inWorkQty;
    }
}
