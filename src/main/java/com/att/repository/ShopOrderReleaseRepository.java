package com.att.repository;

import com.att.domain.shopOrder.SoCustomRequest;
import com.att.repository.entity.ZVwBomComponent;
import com.att.repository.entity.ZVwSoCustom;
import com.fw.mes.me.entity.Router;

import java.util.List;

public interface ShopOrderReleaseRepository {

    List<ZVwSoCustom> getSoReleaseDesc( String locale, SoCustomRequest zVwSoCustom );

    List<ZVwBomComponent> getBomComponent( ZVwBomComponent zVwBomComponent );

    Integer getLastSfcSerialNo( String site, String shopOrder );

    List<Router> getRouter( String site, String router, String ver );
}
