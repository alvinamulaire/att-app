package com.att.repository.entity;

import java.io.Serializable;

public class ZVwPackPallet implements Serializable {
    private String masterSid;

    private String site;

    private String masterContainerName;

    private String masterContainerNo;

    private String masterContainerType;

    private String masterStatus;

    private String masterCartonNo;

    private String detailSid;

    private String detailContainerName;

    private String detailContainerNo;

    private String detailMfgDate;

    private String detailExpDate;

    private String detailStatus;

    private String detailSfc;

    private String detailBatchNo;

    private String detailSn;

    private String sfc;

    private String shopOrder;

    private String item;

    private String description;

    private static final long serialVersionUID = 1L;

    public String getMasterSid() {
        return masterSid;
    }

    public void setMasterSid(String masterSid) {
        this.masterSid = masterSid;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getMasterContainerName() {
        return masterContainerName;
    }

    public void setMasterContainerName(String masterContainerName) {
        this.masterContainerName = masterContainerName;
    }

    public String getMasterContainerNo() {
        return masterContainerNo;
    }

    public void setMasterContainerNo(String masterContainerNo) {
        this.masterContainerNo = masterContainerNo;
    }

    public String getMasterContainerType() {
        return masterContainerType;
    }

    public void setMasterContainerType(String masterContainerType) {
        this.masterContainerType = masterContainerType;
    }

    public String getMasterStatus() {
        return masterStatus;
    }

    public void setMasterStatus(String masterStatus) {
        this.masterStatus = masterStatus;
    }

    public String getMasterCartonNo() {
        return masterCartonNo;
    }

    public void setMasterCartonNo(String masterCartonNo) {
        this.masterCartonNo = masterCartonNo;
    }

    public String getDetailSid() {
        return detailSid;
    }

    public void setDetailSid(String detailSid) {
        this.detailSid = detailSid;
    }

    public String getDetailContainerName() {
        return detailContainerName;
    }

    public void setDetailContainerName(String detailContainerName) {
        this.detailContainerName = detailContainerName;
    }

    public String getDetailContainerNo() {
        return detailContainerNo;
    }

    public void setDetailContainerNo(String detailContainerNo) {
        this.detailContainerNo = detailContainerNo;
    }

    public String getDetailMfgDate() {
        return detailMfgDate;
    }

    public void setDetailMfgDate(String detailMfgDate) {
        this.detailMfgDate = detailMfgDate;
    }

    public String getDetailExpDate() {
        return detailExpDate;
    }

    public void setDetailExpDate(String detailExpDate) {
        this.detailExpDate = detailExpDate;
    }

    public String getDetailStatus() {
        return detailStatus;
    }

    public void setDetailStatus(String detailStatus) {
        this.detailStatus = detailStatus;
    }

    public String getDetailSfc() {
        return detailSfc;
    }

    public void setDetailSfc(String detailSfc) {
        this.detailSfc = detailSfc;
    }

    public String getDetailBatchNo() {
        return detailBatchNo;
    }

    public void setDetailBatchNo(String detailBatchNo) {
        this.detailBatchNo = detailBatchNo;
    }

    public String getDetailSn() {
        return detailSn;
    }

    public void setDetailSn(String detailSn) {
        this.detailSn = detailSn;
    }

    public String getSfc() {
        return sfc;
    }

    public void setSfc(String sfc) {
        this.sfc = sfc;
    }

    public String getShopOrder() {
        return shopOrder;
    }

    public void setShopOrder(String shopOrder) {
        this.shopOrder = shopOrder;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}