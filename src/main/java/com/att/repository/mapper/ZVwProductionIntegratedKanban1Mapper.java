package com.att.repository.mapper;

import com.att.repository.entity.ZVwProductionIntegratedKanban1;
import com.att.repository.entity.ZVwProductionIntegratedKanban1Example;
import java.util.List;

public interface ZVwProductionIntegratedKanban1Mapper {
    long countByExample(ZVwProductionIntegratedKanban1Example example);

    List<ZVwProductionIntegratedKanban1> selectByExample(ZVwProductionIntegratedKanban1Example example);
}