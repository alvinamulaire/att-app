package com.att.nwds.service.impl;

import com.fw.mes.util.DateUtil;
import com.fw.mes.util.FwUtils;
import com.sap.me.common.ObjectReference;
import com.sap.me.document.PrintingDataAcquisitionRequest;
import com.sap.me.document.PrintingDataAcquisitionResponse;
import com.sap.me.document.PrintingDataAcquisitionServiceInterface;
import com.sap.me.extension.Services;
import com.sap.me.frame.BasicBOBeanException;
import com.sap.me.frame.Data;
import com.sap.me.frame.SystemBase;
import com.sap.me.frame.domain.BusinessException;
import com.sap.me.frame.jdbc.DynamicQuery;
import com.sap.me.frame.jdbc.DynamicQueryFactory;
import com.sap.me.frame.service.CommonMethods;
import com.sap.me.frame.transitionutils.Exceptions;
import com.sap.me.productdefinition.DataFieldBOHandle;
import com.sap.me.productdefinition.ItemConfigurationServiceInterface;
import com.sap.me.productdefinition.ItemFullConfiguration;
import com.sap.me.user.UserBOHandle;
import com.sap.me.user.UserBasicConfiguration;
import com.sap.me.user.UserConfigurationServiceInterface;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CustomPrintingDA implements PrintingDataAcquisitionServiceInterface {

	private SystemBase base;
	private DynamicQuery dq = DynamicQueryFactory.newInstance();
	private ResultSet rs;

	// 換行符號
	private final static char CR = (char) 0x0D;
	private final static char LF = (char) 0x0A;
	private final static String CRLF = "" + CR + LF;

	@Override
	public PrintingDataAcquisitionResponse acquirePrintingData(PrintingDataAcquisitionRequest request) throws BusinessException {
		PrintingDataAcquisitionServiceInterface printingDataAcquisitionService = Services
				.getService("com.sap.me.document", "PrintingDataAcquisitionService");

		PrintingDataAcquisitionResponse printingDataAcquisitionResponse = printingDataAcquisitionService
				.acquirePrintingData(request);

		String printContent = printingDataAcquisitionResponse.getPrintContent();
		printingDataAcquisitionResponse.setPrintContent(dataFormat(printContent));
		return printingDataAcquisitionResponse;
	}

	private String dataFormat(String str) throws BusinessException {
		base = SystemBase.createSystemBase("jdbc/jts/wipPool");
		String site = CommonMethods.getSite();

		ItemConfigurationServiceInterface itemConfigurationService = Services.getService("com.sap.me.productdefinition",
				"ItemConfigurationService", site);
		JSONObject request = new JSONObject();

		JSONObject jsonObject = XML.toJSONObject(str);

		JSONObject printContent = jsonObject.optJSONObject("PrintContent");

		JSONObject sfcPrintingData = printContent.optJSONObject("sfcPrintingData");

		try {
			//文管編號
			request.put("iso",getCustomFields(sfcPrintingData.optString("itemRef"),"ISO"));
			//機種
			request.put("productType",getCustomFields(sfcPrintingData.optString("itemRef"),"PRODUCT_TYPE"));
			//目標總良率
			request.put("yield",getCustomFields(sfcPrintingData.optString("itemRef"),"YIELD"));
			//BUILD
			request.put("build",getCustomFields(sfcPrintingData.optString("shopOrderRef"),"BUILD"));
			//版次
			request.put("partRev",getCustomFields(sfcPrintingData.optString("shopOrderRef"),"PART_REV"));
			//製令類型
			String auart = getCustomFields(sfcPrintingData.optString("shopOrderRef"),"AUART");
			request.put("auart",auart);
			request.put("auartDesc",getErpOrderTypeDesc(site, auart));

			request.put("runCardDetail",findRunCardDetail(sfcPrintingData.optString("sfcRef")));

			jsonObject.getJSONObject("PrintContent").put("AttCustomData", request);
		} catch (Exception e) {
			BasicBOBeanException exception = new BasicBOBeanException(25101, new Data("message", e.getMessage()));
			throw Exceptions.convert(exception);
		}
		return XML.toString(jsonObject);
	}

	private String getCustomFields(String handle, String attribute) throws SQLException {
		dq.flush();
		dq.append("select * from CUSTOM_FIELDS where handle = ");
		dq.appendString(handle);
		dq.append(" and ATTRIBUTE = ");
		dq.appendString(attribute);
		rs = base.executeQueryAsResultSet(dq);
		if (rs.next()) {
			return rs.getString("value");
		}
		return "";
	}

	private String getErpOrderTypeDesc(String site, String auart) throws SQLException {
		dq.flush();
		dq.append(" select * from DATA_FIELD_LIST a " );
		dq.append(" join DATA_FIELD_LIST_T b on a.handle = b.DATA_FIELD_LIST_BO and b.LOCALE= ");
		dq.appendString(CommonMethods.getCurrentUserLoginLanguage());
		dq.append(" where DATA_FIELD_BO = ");
		dq.appendString(new DataFieldBOHandle(site,"ERP-ORDERTYPE").getValue());
		dq.append(" and DATA_VALUE = ");
		dq.appendString(auart);
		rs = base.executeQueryAsResultSet(dq);
		if (rs.next()) {
			return rs.getString("DATA_TAG");
		}
		return "";
	}

	private JSONArray findRunCardDetail(String sfcBo) throws SQLException {
		String site = CommonMethods.getSite();
		JSONArray jsonArray = new JSONArray();
		dq.flush();
		dq.append(" select * from Z_VW_RUNCARD(").appendString(CommonMethods.getCurrentUserLoginLanguage()).append(") ");
		dq.append(" where sfc_bo = ");
		dq.appendString(sfcBo);
		rs = base.executeQueryAsResultSet(dq);
		while (rs.next()){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("site", rs.getString("site"));
			jsonObject.put("sfc", rs.getString("sfc"));
			jsonObject.put("sfcBo", rs.getString("sfc_bo"));
			jsonObject.put("stepId", rs.getString("step_id"));
			jsonObject.put("operation", rs.getString("operation"));
			jsonObject.put("opDesc", rs.getString("op_desc"));
			String dateInTimeIn = rs.getString("date_in_time_in");
			if(FwUtils.isNullOrEmpty(dateInTimeIn)){
				jsonObject.put("dateInTimeIn", "");
				jsonObject.put("inputQty", "");
			}else {
				jsonObject.put("dateInTimeIn", dateInTimeIn);
				jsonObject.put("inputQty", rs.getBigDecimal("input_qty").stripTrailingZeros().toPlainString());
			}
			String inputUser = rs.getString("input_user");
			jsonObject.put("inputUser", inputUser);
			if(FwUtils.isNullOrEmpty(inputUser)){
				jsonObject.put("inputUserName", "");
			}else{
				String inputUserName = FwUtils.findUserName(site, inputUser);
				jsonObject.put("inputUserName", inputUser + CRLF + inputUserName);
			}
			String dateOutTimeOut = rs.getString("date_out_time_out");
			if(FwUtils.isNullOrEmpty(dateOutTimeOut)){
				jsonObject.put("dateOutTimeOut", "");
				jsonObject.put("outputQty", "");
			}else {
				jsonObject.put("dateOutTimeOut", dateOutTimeOut);
				jsonObject.put("outputQty", rs.getBigDecimal("output_qty").stripTrailingZeros().toPlainString());
			}
			String outputUser = rs.getString("output_user");
			jsonObject.put("outputUser", outputUser);
			if(FwUtils.isNullOrEmpty(outputUser)){
				jsonObject.put("outputUserName", "");
			}else {
				String outputUserName = FwUtils.findUserName(site, outputUser);
				jsonObject.put("outputUserName", outputUser + CRLF + outputUserName);
			}
			jsonArray.put(jsonObject);
		}
		return jsonArray;
	}
}
