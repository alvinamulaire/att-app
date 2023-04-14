package com.att.converent;

import com.att.domain.shipping.PackingInfo;
import com.att.repository.entity.ZVwShopOrderPackingInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShippingReportConverter {

    ShippingReportConverter INSTANCE = Mappers.getMapper(ShippingReportConverter.class);


    @Mappings({})
    ZVwShopOrderPackingInfo domainToDao( PackingInfo packingInfo );
}
