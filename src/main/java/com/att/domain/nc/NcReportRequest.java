package com.att.domain.nc;

import com.fw.mes.me.domain.common.BaseInfo;

import java.util.Date;
import java.util.List;

public class NcReportRequest extends BaseInfo {

    private String shopOrder;

    private List<String> itemList;

    private List<String> operationList;

    private List<String> ncCodeList;

    private String ncCategory;

    private String isCancelled;

    private Date start;

    private Date end;

    private String startDateTime;

    private String endDateTime;

    private String sid;

    private String cancelReason;

    private String reason;

    private String executeTime;

    public String getShopOrder() {
        return shopOrder;
    }

    public void setShopOrder( String shopOrder ) {
        this.shopOrder = shopOrder;
    }

    public List<String> getItemList() {
        return itemList;
    }

    public void setItemList( List<String> itemList ) {
        this.itemList = itemList;
    }

    public List<String> getOperationList() {
        return operationList;
    }

    public void setOperationList( List<String> operationList ) {
        this.operationList = operationList;
    }

    public List<String> getNcCodeList() {
        return ncCodeList;
    }

    public void setNcCodeList( List<String> ncCodeList ) {
        this.ncCodeList = ncCodeList;
    }

    public String getNcCategory() {
        return ncCategory;
    }

    public void setNcCategory( String ncCategory ) {
        this.ncCategory = ncCategory;
    }

    public String getIsCancelled() {
        return isCancelled;
    }

    public void setIsCancelled( String isCancelled ) {
        this.isCancelled = isCancelled;
    }

    public Date getStart() {
        return start;
    }

    public void setStart( Date start ) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd( Date end ) {
        this.end = end;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime( String startDateTime ) {
        this.startDateTime = startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime( String endDateTime ) {
        this.endDateTime = endDateTime;
    }

    public String getSid() {
        return sid;
    }

    public void setSid( String sid ) {
        this.sid = sid;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason( String cancelReason ) {
        this.cancelReason = cancelReason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason( String reason ) {
        this.reason = reason;
    }

    public String getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime( String executeTime ) {
        this.executeTime = executeTime;
    }
}
