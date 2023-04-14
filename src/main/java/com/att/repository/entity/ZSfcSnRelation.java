package com.att.repository.entity;

import java.io.Serializable;
import java.util.Date;

public class ZSfcSnRelation implements Serializable {
    private String sid;

    private String site;

    private String sfc;

    private String sn;

    private String snType;

    private String status;

    private Date createdDateTime;

    private String createdUser;

    private String newSn;

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

    public String getSfc() {
        return sfc;
    }

    public void setSfc(String sfc) {
        this.sfc = sfc;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getSnType() {
        return snType;
    }

    public void setSnType(String snType) {
        this.snType = snType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getNewSn() {
        return newSn;
    }

    public void setNewSn(String newSn) {
        this.newSn = newSn;
    }
}