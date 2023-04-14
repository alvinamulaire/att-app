package com.att.domain.returnMaterial;

import com.fw.mes.me.domain.common.BaseInfo;

import java.util.List;

public class ReturnMaterialRequest extends BaseInfo {

    private String activity;

    private List<ReturnMaterialInfo> returnMaterialList;

    public String getActivity() {
        return activity;
    }

    public void setActivity( String activity ) {
        this.activity = activity;
    }

    public List<ReturnMaterialInfo> getReturnMaterialList() {
        return returnMaterialList;
    }

    public void setReturnMaterialList( List<ReturnMaterialInfo> returnMaterialList ) {
        this.returnMaterialList = returnMaterialList;
    }
}
