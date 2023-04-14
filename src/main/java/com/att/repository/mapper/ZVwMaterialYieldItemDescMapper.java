package com.att.repository.mapper;

import com.att.repository.entity.ZVwMaterialYieldItemDesc;
import com.att.repository.entity.ZVwMaterialYieldItemDescExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZVwMaterialYieldItemDescMapper {
    long countByExample( ZVwMaterialYieldItemDescExample example );

    List<ZVwMaterialYieldItemDesc> selectByExample( @Param("locale") String locale,
                                                    @Param("example") ZVwMaterialYieldItemDescExample example );
}