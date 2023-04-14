package com.att.service;

import com.att.domain.kanban.*;

import java.util.List;

public interface ResourceIntegrationService {

    KanbanResponse getKanBanInfo( KanbanRequest kanBanRequest );

    KanbanResponse getWorkCenterInfo( KanbanRequest kanbanRequest );

    KanbanResponse getResourceStatusInfo( KanbanRequest kanbanRequest );

    KanbanResponse getMonthAvgEfficiency( KanbanRequest kanbanRequest );

    KanbanResponse getDayAvgEfficiency( KanbanRequest kanbanRequest );

    List<ResourceStatusInfo> getResourceDayEfficiency( KanbanRequest kanbanRequest );

    void saveAttribute( String site, String user, String activity, List<AttributeRequest> attributeRequestList );

    List<AttributeResponse> getAttribute( AttributeRequest attributeRequest, String locale );
}
