package com.att.repository.mapper;

import com.att.repository.entity.ZVwPackCarton;
import com.att.repository.entity.ZVwPackCartonExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZVwPackCartonMapper {
    long countByExample(ZVwPackCartonExample example);

    List<ZVwPackCarton> selectByExample(@Param("example")ZVwPackCartonExample example, @Param("locale")String locale);
}