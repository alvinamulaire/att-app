package com.att.converent;

import com.att.domain.productRack.ProductRackRequest;
import com.att.domain.productRack.ProductRackResponse;
import com.att.repository.entity.ZMaterialShelfState;
import com.att.repository.entity.ZMaterialShelfStateLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductRackConverter {

    ProductRackConverter INSTANCE = Mappers.getMapper(ProductRackConverter.class);

    ProductRackResponse reqToRes( ProductRackRequest productRackRequest );

    ZMaterialShelfStateLog stateToLog( ZMaterialShelfState zMaterialShelfState );
}
