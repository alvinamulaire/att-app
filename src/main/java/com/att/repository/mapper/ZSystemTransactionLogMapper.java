package com.att.repository.mapper;

import com.att.repository.entity.ZSystemTransactionLog;
import com.att.repository.entity.ZSystemTransactionLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZSystemTransactionLogMapper {
    long countByExample(ZSystemTransactionLogExample example);

    int deleteByExample(ZSystemTransactionLogExample example);

    int deleteByPrimaryKey(String transId);

    int insert(ZSystemTransactionLog record);

    int insertSelective(ZSystemTransactionLog record);

    List<ZSystemTransactionLog> selectByExampleWithBLOBs(ZSystemTransactionLogExample example);

    List<ZSystemTransactionLog> selectByExample(ZSystemTransactionLogExample example);

    ZSystemTransactionLog selectByPrimaryKey(String transId);

    int updateByExampleSelective(@Param("record") ZSystemTransactionLog record, @Param("example") ZSystemTransactionLogExample example);

    int updateByExampleWithBLOBs(@Param("record") ZSystemTransactionLog record, @Param("example") ZSystemTransactionLogExample example);

    int updateByExample(@Param("record") ZSystemTransactionLog record, @Param("example") ZSystemTransactionLogExample example);

    int updateByPrimaryKeySelective(ZSystemTransactionLog record);

    int updateByPrimaryKeyWithBLOBs(ZSystemTransactionLog record);

    int updateByPrimaryKey(ZSystemTransactionLog record);
}