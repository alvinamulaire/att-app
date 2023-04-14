package com.att.controller;

import com.att.domain.packagingProduct.PackagingProductRequest;
import com.att.domain.packagingProduct.ProductRequest;
import com.att.repository.entity.ZVwPackInspecItemPlanDetail;
import com.att.repository.entity.ZVwQcPlanItem;
import com.att.service.PackagingProductService;
import com.fw.mes.me.controller.item.ItemRepo;
import com.fw.mes.me.entity.ViewItemDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = { "*" })
public class PackagingProductController {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private PackagingProductService packagingProductService;

    @GetMapping("packaging/prod/item/get")
    public List<ViewItemDesc> getItemList( @RequestParam("site") String site,
                                           @RequestParam("lan") String lan ) {
        return itemRepo.itemList(site, lan.toLowerCase());
    }

    @PostMapping("packaging/prod/qc/get")
    public List<ZVwQcPlanItem> getQcPlan( @RequestBody PackagingProductRequest packagingProductRequest ) {
        return packagingProductService.getQcPlan(packagingProductRequest);
    }

    @PostMapping("packaging/prod/qc/item/get")
    public List<ZVwQcPlanItem> getQcPlanItem( @RequestBody PackagingProductRequest packagingProductRequest ) {
        return packagingProductService.getQcPlanItem(packagingProductRequest);
    }

    @PostMapping("packaging/prod/retrieve")
    public List<ZVwPackInspecItemPlanDetail> retrieve( @RequestBody PackagingProductRequest packagingProductRequest ) {
        return packagingProductService.retrieve(packagingProductRequest);
    }

    @PostMapping("packaging/prod/save")
    public void save( @RequestBody ProductRequest productRequest ) {
        packagingProductService.save(productRequest);
    }
}
