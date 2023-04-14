package com.att.domain.sn;

import com.fw.mes.me.domain.common.BaseInfo;

public class SnRequest extends BaseInfo {

    private String sfc;

    private String sn;

    private String newSn;

    private String snType;

    private String activity;

    public String getSfc() {
        return sfc;
    }

    public void setSfc( String sfc ) {
        this.sfc = sfc;
    }

    public String getSn() {
        return sn;
    }

    public void setSn( String sn ) {
        this.sn = sn;
    }

    public String getNewSn() {
        return newSn;
    }

    public void setNewSn(String newSn) {
        this.newSn = newSn;
    }

    public String getSnType() {
        return snType;
    }

    public void setSnType(String snType) {
        this.snType = snType;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
