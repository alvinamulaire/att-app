package com.att.converent;

import com.att.domain.report.ProductionDateReportResponse;
import com.att.domain.report.ProductionQtyDetailResponse;
import com.att.repository.entity.ZVwProductionQty;
import com.att.repository.entity.ZVwProductionQtyDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductionDateReportConverter {

	ProductionDateReportConverter INSTANCE = Mappers.getMapper(ProductionDateReportConverter.class);

	@Mappings({})
	ProductionDateReportResponse toResponse(ZVwProductionQty zVwProductionQty);

	@Mappings({})
	List<ProductionDateReportResponse> toResponse(List<ZVwProductionQty> zVwProductionQtyList);

	@Mappings({})
	List<ProductionQtyDetailResponse> toResponseByDetail(List<ZVwProductionQtyDetail> zVwProductionQtyDetailList);
}
