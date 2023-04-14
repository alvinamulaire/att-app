package com.att.repository.mapper;

import com.att.repository.entity.ZVwProductionQty;
import com.att.repository.entity.ZVwProductionQtyExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ZVwProductionQtyMapper {
    long countByExample(ZVwProductionQtyExample example);

    List<ZVwProductionQty> selectByExample(@Param("example") ZVwProductionQtyExample example, @Param("locale") String locale,
                                           @Param("startDate") Date startDate, @Param("endDate")Date endDate);
}