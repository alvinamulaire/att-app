package com.att.controller;

import com.att.domain.kanban.*;
import com.att.service.ResourceIntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin(origins = { "*" })
public class ResourceIntegrationController {

    @Autowired
    private ResourceIntegrationService resourceIntegrationService;

    @PostMapping("kanban/info")
    public KanbanResponse kanBanInfo( @RequestBody KanbanRequest kanbanRequest ) {
        return resourceIntegrationService.getKanBanInfo(kanbanRequest);
    }

    @PostMapping("kanban/work/center/info")
    public KanbanResponse workCenterInfo( @RequestBody KanbanRequest kanbanRequest ) {
        return resourceIntegrationService.getWorkCenterInfo(kanbanRequest);
    }

    @PostMapping("kanban/resource/status/info")
    public KanbanResponse resourceStatusInfo( @RequestBody KanbanRequest kanbanRequest ) {
        return resourceIntegrationService.getResourceStatusInfo(kanbanRequest);
    }

    @PostMapping("kanban/month/efficiency")
    public KanbanResponse monthAvgEfficiency( @RequestBody KanbanRequest kanbanRequest ) {
        return resourceIntegrationService.getMonthAvgEfficiency(kanbanRequest);
    }

    @PostMapping("kanban/day/efficiency")
    public KanbanResponse dayAvgEfficiency( @RequestBody KanbanRequest kanbanRequest ) {
        return resourceIntegrationService.getDayAvgEfficiency(kanbanRequest);
    }

    @PostMapping("kanban/resource/efficiency")
    public List<ResourceStatusInfo> resourceDayEfficiency( @RequestBody KanbanRequest kanbanRequest ) {
        return resourceIntegrationService.getResourceDayEfficiency(kanbanRequest);
    }

    @PostMapping("kanban/save/attribute")
    public void saveAttribute( @RequestParam("site") String site,
                               @RequestParam("user") String user,
                               @RequestParam("activity") String activity,
                               @RequestBody List<AttributeRequest> attributeRequestList ) {
        resourceIntegrationService.saveAttribute(site, user, activity, attributeRequestList);
    }

    @PostMapping("kanban/get/attribute")
    public List<AttributeResponse> getAttribute( @RequestBody AttributeRequest attributeRequest,
                                                 Locale locale ) {
        return resourceIntegrationService.getAttribute(attributeRequest, locale.toString().toLowerCase());
    }
}
