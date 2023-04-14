package com.att.service;

import com.att.domain.sn.SnRequest;
import com.att.domain.sn.SnResponse;
import com.businessobjects.visualization.internal.org.json.JSONException;

import java.util.List;

public interface SnSerialNumberService {

    /**
     * SN序號作業-檢索
     *
     * @param snRequest
     * @return
     */
    SnResponse getSfcSnInfo( SnRequest snRequest );

    /**
     * SN序號作業-儲存
     *
     * @param snRequest
     */
    void saveSn( SnRequest snRequest );

    /**
     * TL焊接碼作業-檢索
     * @param snRequest
     * @return
     */
    SnResponse getTlSnInfo(SnRequest snRequest);

    /**
     * TL焊接碼作業-編碼
     * @param snRequest
     * @return
     */
    List<String> createSn(SnRequest snRequest) throws JSONException;
}
