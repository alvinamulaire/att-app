package com.att.nwds.serviceext;

import com.att.nwds.service.domain.SfcInfo;
import com.fw.mes.me.alarm.domain.base.AlarmExecuteRequest;
import com.fw.mes.me.alarm.method.SendingAlarmMessage;
import com.fw.mes.util.FwUtils;
import com.sap.me.activity.ExtensionContextInterface;
import com.sap.me.activity.ExtensionContextSetter;
import com.sap.me.activity.ServiceExtension;
import com.sap.me.demand.SFCBOHandle;
import com.sap.me.frame.SystemBase;
import com.sap.me.frame.domain.BusinessException;
import com.sap.me.frame.jdbc.DynamicQuery;
import com.sap.me.frame.jdbc.DynamicQueryFactory;
import com.sap.me.frame.service.CommonMethods;
import com.sap.me.frame.utils.I18nUtility;
import com.sap.me.nonconformance.DispositionMultipleSfcsRequest;
import com.sap.me.productdefinition.ItemBOHandle;
import com.sap.me.productdefinition.RouterBOHandle;
import com.sap.me.wpmf.MessageType;
import com.sap.me.wpmf.util.MessageHandler;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class YieldNotificationExtension extends ServiceExtension<Object> implements ExtensionContextSetter {

    private SystemBase base;
    private DynamicQuery dq;
    private String activityBo;

    private void init() {
        base = SystemBase.createSystemBase("jdbc/jts/wipPool");
        dq = DynamicQueryFactory.newInstance();
    }

    @Override
    public void execute( Object request ) throws Exception {
        if (request instanceof DispositionMultipleSfcsRequest) {
            execute((DispositionMultipleSfcsRequest) request);
        }
    }

    private void execute( DispositionMultipleSfcsRequest dispositionMultipleSfcsRequest ) throws SQLException, BusinessException {
        init();
        String site = CommonMethods.getSite();

        String operation = dispositionMultipleSfcsRequest.getProdCtx().getStepIdentifier().getOperationId();

        for (String sfcBo : dispositionMultipleSfcsRequest.getSfcs()) {
            String sfc = new SFCBOHandle(sfcBo).getSFC();
            SfcInfo sfcInfo = this.findSfcInfo(sfcBo);
            RouterBOHandle routerBOHandle = new RouterBOHandle(sfcInfo.getRouterBo());

            BigDecimal planYield = this.findPlanYield(site, new ItemBOHandle(sfcInfo.getItemBo()).getItem(),
                                                      routerBOHandle.getRouter(), routerBOHandle.getRevision(), operation);
            if (!FwUtils.objIsEmpty(planYield)) {
                String ncType = this.findActivityOption(activityBo, "NC-TYPE");
                List<String> ncTypeList = Arrays.asList(ncType.split("\\|"));
                List<String> ncCategoryList = this.ncTypeToNcCategory(ncTypeList);

                //有配置良率維護
                BigDecimal ncQty = this.findNcQty(sfcBo, ncCategoryList);

                if (FwUtils.objIsEmpty(ncQty)) {
                    return;
                }

                //((sfcQty-ncQty)/sfcQty)*100
                BigDecimal nowYield = new BigDecimal(100)
                        .multiply((sfcInfo.getQty().subtract(ncQty)).divide(sfcInfo.getQty(), 2, RoundingMode.HALF_UP));

                if (planYield.compareTo(nowYield) > 0) {
                    // 報警
                    this.alarm(site, operation, sfc, nowYield);
                    HashMap<String, Object> map = new HashMap<String, Object>();
                    map.put("%yield%", planYield);
                    map.put("%nowYield%", nowYield);
                    MessageHandler.handle("20105.simple", map, MessageType.WARNING);
                }
            }
        }
    }

    private List<String> ncTypeToNcCategory( List<String> ncTypeList ) {
        List<String> ncCategoryList = new ArrayList<>();
        for (String ncType : ncTypeList) {
            switch (ncType) {
                case "1":
                    ncCategoryList.add("FAILURE");
                    break;
                case "2":
                    ncCategoryList.add("DEFECT");
                    break;
                case "3":
                    ncCategoryList.add("REPAIR");
                    break;
                default:
                    break;
            }
        }
        return ncCategoryList;
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

    private String findActivityOption( String activityBo, String option ) throws SQLException {
        String response = "";
        dq.flush();
        dq.append(" select * from ACTIVITY_OPTION ");
        dq.append(" where ACTIVITY_BO = ");
        dq.appendString(activityBo);
        dq.append(" and EXEC_UNIT_OPTION = ");
        dq.appendString(option);
        ResultSet rs = base.executeQueryAsResultSet(dq);
        while (rs.next()) {
            response = rs.getString("setting");
        }
        return response;
    }

    private BigDecimal findNcQty( String sfcBo, List<String> ncCategoryList ) throws SQLException {
        BigDecimal response = BigDecimal.ZERO;
        if (FwUtils.isEmpty(ncCategoryList)) {
            return response;
        }
        dq.flush();
        dq.append(" select qty from nc_code a ");
        dq.append(" join nc_data b on a.handle = b.nc_code_bo");
        dq.append(" where b.NC_CONTEXT_GBO = ");
        dq.appendString(sfcBo);
        dq.append(" and b.DISPOSITION_DONE = 'false'");
        dq.append(" and a.NC_CATEGORY in ( ");
        this.appendList(ncCategoryList);
        dq.append(" ) ");
        dq.append(" order by DATE_TIME desc ");
        ResultSet rs = base.executeQueryAsResultSet(dq);
        if (rs.next()) {
            response = rs.getBigDecimal("qty");
        }
        return response;
    }

    private BigDecimal findPlanYield( String site, String item, String router, String routerRevision, String operation ) throws SQLException {
        BigDecimal response = null;
        dq.flush();
        dq.append(" select * from Z_MATERIAL_YIELD_BASIS ");
        dq.append(" where site = ");
        dq.appendString(site);
        dq.append(" and item = ");
        dq.appendString(item);
        dq.append(" and router = ");
        dq.appendString(router);
        dq.append(" and router_revision = ");
        dq.appendString(routerRevision);
        dq.append(" and operation = ");
        dq.appendString(operation);
        ResultSet rs = base.executeQueryAsResultSet(dq);
        while (rs.next()) {
            response = rs.getBigDecimal("PLAN_YIELD");
        }
        return response;
    }

    private SfcInfo findSfcInfo( String sfcBo ) throws SQLException {
        SfcInfo response = new SfcInfo();
        dq.flush();
        dq.append(" select * from sfc a " +
                          " join sfc_routing b on a.handle = b.sfc_bo " +
                          " join sfc_router c on b.handle = c.sfc_routing_bo and c.IN_USE='true' ");
        dq.append(" where a.handle = ");
        dq.appendString(sfcBo);
        ResultSet rs = base.executeQueryAsResultSet(dq);
        while (rs.next()) {
            response.setItemBo(rs.getString("ITEM_BO"));
            response.setQty(rs.getBigDecimal("QTY"));
            response.setRouterBo(rs.getString("ROUTER_BO"));
        }
        return response;
    }

    private void alarm( String site, String operation, String sfc, BigDecimal yield ) throws SQLException {
        String projectId = "";
        String url = "";

        // 取得連線資訊
        dq.flush();
        dq.append(" select * from Z_SYSTEM_CONFIG ");
        dq.append(" where site = ");
        dq.appendString(site);
        dq.append(" and SYSTEM_RULE like 'ALM%' ");
        ResultSet rs = base.executeQueryAsResultSet(dq);
        while (rs.next()) {
            String rule = rs.getString("SYSTEM_RULE");
            String value = rs.getString("SYSTEM_VALUE");

            switch (rule) {
                case "ALM_SERVER_URL":
                    url = value;
                    break;
                case "ALM_PROJECT_ID":
                    projectId = value;
                    break;
                default:
                    break;
            }
        }

        if (FwUtils.isNullOrEmpty(url)) {
            return;
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("op", operation);
        map.put("sfc", sfc);
        map.put("yield", yield.toString() + "%");
        String message = I18nUtility.i18nizeMessageText("alarm.sfc", map, null);

        AlarmExecuteRequest alarmExecuteRequest = new AlarmExecuteRequest();
        alarmExecuteRequest.setUrl(url);
        alarmExecuteRequest.setProjectId(projectId);
        alarmExecuteRequest.setFormId("SAPME");
        alarmExecuteRequest.setFormName(I18nUtility.i18nizeMessageText("alarm.title", null, null));
        alarmExecuteRequest.setEventId("LOW_YIELD_ALARM");
        alarmExecuteRequest.setMessageContent(message);
        alarmExecuteRequest.setOffTracking("N");

        try {
            SendingAlarmMessage.execute(alarmExecuteRequest);
        } catch (Exception e) {
            // keep execute
        }
    }

    public void setExtensionContext( ExtensionContextInterface context ) {
        this.extensionContext = context;
        this.activityBo = context.getExtensionConfiguration().getActivityRef();
    }
}
