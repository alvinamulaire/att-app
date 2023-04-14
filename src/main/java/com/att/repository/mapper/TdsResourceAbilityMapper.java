package com.att.repository.mapper;

import com.att.repository.entity.TdsResourceAbility;
import com.att.repository.entity.TdsResourceAbilityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TdsResourceAbilityMapper {
    long countByExample(TdsResourceAbilityExample example);

    int deleteByExample(TdsResourceAbilityExample example);

    int deleteByPrimaryKey(String sid);

    int insert(TdsResourceAbility record);

    int insertSelective(TdsResourceAbility record);

    List<TdsResourceAbility> selectByExample(TdsResourceAbilityExample example);

    TdsResourceAbility selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") TdsResourceAbility record, @Param("example") TdsResourceAbilityExample example);

    int updateByExample(@Param("record") TdsResourceAbility record, @Param("example") TdsResourceAbilityExample example);

    int updateByPrimaryKeySelective(TdsResourceAbility record);

    int updateByPrimaryKey(TdsResourceAbility record);
}