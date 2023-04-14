package com.att.repository.mapper;

import com.att.repository.entity.ZSfcNcData;
import com.att.repository.entity.ZSfcNcDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZSfcNcDataMapper {
    long countByExample(ZSfcNcDataExample example);

    int deleteByExample(ZSfcNcDataExample example);

    int deleteByPrimaryKey(String sid);

    int insert(ZSfcNcData record);

    int insertSelective(ZSfcNcData record);

    List<ZSfcNcData> selectByExample(ZSfcNcDataExample example);

    ZSfcNcData selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") ZSfcNcData record, @Param("example") ZSfcNcDataExample example);

    int updateByExample(@Param("record") ZSfcNcData record, @Param("example") ZSfcNcDataExample example);

    int updateByPrimaryKeySelective(ZSfcNcData record);

    int updateByPrimaryKey(ZSfcNcData record);
}