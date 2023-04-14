package com.att.repository.mapper;

import com.att.repository.entity.ZKanbanAttribute;
import com.att.repository.entity.ZKanbanAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZKanbanAttributeMapper {
    long countByExample(ZKanbanAttributeExample example);

    int deleteByExample(ZKanbanAttributeExample example);

    int deleteByPrimaryKey(String sid);

    int insert(ZKanbanAttribute record);

    int insertSelective(ZKanbanAttribute record);

    List<ZKanbanAttribute> selectByExample(ZKanbanAttributeExample example);

    ZKanbanAttribute selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") ZKanbanAttribute record, @Param("example") ZKanbanAttributeExample example);

    int updateByExample(@Param("record") ZKanbanAttribute record, @Param("example") ZKanbanAttributeExample example);

    int updateByPrimaryKeySelective(ZKanbanAttribute record);

    int updateByPrimaryKey(ZKanbanAttribute record);
}