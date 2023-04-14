package com.att.repository;

import com.att.domain.shipping.PackingInfo;
import com.att.repository.entity.ZSfcSnRelation;
import com.att.repository.entity.ZVwShopOrderPackingInfo;

import java.util.List;

public interface ShippingReportRepository {

    List<ZVwShopOrderPackingInfo> getShippingInfo( PackingInfo packingInfo, String locale );

    List<ZSfcSnRelation> getSn( ZSfcSnRelation zSfcSnRelation );
}
