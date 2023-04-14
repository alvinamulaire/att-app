package com.att.repository.entity;

import java.io.Serializable;

public class ZVwYieldBasisRouter implements Serializable {
    private String site;

    private String item;

    private String router;

    private String routerRevision;

    private String routerType;

    private String description;

    private String nowVer;

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

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }

    public String getRouterRevision() {
        return routerRevision;
    }

    public void setRouterRevision(String routerRevision) {
        this.routerRevision = routerRevision;
    }

    public String getRouterType() {
        return routerType;
    }

    public void setRouterType(String routerType) {
        this.routerType = routerType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNowVer() {
        return nowVer;
    }

    public void setNowVer(String nowVer) {
        this.nowVer = nowVer;
    }
}