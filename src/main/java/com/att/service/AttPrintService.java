package com.att.service;

import com.att.domain.packaging.PackagingMaster;
import com.att.domain.print.AttPrintRequest;
import com.att.domain.print.AttPrintResponse;
import com.att.domain.print.PrintInfo;
import com.businessobjects.visualization.internal.org.json.JSONException;

import java.util.Date;
import java.util.List;

public interface AttPrintService {

    /**
     * 焊接碼列印
     *
     * @param site
     * @param sfc
     */
    void printTLSn( String site, String sfc, String printerName, String printType, String user, List<String> tlSnList ) throws JSONException;

    /**
     * save PrintLog
     *
     * @param site
     * @param labelType      1 : 焊接碼 2 : 箱號 3 : 棧板
     * @param printType      1 : 一般 2 : 補印
     * @param keyValue       焊接碼, 箱號或棧板號
     * @param requestContent
     * @param user
     */
    void savePrintLog( String site, String labelType, String printType, String keyValue, String requestContent, String user, Date createDateTime );

    /**
     * 標籤補列印-列印
     *
     * @param requestList
     */
    void print( List<AttPrintRequest> requestList ) throws JSONException;

    /**
     * 標籤補列印-檢索
     *
     * @param request
     */
    List<AttPrintResponse> printInfo( AttPrintRequest request, String locale);

    /**
     * 列印箱號
     *
     * @param printInfo
     * @throws JSONException
     */
    void printCarton( PrintInfo printInfo ) throws JSONException;

    /**
     * 列印棧板號
     *
     * @param printInfo
     * @throws JSONException
     */
    void printPallet( PrintInfo printInfo ) throws JSONException;

    /**
     * 棧板/箱號 開窗檢索
     * @param request
     * @return
     */
    List<String> findContainNoList(PackagingMaster request);
}
