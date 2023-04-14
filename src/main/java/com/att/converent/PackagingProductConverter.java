package com.att.converent;

import com.att.repository.entity.ZPackInspecItem;
import com.att.repository.entity.ZPackInspecItemLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PackagingProductConverter {

    PackagingProductConverter INSTANCE = Mappers.getMapper(PackagingProductConverter.class);

    @Mappings({})
    ZPackInspecItemLog toLog( ZPackInspecItem zPackInspecItem );

}
