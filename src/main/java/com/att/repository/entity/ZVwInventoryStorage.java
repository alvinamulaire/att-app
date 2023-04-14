package com.att.repository.entity;

import java.io.Serializable;

public class ZVwInventoryStorage implements Serializable {
    private String site;

    private String storageLocationBo;

    private static final long serialVersionUID = 1L;

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getStorageLocationBo() {
        return storageLocationBo;
    }

    public void setStorageLocationBo(String storageLocationBo) {
        this.storageLocationBo = storageLocationBo;
    }
}