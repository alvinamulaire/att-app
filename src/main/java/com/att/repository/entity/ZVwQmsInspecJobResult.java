package com.att.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ZVwQmsInspecJobResult implements Serializable {
    private String handle;

    private String seq;

    private String inspecJobBo;

    private String qcPlanDetailBo;

    private BigDecimal sampleSize;

    private Short measurementPoints;

    private BigDecimal maxValue;

    private BigDecimal minValue;

    private BigDecimal centerValue;

    private String content;

    private String remark;

    private Date inspecDateTime;

    private String result;

    private BigDecimal inspecResult;

    private String memo;

    private Short series;

    private String sn;

    private String qcItemSid;

    private String site;

    private String qcItem;

    private String itemType;

    private static final long serialVersionUID = 1L;

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getInspecJobBo() {
        return inspecJobBo;
    }

    public void setInspecJobBo(String inspecJobBo) {
        this.inspecJobBo = inspecJobBo;
    }

    public String getQcPlanDetailBo() {
        return qcPlanDetailBo;
    }

    public void setQcPlanDetailBo(String qcPlanDetailBo) {
        this.qcPlanDetailBo = qcPlanDetailBo;
    }

    public BigDecimal getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(BigDecimal sampleSize) {
        this.sampleSize = sampleSize;
    }

    public Short getMeasurementPoints() {
        return measurementPoints;
    }

    public void setMeasurementPoints(Short measurementPoints) {
        this.measurementPoints = measurementPoints;
    }

    public BigDecimal getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(BigDecimal maxValue) {
        this.maxValue = maxValue;
    }

    public BigDecimal getMinValue() {
        return minValue;
    }

    public void setMinValue(BigDecimal minValue) {
        this.minValue = minValue;
    }

    public BigDecimal getCenterValue() {
        return centerValue;
    }

    public void setCenterValue(BigDecimal centerValue) {
        this.centerValue = centerValue;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getInspecDateTime() {
        return inspecDateTime;
    }

    public void setInspecDateTime(Date inspecDateTime) {
        this.inspecDateTime = inspecDateTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public BigDecimal getInspecResult() {
        return inspecResult;
    }

    public void setInspecResult(BigDecimal inspecResult) {
        this.inspecResult = inspecResult;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Short getSeries() {
        return series;
    }

    public void setSeries(Short series) {
        this.series = series;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getQcItemSid() {
        return qcItemSid;
    }

    public void setQcItemSid(String qcItemSid) {
        this.qcItemSid = qcItemSid;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getQcItem() {
        return qcItem;
    }

    public void setQcItem(String qcItem) {
        this.qcItem = qcItem;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}