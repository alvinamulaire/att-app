package com.att.converent;

import com.att.domain.report.ProductionIntegratedDetailResponse;
import com.att.repository.entity.ZVwProductionIntegratedKanban3;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductionIntegratedConverter {

	ProductionIntegratedConverter INSTANCE = Mappers.getMapper(ProductionIntegratedConverter.class);

	@Mappings({})
	ProductionIntegratedDetailResponse detailToDomain(ZVwProductionIntegratedKanban3 zVwProductionIntegratedKanban3);

}
