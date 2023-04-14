package com.att.nwds.service.domain;

public class DcInfo {

    private String site;
    private String dcGroup;
    private String sfcBo;
    private String operationBo;
    private String resourceBo;
    private String measureGroup;
    private String measureName;
    private String actual;

    private boolean deleteOld;

    public String getSite() {
        return site;
    }

    public void setSite( String site ) {
        this.site = site;
    }

    public String getDcGroup() {
        return dcGroup;
    }

    public void setDcGroup( String dcGroup ) {
        this.dcGroup = dcGroup;
    }

    public String getSfcBo() {
        return sfcBo;
    }

    public void setSfcBo( String sfcBo ) {
        this.sfcBo = sfcBo;
    }

    public String getOperationBo() {
        return operationBo;
    }

    public void setOperationBo( String operationBo ) {
        this.operationBo = operationBo;
    }

    public String getResourceBo() {
        return resourceBo;
    }

    public void setResourceBo( String resourceBo ) {
        this.resourceBo = resourceBo;
    }

    public String getMeasureGroup() {
        return measureGroup;
    }

    public void setMeasureGroup( String measureGroup ) {
        this.measureGroup = measureGroup;
    }

    public String getMeasureName() {
        return measureName;
    }

    public void setMeasureName( String measureName ) {
        this.measureName = measureName;
    }

    public String getActual() {
        return actual;
    }

    public void setActual( String actual ) {
        this.actual = actual;
    }

    public boolean isDeleteOld() {
        return deleteOld;
    }

    public void setDeleteOld(boolean deleteOld) {
        this.deleteOld = deleteOld;
    }
}
