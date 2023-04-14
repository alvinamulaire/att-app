package com.att.repository.mapper;

import com.att.repository.entity.ZSnToolState;
import com.att.repository.entity.ZSnToolStateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZSnToolStateMapper {
    long countByExample(ZSnToolStateExample example);

    int deleteByExample(ZSnToolStateExample example);

    int deleteByPrimaryKey(String sid);

    int insert(ZSnToolState record);

    int insertSelective(ZSnToolState record);

    List<ZSnToolState> selectByExample(ZSnToolStateExample example);

    ZSnToolState selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") ZSnToolState record, @Param("example") ZSnToolStateExample example);

    int updateByExample(@Param("record") ZSnToolState record, @Param("example") ZSnToolStateExample example);

    int updateByPrimaryKeySelective(ZSnToolState record);

    int updateByPrimaryKey(ZSnToolState record);
}