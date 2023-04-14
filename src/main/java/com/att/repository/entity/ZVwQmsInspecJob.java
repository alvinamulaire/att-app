package com.att.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ZVwQmsInspecJob implements Serializable {
    private String handle;

    private String site;

    private String jobNo;

    private String workCenter;

    private String operation;

    private String sfc;

    private String resrce;

    private String item;

    private String materialNo;

    private String userGroup;

    private String qcPlan;

    private String qcPlanRevision;

    private String qcFreq;

    private String qcType;

    private BigDecimal populationQty;

    private String status;

    private Date endDateTime;

    private String createdUser;

    private Date createdDateTime;

    private String checkUser;

    private Date checkDateTime;

    private String result;

    private BigDecimal okQty;

    private BigDecimal ngQty;

    private String abnGroupNo;

    private String udCode;

    private BigDecimal testingQty;

    private Date modifiedDateTime;

    private String modifiedUser;

    private String isErp;

    private String qcMode;

    private String submitRemark;

    private String judgeRemark;

    private static final long serialVersionUID = 1L;

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
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

    public String getSfc() {
        return sfc;
    }

    public void setSfc(String sfc) {
        this.sfc = sfc;
    }

    public String getResrce() {
        return resrce;
    }

    public void setResrce(String resrce) {
        this.resrce = resrce;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
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

    public String getQcFreq() {
        return qcFreq;
    }

    public void setQcFreq(String qcFreq) {
        this.qcFreq = qcFreq;
    }

    public String getQcType() {
        return qcType;
    }

    public void setQcType(String qcType) {
        this.qcType = qcType;
    }

    public BigDecimal getPopulationQty() {
        return populationQty;
    }

    public void setPopulationQty(BigDecimal populationQty) {
        this.populationQty = populationQty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
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

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public Date getCheckDateTime() {
        return checkDateTime;
    }

    public void setCheckDateTime(Date checkDateTime) {
        this.checkDateTime = checkDateTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public BigDecimal getOkQty() {
        return okQty;
    }

    public void setOkQty(BigDecimal okQty) {
        this.okQty = okQty;
    }

    public BigDecimal getNgQty() {
        return ngQty;
    }

    public void setNgQty(BigDecimal ngQty) {
        this.ngQty = ngQty;
    }

    public String getAbnGroupNo() {
        return abnGroupNo;
    }

    public void setAbnGroupNo(String abnGroupNo) {
        this.abnGroupNo = abnGroupNo;
    }

    public String getUdCode() {
        return udCode;
    }

    public void setUdCode(String udCode) {
        this.udCode = udCode;
    }

    public BigDecimal getTestingQty() {
        return testingQty;
    }

    public void setTestingQty(BigDecimal testingQty) {
        this.testingQty = testingQty;
    }

    public Date getModifiedDateTime() {
        return modifiedDateTime;
    }

    public void setModifiedDateTime(Date modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public String getIsErp() {
        return isErp;
    }

    public void setIsErp(String isErp) {
        this.isErp = isErp;
    }

    public String getQcMode() {
        return qcMode;
    }

    public void setQcMode(String qcMode) {
        this.qcMode = qcMode;
    }

    public String getSubmitRemark() {
        return submitRemark;
    }

    public void setSubmitRemark(String submitRemark) {
        this.submitRemark = submitRemark;
    }

    public String getJudgeRemark() {
        return judgeRemark;
    }

    public void setJudgeRemark(String judgeRemark) {
        this.judgeRemark = judgeRemark;
    }
}