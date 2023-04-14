package com.att.repository.impl;

import com.att.domain.tool.ToolRequest;
import com.att.repository.ToolRepository;
import com.att.repository.entity.ZSnToolLog;
import com.att.repository.entity.ZSnToolLogExample;
import com.att.repository.entity.ZSnToolState;
import com.att.repository.entity.ZSnToolStateExample;
import com.att.repository.mapper.ZSnToolLogMapper;
import com.att.repository.mapper.ZSnToolStateMapper;
import com.fw.mes.util.FwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ToolRepositoryImpl implements ToolRepository {

    @Autowired
    private ZSnToolStateMapper zSnToolStateMapper;

    @Autowired
    private ZSnToolLogMapper zSnToolLogMapper;

    @Override
    public List<ZSnToolState> getToolList( ZSnToolState zSnToolState ) {
        ZSnToolStateExample example = new ZSnToolStateExample();
        ZSnToolStateExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(zSnToolState.getSite());

        if (!FwUtils.isNullOrEmpty(zSnToolState.getSfc())) {
            criteria.andSfcEqualTo(zSnToolState.getSfc());
        }

        if (!FwUtils.isNullOrEmpty(zSnToolState.getToolNumber())) {
            criteria.andToolNumberEqualTo(zSnToolState.getToolNumber());
        }

        if (!FwUtils.isNullOrEmpty(zSnToolState.getSn())) {
            criteria.andSnEqualTo(zSnToolState.getSn());
        }

        if (!FwUtils.isNullOrEmpty(zSnToolState.getStatus())) {
            criteria.andStatusEqualTo(zSnToolState.getStatus());
        }

        if (!FwUtils.isNullOrEmpty(zSnToolState.getResource())) {
            criteria.andResourceEqualTo(zSnToolState.getResource());
        }

        if (!FwUtils.isNullOrEmpty(zSnToolState.getOperation())) {
            criteria.andOperationEqualTo(zSnToolState.getOperation());
        }

        return zSnToolStateMapper.selectByExample(example);
    }

    @Override
    public void insertSnToolState( ZSnToolState zSnToolState ) {
        zSnToolStateMapper.insertSelective(zSnToolState);
    }

    @Override
    public void updateSnToolState( ZSnToolState zSnToolState ) {
        ZSnToolStateExample example = new ZSnToolStateExample();
        ZSnToolStateExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(zSnToolState.getSite())
                .andSfcEqualTo(zSnToolState.getSfc())
                .andToolNumberEqualTo(zSnToolState.getToolNumber())
                .andSnEqualTo(zSnToolState.getSn());

        zSnToolStateMapper.updateByExampleSelective(zSnToolState, example);
    }

    @Override
    public void deleteSnToolState( String sid ) {
        zSnToolStateMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public void insertSnToolLog( ZSnToolLog zSnToolLog ) {
        zSnToolLogMapper.insertSelective(zSnToolLog);
    }

    @Override
    public void updateSnToolLog( ZSnToolLog zSnToolLog ) {
        ZSnToolLogExample example = new ZSnToolLogExample();
        ZSnToolLogExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(zSnToolLog.getSite())
                .andSfcEqualTo(zSnToolLog.getSfc())
                .andToolNumberEqualTo(zSnToolLog.getToolNumber())
                .andSnEqualTo(zSnToolLog.getSn());

        zSnToolLogMapper.updateByExampleSelective(zSnToolLog, example);
    }

    @Override
    public List<ZSnToolState> getToolInfo( ToolRequest toolRequest ) {
        ZSnToolStateExample example = new ZSnToolStateExample();
        ZSnToolStateExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(toolRequest.getSite());

        if (!FwUtils.isNullOrEmpty(toolRequest.getSfc())) {
            criteria.andSfcEqualTo(toolRequest.getSfc());
        }

        if (!FwUtils.isEmpty(toolRequest.getToolList())) {
            criteria.andToolNumberIn(toolRequest.getToolList());
        }

        if (!FwUtils.isNullOrEmpty(toolRequest.getStatus())) {
            criteria.andStatusEqualTo(toolRequest.getStatus());
        }

        return zSnToolStateMapper.selectByExample(example);
    }
}
