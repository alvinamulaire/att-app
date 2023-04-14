package com.att.nwds.hook;

import com.fw.mes.util.FwUtils;
import com.sap.me.activity.ActivityBOHandle;
import com.sap.me.activity.ActivityOption;
import com.sap.me.activity.HookContextInterface;
import com.sap.me.activity.HookContextSetter;
import com.sap.me.frame.BasicBOBeanException;
import com.sap.me.frame.Data;
import com.sap.me.frame.SystemBase;
import com.sap.me.frame.jdbc.DynamicQuery;
import com.sap.me.frame.jdbc.DynamicQueryFactory;
import com.sap.me.frame.service.CommonMethods;
import com.sap.me.frame.transitionutils.Exceptions;
import com.sap.me.inventory.Inventory;
import com.sap.me.inventory.InventoryIdentifier;
import com.sap.me.inventory.InventoryServiceInterface;
import com.sap.me.inventory.InventoryValidateAndUpdateRequest;
import com.sap.me.production.PostCompleteHookDTO;
import com.sap.me.security.Role;
import com.sap.me.security.RunAsServiceLocator;
import com.sap.me.status.StatusBOHandle;
import com.visiprise.frame.configuration.ServiceReference;
import com.visiprise.frame.service.ext.ActivityInterface;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClearInvHook implements ActivityInterface<PostCompleteHookDTO>, HookContextSetter {

	private SystemBase base;
	private DynamicQuery dq;
	private String reasonCode;


	private void init() {
		base = SystemBase.createSystemBase("jdbc/jts/wipPool");
		dq = DynamicQueryFactory.newInstance();
	}

	@Override
	public void execute(PostCompleteHookDTO request) throws Exception {
		init();
		String sfcBo = request.getSfcBO().getValue();
		SystemBase base = SystemBase.createSystemBase("jdbc/jts/wipPool");

		DynamicQuery dq = DynamicQueryFactory.newInstance();
		dq.flush();
		dq.append("select * from sfc where handle = ");
		dq.appendString(sfcBo);
		ResultSet rs = base.executeQueryAsResultSet(dq);

		String statusBo = null;
		String sfc = null;
		String item = null;
		while (rs.next()) {
			sfc = rs.getString("SFC");
			statusBo = rs.getString("STATUS_BO");
			item = rs.getString("ITEM_BO");
		}
		String status = new StatusBOHandle(statusBo).getStatus();

		if (status.equals("405")) {
			String site = CommonMethods.getSite();
			String user = CommonMethods.getUserId();

			List<Role> roles = new ArrayList<Role>();
			roles.add(Role.SAP_ME_USER);
			roles.add(Role.SAP_ME_INTEGRATOR);

			InventoryServiceInterface inventoryServiceInterface = RunAsServiceLocator.getService(
					new ServiceReference("com.sap.me.inventory", "InventoryService"), roles, user, site, null);

			InventoryIdentifier iif = new InventoryIdentifier();
			iif.setInventoryId(sfc);

			Inventory inventory = inventoryServiceInterface.findInventory(iif);
			BigDecimal qty = BigDecimal.ZERO;
			if (inventory != null) {
				qty = inventory.getQtyOnHand();
			}

			if (qty.compareTo(BigDecimal.ZERO) > 0) {

				dq.flush();
				dq.append(" select * from REASON_CODE ");
				dq.append(" where SITE = ");
				dq.appendString(site);
				dq.append(" and REASON_CODE = ");
				if(FwUtils.isNullOrEmpty(reasonCode)){
					dq.appendString("INV_RECEIPT");
				}else {
					dq.appendString(reasonCode);
				}
				ResultSet rs1 = base.executeQueryAsResultSet(dq);

				String reasonBo = null;
				String desc = null;
				while (rs1.next()) {
					reasonBo = rs1.getString("HANDLE");
					desc = rs1.getString("DESCRIPTION");
				}

				if(FwUtils.isNullOrEmpty(reasonBo)) {
					BasicBOBeanException exception = new BasicBOBeanException(20109, new Data());
					throw Exceptions.convert(exception);
				}

				InventoryValidateAndUpdateRequest iq = new InventoryValidateAndUpdateRequest();
				iq.setInventoryId(sfc);
				iq.setQuantityOnHand(BigDecimal.ZERO);
				iq.setItemRef(item);
				iq.setModifiedDateTime(inventory.getModifiedDateTime());
				iq.setReasonCodeRef(reasonBo);
				iq.setComments(desc);

				inventoryServiceInterface.validateAndUpdate(iq);
			}
		}
	}

	@Override
	public void setHookContext(HookContextInterface hookContextInterface) {
		for(ActivityOption option : hookContextInterface.getActivityOptions()){
			if("REASON_CODE".equals(option.getExecUnitOption()) && !FwUtils.isNullOrEmpty(option.getSetting())){
				reasonCode = option.getSetting();
			}else {
				reasonCode = "";
			}
		}

	}
}
