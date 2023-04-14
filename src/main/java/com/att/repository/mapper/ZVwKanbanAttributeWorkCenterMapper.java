package com.att.repository.mapper;

import com.att.repository.entity.ZVwKanbanAttributeWorkCenter;
import com.att.repository.entity.ZVwKanbanAttributeWorkCenterExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZVwKanbanAttributeWorkCenterMapper {

    List<ZVwKanbanAttributeWorkCenter> selectByExample( @Param("locale") String locale,
                                                        @Param("example") ZVwKanbanAttributeWorkCenterExample example );
}