package com.att.repository.impl;

import com.att.domain.returnMaterial.ReturnMaterialInfo;
import com.att.repository.ReturnMaterialRepository;
import com.att.repository.entity.*;
import com.att.repository.mapper.*;
import com.fw.mes.util.FwUtils;
import com.sap.me.demand.ShopOrderBOHandle;
import com.sap.me.status.StatusBOHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ReturnMaterialRepositoryImpl implements ReturnMaterialRepository {

    @Autowired
    private ZVwReturnMaterialMapper zVwReturnMaterialMapper;

    @Autowired
    private ZVwInventoryItemMapper zVwInventoryItemMapper;

    @Autowired
    private ZVwInventoryShopOrderMapper zVwInventoryShopOrderMapper;

    @Autowired
    private ZVwInventoryAssyDataMapper zVwInventoryAssyDataMapper;

    @Autowired
    private ZVwInventoryStorageMapper zVwInventoryStorageMapper;

    @Override
    public List<ZVwReturnMaterial> findViewReturnMaterial( ReturnMaterialInfo returnMaterialInfo, String locale ) {
        ZVwReturnMaterialExample example = new ZVwReturnMaterialExample();
        ZVwReturnMaterialExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(returnMaterialInfo.getSite())
                .andStatusBoEqualTo(new StatusBOHandle(returnMaterialInfo.getSite(), "1001").getValue())
                .andQtyOnHandGreaterThan(BigDecimal.ZERO);

        if (!FwUtils.isNullOrEmpty(returnMaterialInfo.getItem())) {
            criteria.andItemEqualTo(returnMaterialInfo.getItem());
        }

        if (!FwUtils.isNullOrEmpty(returnMaterialInfo.getShopOrder())) {
            criteria.andShopOrderLocBoEqualTo(new ShopOrderBOHandle(returnMaterialInfo.getSite(), returnMaterialInfo.getShopOrder()).getValue());
        }

        if (!FwUtils.isNullOrEmpty(returnMaterialInfo.getBatchNumber())) {
            criteria.andBatchNumberEqualTo(returnMaterialInfo.getBatchNumber());
        }

        if (!FwUtils.isNullOrEmpty(returnMaterialInfo.getMch1Lifnr())) {
            criteria.andMch1LifnrEqualTo(returnMaterialInfo.getMch1Lifnr());
        }

        if (!FwUtils.isNullOrEmpty(returnMaterialInfo.getMatDocNum())) {
            criteria.andMatDocNumEqualTo(returnMaterialInfo.getMatDocNum());
        }

        if (!FwUtils.isNullOrEmpty(returnMaterialInfo.getStorage())) {
            criteria.andStorageLocationBoEqualTo("StorageLocationBO:" + returnMaterialInfo.getSite() + "," + returnMaterialInfo.getStorage());
        }

        if ("Y".equals(returnMaterialInfo.getIsIssue())) {
            criteria.andShopOrderSetByErpEqualTo("true");
            criteria.andErpInventoryEqualTo("true");
        }

        return zVwReturnMaterialMapper.selectByExample(locale, example);
    }

    @Override
    public List<ZVwInventoryItem> findItemByReturnMaterial( String site, String item, String local ) {
        ZVwInventoryItemExample example = new ZVwInventoryItemExample();
        example.createCriteria()
                .andSiteEqualTo(site);

        if (!FwUtils.isNullOrEmpty(item)) {
            example.getOredCriteria().get(0).andItemLike(item + "%");
        }

        return zVwInventoryItemMapper.selectByExample(local, example);
    }

    @Override
    public List<ZVwInventoryShopOrder> findShopOrderByReturnMaterial( String site, String shopOrder, String local ) {
        ZVwInventoryShopOrderExample example = new ZVwInventoryShopOrderExample();
        ZVwInventoryShopOrderExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(site);

        if (!FwUtils.isNullOrEmpty(shopOrder)) {
            criteria.andShopOrderLike(shopOrder + "%");
        }

        return zVwInventoryShopOrderMapper.selectByExample(local, example);
    }

    @Override
    public List<ZVwInventoryAssyData> findInventoryAssyDataByReturnMaterial( String site, String dataField ) {
        ZVwInventoryAssyDataExample example = new ZVwInventoryAssyDataExample();
        ZVwInventoryAssyDataExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(site)
                .andDataFieldEqualTo(dataField)
                .andStatusBoEqualTo(new StatusBOHandle(site, "1001").getValue())
                .andQtyOnHandGreaterThan(BigDecimal.ZERO)
                .andResourceLocBoIsNull()
                .andResourceLocResEqualTo("false");

        return zVwInventoryAssyDataMapper.selectByExample(example);
    }

    @Override
    public List<ZVwInventoryStorage> findStorageByReturnMaterial( String site ) {
        ZVwInventoryStorageExample example = new ZVwInventoryStorageExample();
        ZVwInventoryStorageExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(site);

        return zVwInventoryStorageMapper.selectByExample(example);
    }
}
