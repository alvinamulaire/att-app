package com.att.repository.impl;

import com.att.repository.PackagingProductRepository;
import com.att.repository.entity.*;
import com.att.repository.mapper.*;
import com.fw.mes.util.FwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PackagingProductRepositoryImpl implements PackagingProductRepository {

    @Autowired
    private ZVwQcPlanProdMapper zVwQcPlanProdMapper;

    @Autowired
    private ZVwQcPlanItemMapper zVwQcPlanItemMapper;

    @Autowired
    private ZPackInspecItemMapper zPackInspecItemMapper;

    @Autowired
    private ZPackInspecItemLogMapper zPackInspecItemLogMapper;

    @Autowired
    private ZVwInspecItemDetailMapper zVwInspecItemDetailMapper;

    @Autowired
    private ZVwPackInspecItemPlanDetailMapper zVwPackInspecItemPlanDetailMapper;

    @Override
    public List<ZVwQcPlanProd> getQcPlan( ZVwQcPlanProd zVwQcPlanProd ) {
        ZVwQcPlanProdExample example = new ZVwQcPlanProdExample();
        ZVwQcPlanProdExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(zVwQcPlanProd.getSite());

        if (!FwUtils.isNullOrEmpty(zVwQcPlanProd.getQcPlan())) {
            criteria.andQcPlanEqualTo(zVwQcPlanProd.getQcPlan());
        }

        if (!FwUtils.isNullOrEmpty(zVwQcPlanProd.getItem())) {
            criteria.andItemEqualTo(zVwQcPlanProd.getItem());
        }

        if (!FwUtils.isNullOrEmpty(zVwQcPlanProd.getMaterialNo())) {
            criteria.andMaterialNoEqualTo(zVwQcPlanProd.getMaterialNo());
        }

        if (!FwUtils.isNullOrEmpty(zVwQcPlanProd.getCurrentRevision())) {
            criteria.andCurrentRevisionEqualTo(zVwQcPlanProd.getCurrentRevision());
        }

        return zVwQcPlanProdMapper.selectByExample(example);
    }

    @Override
    public List<ZVwQcPlanItem> getQcPlanItem( ZVwQcPlanItem zVwQcPlanItem ) {
        ZVwQcPlanItemExample example = new ZVwQcPlanItemExample();
        ZVwQcPlanItemExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(zVwQcPlanItem.getSite());

        if (!FwUtils.isNullOrEmpty(zVwQcPlanItem.getHandle())) {
            criteria.andHandleEqualTo(zVwQcPlanItem.getHandle());
        }

        if (!FwUtils.isNullOrEmpty(zVwQcPlanItem.getQcPlan())) {
            criteria.andQcPlanEqualTo(zVwQcPlanItem.getQcPlan());
        }

        if (!FwUtils.isNullOrEmpty(zVwQcPlanItem.getQcItemSid())) {
            criteria.andQcItemSidEqualTo(zVwQcPlanItem.getQcItemSid());
        }

        if (!FwUtils.isNullOrEmpty(zVwQcPlanItem.getCurrentRevision())) {
            criteria.andCurrentRevisionEqualTo(zVwQcPlanItem.getCurrentRevision());
        }

        if (!FwUtils.isNullOrEmpty(zVwQcPlanItem.getStatus())) {
            criteria.andStatusEqualTo(zVwQcPlanItem.getStatus());
        }

        if (!FwUtils.isNullOrEmpty(zVwQcPlanItem.getQcMode())) {
            criteria.andQcModeEqualTo(zVwQcPlanItem.getQcMode());
        }

        if (!FwUtils.isNullOrEmpty(zVwQcPlanItem.getItemType())) {
            criteria.andItemTypeEqualTo(zVwQcPlanItem.getItemType());
        }

        return zVwQcPlanItemMapper.selectByExample(example);
    }

    @Override
    public List<ZPackInspecItem> getPackInspec( ZPackInspecItem zPackInspecItem ) {
        ZPackInspecItemExample example = new ZPackInspecItemExample();
        ZPackInspecItemExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(zPackInspecItem.getSite());

        if (!FwUtils.isNullOrEmpty(zPackInspecItem.getItem())) {
            criteria.andItemEqualTo(zPackInspecItem.getItem());
        }

        if (!FwUtils.isNullOrEmpty(zPackInspecItem.getQcPlanBo())) {
            criteria.andQcPlanBoEqualTo(zPackInspecItem.getQcPlanBo());
        }

        if (!FwUtils.isNullOrEmpty(zPackInspecItem.getQcItemSid())) {
            criteria.andQcItemSidEqualTo(zPackInspecItem.getQcItemSid());
        }

        return zPackInspecItemMapper.selectByExample(example);
    }

    @Override
    public List<ZVwInspecItemDetail> getPackInspecDetail( ZVwInspecItemDetail zVwInspecItemDetail ) {
        ZVwInspecItemDetailExample example = new ZVwInspecItemDetailExample();
        ZVwInspecItemDetailExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(zVwInspecItemDetail.getSite());

        if (!FwUtils.isNullOrEmpty(zVwInspecItemDetail.getItem())) {
            criteria.andItemEqualTo(zVwInspecItemDetail.getItem());
        }

        return zVwInspecItemDetailMapper.selectByExample(example);
    }

    @Override
    public List<ZVwPackInspecItemPlanDetail> getPackInspec( String site, String item ) {
        ZVwPackInspecItemPlanDetailExample example = new ZVwPackInspecItemPlanDetailExample();
        ZVwPackInspecItemPlanDetailExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(site);

        if (!FwUtils.isNullOrEmpty(item)) {
            criteria.andItemEqualTo(item);
        }

        return zVwPackInspecItemPlanDetailMapper.selectByExample(example);
    }

    @Override
    public void insertPackInspecItem( ZPackInspecItem zPackInspecItem ) {
        zPackInspecItemMapper.insertSelective(zPackInspecItem);
    }

    @Override
    public void delPackInspecItem( String sid ) {
        zPackInspecItemMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public void insertPackInspecItemLog( ZPackInspecItemLog zPackInspecItemLog ) {
        zPackInspecItemLogMapper.insertSelective(zPackInspecItemLog);
    }

}
