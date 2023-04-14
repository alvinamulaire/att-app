package com.att.repository.mapper;

import com.att.repository.entity.ZVwProductionIntegratedKanban3;
import com.att.repository.entity.ZVwProductionIntegratedKanban3Example;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ZVwProductionIntegratedKanban3Mapper {
    long countByExample(ZVwProductionIntegratedKanban3Example example);

    List<ZVwProductionIntegratedKanban3> selectByExample(@Param("example") ZVwProductionIntegratedKanban3Example example,
                                                         @Param("startDate") Date startDate, @Param("endDate")Date endDate);
}