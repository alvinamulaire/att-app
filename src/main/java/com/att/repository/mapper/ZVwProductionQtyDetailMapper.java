package com.att.repository.mapper;

import com.att.repository.entity.ZVwProductionQtyDetail;
import com.att.repository.entity.ZVwProductionQtyDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ZVwProductionQtyDetailMapper {
    long countByExample(ZVwProductionQtyDetailExample example);

    List<ZVwProductionQtyDetail> selectByExample(@Param("example") ZVwProductionQtyDetailExample example, @Param("locale") String locale,
                                                 @Param("startDate") Date startDate, @Param("endDate")Date endDate);
}