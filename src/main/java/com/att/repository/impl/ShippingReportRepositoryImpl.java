package com.att.repository.impl;

import com.att.domain.shipping.PackingInfo;
import com.att.repository.ShippingReportRepository;
import com.att.repository.entity.ZSfcSnRelation;
import com.att.repository.entity.ZSfcSnRelationExample;
import com.att.repository.entity.ZVwShopOrderPackingInfo;
import com.att.repository.entity.ZVwShopOrderPackingInfoExample;
import com.att.repository.mapper.ZSfcSnRelationMapper;
import com.att.repository.mapper.ZVwShopOrderPackingInfoMapper;
import com.fw.mes.util.FwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShippingReportRepositoryImpl implements ShippingReportRepository {

    @Autowired
    private ZVwShopOrderPackingInfoMapper zVwShopOrderPackingInfoMapper;

    @Autowired
    private ZSfcSnRelationMapper zSfcSnRelationMapper;

    @Override
    public List<ZVwShopOrderPackingInfo> getShippingInfo( PackingInfo packingInfo, String locale ) {
        ZVwShopOrderPackingInfoExample example = new ZVwShopOrderPackingInfoExample();
        ZVwShopOrderPackingInfoExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(packingInfo.getSite());

        if (!FwUtils.isNullOrEmpty(packingInfo.getShopOrder())) {
            criteria.andShopOrderEqualTo(packingInfo.getShopOrder());
        }

        if (!FwUtils.isNullOrEmpty(packingInfo.getCartonNo())) {
            criteria.andCartonNoEqualTo(packingInfo.getCartonNo());
        }

        if (!FwUtils.isNullOrEmpty(packingInfo.getPalletNo())) {
            criteria.andPalletNoEqualTo(packingInfo.getPalletNo());
        }

        if (!FwUtils.isNullOrEmpty(packingInfo.getSn())) {
            criteria.andSnEqualTo(packingInfo.getSn());
        }

        if (!FwUtils.isEmpty(packingInfo.getCartonNoList())) {
            criteria.andCartonNoIn(packingInfo.getCartonNoList());
        }

        if (!FwUtils.isEmpty(packingInfo.getPalletNoList())) {
            criteria.andPalletNoIn(packingInfo.getPalletNoList());
        }

        if (!FwUtils.isEmpty(packingInfo.getSnList())) {
            criteria.andSnIn(packingInfo.getSnList());
        }

        if (!FwUtils.objIsEmpty(packingInfo.getPlannedStartDate())) {
            criteria.andPlannedStartDateGreaterThanOrEqualTo(packingInfo.getPlannedStartDate());
        }

        if (!FwUtils.objIsEmpty(packingInfo.getPlannedCompDate())) {
            criteria.andPlannedCompDateLessThanOrEqualTo(packingInfo.getPlannedCompDate());
        }

        return zVwShopOrderPackingInfoMapper.selectByExample(locale, example);
    }

    @Override
    public List<ZSfcSnRelation> getSn( ZSfcSnRelation zSfcSnRelation ) {
        ZSfcSnRelationExample example = new ZSfcSnRelationExample();
        ZSfcSnRelationExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(zSfcSnRelation.getSite());

        if (!FwUtils.isNullOrEmpty(zSfcSnRelation.getSn())) {
            criteria.andSnEqualTo(zSfcSnRelation.getSn());
        }

        if (!FwUtils.isNullOrEmpty(zSfcSnRelation.getNewSn())) {
            criteria.andNewSnEqualTo(zSfcSnRelation.getNewSn());
        }

        example.setOrderByClause(" CREATED_DATE_TIME DESC ");

        return zSfcSnRelationMapper.selectByExample(example);
    }
}
