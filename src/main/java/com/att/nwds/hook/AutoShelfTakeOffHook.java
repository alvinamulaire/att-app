package com.att.nwds.hook;

import com.att.converent.MaterialShelfConverter;
import com.att.repository.entity.ZMaterialShelfState;
import com.att.repository.entity.ZMaterialShelfStateLog;
import com.fw.mes.util.DateUtil;
import com.fw.mes.util.FwUtils;
import com.sap.me.demand.SFCBOHandle;
import com.sap.me.frame.BasicBOBeanException;
import com.sap.me.frame.Data;
import com.sap.me.frame.SystemBase;
import com.sap.me.frame.domain.BusinessException;
import com.sap.me.frame.jdbc.DynamicQuery;
import com.sap.me.frame.jdbc.DynamicQueryFactory;
import com.sap.me.frame.transitionutils.Exceptions;
import com.sap.me.plant.ResourceBOHandle;
import com.sap.me.productdefinition.OperationBOHandle;
import com.sap.me.production.PostCompleteHookDTO;
import com.sap.me.user.UserBOHandle;
import com.visiprise.frame.service.ext.ActivityInterface;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AutoShelfTakeOffHook implements ActivityInterface<PostCompleteHookDTO> {

	private SystemBase base;
	private DynamicQuery dq;

	private void init() {
		base = SystemBase.createSystemBase("jdbc/jts/wipPool");
		dq = DynamicQueryFactory.newInstance();
	}

	@Override
	public void execute(PostCompleteHookDTO request) throws BusinessException, SQLException {
		init();
		List<ZMaterialShelfState> zMaterialShelfStateList = findZMaterialShelfState(request);
		BigDecimal qty = request.getQty();
		List<ZMaterialShelfStateLog> zMaterialShelfStateLogList = new ArrayList<>();
		for (ZMaterialShelfState state : zMaterialShelfStateList) {
			if(qty.compareTo(BigDecimal.ZERO)>0){
				//qty > 0
				ZMaterialShelfStateLog zMaterialShelfStateLog = MaterialShelfConverter.INSTANCE.toLog(state);
				zMaterialShelfStateLog.setTakeoffDateTime(DateUtil.getGmtTime());
				zMaterialShelfStateLog.setTakeoffUser(new UserBOHandle(request.getUserBO().getValue()).getUser());
				zMaterialShelfStateLogList.add(zMaterialShelfStateLog);
				qty = qty.subtract(state.getQty());
			}

			if(qty.compareTo(BigDecimal.ZERO)==0){
				//qty == 0
				break;
			}

			if(qty.compareTo(BigDecimal.ZERO)<0){
				//比對最終餘數不為0且不足料架數量時
				//qty<0
				BasicBOBeanException exception = new BasicBOBeanException(20106, new Data());
				throw Exceptions.convert(exception);
			}
		}

		if(qty.compareTo(BigDecimal.ZERO)>0){
			//比對最終餘數不為0且不足料架數量時
			//qty > 0
			BasicBOBeanException exception = new BasicBOBeanException(20106, new Data());
			throw Exceptions.convert(exception);
		}

		insertZMaterialShelfStateLog(zMaterialShelfStateLogList);
		deleteZMaterialShelfState(zMaterialShelfStateLogList.stream().map(ZMaterialShelfStateLog::getSid).collect(Collectors.toList()));
	}

	private void insertZMaterialShelfStateLog(List<ZMaterialShelfStateLog> zMaterialShelfStateLogList){
		for(ZMaterialShelfStateLog zMaterialShelfStateLog : zMaterialShelfStateLogList){
			dq.flush();
			dq.append(" insert into Z_MATERIAL_SHELF_STATE_LOG(SID,SITE,OPERATION,RESOURCE,SFC,QTY,SHELF_NO,PUTON_DATE_TIME,PUTON_USER,TAKEOFF_DATE_TIME,TAKEOFF_USER) ");
			dq.append(" values(");
			dq.appendString(zMaterialShelfStateLog.getSid()).append(",");
			dq.appendString(zMaterialShelfStateLog.getSite()).append(",");
			dq.appendString(zMaterialShelfStateLog.getOperation()).append(",");
			dq.appendString(zMaterialShelfStateLog.getResource()).append(",");
			dq.appendString(zMaterialShelfStateLog.getSfc()).append(",");
			dq.appendBigDecimal(zMaterialShelfStateLog.getQty()).append(",");
			dq.appendString(zMaterialShelfStateLog.getShelfNo()).append(",");
			dq.appendString(DateUtil.dateToString(zMaterialShelfStateLog.getPutonDateTime())).append(",");
			dq.appendString(zMaterialShelfStateLog.getPutonUser()).append(",");
			dq.append("CURRENT_UTCTIMESTAMP").append(",");
			dq.appendString(zMaterialShelfStateLog.getTakeoffUser());
			dq.append(") ");
			base.executeUpdate(dq);
		}
	}

	private void deleteZMaterialShelfState(List<String> sidList){
		dq.flush();
		dq.append(" delete from Z_MATERIAL_SHELF_STATE " );
		dq.append(" where sid in (");
		this.appendList(sidList);
		dq.append(" ) ");
		base.executeUpdate(dq);
	}

	private List<ZMaterialShelfState> findZMaterialShelfState(PostCompleteHookDTO request) throws SQLException {
		List<ZMaterialShelfState> zMaterialShelfStateList = new ArrayList<>();

		dq.flush();
		dq.append(" select * from Z_MATERIAL_SHELF_STATE " );
		dq.append(" where SITE = ");
		dq.appendString(request.getSite());
		dq.append(" and OPERATION = ");
		dq.appendString(new OperationBOHandle(request.getOperationBO().getValue()).getOperation());
		dq.append(" and RESOURCE = ");
		dq.appendString(new ResourceBOHandle(request.getResourceBO().getValue()).getResource());
		dq.append(" and SFC = ");
		dq.appendString(new SFCBOHandle(request.getSfcBO().getValue()).getSFC());
		dq.append(" order by PUTON_DATE_TIME ");
		ResultSet rs = base.executeQueryAsResultSet(dq);
		while (rs.next()) {
			ZMaterialShelfState zMaterialShelfState = new ZMaterialShelfState();
			zMaterialShelfState.setSid(rs.getString("SID"));
			zMaterialShelfState.setSite(rs.getString("SITE"));
			zMaterialShelfState.setOperation(rs.getString("OPERATION"));
			zMaterialShelfState.setResource(rs.getString("RESOURCE"));
			zMaterialShelfState.setSfc(rs.getString("SFC"));
			zMaterialShelfState.setQty(rs.getBigDecimal("QTY"));
			zMaterialShelfState.setShelfNo(rs.getString("SHELF_NO"));
			zMaterialShelfState.setPutonDateTime(DateUtil.stringToDay(rs.getString("PUTON_DATE_TIME")));
			zMaterialShelfState.setPutonUser(rs.getString("PUTON_USER"));
			zMaterialShelfStateList.add(zMaterialShelfState);
		}
		return zMaterialShelfStateList;
	}

	private void appendList( List<String> parameters ) {
		if (!FwUtils.isEmpty(parameters)) {
			boolean first = false;
			for (String param : parameters) {
				if (first) {
					dq.append(",");
				} else {
					first = true;
				}
				dq.appendString(param.trim());
			}
		}
	}
}
