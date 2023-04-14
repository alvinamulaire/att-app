package com.att.repository.mapper;

import com.att.repository.entity.ZMaterialYieldBasis;
import com.att.repository.entity.ZMaterialYieldBasisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZMaterialYieldBasisMapper {
    long countByExample(ZMaterialYieldBasisExample example);

    int deleteByExample(ZMaterialYieldBasisExample example);

    int deleteByPrimaryKey(String sid);

    int insert(ZMaterialYieldBasis record);

    int insertSelective(ZMaterialYieldBasis record);

    List<ZMaterialYieldBasis> selectByExample(ZMaterialYieldBasisExample example);

    ZMaterialYieldBasis selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") ZMaterialYieldBasis record, @Param("example") ZMaterialYieldBasisExample example);

    int updateByExample(@Param("record") ZMaterialYieldBasis record, @Param("example") ZMaterialYieldBasisExample example);

    int updateByPrimaryKeySelective(ZMaterialYieldBasis record);

    int updateByPrimaryKey(ZMaterialYieldBasis record);
}