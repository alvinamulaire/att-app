package com.att.repository;

import com.att.domain.returnMaterial.ReturnMaterialInfo;
import com.att.repository.entity.*;

import java.util.List;

public interface ReturnMaterialRepository {

    List<ZVwReturnMaterial> findViewReturnMaterial( ReturnMaterialInfo returnMaterialInfo, String locale );

    List<ZVwInventoryItem> findItemByReturnMaterial( String site, String item, String local );

    List<ZVwInventoryShopOrder> findShopOrderByReturnMaterial( String site, String shopOrder, String local );

    List<ZVwInventoryAssyData> findInventoryAssyDataByReturnMaterial( String site, String dataField );

    List<ZVwInventoryStorage> findStorageByReturnMaterial( String site );
}
