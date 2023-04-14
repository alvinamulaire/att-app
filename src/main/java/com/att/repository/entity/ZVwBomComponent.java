package com.att.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ZVwBomComponent implements Serializable {
    private String site;

    private String handle;

    private String bom;

    private String bomType;

    private String statusBo;

    private String revision;

    private String currentRevision;

    private String componentGbo;

    private BigDecimal qty;

    private String operationBo;

    private static final long serialVersionUID = 1L;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getBom() {
        return bom;
    }

    public void setBom(String bom) {
        this.bom = bom;
    }

    public String getBomType() {
        return bomType;
    }

    public void setBomType(String bomType) {
        this.bomType = bomType;
    }

    public String getStatusBo() {
        return statusBo;
    }

    public void setStatusBo(String statusBo) {
        this.statusBo = statusBo;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getCurrentRevision() {
        return currentRevision;
    }

    public void setCurrentRevision(String currentRevision) {
        this.currentRevision = currentRevision;
    }

    public String getComponentGbo() {
        return componentGbo;
    }

    public void setComponentGbo(String componentGbo) {
        this.componentGbo = componentGbo;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getOperationBo() {
        return operationBo;
    }

    public void setOperationBo(String operationBo) {
        this.operationBo = operationBo;
    }
}