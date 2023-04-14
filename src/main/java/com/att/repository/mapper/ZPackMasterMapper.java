package com.att.repository.mapper;

import com.att.repository.entity.ZPackMaster;
import com.att.repository.entity.ZPackMasterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZPackMasterMapper {
    long countByExample(ZPackMasterExample example);

    int deleteByExample(ZPackMasterExample example);

    int deleteByPrimaryKey(String sid);

    int insert(ZPackMaster record);

    int insertSelective(ZPackMaster record);

    List<ZPackMaster> selectByExample(ZPackMasterExample example);

    ZPackMaster selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") ZPackMaster record, @Param("example") ZPackMasterExample example);

    int updateByExample(@Param("record") ZPackMaster record, @Param("example") ZPackMasterExample example);

    int updateByPrimaryKeySelective(ZPackMaster record);

    int updateByPrimaryKey(ZPackMaster record);
}