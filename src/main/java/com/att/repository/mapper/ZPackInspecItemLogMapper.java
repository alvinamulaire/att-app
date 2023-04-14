package com.att.repository.mapper;

import com.att.repository.entity.ZPackInspecItemLog;
import com.att.repository.entity.ZPackInspecItemLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZPackInspecItemLogMapper {
    long countByExample(ZPackInspecItemLogExample example);

    int deleteByExample(ZPackInspecItemLogExample example);

    int deleteByPrimaryKey(String sid);

    int insert(ZPackInspecItemLog record);

    int insertSelective(ZPackInspecItemLog record);

    List<ZPackInspecItemLog> selectByExample(ZPackInspecItemLogExample example);

    ZPackInspecItemLog selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") ZPackInspecItemLog record, @Param("example") ZPackInspecItemLogExample example);

    int updateByExample(@Param("record") ZPackInspecItemLog record, @Param("example") ZPackInspecItemLogExample example);

    int updateByPrimaryKeySelective(ZPackInspecItemLog record);

    int updateByPrimaryKey(ZPackInspecItemLog record);
}