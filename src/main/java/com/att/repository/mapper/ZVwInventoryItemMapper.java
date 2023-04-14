package com.att.repository.mapper;

import com.att.repository.entity.ZVwInventoryItem;
import com.att.repository.entity.ZVwInventoryItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZVwInventoryItemMapper {
    long countByExample( ZVwInventoryItemExample example );

    List<ZVwInventoryItem> selectByExample( @Param("locale") String locale,
                                            @Param("example") ZVwInventoryItemExample example );
}