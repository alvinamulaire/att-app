package com.att.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ZVwSfcNcData implements Serializable {
    private String sid;

    private String site;

    private String ncDataBo;

    private String isCancelled;

    private String cancelledUserBo;

    private Date cancelledDateTime;

    private String cancelledReason;

    private String sfc;

    private String shopOrder;

    private String shopOrderErpType;

    private String operation;

    private String operationDesc;

    private String item;

    private String itemDesc;

    private String ncCode;

    private String ncCodeDesc;

    private String ncState;

    private String ncCategory;

    private BigDecimal ncQty;

    private String actionCode;

    private String actionCodeDesc;

    private String comments;

    private Date dateTime;

    private String userBo;

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

    public String getShopOrderErpType() {
        return shopOrderErpType;
    }

    public void setShopOrderErpType(String shopOrderErpType) {
        this.shopOrderErpType = shopOrderErpType;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperationDesc() {
        return operationDesc;
    }

    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getNcCode() {
        return ncCode;
    }

    public void setNcCode(String ncCode) {
        this.ncCode = ncCode;
    }

    public String getNcCodeDesc() {
        return ncCodeDesc;
    }

    public void setNcCodeDesc(String ncCodeDesc) {
        this.ncCodeDesc = ncCodeDesc;
    }

    public String getNcState() {
        return ncState;
    }

    public void setNcState(String ncState) {
        this.ncState = ncState;
    }

    public String getNcCategory() {
        return ncCategory;
    }

    public void setNcCategory(String ncCategory) {
        this.ncCategory = ncCategory;
    }

    public BigDecimal getNcQty() {
        return ncQty;
    }

    public void setNcQty(BigDecimal ncQty) {
        this.ncQty = ncQty;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getActionCodeDesc() {
        return actionCodeDesc;
    }

    public void setActionCodeDesc(String actionCodeDesc) {
        this.actionCodeDesc = actionCodeDesc;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getUserBo() {
        return userBo;
    }

    public void setUserBo(String userBo) {
        this.userBo = userBo;
    }
}