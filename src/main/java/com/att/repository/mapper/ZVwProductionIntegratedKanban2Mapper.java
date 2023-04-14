package com.att.repository.mapper;

import com.att.repository.entity.ZVwProductionIntegratedKanban2;
import com.att.repository.entity.ZVwProductionIntegratedKanban2Example;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ZVwProductionIntegratedKanban2Mapper {
    long countByExample(ZVwProductionIntegratedKanban2Example example);

    List<ZVwProductionIntegratedKanban2> selectByExample(@Param("example") ZVwProductionIntegratedKanban2Example example,
                                                         @Param("startDate") Date startDate, @Param("endDate")Date endDate);
}