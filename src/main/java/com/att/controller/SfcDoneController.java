package com.att.controller;

import com.att.domain.sfc.SfcDoneRequest;
import com.att.domain.sfc.SfcDoneResponse;
import com.att.domain.sfcDone.SfcDoneInfo;
import com.att.service.SfcDoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin(origins = { "*" })
public class SfcDoneController {

    @Autowired
    private SfcDoneService sfcDoneService;

    @PostMapping("sfc/done/info")
    public SfcDoneResponse sfcDoneInfo( @RequestBody SfcDoneRequest sfcDoneRequest, Locale locale ) {
        return sfcDoneService.findSfcDoneList(sfcDoneRequest, locale.toString().toLowerCase());
    }

    @PostMapping("sfc/done")
    @Transactional
    public List<SfcDoneInfo> sfcDone( @RequestBody List<SfcDoneInfo> sfcDoneList ) {
        return sfcDoneService.sfcDone(sfcDoneList);
    }
}
