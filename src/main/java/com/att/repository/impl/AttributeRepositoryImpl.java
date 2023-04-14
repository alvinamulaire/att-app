package com.att.repository.impl;

import com.att.repository.AttributeRepository;
import com.att.repository.entity.ZKanbanAttribute;
import com.att.repository.entity.ZKanbanAttributeExample;
import com.att.repository.entity.ZVwKanbanAttributeWorkCenter;
import com.att.repository.entity.ZVwKanbanAttributeWorkCenterExample;
import com.att.repository.mapper.ZKanbanAttributeMapper;
import com.att.repository.mapper.ZVwKanbanAttributeWorkCenterMapper;
import com.fw.mes.util.FwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttributeRepositoryImpl implements AttributeRepository {

    @Autowired
    private ZKanbanAttributeMapper zKanbanAttributeMapper;

    @Autowired
    private ZVwKanbanAttributeWorkCenterMapper zVwKanbanAttributeWorkCenterMapper;


    @Override
    public void save( ZKanbanAttribute zKanbanAttribute ) {
        zKanbanAttribute.setSid(FwUtils.getUid());
        zKanbanAttributeMapper.insertSelective(zKanbanAttribute);
    }

    @Override
    public List<ZVwKanbanAttributeWorkCenter> getAttribute( ZKanbanAttribute zKanbanAttribute, String locale ) {
        ZVwKanbanAttributeWorkCenterExample example = new ZVwKanbanAttributeWorkCenterExample();
        ZVwKanbanAttributeWorkCenterExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(zKanbanAttribute.getSite());

        if (!FwUtils.isNullOrEmpty(zKanbanAttribute.getType())) {
            criteria.andTypeEqualTo(zKanbanAttribute.getType());
        }

        if (!FwUtils.isNullOrEmpty(zKanbanAttribute.getActivity())) {
            criteria.andActivityEqualTo(zKanbanAttribute.getActivity());
        }

        example.setOrderByClause(" ATTRIBUTE1 ");

        return zVwKanbanAttributeWorkCenterMapper.selectByExample(locale, example);
    }

    @Override
    public void delete( String site, String activity ) {
        ZKanbanAttributeExample example = new ZKanbanAttributeExample();
        ZKanbanAttributeExample.Criteria criteria = example.createCriteria();

        criteria.andSiteEqualTo(site)
                .andActivityEqualTo(activity);

        zKanbanAttributeMapper.deleteByExample(example);
    }
}
