package com.att.repository.impl;

import com.att.repository.ResourceAbilityRepository;
import com.att.repository.entity.TdsResourceAbility;
import com.att.repository.entity.TdsResourceAbilityExample;
import com.att.repository.mapper.TdsResourceAbilityMapper;
import com.fw.mes.util.FwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResourceAbilityRepositoryImpl implements ResourceAbilityRepository {

    @Autowired
    private TdsResourceAbilityMapper tdsResourceAbilityMapper;

    @Override
    public TdsResourceAbility getAbility( String site, String item, String operation, String resource ) {
        TdsResourceAbilityExample example = new TdsResourceAbilityExample();
        TdsResourceAbilityExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(site)
                .andItemEqualTo(item)
                .andOperationEqualTo(operation)
                .andResourceEqualTo(resource);

        List<TdsResourceAbility> list = tdsResourceAbilityMapper.selectByExample(example);

        return !FwUtils.isEmpty(list) ? list.get(0) : null;
    }
}
