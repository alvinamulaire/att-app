package com.att.controller;

import com.att.domain.yield.YieldRateRequest;
import com.att.repository.entity.ZVwMaterialYieldItemDesc;
import com.att.repository.entity.ZVwYieldBasisRouter;
import com.att.repository.entity.ZVwYieldRouter;
import com.att.service.YieldRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin(origins = { "*" })
public class YieldRateController {

    @Autowired
    private YieldRateService yieldRateService;

    @GetMapping("yield/item/get")
    public List<ZVwMaterialYieldItemDesc> getMaterialDesc( @RequestParam("site") String site,
                                                           @RequestParam(value = "item", required = false) String item,
                                                           Locale locale ) {
        return yieldRateService.getMaterialDesc(site, item, locale.toString().toLowerCase());
    }

    @GetMapping("yield/router/get")
    public List<ZVwYieldBasisRouter> getYieldRouter( @RequestParam("site") String site,
                                                     @RequestParam("item") String item,
                                                     @RequestParam(value = "router", required = false) String router ) {
        return yieldRateService.getYieldRouter(site, item, router);
    }

    @PostMapping("yield/info")
    public List<ZVwYieldRouter> getMaterialYield( @RequestBody YieldRateRequest yieldRateRequest ) {
        return yieldRateService.getMaterialYield(yieldRateRequest);
    }

    @PostMapping("yield/import")
    public void importYield( @RequestBody YieldRateRequest yieldRateRequest ) {
        yieldRateService.importYield(yieldRateRequest);
    }
}
