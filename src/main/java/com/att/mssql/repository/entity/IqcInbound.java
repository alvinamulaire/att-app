package com.att.mssql.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class IqcInbound implements Serializable {
    private String werk;

    private String prueflos;

    private String selmatnr;

    private BigDecimal lmengezub;

    private String vcode;

    private Short lmengeist;

    private Short anzfehler;

    private Short gesstichpr;

    private String statustext;

    private String erpStatus;

    private String erpMemo;

    private BigDecimal lmenge01;

    private BigDecimal lmenge08;

    private BigDecimal lmenge03;

    private String createdBy;

    private String creationDate;

    private String creationTime;

    private String lastUpdatedBy;

    private String lastUpdateDate;

    private String lastUpdateTime;

    private static final long serialVersionUID = 1L;

    public String getWerk() {
        return werk;
    }

    public void setWerk(String werk) {
        this.werk = werk;
    }

    public String getPrueflos() {
        return prueflos;
    }

    public void setPrueflos(String prueflos) {
        this.prueflos = prueflos;
    }

    public String getSelmatnr() {
        return selmatnr;
    }

    public void setSelmatnr(String selmatnr) {
        this.selmatnr = selmatnr;
    }

    public BigDecimal getLmengezub() {
        return lmengezub;
    }

    public void setLmengezub(BigDecimal lmengezub) {
        this.lmengezub = lmengezub;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public Short getLmengeist() {
        return lmengeist;
    }

    public void setLmengeist(Short lmengeist) {
        this.lmengeist = lmengeist;
    }

    public Short getAnzfehler() {
        return anzfehler;
    }

    public void setAnzfehler(Short anzfehler) {
        this.anzfehler = anzfehler;
    }

    public Short getGesstichpr() {
        return gesstichpr;
    }

    public void setGesstichpr(Short gesstichpr) {
        this.gesstichpr = gesstichpr;
    }

    public String getStatustext() {
        return statustext;
    }

    public void setStatustext(String statustext) {
        this.statustext = statustext;
    }

    public String getErpStatus() {
        return erpStatus;
    }

    public void setErpStatus(String erpStatus) {
        this.erpStatus = erpStatus;
    }

    public String getErpMemo() {
        return erpMemo;
    }

    public void setErpMemo(String erpMemo) {
        this.erpMemo = erpMemo;
    }

    public BigDecimal getLmenge01() {
        return lmenge01;
    }

    public void setLmenge01(BigDecimal lmenge01) {
        this.lmenge01 = lmenge01;
    }

    public BigDecimal getLmenge08() {
        return lmenge08;
    }

    public void setLmenge08(BigDecimal lmenge08) {
        this.lmenge08 = lmenge08;
    }

    public BigDecimal getLmenge03() {
        return lmenge03;
    }

    public void setLmenge03(BigDecimal lmenge03) {
        this.lmenge03 = lmenge03;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}