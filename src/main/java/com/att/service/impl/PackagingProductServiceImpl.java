package com.att.service.impl;

import com.att.converent.PackagingProductConverter;
import com.att.domain.packagingProduct.PackagingProductRequest;
import com.att.domain.packagingProduct.ProductRequest;
import com.att.repository.PackagingProductRepository;
import com.att.repository.entity.*;
import com.att.service.PackagingProductService;
import com.fw.mes.me.controller.item.ItemRepo;
import com.fw.mes.util.DateUtil;
import com.fw.mes.util.FwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PackagingProductServiceImpl implements PackagingProductService {

    @Autowired
    private PackagingProductRepository packagingProductRepository;

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public List<ZVwQcPlanItem> getQcPlan( PackagingProductRequest packagingProductRequest ) {
        ZVwQcPlanItem zVwQcPlanItem = new ZVwQcPlanItem();
        zVwQcPlanItem.setSite(packagingProductRequest.getSite());
        zVwQcPlanItem.setCurrentRevision("true");
        return packagingProductRepository.getQcPlanItem(zVwQcPlanItem).stream()
                .filter(FwUtils.distinctByKey(ZVwQcPlanItem::getQcPlan))
                .collect(Collectors.toList());
    }

    @Override
    public List<ZVwQcPlanItem> getQcPlanItem( PackagingProductRequest packagingProductRequest ) {
        ZVwQcPlanItem zVwQcPlanItem = new ZVwQcPlanItem();
        zVwQcPlanItem.setSite(packagingProductRequest.getSite());
        zVwQcPlanItem.setCurrentRevision("true");
        zVwQcPlanItem.setQcMode("0");
        zVwQcPlanItem.setItemType("1");
        zVwQcPlanItem.setStatus("0");
        return packagingProductRepository.getQcPlanItem(zVwQcPlanItem);
    }

    @Override
    public List<ZVwPackInspecItemPlanDetail> retrieve( PackagingProductRequest packagingProductRequest ) {
        String site = packagingProductRequest.getSite();
        String item = packagingProductRequest.getItem();

        this.checkItem(site, item);

        return packagingProductRepository.getPackInspec(site, item);
    }

    @Transactional
    @Override
    public void save( List<PackagingProductRequest> list ) {
        list.forEach(request -> {
            ZPackInspecItem zPackInspecItem = new ZPackInspecItem();
            zPackInspecItem.setSid(FwUtils.getUid());
            zPackInspecItem.setSite(request.getSite());
            zPackInspecItem.setItem(request.getItem());
            zPackInspecItem.setQcPlanBo(request.getQcPlanBo());
            zPackInspecItem.setQcItemSid(request.getQcItemSid());
            zPackInspecItem.setCreateDateTime(DateUtil.getGmtTime());
            zPackInspecItem.setCreateUser(request.getUser());
            packagingProductRepository.insertPackInspecItem(zPackInspecItem);
        });
    }

    @Transactional
    @Override
    public void save( ProductRequest productRequest ) {
        String site = productRequest.getSite();
        String item = productRequest.getItem();

        ZPackInspecItem packInspecItem = new ZPackInspecItem();
        packInspecItem.setSite(site);
        packInspecItem.setItem(item);

        this.checkItem(site, item);

        List<ZPackInspecItem> packInspecItems = packagingProductRepository.getPackInspec(packInspecItem);

        packInspecItems.forEach(inspecItem -> {
            ZPackInspecItemLog zPackInspecItemLog = PackagingProductConverter.INSTANCE.toLog(inspecItem);
            packagingProductRepository.delPackInspecItem(zPackInspecItemLog.getSid());
            packagingProductRepository.insertPackInspecItemLog(zPackInspecItemLog);
        });

        this.save(productRequest.getProductRequestList());
    }

    private void checkItem( String site, String item ) {
        if (FwUtils.isEmpty(itemRepo.findCurrentItem(site, item))) {
            FwUtils.getCustomException("packaging.inspec.error1");
        }
    }
}
