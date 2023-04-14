package com.att.repository.mapper;

import com.att.repository.entity.ZPackDetail;
import com.att.repository.entity.ZPackDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZPackDetailMapper {
    long countByExample(ZPackDetailExample example);

    int deleteByExample(ZPackDetailExample example);

    int deleteByPrimaryKey(String sid);

    int insert(ZPackDetail record);

    int insertSelective(ZPackDetail record);

    List<ZPackDetail> selectByExample(ZPackDetailExample example);

    ZPackDetail selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") ZPackDetail record, @Param("example") ZPackDetailExample example);

    int updateByExample(@Param("record") ZPackDetail record, @Param("example") ZPackDetailExample example);

    int updateByPrimaryKeySelective(ZPackDetail record);

    int updateByPrimaryKey(ZPackDetail record);
}