package com.att.repository.entity;

import java.io.Serializable;
import java.util.Date;

public class ZVwPackInspecItemPlanDetail implements Serializable {
    private String sid;

    private String site;

    private String item;

    private String qcPlanBo;

    private Date createDateTime;

    private String createUser;

    private String qcItemSid;

    private String qcItem;

    private String qcItemDesc;

    private String itemType;

    private String resourceType;

    private String qcDescription;

    private String status;

    private String units;

    private String controlMode;

    private String remark;

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

    public String getQcItemSid() {
        return qcItemSid;
    }

    public void setQcItemSid(String qcItemSid) {
        this.qcItemSid = qcItemSid;
    }

    public String getQcItem() {
        return qcItem;
    }

    public void setQcItem(String qcItem) {
        this.qcItem = qcItem;
    }

    public String getQcItemDesc() {
        return qcItemDesc;
    }

    public void setQcItemDesc(String qcItemDesc) {
        this.qcItemDesc = qcItemDesc;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getQcDescription() {
        return qcDescription;
    }

    public void setQcDescription(String qcDescription) {
        this.qcDescription = qcDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getControlMode() {
        return controlMode;
    }

    public void setControlMode(String controlMode) {
        this.controlMode = controlMode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}