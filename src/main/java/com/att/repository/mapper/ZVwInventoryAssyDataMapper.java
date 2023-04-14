package com.att.repository.mapper;

import com.att.repository.entity.ZVwInventoryAssyData;
import com.att.repository.entity.ZVwInventoryAssyDataExample;
import java.util.List;

public interface ZVwInventoryAssyDataMapper {
    long countByExample(ZVwInventoryAssyDataExample example);

    List<ZVwInventoryAssyData> selectByExample(ZVwInventoryAssyDataExample example);
}