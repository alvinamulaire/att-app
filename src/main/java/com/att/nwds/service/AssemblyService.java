package com.att.nwds.service;

import com.sap.me.frame.domain.BusinessException;

import java.math.BigDecimal;

public interface AssemblyService {

	/**
	 * 組裝
	 * @param sfcBo
	 * @param inventoryId
	 * @param itemBo
	 * @param componentBo
	 * @param qty
	 * @throws BusinessException
	 */
	void assembly(String sfcBo, String inventoryId, String itemBo, String componentBo, String operationBo, String resourceBo, BigDecimal qty) throws BusinessException;

}
