package com.att.repository.mapper;

import com.att.repository.entity.ZVwReturnMaterial;
import com.att.repository.entity.ZVwReturnMaterialExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZVwReturnMaterialMapper {
    long countByExample( ZVwReturnMaterialExample example );

    List<ZVwReturnMaterial> selectByExample( @Param("locale") String locale,
                                             @Param("example") ZVwReturnMaterialExample example );
}