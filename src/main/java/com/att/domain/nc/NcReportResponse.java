package com.att.domain.nc;

import java.util.List;

public class NcReportResponse {

    private List<SfcNcDataInfo> sfcNcDataInfoList;

    private List<OperationNcInfo> operationNcInfoList;

    private List<NcInfo> ncInfoList;

    public List<SfcNcDataInfo> getSfcNcDataInfoList() {
        return sfcNcDataInfoList;
    }

    public void setSfcNcDataInfoList( List<SfcNcDataInfo> sfcNcDataInfoList ) {
        this.sfcNcDataInfoList = sfcNcDataInfoList;
    }

    public List<OperationNcInfo> getOperationNcInfoList() {
        return operationNcInfoList;
    }

    public void setOperationNcInfoList( List<OperationNcInfo> operationNcInfoList ) {
        this.operationNcInfoList = operationNcInfoList;
    }

    public List<NcInfo> getNcInfoList() {
        return ncInfoList;
    }

    public void setNcInfoList( List<NcInfo> ncInfoList ) {
        this.ncInfoList = ncInfoList;
    }
}
