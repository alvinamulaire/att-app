package com.att.controller;

import com.att.domain.tool.ToolRequest;
import com.att.domain.tool.ToolResponse;
import com.att.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = { "*" })
public class ToolController {

    @Autowired
    private ToolService toolService;

    @PostMapping("tool/opAndRes/info")
    public ToolResponse getOpResInfo( @RequestBody ToolRequest toolRequest ) {
        return toolService.getOpResInfo(toolRequest);
    }

    @PostMapping("tool/scan/sfc")
    public ToolResponse scanSfc( @RequestBody ToolRequest toolRequest ) {
        return toolService.scanSfc(toolRequest);
    }

    @PostMapping("tool/scan/resource")
    public ToolResponse scanResource( @RequestBody ToolRequest toolRequest ) {
        return toolService.scanResource(toolRequest);
    }

    @PostMapping("tool/scan")
    public ToolResponse scan( @RequestBody ToolRequest toolRequest ) {
        return toolService.scan(toolRequest);
    }

    @PostMapping("tool/del")
    public ToolResponse delTool( @RequestBody ToolRequest toolRequest ) {
        return toolService.delTool(toolRequest);
    }

    @PostMapping("tool/start")
    public String start( @RequestBody ToolRequest toolRequest ) {
        return toolService.start(toolRequest);
    }

    @PostMapping("tool/complete")
    public String complete( @RequestBody ToolRequest toolRequest ) {
        return toolService.complete(toolRequest);
    }

    @PostMapping("tool/off")
    public String off( @RequestBody ToolRequest toolRequest ) {
        return toolService.off(toolRequest);
    }
}
