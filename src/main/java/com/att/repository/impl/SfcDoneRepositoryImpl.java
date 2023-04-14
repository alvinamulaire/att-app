package com.att.repository.impl;

import com.att.repository.SfcDoneRepository;
import com.att.repository.entity.ZVwSfcDone;
import com.att.repository.entity.ZVwSfcDoneExample;
import com.att.repository.mapper.ZVwSfcDoneMapper;
import com.fw.mes.util.FwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SfcDoneRepositoryImpl implements SfcDoneRepository {

	@Autowired
	private ZVwSfcDoneMapper zVwSfcDoneMapper;

	@Override
	public List<ZVwSfcDone> findSfcDoneInfo(ZVwSfcDone zSfcDone, String locale) {
		ZVwSfcDoneExample example = new ZVwSfcDoneExample();
		ZVwSfcDoneExample.Criteria criteria = example.createCriteria();
		criteria.andSiteEqualTo(zSfcDone.getSite());
		if(!FwUtils.isNullOrEmpty(zSfcDone.getSfc())){
			criteria.andSfcEqualTo(zSfcDone.getSfc());
		}
		if(!FwUtils.isNullOrEmpty(zSfcDone.getResourceBo())){
			criteria.andResourceBoEqualTo(zSfcDone.getResourceBo());
		}
		if(!FwUtils.isNullOrEmpty(zSfcDone.getOperationBo())){
			criteria.andOperationBoEqualTo(zSfcDone.getOperationBo());
		}

		return zVwSfcDoneMapper.selectByExample(example, locale);
	}
}
