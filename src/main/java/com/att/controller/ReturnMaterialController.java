package com.att.controller;

import com.att.domain.returnMaterial.ReturnMaterialInfo;
import com.att.domain.returnMaterial.ReturnMaterialRequest;
import com.att.repository.entity.ZVwInventoryAssyData;
import com.att.repository.entity.ZVwInventoryItem;
import com.att.repository.entity.ZVwInventoryShopOrder;
import com.att.service.ReturnMaterialService;
import com.businessobjects.visualization.internal.org.json.JSONException;
import com.sap.me.frame.domain.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin(origins = { "*" })
public class ReturnMaterialController {

    @Autowired
    private ReturnMaterialService returnMaterialService;

    @PostMapping("return/material/info")
    public List<ReturnMaterialInfo> findReturnMaterialList( @RequestBody ReturnMaterialInfo returnMaterialInfo ) {
        return returnMaterialService.findReturnMaterialList(returnMaterialInfo);
    }

    @GetMapping("return/material/item")
    public List<ZVwInventoryItem> findItemByReturnMaterial( @RequestParam("site") String site,
                                                            @RequestParam(value = "item", required = false) String item,
                                                            Locale locale ) {
        return returnMaterialService.findItemByReturnMaterial(site, item, locale.toString().toLowerCase());
    }

    @GetMapping("return/material/shopOrder")
    public List<ReturnMaterialInfo> findShopOrderByReturnMaterial( @RequestParam("site") String site,
                                                                      @RequestParam("shopOrder") String shopOrder,
                                                                      Locale locale ) {
        return returnMaterialService.findShopOrderByReturnMaterial(site, shopOrder, locale.toString().toLowerCase());
    }

    @GetMapping("return/material/assyData")
    public List<ZVwInventoryAssyData> findInventoryAssyDataByReturnMaterial( @RequestParam("site") String site,
                                                                             @RequestParam("dataField") String dataField ) {
        return returnMaterialService.findInventoryAssyDataByReturnMaterial(site, dataField);
    }

    @GetMapping("return/material/storage")
    public List<ReturnMaterialInfo> findStorageByReturnMaterial( @RequestParam("site") String site ) throws JSONException {
        return returnMaterialService.findStorageByReturnMaterial(site);
    }

    @PostMapping("return/material")
    public void returnMaterial( @RequestBody ReturnMaterialRequest returnMaterialRequest ) throws BusinessException {
        returnMaterialService.returnMaterial(returnMaterialRequest);
    }
}
