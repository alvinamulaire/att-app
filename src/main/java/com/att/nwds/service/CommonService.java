package com.att.nwds.service;

import com.att.nwds.service.domain.*;
import com.sap.me.frame.domain.BusinessException;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CommonService {

    /**
     * get SFC Info
     *
     * @param sfcBo
     * @return
     * @throws SQLException
     */
    SfcInfo getSfcInfo( String sfcBo ) throws SQLException;

    /**
     * get SFC's BOM Component
     *
     * @param sfcBo
     * @param operationBo
     * @return
     * @throws SQLException
     */
    List<BomComponent> getComponent( String sfcBo, String operationBo ) throws SQLException;

    /**
     * 檢查資源是否上料
     *
     * @param resourceBo
     */
    void checkResourceMaterial( String resourceBo ) throws SQLException, BusinessException;

    /**
     * 取得物料庫存
     *
     * @param invInfo
     * @return
     */
    Map<String, List<InvInfo>> getItemInventory( InvInfo invInfo ) throws SQLException;

    /**
     * 取得物料庫存
     * @param invInfo
     * @return
     * @throws SQLException
     */
    List<InvInfo> getInventoryList(InvInfo invInfo) throws SQLException;

    /**
     * 庫存數量檢查
     *
     * @param requestBaseList
     * @throws BusinessException
     * @throws SQLException
     */
    void checkInventory( List<RequestBase> requestBaseList ) throws BusinessException;

    /**
     * DC收集
     *
     * @param dcInfo
     * @throws BusinessException
     */
    void dcCollection( DcInfo dcInfo ) throws BusinessException;

    /**
     * 刪除資料收集
     *
     * @param dcInfo
     */
    void deleteDcCollection( DcInfo dcInfo ) throws BusinessException;

    /**
     * 取得系統參數
     *
     * @param site
     * @param rule
     * @return
     * @throws SQLException
     */
    String getSystemConfig( String site, String rule ) throws SQLException;
}
