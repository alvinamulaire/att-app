package com.att.domain.kanban;

import com.fw.mes.me.domain.common.BaseInfo;

import java.util.List;

public class KanbanRequest extends BaseInfo {

    private String activity;

    private String workCenter;

    private List<AttributeRequest> attributeList;

    public String getActivity() {
        return activity;
    }

    public void setActivity( String activity ) {
        this.activity = activity;
    }

    public String getWorkCenter() {
        return workCenter;
    }

    public void setWorkCenter( String workCenter ) {
        this.workCenter = workCenter;
    }

    public List<AttributeRequest> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList( List<AttributeRequest> attributeList ) {
        this.attributeList = attributeList;
    }
}
