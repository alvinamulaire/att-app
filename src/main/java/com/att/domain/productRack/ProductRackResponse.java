package com.att.domain.productRack;

import com.att.repository.entity.ZMaterialShelfState;
import com.fw.mes.me.domain.common.BaseInfo;

import java.math.BigDecimal;
import java.util.List;

public class ProductRackResponse extends BaseInfo {

    private String sfc;

    private String operation;

    private String resource;

    private String operationDesc;

    private String resourceDesc;

    private BigDecimal sfcQty;

    private BigDecimal rackQty;

    private List<ZMaterialShelfState> shelfList;

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

    public BigDecimal getSfcQty() {
        return sfcQty;
    }

    public void setSfcQty( BigDecimal sfcQty ) {
        this.sfcQty = sfcQty;
    }

    public BigDecimal getRackQty() {
        return rackQty;
    }

    public List<ZMaterialShelfState> getShelfList() {
        return shelfList;
    }

    public void setShelfList( List<ZMaterialShelfState> shelfList ) {
        this.shelfList = shelfList;
    }

    public void setRackQty( BigDecimal rackQty ) {
        this.rackQty = rackQty;
    }
}
