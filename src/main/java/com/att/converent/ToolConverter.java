package com.att.converent;

import com.att.repository.entity.ZSnToolLog;
import com.att.repository.entity.ZSnToolState;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ToolConverter {
    ToolConverter INSTANCE = Mappers.getMapper(ToolConverter.class);

    @Mappings({})
    ZSnToolLog toLog( ZSnToolState zSnToolState );

}
