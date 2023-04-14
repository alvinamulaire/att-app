package com.att.repository.impl;

import com.att.repository.YieldRateRepository;
import com.att.repository.entity.*;
import com.att.repository.mapper.ZMaterialYieldBasisMapper;
import com.att.repository.mapper.ZVwMaterialYieldItemDescMapper;
import com.att.repository.mapper.ZVwYieldBasisRouterMapper;
import com.att.repository.mapper.ZVwYieldRouterMapper;
import com.fw.mes.util.FwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class YieldRateRepositoryImpl implements YieldRateRepository {

    @Autowired
    private ZVwMaterialYieldItemDescMapper zVwMaterialYieldItemDescMapper;

    @Autowired
    private ZVwYieldBasisRouterMapper zVwYieldBasisRouterMapper;

    @Autowired
    private ZMaterialYieldBasisMapper zMaterialYieldBasisMapper;

    @Autowired
    private ZVwYieldRouterMapper zVwYieldRouterMapper;

    @Override
    public List<ZVwMaterialYieldItemDesc> getMaterialDesc( String site, String item, String locale ) {
        ZVwMaterialYieldItemDescExample example = new ZVwMaterialYieldItemDescExample();
        ZVwMaterialYieldItemDescExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(site);

        if (!FwUtils.isNullOrEmpty(item)) {
            criteria.andItemEqualTo(item);
        }

        return zVwMaterialYieldItemDescMapper.selectByExample(locale, example);
    }

    @Override
    public List<ZVwYieldBasisRouter> getYieldRouter( ZVwYieldBasisRouter zVwYieldBasisRouter ) {
        ZVwYieldBasisRouterExample example = new ZVwYieldBasisRouterExample();
        ZVwYieldBasisRouterExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(zVwYieldBasisRouter.getSite());

        if (!FwUtils.isNullOrEmpty(zVwYieldBasisRouter.getItem())) {
            criteria.andItemEqualTo(zVwYieldBasisRouter.getItem());
        }

        if (!FwUtils.isNullOrEmpty(zVwYieldBasisRouter.getRouter())) {
            criteria.andRouterLike(zVwYieldBasisRouter.getRouter() + "%");
        }

        return zVwYieldBasisRouterMapper.selectByExample(example);
    }

    @Override
    public List<ZVwYieldRouter> getYieldInfo( String locale, ZVwYieldRouter zVwYieldRouter ) {
        ZVwYieldRouterExample example = new ZVwYieldRouterExample();
        ZVwYieldRouterExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(zVwYieldRouter.getSite());

        if (!FwUtils.isNullOrEmpty(zVwYieldRouter.getItem())) {
            criteria.andItemEqualTo(zVwYieldRouter.getItem());
        }

        if (!FwUtils.isNullOrEmpty(zVwYieldRouter.getRouter())) {
            criteria.andRouterEqualTo(zVwYieldRouter.getRouter());
        }

        return zVwYieldRouterMapper.selectByExample(locale, example);
    }

    @Override
    public List<ZMaterialYieldBasis> getMaterialYield( ZMaterialYieldBasis zMaterialYieldBasis ) {
        ZMaterialYieldBasisExample example = new ZMaterialYieldBasisExample();
        ZMaterialYieldBasisExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(zMaterialYieldBasis.getSite());

        if (!FwUtils.isNullOrEmpty(zMaterialYieldBasis.getItem())) {
            criteria.andItemEqualTo(zMaterialYieldBasis.getItem());
        }

        if (!FwUtils.isNullOrEmpty(zMaterialYieldBasis.getRouter())) {
            criteria.andRouterEqualTo(zMaterialYieldBasis.getRouter());
        }

        return zMaterialYieldBasisMapper.selectByExample(example);
    }

    @Override
    public void deleteMaterialYield( String site, String item ) {
        ZMaterialYieldBasisExample example = new ZMaterialYieldBasisExample();
        example.createCriteria()
                .andSiteEqualTo(site)
                .andItemEqualTo(item);

        zMaterialYieldBasisMapper.deleteByExample(example);
    }

    @Override
    public void insertMaterialYield( ZMaterialYieldBasis zMaterialYieldBasis ) {
        zMaterialYieldBasisMapper.insertSelective(zMaterialYieldBasis);
    }
}
