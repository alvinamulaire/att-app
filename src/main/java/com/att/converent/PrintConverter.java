package com.att.converent;

import com.att.domain.print.AttPrintResponse;
import com.att.repository.entity.ZVwSfcSnRelation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PrintConverter {

	PrintConverter INSTANCE = Mappers.getMapper(PrintConverter.class);

	@Mappings({
			@Mapping(source = "sn", target = "tlSn")
	})
	AttPrintResponse toResponseByTlSn(ZVwSfcSnRelation zVwSfcSnRelation);
}
