package com.att.domain.iqc;

public class IqcBaseInfo {

    private String site;
    private String timeZone;
    private String url;

    public String getSite() {
        return site;
    }

    public void setSite( String site ) {
        this.site = site;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone( String timeZone ) {
        this.timeZone = timeZone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl( String url ) {
        this.url = url;
    }
}
