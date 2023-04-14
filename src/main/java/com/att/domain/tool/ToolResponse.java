package com.att.domain.tool;

public class ToolResponse extends ToolRequest {

    private String resourceDesc;

    private String operationDesc;

    private int qtyInQueue;

    private int qtyInWork;

    private int snQty;

    private String sfcStatus;

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc( String resourceDesc ) {
        this.resourceDesc = resourceDesc;
    }

    public String getOperationDesc() {
        return operationDesc;
    }

    public void setOperationDesc( String operationDesc ) {
        this.operationDesc = operationDesc;
    }

    public int getQtyInQueue() {
        return qtyInQueue;
    }

    public void setQtyInQueue( int qtyInQueue ) {
        this.qtyInQueue = qtyInQueue;
    }

    public int getSnQty() {
        return snQty;
    }

    public void setSnQty( int snQty ) {
        this.snQty = snQty;
    }

    public int getQtyInWork() {
        return qtyInWork;
    }

    public void setQtyInWork( int qtyInWork ) {
        this.qtyInWork = qtyInWork;
    }

    public String getSfcStatus() {
        return sfcStatus;
    }

    public void setSfcStatus( String sfcStatus ) {
        this.sfcStatus = sfcStatus;
    }
}