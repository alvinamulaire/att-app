package com.att.repository.mapper;

import com.att.repository.entity.ZMaterialShelfStateLog;
import com.att.repository.entity.ZMaterialShelfStateLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZMaterialShelfStateLogMapper {
    long countByExample(ZMaterialShelfStateLogExample example);

    int deleteByExample(ZMaterialShelfStateLogExample example);

    int deleteByPrimaryKey(String sid);

    int insert(ZMaterialShelfStateLog record);

    int insertSelective(ZMaterialShelfStateLog record);

    List<ZMaterialShelfStateLog> selectByExample(ZMaterialShelfStateLogExample example);

    ZMaterialShelfStateLog selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") ZMaterialShelfStateLog record, @Param("example") ZMaterialShelfStateLogExample example);

    int updateByExample(@Param("record") ZMaterialShelfStateLog record, @Param("example") ZMaterialShelfStateLogExample example);

    int updateByPrimaryKeySelective(ZMaterialShelfStateLog record);

    int updateByPrimaryKey(ZMaterialShelfStateLog record);
}