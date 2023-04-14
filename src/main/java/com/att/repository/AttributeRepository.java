package com.att.repository;

import com.att.repository.entity.ZKanbanAttribute;
import com.att.repository.entity.ZVwKanbanAttributeWorkCenter;

import java.util.List;

public interface AttributeRepository {

    void save( ZKanbanAttribute zKanbanAttribute );

    List<ZVwKanbanAttributeWorkCenter> getAttribute( ZKanbanAttribute zKanbanAttribute, String locale );

    void delete( String site, String activity );
}
