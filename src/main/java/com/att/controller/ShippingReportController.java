package com.att.controller;

import com.att.domain.shipping.PackingInfo;
import com.att.repository.entity.ZVwShopOrderPackingInfo;
import com.att.service.ShippingReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = { "*" })
public class ShippingReportController {

    @Autowired
    private ShippingReportService shippingReportService;

    @PostMapping("shipping/shop/order/info")
    public List<ZVwShopOrderPackingInfo> getPackingShopOrder( @RequestBody PackingInfo packingInfo ) {
        return shippingReportService.getPackingShopOrder(packingInfo);
    }

    @PostMapping("shipping/carton/info")
    public List<ZVwShopOrderPackingInfo> getPackingCarton( @RequestBody PackingInfo packingInfo ) {
        return shippingReportService.getPackingCarton(packingInfo);
    }

    @PostMapping("shipping/pallet/info")
    public List<ZVwShopOrderPackingInfo> getPackingPallet( @RequestBody PackingInfo packingInfo ) {
        return shippingReportService.getPackingPallet(packingInfo);
    }

    @PostMapping("shipping/sn/info")
    public List<ZVwShopOrderPackingInfo> getPackingSn( @RequestBody PackingInfo packingInfo ) {
        return shippingReportService.getPackingSn(packingInfo);
    }

    @PostMapping("shipping/retrieve")
    public List<Map<String, String>> retrieve( @RequestBody PackingInfo packingInfo ) {
        return shippingReportService.retrieve(packingInfo);
    }

    @PostMapping("shipping/read/excel")
    public byte[] readExcel( @RequestBody List<Map<String, String>> maps ) {
        return shippingReportService.readExcel(maps);
    }
}
