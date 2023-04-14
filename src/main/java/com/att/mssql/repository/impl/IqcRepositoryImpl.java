package com.att.mssql.repository.impl;

import com.att.domain.iqc.IqcOutInfo;
import com.att.mssql.repository.IqcRepository;
import com.att.mssql.repository.entity.IqcInbound;
import com.att.mssql.repository.entity.IqcOutbound;
import com.att.mssql.repository.entity.IqcOutboundExample;
import com.att.mssql.repository.mapper.IqcInboundMapper;
import com.att.mssql.repository.mapper.IqcOutboundMapper;
import com.att.repository.entity.*;
import com.att.repository.mapper.ZSystemTransactionLogMapper;
import com.att.repository.mapper.ZVwQcPlanProdMapper;
import com.att.repository.mapper.ZVwQmsInspecJobMapper;
import com.fw.mes.util.FwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class IqcRepositoryImpl implements IqcRepository {

    @Autowired
    private IqcInboundMapper iqcInboundMapper;

    @Autowired
    private IqcOutboundMapper iqcOutboundMapper;

    @Autowired
    private ZVwQcPlanProdMapper zVwQcPlanProdMapper;

    @Autowired
    private ZSystemTransactionLogMapper zSystemTransactionLogMapper;

    @Autowired
    private ZVwQmsInspecJobMapper zVwQmsInspecJobMapper;

    @Override
    public List<IqcOutbound> getIqcOutBound( IqcOutInfo iqcOutInfo ) {
        IqcOutboundExample example = new IqcOutboundExample();
        IqcOutboundExample.Criteria criteria = example.createCriteria();

        criteria.andWerkEqualTo(iqcOutInfo.getWerk());

        if (!FwUtils.isNullOrEmpty(iqcOutInfo.getStatustext())) {
            criteria.andStatustextEqualTo(iqcOutInfo.getStatustext());
        }

        if (!FwUtils.isNullOrEmpty(iqcOutInfo.getMeStatus())) {
            criteria.andMeStatusEqualTo(iqcOutInfo.getMeStatus());
        }

        if (!FwUtils.isEmpty(iqcOutInfo.getMeStatusList())) {
            criteria.andMeStatusIn(iqcOutInfo.getMeStatusList());
        }

        return iqcOutboundMapper.selectByExample(example);
    }

    @Override
    public void updateIqcOutBound( IqcOutbound iqcOutbound ) {
        IqcOutboundExample example = new IqcOutboundExample();
        IqcOutboundExample.Criteria criteria = example.createCriteria();

        criteria.andWerkEqualTo(iqcOutbound.getWerk())
                .andPrueflosEqualTo(iqcOutbound.getPrueflos())
                .andSelmatnrEqualTo(iqcOutbound.getSelmatnr());

        iqcOutboundMapper.updateByExampleSelective(iqcOutbound, example);
    }

    @Override
    public List<ZVwQcPlanProd> getQcPlanProd( ZVwQcPlanProd zVwQcPlanProd ) {
        ZVwQcPlanProdExample example = new ZVwQcPlanProdExample();
        ZVwQcPlanProdExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(zVwQcPlanProd.getSite())
                .andMaterialNoEqualTo(zVwQcPlanProd.getMaterialNo())
                .andCurrentRevisionEqualTo("true");

        return zVwQcPlanProdMapper.selectByExample(example);
    }

    @Override
    public void insertTransactionLog( ZSystemTransactionLog zSystemTransactionLog ) {
        zSystemTransactionLogMapper.insertSelective(zSystemTransactionLog);
    }

    @Override
    public List<ZVwQmsInspecJob> getInspecJob( ZVwQmsInspecJob zVwQmsInspecJob ) {
        ZVwQmsInspecJobExample example = new ZVwQmsInspecJobExample();
        ZVwQmsInspecJobExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(zVwQmsInspecJob.getSite())
                .andQcModeEqualTo("3")
                .andStatusIn(Arrays.asList("4", "5"))
                .andIsErpEqualTo("0");

        return zVwQmsInspecJobMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public void insertIqcInBound( IqcInbound iqcInbound ) {
        iqcInboundMapper.insertSelective(iqcInbound);
    }
}
