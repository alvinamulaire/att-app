package com.att.repository.mapper;

import com.att.repository.entity.ZPackInspecItem;
import com.att.repository.entity.ZPackInspecItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZPackInspecItemMapper {
    long countByExample(ZPackInspecItemExample example);

    int deleteByExample(ZPackInspecItemExample example);

    int deleteByPrimaryKey(String sid);

    int insert(ZPackInspecItem record);

    int insertSelective(ZPackInspecItem record);

    List<ZPackInspecItem> selectByExample(ZPackInspecItemExample example);

    ZPackInspecItem selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") ZPackInspecItem record, @Param("example") ZPackInspecItemExample example);

    int updateByExample(@Param("record") ZPackInspecItem record, @Param("example") ZPackInspecItemExample example);

    int updateByPrimaryKeySelective(ZPackInspecItem record);

    int updateByPrimaryKey(ZPackInspecItem record);
}