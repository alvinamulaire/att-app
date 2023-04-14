package com.att.service;

import com.att.domain.print.RunCardRequest;
import com.att.domain.soRelease.ReleaseSfcResponse;
import com.att.domain.soRelease.SoCustom;
import com.att.domain.soRelease.SoInfo;

import java.util.List;

public interface ShopOrderReleaseService {

    /**
     * SFC核發-檢索
     *
     * @param soInfo
     * @return
     */
    SoCustom getReleaseSo( SoInfo soInfo );

    /**
     * SFC核發-工單開窗
     *
     * @param soInfo
     * @return
     */
    List<SoCustom> getSo( SoInfo soInfo );

    /**
     * SFC核發-核發
     *
     * @param soCustom
     * @return
     */
    List<ReleaseSfcResponse> release( SoCustom soCustom );

    /**
     * SFC核發-列印run card(異步)
     *
     * @param runCardRequest
     */
    void printRunCard( RunCardRequest runCardRequest );
}
