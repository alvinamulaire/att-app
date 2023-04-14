package com.att.controller;

import com.att.domain.sn.SnRequest;
import com.att.domain.sn.SnResponse;
import com.att.service.SnSerialNumberService;
import com.businessobjects.visualization.internal.org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = { "*" })
public class SnSerialNumberController {

    @Autowired
    private SnSerialNumberService snSerialNumberService;

    @PostMapping("sn/info")
    public SnResponse getSfcSnInfo( @RequestBody SnRequest snRequest ) {
        return snSerialNumberService.getSfcSnInfo(snRequest);
    }

    @PostMapping("sn/save")
    public void saveSn( @RequestBody SnRequest snRequest ) {
        snSerialNumberService.saveSn(snRequest);
    }

    @PostMapping("tl/sn/info")
    public SnResponse tlSnInfo(@RequestBody SnRequest snRequest ){
        return snSerialNumberService.getTlSnInfo(snRequest);
    }

    @PostMapping("tl/sn/createSn")
    public List<String> tlCreateSn(@RequestBody SnRequest snRequest) throws JSONException {
        return snSerialNumberService.createSn(snRequest);
    }
}
