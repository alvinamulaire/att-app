package com.att.repository.mapper;

import com.att.repository.entity.ZVwSoCustom;
import com.att.repository.entity.ZVwSoCustomExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZVwSoCustomMapper {
    long countByExample( ZVwSoCustomExample example );

    List<ZVwSoCustom> selectByExample( @Param("locale") String locale,
                                       @Param("example") ZVwSoCustomExample example );
}