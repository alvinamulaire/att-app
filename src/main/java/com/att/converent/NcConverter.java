package com.att.converent;

import com.att.domain.nc.SfcNcDataInfo;
import com.att.repository.entity.ZVwSfcNcData;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NcConverter {
    NcConverter INSTANCE = Mappers.getMapper(NcConverter.class);

    @Mappings({})
    SfcNcDataInfo daoToDomain( ZVwSfcNcData zVwSfcNcData );
}
