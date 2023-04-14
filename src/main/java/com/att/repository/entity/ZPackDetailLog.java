package com.att.repository.entity;

import java.io.Serializable;
import java.util.Date;

public class ZPackDetailLog implements Serializable {
    private String sid;

    private String site;

    private String masterSid;

    private String sfc;

    private String batchNo;

    private String sn;

    private String cartonNo;

    private Date createdDateTime;

    private String createdUser;

    private Date unboxingDateTime;

    private String unboxingUser;

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

    public String getMasterSid() {
        return masterSid;
    }

    public void setMasterSid(String masterSid) {
        this.masterSid = masterSid;
    }

    public String getSfc() {
        return sfc;
    }

    public void setSfc(String sfc) {
        this.sfc = sfc;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getCartonNo() {
        return cartonNo;
    }

    public void setCartonNo(String cartonNo) {
        this.cartonNo = cartonNo;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getUnboxingDateTime() {
        return unboxingDateTime;
    }

    public void setUnboxingDateTime(Date unboxingDateTime) {
        this.unboxingDateTime = unboxingDateTime;
    }

    public String getUnboxingUser() {
        return unboxingUser;
    }

    public void setUnboxingUser(String unboxingUser) {
        this.unboxingUser = unboxingUser;
    }
}