package com.att.converent;

import com.att.domain.packaging.PackagingDetail;
import com.att.domain.packaging.PackagingMaster;
import com.att.repository.entity.ZPackDetail;
import com.att.repository.entity.ZPackDetailLog;
import com.att.repository.entity.ZPackMaster;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PackagingConverter {

    PackagingConverter INSTANCE = Mappers.getMapper(PackagingConverter.class);

    ZPackDetailLog detailToLog( ZPackDetail zPackDetail );

    @Mappings({})
    List<PackagingDetail> daoToDomain( List<ZPackDetail> list );

    @Mappings({})
    PackagingMaster daoToMaster( ZPackMaster zPackMaster );
}
