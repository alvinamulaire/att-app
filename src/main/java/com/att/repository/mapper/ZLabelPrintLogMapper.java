package com.att.repository.mapper;

import com.att.repository.entity.ZLabelPrintLog;
import com.att.repository.entity.ZLabelPrintLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZLabelPrintLogMapper {
    long countByExample(ZLabelPrintLogExample example);

    int deleteByExample(ZLabelPrintLogExample example);

    int deleteByPrimaryKey(String sid);

    int insert(ZLabelPrintLog record);

    int insertSelective(ZLabelPrintLog record);

    List<ZLabelPrintLog> selectByExampleWithBLOBs(ZLabelPrintLogExample example);

    List<ZLabelPrintLog> selectByExample(ZLabelPrintLogExample example);

    ZLabelPrintLog selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") ZLabelPrintLog record, @Param("example") ZLabelPrintLogExample example);

    int updateByExampleWithBLOBs(@Param("record") ZLabelPrintLog record, @Param("example") ZLabelPrintLogExample example);

    int updateByExample(@Param("record") ZLabelPrintLog record, @Param("example") ZLabelPrintLogExample example);

    int updateByPrimaryKeySelective(ZLabelPrintLog record);

    int updateByPrimaryKeyWithBLOBs(ZLabelPrintLog record);

    int updateByPrimaryKey(ZLabelPrintLog record);
}