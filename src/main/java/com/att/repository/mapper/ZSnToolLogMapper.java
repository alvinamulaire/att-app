package com.att.repository.mapper;

import com.att.repository.entity.ZSnToolLog;
import com.att.repository.entity.ZSnToolLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZSnToolLogMapper {
    long countByExample(ZSnToolLogExample example);

    int deleteByExample(ZSnToolLogExample example);

    int deleteByPrimaryKey(String sid);

    int insert(ZSnToolLog record);

    int insertSelective(ZSnToolLog record);

    List<ZSnToolLog> selectByExample(ZSnToolLogExample example);

    ZSnToolLog selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") ZSnToolLog record, @Param("example") ZSnToolLogExample example);

    int updateByExample(@Param("record") ZSnToolLog record, @Param("example") ZSnToolLogExample example);

    int updateByPrimaryKeySelective(ZSnToolLog record);

    int updateByPrimaryKey(ZSnToolLog record);
}