package com.att.service;

import com.att.domain.returnMaterial.ReturnMaterialInfo;
import com.att.domain.returnMaterial.ReturnMaterialRequest;
import com.att.repository.entity.ZVwInventoryAssyData;
import com.att.repository.entity.ZVwInventoryItem;

import java.util.List;

public interface ReturnMaterialService {

    /**
     * 退料-檢索
     *
     * @param returnMaterialInfo
     * @return
     */
    List<ReturnMaterialInfo> findReturnMaterialList( ReturnMaterialInfo returnMaterialInfo );

    /**
     * 退料-物料開窗
     *
     * @param site
     * @param item
     * @param locale
     * @return
     */
    List<ZVwInventoryItem> findItemByReturnMaterial( String site, String item, String locale );

    /**
     * 退料-工單開窗
     *
     * @param site
     * @param shopOrder
     * @param local
     * @return
     */
    List<ReturnMaterialInfo> findShopOrderByReturnMaterial( String site, String shopOrder, String local );

    /**
     * 退料-Assy Data開窗
     *
     * @param site
     * @param dataField
     * @return
     */
    List<ZVwInventoryAssyData> findInventoryAssyDataByReturnMaterial( String site, String dataField );

    /**
     * 退料-線邊倉開窗
     *
     * @param site
     * @return
     */
    List<ReturnMaterialInfo> findStorageByReturnMaterial( String site );

    /**
     * 退料
     *
     * @param returnMaterialRequest
     */
    void returnMaterial( ReturnMaterialRequest returnMaterialRequest );
}
