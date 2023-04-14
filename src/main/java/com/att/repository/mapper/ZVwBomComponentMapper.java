package com.att.repository.mapper;

import com.att.repository.entity.ZVwBomComponent;
import com.att.repository.entity.ZVwBomComponentExample;
import java.util.List;

public interface ZVwBomComponentMapper {
    long countByExample(ZVwBomComponentExample example);

    List<ZVwBomComponent> selectByExample(ZVwBomComponentExample example);
}