package com.att.controller;

import com.att.domain.nc.NcReportRequest;
import com.att.domain.nc.NcReportResponse;
import com.att.domain.nc.SfcNcDataInfo;
import com.att.service.NcReportService;
import com.fw.mes.me.entity.ViewItemDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin(origins = { "*" })
public class NcReportController {

    @Autowired
    private NcReportService ncReportService;

    @PostMapping("nc/report/shop/order/info")
    public List<SfcNcDataInfo> ncShopOrderInfo( @RequestBody NcReportRequest ncReportRequest ) {
        return ncReportService.getNcShopOrder(ncReportRequest);
    }

    @GetMapping("nc/report/item/info")
    public List<ViewItemDesc> itemInfo( @RequestParam("site") String site,
                                        Locale locale ) {
        return ncReportService.getItem(site, locale.toString().toLowerCase());
    }

    @PostMapping("nc/report/retrieve")
    public NcReportResponse retrieve( @RequestBody NcReportRequest ncReportRequest ) {
        return ncReportService.retrieve(ncReportRequest);
    }

    @GetMapping("nc/report/user/name")
    public String userNameInfo( @RequestParam("site") String site,
                                @RequestParam("user") String user ) {
        return ncReportService.getUserName(site, user);
    }

    @PostMapping("nc/report/update/reason")
    public void updateSfcNcData( @RequestBody NcReportRequest ncReportRequest ) {
        ncReportService.updateSfcNcData(ncReportRequest);
    }
}
