package com.att.controller;

import com.att.domain.packaging.PackagingMaster;
import com.att.domain.print.AttPrintRequest;
import com.att.domain.print.AttPrintResponse;
import com.att.domain.print.PrintInfo;
import com.att.service.AttPrintService;
import com.businessobjects.visualization.internal.org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin(origins = { "*" })
public class PrintController {

    @Autowired
    private AttPrintService attPrintService;

    @PostMapping("print/print")
    public void print( @RequestBody List<AttPrintRequest> requestList ) throws JSONException {
        attPrintService.print(requestList);
    }

    @PostMapping("print/info")
    public List<AttPrintResponse> printInfo(@RequestBody AttPrintRequest attPrintRequest , Locale locale) {
        return attPrintService.printInfo(attPrintRequest, locale.toString().toLowerCase());
    }

    @PostMapping("reprint/carton")
    public void printCarton( @RequestBody PrintInfo printInfo ) throws JSONException {
        attPrintService.printCarton(printInfo);
    }

    @PostMapping("reprint/pallet")
    public void printPallet( @RequestBody PrintInfo printInfo ) throws JSONException {
        attPrintService.printPallet(printInfo);
    }

    @PostMapping("print/containNo")
    public List<String> findContainNoList(@RequestBody PackagingMaster request ) {
        return attPrintService.findContainNoList(request);
    }
}
