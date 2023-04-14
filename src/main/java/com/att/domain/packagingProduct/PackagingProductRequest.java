package com.att.domain.packagingProduct;

import com.fw.mes.me.domain.common.BaseInfo;

public class PackagingProductRequest extends BaseInfo {

    private String qcPlan;

    private String item;

    private String qcPlanBo;

    private String qcItemSid;

    private String remark;

    public String getQcPlan() {
        return qcPlan;
    }

    public void setQcPlan( String qcPlan ) {
        this.qcPlan = qcPlan;
    }

    public String getItem() {
        return item;
    }

    public void setItem( String item ) {
        this.item = item;
    }

    public String getQcPlanBo() {
        return qcPlanBo;
    }

    public void setQcPlanBo( String qcPlanBo ) {
        this.qcPlanBo = qcPlanBo;
    }

    public String getQcItemSid() {
        return qcItemSid;
    }

    public void setQcItemSid( String qcItemSid ) {
        this.qcItemSid = qcItemSid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark( String remark ) {
        this.remark = remark;
    }
}
