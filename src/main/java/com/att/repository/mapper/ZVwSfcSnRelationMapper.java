package com.att.repository.mapper;

import com.att.repository.entity.ZVwSfcSnRelation;
import com.att.repository.entity.ZVwSfcSnRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZVwSfcSnRelationMapper {
    long countByExample(ZVwSfcSnRelationExample example);

    int deleteByExample(ZVwSfcSnRelationExample example);

    int insert(ZVwSfcSnRelation record);

    int insertSelective(ZVwSfcSnRelation record);

    List<ZVwSfcSnRelation> selectByExample(ZVwSfcSnRelationExample example);

    int updateByExampleSelective(@Param("record") ZVwSfcSnRelation record, @Param("example") ZVwSfcSnRelationExample example);

    int updateByExample(@Param("record") ZVwSfcSnRelation record, @Param("example") ZVwSfcSnRelationExample example);
}