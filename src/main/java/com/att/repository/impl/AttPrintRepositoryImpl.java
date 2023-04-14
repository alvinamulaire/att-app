package com.att.repository.impl;

import com.att.repository.AttPrintRepository;
import com.att.repository.entity.ZLabelPrintLog;
import com.att.repository.mapper.ZLabelPrintLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AttPrintRepositoryImpl implements AttPrintRepository {

	@Autowired
	private ZLabelPrintLogMapper zLabelPrintLogMapper;

	@Override
	public void insertPrintLog(ZLabelPrintLog zLabelPrintLog) {
		zLabelPrintLogMapper.insert(zLabelPrintLog);
	}
}
