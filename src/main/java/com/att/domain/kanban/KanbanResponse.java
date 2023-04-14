package com.att.domain.kanban;

import java.math.BigDecimal;
import java.util.List;

public class KanbanResponse {

    private String workCenter;

    private String workCenterDesc;

    private int refreshFrequency;

    private int listChangeTime;

    private String kanbanType;

    private List<ResourceStatusInfo> statusInfoList;

    private int resourceTotalQty;

    private BigDecimal targetMonthEfficiency;
    private BigDecimal targetMonthYield;
    private BigDecimal targetMonthUtilizationRate;
    private BigDecimal targetMonthOee;
    private BigDecimal targetDayEfficiency;
    private BigDecimal targetDayYield;
    private BigDecimal targetDayUtilizationRate;
    private BigDecimal targetDayOee;

    private BigDecimal avgMonthEfficiency;
    private BigDecimal avgMonthYield;
    private BigDecimal avgMonthUtilizationRate;
    private BigDecimal avgMonthOee;
    private BigDecimal avgDayEfficiency;
    private BigDecimal avgDayYield;
    private BigDecimal avgDayUtilizationRate;
    private BigDecimal avgDayOee;

    public String getWorkCenter() {
        return workCenter;
    }

    public void setWorkCenter( String workCenter ) {
        this.workCenter = workCenter;
    }

    public String getWorkCenterDesc() {
        return workCenterDesc;
    }

    public void setWorkCenterDesc( String workCenterDesc ) {
        this.workCenterDesc = workCenterDesc;
    }

    public int getRefreshFrequency() {
        return refreshFrequency;
    }

    public void setRefreshFrequency( int refreshFrequency ) {
        this.refreshFrequency = refreshFrequency;
    }

    public int getListChangeTime() {
        return listChangeTime;
    }

    public void setListChangeTime( int listChangeTime ) {
        this.listChangeTime = listChangeTime;
    }

    public String getKanbanType() {
        return kanbanType;
    }

    public void setKanbanType( String kanbanType ) {
        this.kanbanType = kanbanType;
    }

    public List<ResourceStatusInfo> getStatusInfoList() {
        return statusInfoList;
    }

    public void setStatusInfoList( List<ResourceStatusInfo> statusInfoList ) {
        this.statusInfoList = statusInfoList;
    }

    public int getResourceTotalQty() {
        return resourceTotalQty;
    }

    public void setResourceTotalQty( int resourceTotalQty ) {
        this.resourceTotalQty = resourceTotalQty;
    }

    public BigDecimal getTargetMonthEfficiency() {
        return targetMonthEfficiency;
    }

    public void setTargetMonthEfficiency( BigDecimal targetMonthEfficiency ) {
        this.targetMonthEfficiency = targetMonthEfficiency;
    }

    public BigDecimal getTargetMonthYield() {
        return targetMonthYield;
    }

    public void setTargetMonthYield( BigDecimal targetMonthYield ) {
        this.targetMonthYield = targetMonthYield;
    }

    public BigDecimal getTargetMonthUtilizationRate() {
        return targetMonthUtilizationRate;
    }

    public void setTargetMonthUtilizationRate( BigDecimal targetMonthUtilizationRate ) {
        this.targetMonthUtilizationRate = targetMonthUtilizationRate;
    }

    public BigDecimal getTargetMonthOee() {
        return targetMonthOee;
    }

    public void setTargetMonthOee( BigDecimal targetMonthOee ) {
        this.targetMonthOee = targetMonthOee;
    }

    public BigDecimal getTargetDayEfficiency() {
        return targetDayEfficiency;
    }

    public void setTargetDayEfficiency( BigDecimal targetDayEfficiency ) {
        this.targetDayEfficiency = targetDayEfficiency;
    }

    public BigDecimal getTargetDayYield() {
        return targetDayYield;
    }

    public void setTargetDayYield( BigDecimal targetDayYield ) {
        this.targetDayYield = targetDayYield;
    }

    public BigDecimal getTargetDayUtilizationRate() {
        return targetDayUtilizationRate;
    }

    public void setTargetDayUtilizationRate( BigDecimal targetDayUtilizationRate ) {
        this.targetDayUtilizationRate = targetDayUtilizationRate;
    }

    public BigDecimal getTargetDayOee() {
        return targetDayOee;
    }

    public void setTargetDayOee( BigDecimal targetDayOee ) {
        this.targetDayOee = targetDayOee;
    }

    public BigDecimal getAvgMonthEfficiency() {
        return avgMonthEfficiency;
    }

    public void setAvgMonthEfficiency( BigDecimal avgMonthEfficiency ) {
        this.avgMonthEfficiency = avgMonthEfficiency;
    }

    public BigDecimal getAvgMonthYield() {
        return avgMonthYield;
    }

    public void setAvgMonthYield( BigDecimal avgMonthYield ) {
        this.avgMonthYield = avgMonthYield;
    }

    public BigDecimal getAvgMonthUtilizationRate() {
        return avgMonthUtilizationRate;
    }

    public void setAvgMonthUtilizationRate( BigDecimal avgMonthUtilizationRate ) {
        this.avgMonthUtilizationRate = avgMonthUtilizationRate;
    }

    public BigDecimal getAvgMonthOee() {
        return avgMonthOee;
    }

    public void setAvgMonthOee( BigDecimal avgMonthOee ) {
        this.avgMonthOee = avgMonthOee;
    }

    public BigDecimal getAvgDayEfficiency() {
        return avgDayEfficiency;
    }

    public void setAvgDayEfficiency( BigDecimal avgDayEfficiency ) {
        this.avgDayEfficiency = avgDayEfficiency;
    }

    public BigDecimal getAvgDayYield() {
        return avgDayYield;
    }

    public void setAvgDayYield( BigDecimal avgDayYield ) {
        this.avgDayYield = avgDayYield;
    }

    public BigDecimal getAvgDayUtilizationRate() {
        return avgDayUtilizationRate;
    }

    public void setAvgDayUtilizationRate( BigDecimal avgDayUtilizationRate ) {
        this.avgDayUtilizationRate = avgDayUtilizationRate;
    }

    public BigDecimal getAvgDayOee() {
        return avgDayOee;
    }

    public void setAvgDayOee( BigDecimal avgDayOee ) {
        this.avgDayOee = avgDayOee;
    }
}
