package com.att.repository.impl;

import com.att.repository.SnSerialNumberRepository;
import com.att.repository.entity.ZSfcSnRelation;
import com.att.repository.entity.ZSfcSnRelationExample;
import com.att.repository.entity.ZVwSfcSnRelation;
import com.att.repository.entity.ZVwSfcSnRelationExample;
import com.att.repository.mapper.ZSfcSnRelationMapper;
import com.att.repository.mapper.ZVwSfcSnRelationMapper;
import com.fw.mes.util.FwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SnSerialNumberRepositoryImpl implements SnSerialNumberRepository {

    @Autowired
    private ZSfcSnRelationMapper zSfcSnRelationMapper;

    @Autowired
    private ZVwSfcSnRelationMapper zVwSfcSnRelationMapper;

    @Override
    public List<ZSfcSnRelation> getSnRelation( ZSfcSnRelation zSfcSnRelation ) {
        ZSfcSnRelationExample example = new ZSfcSnRelationExample();
        ZSfcSnRelationExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(zSfcSnRelation.getSite());

        if (!FwUtils.isNullOrEmpty(zSfcSnRelation.getSfc())) {
            criteria.andSfcEqualTo(zSfcSnRelation.getSfc());
        }

        if (!FwUtils.isNullOrEmpty(zSfcSnRelation.getSn())) {
            criteria.andSnEqualTo(zSfcSnRelation.getSn());
        }

        if (!FwUtils.isNullOrEmpty(zSfcSnRelation.getSnType())){
            criteria.andSnTypeEqualTo(zSfcSnRelation.getSnType());
        }

        return zSfcSnRelationMapper.selectByExample(example);
    }

    @Override
    public void saveSn( ZSfcSnRelation zSfcSnRelation ) {
        zSfcSnRelationMapper.insertSelective(zSfcSnRelation);
    }

    @Override
    public List<ZVwSfcSnRelation> findZVwSfcSnRelation(ZVwSfcSnRelation zVwSfcSnRelation) {
        ZVwSfcSnRelationExample example = new ZVwSfcSnRelationExample();
        ZVwSfcSnRelationExample.Criteria criteria = example.createCriteria();
        criteria.andSiteEqualTo(zVwSfcSnRelation.getSite());
        if(!FwUtils.isNullOrEmpty(zVwSfcSnRelation.getSnType())){
            criteria.andSnTypeEqualTo(zVwSfcSnRelation.getSnType());
        }
        if(!FwUtils.isNullOrEmpty(zVwSfcSnRelation.getShopOrder())){
            criteria.andShopOrderEqualTo(zVwSfcSnRelation.getShopOrder());
        }
        if(!FwUtils.isNullOrEmpty(zVwSfcSnRelation.getSfc())){
            criteria.andSfcEqualTo(zVwSfcSnRelation.getSfc());
        }
        if(!FwUtils.isNullOrEmpty(zVwSfcSnRelation.getSn())){
            criteria.andSnEqualTo(zVwSfcSnRelation.getSn());
        }

        example.setOrderByClause(" shop_order,sfc,sn ");
        return zVwSfcSnRelationMapper.selectByExample(example);
    }
}
