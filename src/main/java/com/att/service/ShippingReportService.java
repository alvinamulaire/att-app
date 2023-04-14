package com.att.service;

import com.att.domain.shipping.PackingInfo;
import com.att.repository.entity.ZVwShopOrderPackingInfo;

import java.util.List;
import java.util.Map;

public interface ShippingReportService {

    /**
     * 取得包裝工單
     *
     * @param packingInfo
     * @return
     */
    List<ZVwShopOrderPackingInfo> getPackingShopOrder( PackingInfo packingInfo );

    /**
     * 取得包裝箱號
     *
     * @param packingInfo
     * @return
     */
    List<ZVwShopOrderPackingInfo> getPackingCarton( PackingInfo packingInfo );

    /**
     * 取得包裝棧板
     *
     * @param packingInfo
     * @return
     */
    List<ZVwShopOrderPackingInfo> getPackingPallet( PackingInfo packingInfo );

    /**
     * 取得包裝SN
     *
     * @param packingInfo
     * @return
     */
    List<ZVwShopOrderPackingInfo> getPackingSn( PackingInfo packingInfo );

    /**
     * 檢索
     *
     * @param packingInfo
     * @return
     */
    List<Map<String, String>> retrieve( PackingInfo packingInfo );

    /**
     * 匯出
     *
     * @param maps
     * @return
     */
    byte[] readExcel( List<Map<String, String>> maps );
}
