package com.att.repository.impl;

import com.att.domain.inpsec.InspecJobResultInfo;
import com.att.repository.InspecRepository;
import com.att.repository.entity.ZVwQmsInspecJob;
import com.att.repository.entity.ZVwQmsInspecJobExample;
import com.att.repository.entity.ZVwQmsInspecJobResult;
import com.att.repository.entity.ZVwQmsInspecJobResultExample;
import com.att.repository.mapper.ZVwQmsInspecJobMapper;
import com.att.repository.mapper.ZVwQmsInspecJobResultMapper;
import com.fw.mes.util.FwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InspecRepositoryImpl implements InspecRepository {

    @Autowired
    private ZVwQmsInspecJobResultMapper zVwQmsInspecJobResultMapper;

    @Autowired
    private ZVwQmsInspecJobMapper zVwQmsInspecJobMapper;

    @Override
    public List<ZVwQmsInspecJobResult> getInspecDetail( ZVwQmsInspecJobResult zVwQmsInspecJobResult ) {
        ZVwQmsInspecJobResultExample example = new ZVwQmsInspecJobResultExample();
        ZVwQmsInspecJobResultExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(zVwQmsInspecJobResult.getSite());

        if (!FwUtils.isNullOrEmpty(zVwQmsInspecJobResult.getQcItemSid())) {
            criteria.andQcItemSidEqualTo(zVwQmsInspecJobResult.getQcItemSid());
        }

        if (!FwUtils.isNullOrEmpty(zVwQmsInspecJobResult.getSn())) {
            criteria.andSnEqualTo(zVwQmsInspecJobResult.getSn());
        }

        if (!FwUtils.isNullOrEmpty(zVwQmsInspecJobResult.getHandle())) {
            criteria.andHandleEqualTo(zVwQmsInspecJobResult.getHandle());
        }

        example.setOrderByClause(" INSPEC_DATE_TIME DESC ");

        return zVwQmsInspecJobResultMapper.selectByExample(example);
    }

    @Override
    public ZVwQmsInspecJob getInspecJob( String handle ) {
        ZVwQmsInspecJobExample example = new ZVwQmsInspecJobExample();
        ZVwQmsInspecJobExample.Criteria criteria = example.createCriteria();

        criteria.andHandleEqualTo(handle);

        List<ZVwQmsInspecJob> list = zVwQmsInspecJobMapper.selectByExample(example);

        return !FwUtils.isEmpty(list) ? list.get(0) : null;
    }

    @Override
    public List<ZVwQmsInspecJobResult> getInspecDetail( InspecJobResultInfo inspecJobResultInfo ) {
        ZVwQmsInspecJobResultExample example = new ZVwQmsInspecJobResultExample();
        ZVwQmsInspecJobResultExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(inspecJobResultInfo.getSite());

        if (!FwUtils.isNullOrEmpty(inspecJobResultInfo.getQcItemSid())) {
            criteria.andQcItemSidEqualTo(inspecJobResultInfo.getQcItemSid());
        }

        if (!FwUtils.isEmpty(inspecJobResultInfo.getSnList())) {
            criteria.andSnIn(inspecJobResultInfo.getSnList());
        }

        example.setOrderByClause(" INSPEC_DATE_TIME DESC ");

        return zVwQmsInspecJobResultMapper.selectByExample(example);
    }
}
