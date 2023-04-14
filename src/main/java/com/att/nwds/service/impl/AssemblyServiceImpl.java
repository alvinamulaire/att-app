package com.att.nwds.service.impl;

import com.att.nwds.service.AssemblyService;
import com.sap.me.extension.Services;
import com.sap.me.frame.domain.BusinessException;
import com.sap.me.production.AssembleAsBuiltComponentsRequest;
import com.sap.me.production.AssemblyComponent;
import com.sap.me.production.AssemblyDataField;
import com.sap.me.production.AssemblyServiceInterface;

import java.math.BigDecimal;

public class AssemblyServiceImpl implements AssemblyService {

	@Override
	public void assembly(String sfcBo, String inventoryId, String itemBo, String componentBo, String operationBo, String resourceBo, BigDecimal qty) throws BusinessException {
		AssemblyServiceInterface assemblyService = Services.getService("com.sap.me.production", "AssemblyService");
		// build request
		AssembleAsBuiltComponentsRequest assembleComponentsRequest = new AssembleAsBuiltComponentsRequest();
		assembleComponentsRequest.setOperationRef(operationBo);
		assembleComponentsRequest.setResourceRef(resourceBo);
		assembleComponentsRequest.setEvent("baseFinished:AsBuilt");
		assembleComponentsRequest.setForceActivityLog(false);
		assembleComponentsRequest.setSfcRef(sfcBo);

		AssemblyComponent assemblyComponent = new AssemblyComponent();

		AssemblyDataField assemblyDataField = new AssemblyDataField();
		assemblyDataField.setAttribute("INVENTORY_ID_SFC");
		assemblyDataField.setValue(inventoryId);
		assemblyComponent.getAssemblyDataFields().add(assemblyDataField);

		assemblyComponent.setActualComponentRef(itemBo);
		assemblyComponent.setBomComponentRef(componentBo);
		assemblyComponent.setTimeBased(false);
		assemblyComponent.setPlanned(false);
		assemblyComponent.setSetErpSentFlag(false);
		assemblyComponent.setSkipValidation(false);
		assemblyComponent.setQty(qty);

		assembleComponentsRequest.getComponentList().add(assemblyComponent);

		assemblyService.assembleByComponents(assembleComponentsRequest);
	}
}
