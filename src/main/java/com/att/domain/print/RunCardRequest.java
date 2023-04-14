package com.att.domain.print;

import com.att.domain.soRelease.ReleaseSfcResponse;

import java.util.List;

public class RunCardRequest {

    private String site;

    private String user;

    private String itemBo;

    private String document;

    private List<ReleaseSfcResponse> releaseSfcResponses;

    public String getSite() {
        return site;
    }

    public void setSite( String site ) {
        this.site = site;
    }

    public String getUser() {
        return user;
    }

    public void setUser( String user ) {
        this.user = user;
    }

    public String getItemBo() {
        return itemBo;
    }

    public void setItemBo( String itemBo ) {
        this.itemBo = itemBo;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument( String document ) {
        this.document = document;
    }

    public List<ReleaseSfcResponse> getReleaseSfcResponses() {
        return releaseSfcResponses;
    }

    public void setReleaseSfcResponses( List<ReleaseSfcResponse> releaseSfcResponses ) {
        this.releaseSfcResponses = releaseSfcResponses;
    }
}
