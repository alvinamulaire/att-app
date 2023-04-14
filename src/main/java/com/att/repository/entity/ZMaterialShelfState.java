package com.att.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ZMaterialShelfState implements Serializable {
    private String sid;

    private String site;

    private String operation;

    private String resource;

    private String sfc;

    private BigDecimal qty;

    private String shelfNo;

    private Date putonDateTime;

    private String putonUser;

    private static final long serialVersionUID = 1L;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getSfc() {
        return sfc;
    }

    public void setSfc(String sfc) {
        this.sfc = sfc;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getShelfNo() {
        return shelfNo;
    }

    public void setShelfNo(String shelfNo) {
        this.shelfNo = shelfNo;
    }

    public Date getPutonDateTime() {
        return putonDateTime;
    }

    public void setPutonDateTime(Date putonDateTime) {
        this.putonDateTime = putonDateTime;
    }

    public String getPutonUser() {
        return putonUser;
    }

    public void setPutonUser(String putonUser) {
        this.putonUser = putonUser;
    }
}