package com.att.domain.nc;

import com.fw.mes.me.domain.common.BaseInfo;

import java.util.List;
import java.util.Map;

public class NcRequest extends BaseInfo {

    private String sfc;

    private String operation;

    private String resource;

    private List<Map<String, String>> ncList;

    public String getSfc() {
        return sfc;
    }

    public void setSfc( String sfc ) {
        this.sfc = sfc;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation( String operation ) {
        this.operation = operation;
    }

    public String getResource() {
        return resource;
    }

    public void setResource( String resource ) {
        this.resource = resource;
    }

    public List<Map<String, String>> getNcList() {
        return ncList;
    }

    public void setNcList( List<Map<String, String>> ncList ) {
        this.ncList = ncList;
    }
}
