package com.att.repository.entity;

import java.io.Serializable;
import java.util.Date;

public class TdsResourceAbility implements Serializable {
    private String sid;

    private String site;

    private String item;

    private String operation;

    private String resource;

    private Short priority;

    private Short switchTime;

    private Short preparationTime;

    private Integer uph;

    private Date modifiedDateTime;

    private String modifiedUser;

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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Short getPriority() {
        return priority;
    }

    public void setPriority(Short priority) {
        this.priority = priority;
    }

    public Short getSwitchTime() {
        return switchTime;
    }

    public void setSwitchTime(Short switchTime) {
        this.switchTime = switchTime;
    }

    public Short getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Short preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Integer getUph() {
        return uph;
    }

    public void setUph(Integer uph) {
        this.uph = uph;
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
}