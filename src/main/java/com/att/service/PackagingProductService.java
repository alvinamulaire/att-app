package com.att.service;

import com.att.domain.packagingProduct.PackagingProductRequest;
import com.att.domain.packagingProduct.ProductRequest;
import com.att.repository.entity.ZVwPackInspecItemPlanDetail;
import com.att.repository.entity.ZVwQcPlanItem;

import java.util.List;

public interface PackagingProductService {

    /**
     * 包裝產品參數 - 檢驗計畫開窗
     *
     * @param packagingProductRequest
     * @return
     */
    List<ZVwQcPlanItem> getQcPlan( PackagingProductRequest packagingProductRequest );

    /**
     * 包裝產品參數 - 檢驗項目開窗
     *
     * @param packagingProductRequest
     * @return
     */
    List<ZVwQcPlanItem> getQcPlanItem( PackagingProductRequest packagingProductRequest );

    /**
     * 包裝產品參數 - 檢索
     *
     * @param packagingProductRequest
     * @return
     */
    List<ZVwPackInspecItemPlanDetail> retrieve( PackagingProductRequest packagingProductRequest );

    /**
     * 包裝產品參數 - 儲存
     *
     * @param list
     */
    void save( List<PackagingProductRequest> list );

    /**
     * 包裝產品參數 - 儲存
     *
     * @param productRequest
     */
    void save( ProductRequest productRequest );
}
