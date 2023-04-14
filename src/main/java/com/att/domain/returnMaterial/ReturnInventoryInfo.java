package com.att.domain.returnMaterial;

import java.math.BigDecimal;

public class ReturnInventoryInfo {

    private String inventoryBo;

    private BigDecimal modifyQty;

    private String reasonCodeRef;

    private String comments;

    public ReturnInventoryInfo() {

    }

    public ReturnInventoryInfo( String inventoryBo, BigDecimal modifyQty, String reasonCodeRef, String comments ) {
        this.inventoryBo = inventoryBo;
        this.modifyQty = modifyQty;
        this.reasonCodeRef = reasonCodeRef;
        this.comments = comments;
    }

    public String getInventoryBo() {
        return inventoryBo;
    }

    public void setInventoryBo( String inventoryBo ) {
        this.inventoryBo = inventoryBo;
    }

    public BigDecimal getModifyQty() {
        return modifyQty;
    }

    public void setModifyQty( BigDecimal modifyQty ) {
        this.modifyQty = modifyQty;
    }

    public String getReasonCodeRef() {
        return reasonCodeRef;
    }

    public void setReasonCodeRef( String reasonCodeRef ) {
        this.reasonCodeRef = reasonCodeRef;
    }

    public String getComments() {
        return comments;
    }

    public void setComments( String comments ) {
        this.comments = comments;
    }
}
