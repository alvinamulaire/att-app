package com.att.domain.soRelease;

import com.fw.mes.me.domain.common.BaseInfo;

public class SoInfo extends BaseInfo {

    private String so;

    private String status;

    public String getSo() {
        return so;
    }

    public void setSo( String so ) {
        this.so = so;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }
}
