package com.att.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ZPackMaster implements Serializable {
    private String sid;

    private String site;

    private String containerName;

    private String containerNo;

    private String containerType;

    private BigDecimal maxQty;

    private String isMantissa;

    private String mfgDate;

    private String expDate;

    private String dmxMfg1;

    private String dmxMfg2;

    private String dmxMfg3;

    private String dmxExp1;

    private String dmxExp2;

    private String dmxExp3;

    private BigDecimal weight;

    private String shippingDate;

    private String status;

    private Date createdDateTime;

    private String createdUser;

    private Date modifiedDateTime;

    private String modifiedUser;

    private Date closeDateTime;

    private String closeUser;

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

    public String getContainerName() {
        return containerName;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    public String getContainerNo() {
        return containerNo;
    }

    public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public BigDecimal getMaxQty() {
        return maxQty;
    }

    public void setMaxQty(BigDecimal maxQty) {
        this.maxQty = maxQty;
    }

    public String getIsMantissa() {
        return isMantissa;
    }

    public void setIsMantissa(String isMantissa) {
        this.isMantissa = isMantissa;
    }

    public String getMfgDate() {
        return mfgDate;
    }

    public void setMfgDate(String mfgDate) {
        this.mfgDate = mfgDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getDmxMfg1() {
        return dmxMfg1;
    }

    public void setDmxMfg1(String dmxMfg1) {
        this.dmxMfg1 = dmxMfg1;
    }

    public String getDmxMfg2() {
        return dmxMfg2;
    }

    public void setDmxMfg2(String dmxMfg2) {
        this.dmxMfg2 = dmxMfg2;
    }

    public String getDmxMfg3() {
        return dmxMfg3;
    }

    public void setDmxMfg3(String dmxMfg3) {
        this.dmxMfg3 = dmxMfg3;
    }

    public String getDmxExp1() {
        return dmxExp1;
    }

    public void setDmxExp1(String dmxExp1) {
        this.dmxExp1 = dmxExp1;
    }

    public String getDmxExp2() {
        return dmxExp2;
    }

    public void setDmxExp2(String dmxExp2) {
        this.dmxExp2 = dmxExp2;
    }

    public String getDmxExp3() {
        return dmxExp3;
    }

    public void setDmxExp3(String dmxExp3) {
        this.dmxExp3 = dmxExp3;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
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

    public Date getCloseDateTime() {
        return closeDateTime;
    }

    public void setCloseDateTime(Date closeDateTime) {
        this.closeDateTime = closeDateTime;
    }

    public String getCloseUser() {
        return closeUser;
    }

    public void setCloseUser(String closeUser) {
        this.closeUser = closeUser;
    }
}