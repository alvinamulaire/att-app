package com.att.repository.impl;

import com.att.repository.ProductRackRepository;
import com.att.repository.entity.ZMaterialShelfState;
import com.att.repository.entity.ZMaterialShelfStateExample;
import com.att.repository.entity.ZMaterialShelfStateLog;
import com.att.repository.mapper.ZMaterialShelfStateLogMapper;
import com.att.repository.mapper.ZMaterialShelfStateMapper;
import com.fw.mes.util.FwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRackRepositoryImpl implements ProductRackRepository {

    @Autowired
    private ZMaterialShelfStateMapper zMaterialShelfStateMapper;

    @Autowired
    private ZMaterialShelfStateLogMapper zMaterialShelfStateLogMapper;

    @Override
    public List<ZMaterialShelfState> getShelf( ZMaterialShelfState zMaterialShelfState ) {
        ZMaterialShelfStateExample example = new ZMaterialShelfStateExample();
        ZMaterialShelfStateExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(zMaterialShelfState.getSite());

        if (!FwUtils.isNullOrEmpty(zMaterialShelfState.getSfc())) {
            criteria.andSfcEqualTo(zMaterialShelfState.getSfc());
        }

        if (!FwUtils.isNullOrEmpty(zMaterialShelfState.getShelfNo())) {
            criteria.andShelfNoEqualTo(zMaterialShelfState.getShelfNo());
        }

        return zMaterialShelfStateMapper.selectByExample(example);
    }

    @Override
    public void insertShelf( ZMaterialShelfState zMaterialShelfState ) {
        zMaterialShelfStateMapper.insertSelective(zMaterialShelfState);
    }

    @Override
    public void deleteShelf( String sid ) {
        zMaterialShelfStateMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public void insertShelfLog( ZMaterialShelfStateLog zMaterialShelfStateLog ) {
        zMaterialShelfStateLogMapper.insertSelective(zMaterialShelfStateLog);
    }
}
