package com.att.repository.mapper;

import com.att.repository.entity.ZVwQcPlanProd;
import com.att.repository.entity.ZVwQcPlanProdExample;
import java.util.List;

public interface ZVwQcPlanProdMapper {
    long countByExample(ZVwQcPlanProdExample example);

    List<ZVwQcPlanProd> selectByExample(ZVwQcPlanProdExample example);
}