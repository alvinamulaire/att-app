package com.att.repository.mapper;

import com.att.repository.entity.ZSfcSnRelation;
import com.att.repository.entity.ZSfcSnRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZSfcSnRelationMapper {
    long countByExample(ZSfcSnRelationExample example);

    int deleteByExample(ZSfcSnRelationExample example);

    int deleteByPrimaryKey(String sid);

    int insert(ZSfcSnRelation record);

    int insertSelective(ZSfcSnRelation record);

    List<ZSfcSnRelation> selectByExample(ZSfcSnRelationExample example);

    ZSfcSnRelation selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") ZSfcSnRelation record, @Param("example") ZSfcSnRelationExample example);

    int updateByExample(@Param("record") ZSfcSnRelation record, @Param("example") ZSfcSnRelationExample example);

    int updateByPrimaryKeySelective(ZSfcSnRelation record);

    int updateByPrimaryKey(ZSfcSnRelation record);
}