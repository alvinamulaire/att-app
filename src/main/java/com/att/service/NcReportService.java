package com.att.service;

import com.att.domain.nc.NcReportRequest;
import com.att.domain.nc.NcReportResponse;
import com.att.domain.nc.SfcNcDataInfo;
import com.fw.mes.me.entity.ViewItemDesc;

import java.util.List;

public interface NcReportService {

    List<SfcNcDataInfo> getSfcNcData( NcReportRequest ncReportRequest );

    List<SfcNcDataInfo> getNcShopOrder( NcReportRequest ncReportRequest );

    List<ViewItemDesc> getItem( String site, String locale );

    NcReportResponse retrieve( NcReportRequest ncReportRequest );

    String getUserName( String site, String user );

    void updateSfcNcData( NcReportRequest request );
}
