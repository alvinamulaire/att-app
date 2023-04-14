package com.att.repository.mapper;

import com.att.repository.entity.ZPackDetailLog;
import com.att.repository.entity.ZPackDetailLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZPackDetailLogMapper {
    long countByExample(ZPackDetailLogExample example);

    int deleteByExample(ZPackDetailLogExample example);

    int deleteByPrimaryKey(String sid);

    int insert(ZPackDetailLog record);

    int insertSelective(ZPackDetailLog record);

    List<ZPackDetailLog> selectByExample(ZPackDetailLogExample example);

    ZPackDetailLog selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") ZPackDetailLog record, @Param("example") ZPackDetailLogExample example);

    int updateByExample(@Param("record") ZPackDetailLog record, @Param("example") ZPackDetailLogExample example);

    int updateByPrimaryKeySelective(ZPackDetailLog record);

    int updateByPrimaryKey(ZPackDetailLog record);
}