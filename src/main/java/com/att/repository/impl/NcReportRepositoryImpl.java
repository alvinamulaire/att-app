package com.att.repository.impl;

import com.att.domain.nc.NcReportRequest;
import com.att.repository.NcReportRepository;
import com.att.repository.entity.ZSfcNcData;
import com.att.repository.entity.ZSfcNcDataExample;
import com.att.repository.entity.ZVwSfcNcData;
import com.att.repository.entity.ZVwSfcNcDataExample;
import com.att.repository.mapper.ZSfcNcDataMapper;
import com.att.repository.mapper.ZVwSfcNcDataMapper;
import com.fw.mes.util.FwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NcReportRepositoryImpl implements NcReportRepository {

    @Autowired
    private ZVwSfcNcDataMapper zVwSfcNcDataMapper;

    @Autowired
    private ZSfcNcDataMapper zSfcNcDataMapper;

    @Override
    public List<ZVwSfcNcData> getSfcNcData( String locale, NcReportRequest ncReportRequest ) {
        ZVwSfcNcDataExample example = new ZVwSfcNcDataExample();
        ZVwSfcNcDataExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(ncReportRequest.getSite());

        if (!FwUtils.isNullOrEmpty(ncReportRequest.getShopOrder())) {
            criteria.andShopOrderEqualTo(ncReportRequest.getShopOrder());
        }

        if (!FwUtils.isEmpty(ncReportRequest.getItemList())) {
            criteria.andItemIn(ncReportRequest.getItemList());
        }

        if (!FwUtils.isEmpty(ncReportRequest.getOperationList())) {
            criteria.andOperationIn(ncReportRequest.getOperationList());
        }

        if (!FwUtils.isEmpty(ncReportRequest.getNcCodeList())) {
            criteria.andNcCodeIn(ncReportRequest.getNcCodeList());
        }

        if (!FwUtils.isNullOrEmpty(ncReportRequest.getNcCategory())) {
            criteria.andNcCategoryEqualTo(ncReportRequest.getNcCategory());
        }

        if (!FwUtils.isNullOrEmpty(ncReportRequest.getIsCancelled())) {
            criteria.andIsCancelledEqualTo(ncReportRequest.getIsCancelled());
        }

        if (!FwUtils.objIsEmpty(ncReportRequest.getStart())) {
            criteria.andDateTimeGreaterThanOrEqualTo(ncReportRequest.getStart());
        }

        if (!FwUtils.objIsEmpty(ncReportRequest.getEnd())) {
            criteria.andDateTimeLessThanOrEqualTo(ncReportRequest.getEnd());
        }

        return zVwSfcNcDataMapper.selectByExample(locale, example);
    }

    @Override
    public void updateSfcNcData( ZSfcNcData zSfcNcData ) {
        ZSfcNcDataExample example = new ZSfcNcDataExample();
        ZSfcNcDataExample.Criteria criteria = example.createCriteria();

        criteria.andSidEqualTo(zSfcNcData.getSid());

        zSfcNcDataMapper.updateByExampleSelective(zSfcNcData, example);
    }
}
