package com.att.repository.entity;

import java.io.Serializable;
import java.util.Date;

public class ZVwQcPlanProd implements Serializable {
    private String sid;

    private String site;

    private String item;

    private String workCenter;

    private String operation;

    private String resrce;

    private String qcPlan;

    private String qcPlanRevision;

    private String createdUser;

    private Date createdDateTime;

    private String materialNo;

    private String currentRevision;

    private String description;

    private String qcMode;

    private String qcType;

    private String inspecNo;

    private String userGroup;

    private String toSpc;

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

    public String getWorkCenter() {
        return workCenter;
    }

    public void setWorkCenter(String workCenter) {
        this.workCenter = workCenter;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResrce() {
        return resrce;
    }

    public void setResrce(String resrce) {
        this.resrce = resrce;
    }

    public String getQcPlan() {
        return qcPlan;
    }

    public void setQcPlan(String qcPlan) {
        this.qcPlan = qcPlan;
    }

    public String getQcPlanRevision() {
        return qcPlanRevision;
    }

    public void setQcPlanRevision(String qcPlanRevision) {
        this.qcPlanRevision = qcPlanRevision;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    public String getCurrentRevision() {
        return currentRevision;
    }

    public void setCurrentRevision(String currentRevision) {
        this.currentRevision = currentRevision;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQcMode() {
        return qcMode;
    }

    public void setQcMode(String qcMode) {
        this.qcMode = qcMode;
    }

    public String getQcType() {
        return qcType;
    }

    public void setQcType(String qcType) {
        this.qcType = qcType;
    }

    public String getInspecNo() {
        return inspecNo;
    }

    public void setInspecNo(String inspecNo) {
        this.inspecNo = inspecNo;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public String getToSpc() {
        return toSpc;
    }

    public void setToSpc(String toSpc) {
        this.toSpc = toSpc;
    }
}