package com.att.repository.mapper;

import com.att.repository.entity.ZMaterialShelfState;
import com.att.repository.entity.ZMaterialShelfStateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZMaterialShelfStateMapper {
    long countByExample(ZMaterialShelfStateExample example);

    int deleteByExample(ZMaterialShelfStateExample example);

    int deleteByPrimaryKey(String sid);

    int insert(ZMaterialShelfState record);

    int insertSelective(ZMaterialShelfState record);

    List<ZMaterialShelfState> selectByExample(ZMaterialShelfStateExample example);

    ZMaterialShelfState selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") ZMaterialShelfState record, @Param("example") ZMaterialShelfStateExample example);

    int updateByExample(@Param("record") ZMaterialShelfState record, @Param("example") ZMaterialShelfStateExample example);

    int updateByPrimaryKeySelective(ZMaterialShelfState record);

    int updateByPrimaryKey(ZMaterialShelfState record);
}