package com.att.domain.packaging;

import com.fw.mes.me.domain.common.BaseInfo;

import java.math.BigDecimal;
import java.util.List;

public class PackagingRequest extends BaseInfo {

    private String activity;

    private String containerName;

    private String containerNo;

    private String containerType;

    private String sfc;

    private String operation;

    private String resource;

    private String sn;

    private String batchNo;

    private boolean isMantissa;

    private String status;

    private BigDecimal weight;

    private BigDecimal maxQty;

    private String printName;

    private String shippingDate;

    private String cartonNo;

    private String prefix;

    private List<PackagingDetail> detailInfoList;

    public String getActivity() {
        return activity;
    }

    public void setActivity( String activity ) {
        this.activity = activity;
    }

    public String getContainerName() {
        return containerName;
    }

    public void setContainerName( String containerName ) {
        this.containerName = containerName;
    }

    public String getContainerNo() {
        return containerNo;
    }

    public void setContainerNo( String containerNo ) {
        this.containerNo = containerNo;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType( String containerType ) {
        this.containerType = containerType;
    }

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

    public String getSn() {
        return sn;
    }

    public void setSn( String sn ) {
        this.sn = sn;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo( String batchNo ) {
        this.batchNo = batchNo;
    }

    public boolean isMantissa() {
        return isMantissa;
    }

    public void setMantissa( boolean mantissa ) {
        isMantissa = mantissa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight( BigDecimal weight ) {
        this.weight = weight;
    }

    public BigDecimal getMaxQty() {
        return maxQty;
    }

    public void setMaxQty( BigDecimal maxQty ) {
        this.maxQty = maxQty;
    }

    public String getPrintName() {
        return printName;
    }

    public void setPrintName( String printName ) {
        this.printName = printName;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate( String shippingDate ) {
        this.shippingDate = shippingDate;
    }

    public String getCartonNo() {
        return cartonNo;
    }

    public void setCartonNo( String cartonNo ) {
        this.cartonNo = cartonNo;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix( String prefix ) {
        this.prefix = prefix;
    }

    public List<PackagingDetail> getDetailInfoList() {
        return detailInfoList;
    }

    public void setDetailInfoList( List<PackagingDetail> detailInfoList ) {
        this.detailInfoList = detailInfoList;
    }
}
