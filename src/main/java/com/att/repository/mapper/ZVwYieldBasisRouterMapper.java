package com.att.repository.mapper;

import com.att.repository.entity.ZVwYieldBasisRouter;
import com.att.repository.entity.ZVwYieldBasisRouterExample;
import java.util.List;

public interface ZVwYieldBasisRouterMapper {
    long countByExample(ZVwYieldBasisRouterExample example);

    List<ZVwYieldBasisRouter> selectByExample(ZVwYieldBasisRouterExample example);
}