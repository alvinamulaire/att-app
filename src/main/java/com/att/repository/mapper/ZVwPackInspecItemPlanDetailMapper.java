package com.att.repository.mapper;

import com.att.repository.entity.ZVwPackInspecItemPlanDetail;
import com.att.repository.entity.ZVwPackInspecItemPlanDetailExample;
import java.util.List;

public interface ZVwPackInspecItemPlanDetailMapper {
    long countByExample(ZVwPackInspecItemPlanDetailExample example);

    List<ZVwPackInspecItemPlanDetail> selectByExample(ZVwPackInspecItemPlanDetailExample example);
}