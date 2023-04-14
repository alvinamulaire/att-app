package com.att.repository.entity;

import java.io.Serializable;
import java.util.Date;

public class ZSfcNcData implements Serializable {
    private String sid;

    private String site;

    private String ncDataBo;

    private String isCancelled;

    private String cancelledUserBo;

    private Date cancelledDateTime;

    private String cancelledReason;

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

    public String getNcDataBo() {
        return ncDataBo;
    }

    public void setNcDataBo(String ncDataBo) {
        this.ncDataBo = ncDataBo;
    }

    public String getIsCancelled() {
        return isCancelled;
    }

    public void setIsCancelled(String isCancelled) {
        this.isCancelled = isCancelled;
    }

    public String getCancelledUserBo() {
        return cancelledUserBo;
    }

    public void setCancelledUserBo(String cancelledUserBo) {
        this.cancelledUserBo = cancelledUserBo;
    }

    public Date getCancelledDateTime() {
        return cancelledDateTime;
    }

    public void setCancelledDateTime(Date cancelledDateTime) {
        this.cancelledDateTime = cancelledDateTime;
    }

    public String getCancelledReason() {
        return cancelledReason;
    }

    public void setCancelledReason(String cancelledReason) {
        this.cancelledReason = cancelledReason;
    }
}