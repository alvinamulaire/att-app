package com.att.repository.mapper;

import com.att.repository.entity.ZVwQcPlanItem;
import com.att.repository.entity.ZVwQcPlanItemExample;
import java.util.List;

public interface ZVwQcPlanItemMapper {
    long countByExample(ZVwQcPlanItemExample example);

    List<ZVwQcPlanItem> selectByExample(ZVwQcPlanItemExample example);
}