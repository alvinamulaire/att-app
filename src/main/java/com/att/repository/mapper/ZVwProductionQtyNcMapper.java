package com.att.repository.mapper;

import com.att.repository.entity.ZVwProductionQtyNc;
import com.att.repository.entity.ZVwProductionQtyNcExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ZVwProductionQtyNcMapper {
    long countByExample(ZVwProductionQtyNcExample example);

    List<ZVwProductionQtyNc> selectByExample(@Param("example") ZVwProductionQtyNcExample example, @Param("locale") String locale,
                                             @Param("startDate") Date startDate, @Param("endDate")Date endDate);
}