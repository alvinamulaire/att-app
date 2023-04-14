package com.att.service;

import com.att.domain.sfc.SfcDoneRequest;
import com.att.domain.sfc.SfcDoneResponse;
import com.att.domain.sfcDone.SfcDoneInfo;

import java.util.List;

public interface SfcDoneService {

    /**
     * 入庫作業 - 檢索
     *
     * @param sfcDoneRequest
     * @return
     */
    SfcDoneResponse findSfcDoneList( SfcDoneRequest sfcDoneRequest, String locale );

    /**
     * 入庫作業 - 完成
     *
     * @param sfcDoneList
     * @return
     */
    List<SfcDoneInfo> sfcDone( List<SfcDoneInfo> sfcDoneList );
}
