package com.att.repository.entity;

import java.io.Serializable;
import java.util.Date;

public class ZPackInspecItem implements Serializable {
    private String sid;

    private String site;

    private String item;

    private String qcPlanBo;

    private String qcItemSid;

    private String remark;

    private Date createDateTime;

    private String createUser;

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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQcPlanBo() {
        return qcPlanBo;
    }

    public void setQcPlanBo(String qcPlanBo) {
        this.qcPlanBo = qcPlanBo;
    }

    public String getQcItemSid() {
        return qcItemSid;
    }

    public void setQcItemSid(String qcItemSid) {
        this.qcItemSid = qcItemSid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
}