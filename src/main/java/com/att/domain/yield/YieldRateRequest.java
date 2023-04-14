package com.att.domain.yield;

import com.fw.mes.me.domain.common.BaseInfo;

import java.util.List;

public class YieldRateRequest extends BaseInfo {

    private String item;

    private String router;

    private List<YieldDetailInfo> detailInfoList;

    public String getItem() {
        return item;
    }

    public void setItem( String item ) {
        this.item = item;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter( String router ) {
        this.router = router;
    }

    public List<YieldDetailInfo> getDetailInfoList() {
        return detailInfoList;
    }

    public void setDetailInfoList( List<YieldDetailInfo> detailInfoList ) {
        this.detailInfoList = detailInfoList;
    }
}
