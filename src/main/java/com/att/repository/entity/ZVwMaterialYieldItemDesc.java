package com.att.repository.entity;

import java.io.Serializable;

public class ZVwMaterialYieldItemDesc implements Serializable {
    private String site;

    private String item;

    private String revision;

    private String description;

    private static final long serialVersionUID = 1L;

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

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}