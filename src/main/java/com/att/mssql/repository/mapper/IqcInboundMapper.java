package com.att.mssql.repository.mapper;

import com.att.mssql.repository.entity.IqcInbound;
import com.att.mssql.repository.entity.IqcInboundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IqcInboundMapper {
    long countByExample(IqcInboundExample example);

    int deleteByExample(IqcInboundExample example);

    int insert(IqcInbound record);

    int insertSelective(IqcInbound record);

    List<IqcInbound> selectByExample(IqcInboundExample example);

    int updateByExampleSelective(@Param("record") IqcInbound record, @Param("example") IqcInboundExample example);

    int updateByExample(@Param("record") IqcInbound record, @Param("example") IqcInboundExample example);
}