package com.att.converent;

import com.att.domain.soRelease.SoCustom;
import com.att.repository.entity.ZVwSoCustom;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SoReleaseConverter {

    SoReleaseConverter INSTANCE = Mappers.getMapper(SoReleaseConverter.class);

    SoCustom daoToDomain( ZVwSoCustom zVwSoCustom );
}
