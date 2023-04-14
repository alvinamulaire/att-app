package com.att.converent;

import com.att.repository.entity.ZMaterialShelfState;
import com.att.repository.entity.ZMaterialShelfStateLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MaterialShelfConverter {
	MaterialShelfConverter INSTANCE = Mappers.getMapper(MaterialShelfConverter.class);

	@Mappings({})
	ZMaterialShelfStateLog toLog(ZMaterialShelfState fwDutyState);

}
