package com.att.mssql.repository.mapper;

import com.att.mssql.repository.entity.IqcOutbound;
import com.att.mssql.repository.entity.IqcOutboundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IqcOutboundMapper {
    long countByExample(IqcOutboundExample example);

    int deleteByExample(IqcOutboundExample example);

    int insert(IqcOutbound record);

    int insertSelective(IqcOutbound record);

    List<IqcOutbound> selectByExample(IqcOutboundExample example);

    int updateByExampleSelective(@Param("record") IqcOutbound record, @Param("example") IqcOutboundExample example);

    int updateByExample(@Param("record") IqcOutbound record, @Param("example") IqcOutboundExample example);
}