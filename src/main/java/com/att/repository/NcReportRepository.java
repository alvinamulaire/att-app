package com.att.repository;

import com.att.domain.nc.NcReportRequest;
import com.att.repository.entity.ZSfcNcData;
import com.att.repository.entity.ZVwSfcNcData;

import java.util.List;

public interface NcReportRepository {

    List<ZVwSfcNcData> getSfcNcData( String locale, NcReportRequest ncReportRequest );

    void updateSfcNcData( ZSfcNcData zSfcNcData );
}
