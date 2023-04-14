package com.att.controller;

import com.att.domain.nc.NcRequest;
import com.att.domain.nc.NcResponse;
import com.att.service.NcService;
import com.fw.mes.me.entity.ViewDataTypeField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = { "*" })
public class NcController {

    @Autowired
    private NcService ncService;

    @PostMapping("nc/sfc/info")
    public NcResponse getSfcInfo( @RequestBody NcRequest ncRequest ) {
        return ncService.getSfcInfo(ncRequest);
    }

    @PostMapping("nc/column/info")
    public List<ViewDataTypeField> getColumn( @RequestBody NcRequest ncRequest ) {
        return ncService.getColumn(ncRequest);
    }

    @PostMapping("nc/save")
    public void save( @RequestBody NcRequest ncRequest ) {
        ncService.save(ncRequest);
    }
}
