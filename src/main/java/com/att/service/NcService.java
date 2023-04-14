package com.att.service;

import com.att.domain.nc.NcRequest;
import com.att.domain.nc.NcResponse;
import com.fw.mes.me.entity.ViewDataTypeField;

import java.util.List;

public interface NcService {

    NcResponse getSfcInfo( NcRequest ncRequest );

    List<ViewDataTypeField> getColumn( NcRequest ncRequest );

    void save( NcRequest ncRequest );
}


