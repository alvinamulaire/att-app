package com.att.domain.tool;

import com.att.repository.entity.ZSnToolState;
import com.fw.mes.me.domain.common.BaseInfo;

import java.util.List;

public class ToolRequest extends BaseInfo {

    private String sfc;

    private String operation;

    private String resource;

    private String tool;

    private String sn;

    private List<ZSnToolState> toolStateList;

    private String type;

    private String activity;

    private List<String> toolList;

    private String status;

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

    public String getTool() {
        return tool;
    }

    public void setTool( String tool ) {
        this.tool = tool;
    }

    public String getSn() {
        return sn;
    }

    public void setSn( String sn ) {
        this.sn = sn;
    }

    public List<ZSnToolState> getToolStateList() {
        return toolStateList;
    }

    public void setToolStateList( List<ZSnToolState> toolStateList ) {
        this.toolStateList = toolStateList;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity( String activity ) {
        this.activity = activity;
    }

    public List<String> getToolList() {
        return toolList;
    }

    public void setToolList( List<String> toolList ) {
        this.toolList = toolList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }
}
