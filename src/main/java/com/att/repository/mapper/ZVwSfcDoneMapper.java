package com.att.repository.mapper;

import com.att.repository.entity.ZVwSfcDone;
import com.att.repository.entity.ZVwSfcDoneExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZVwSfcDoneMapper {
    long countByExample(ZVwSfcDoneExample example);

    List<ZVwSfcDone> selectByExample(@Param("example")ZVwSfcDoneExample example, @Param("locale") String locale);
}