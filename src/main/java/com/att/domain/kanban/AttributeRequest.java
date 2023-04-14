package com.att.domain.kanban;

public class AttributeRequest {

    private String site;

    private String type;

    private String workCenter;

    private String status;

    private String statusType;

    private String activity;

    private String item;

    private String routerBo;

    public String getSite() {
        return site;
    }

    public void setSite( String site ) {
        this.site = site;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public String getWorkCenter() {
        return workCenter;
    }

    public void setWorkCenter( String workCenter ) {
        this.workCenter = workCenter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType( String statusType ) {
        this.statusType = statusType;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity( String activity ) {
        this.activity = activity;
    }

    public String getItem() {
        return item;
    }

    public void setItem( String item ) {
        this.item = item;
    }

    public String getRouterBo() {
        return routerBo;
    }

    public void setRouterBo( String routerBo ) {
        this.routerBo = routerBo;
    }
}
