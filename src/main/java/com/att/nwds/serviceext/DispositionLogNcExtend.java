package com.att.nwds.serviceext;

import com.fw.mes.util.FwUtils;
import com.sap.me.activity.ExtensionContextSetter;
import com.sap.me.activity.ServiceExtension;
import com.sap.me.frame.BasicBOBeanException;
import com.sap.me.frame.Data;
import com.sap.me.frame.SystemBase;
import com.sap.me.frame.domain.BusinessException;
import com.sap.me.frame.jdbc.DynamicQuery;
import com.sap.me.frame.jdbc.DynamicQueryFactory;
import com.sap.me.frame.service.CommonMethods;
import com.sap.me.frame.transitionutils.Exceptions;
import com.sap.me.nonconformance.DispositionMultipleSfcsRequest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DispositionLogNcExtend extends ServiceExtension<Object> implements ExtensionContextSetter {

    private SystemBase base;
    private DynamicQuery dq;
    private ResultSet rs;

    @Override
    public void execute( Object request ) throws Exception {
        if (request instanceof DispositionMultipleSfcsRequest) {
            execute((DispositionMultipleSfcsRequest) request);
        }
    }

    private void execute( DispositionMultipleSfcsRequest dispositionMultipleSfcsRequest ) throws BusinessException {
        try {
            init();
            String site = CommonMethods.getSite();
            String operation = dispositionMultipleSfcsRequest.getProdCtx().getStepIdentifier().getOperationId();
            String operationBo = this.getCurrentOperation(site, operation);
            String resourceBo = dispositionMultipleSfcsRequest.getProdCtx().getResourceRef();

            for (String sfcBo : dispositionMultipleSfcsRequest.getSfcs()) {
                String ncDataBo = this.getNcData(sfcBo, operationBo, resourceBo);
                if (!FwUtils.isNullOrEmpty(ncDataBo)) {
                    this.insertSfcNcData(site, ncDataBo);
                }
            }
        } catch (Exception e) {
            String msg = e.toString();
            BasicBOBeanException exception = new BasicBOBeanException(20101, new Data("message", e.toString()));
            throw Exceptions.convert(exception);
        }

    }

    private void init() {
        base = SystemBase.createSystemBase("jdbc/jts/wipPool");
        dq = DynamicQueryFactory.newInstance();
    }

    private String getCurrentOperation( String site, String operation ) throws SQLException {
        dq.flush();
        dq.append(" select * from operation ");
        dq.append(" where site = ");
        dq.appendString(site);
        dq.append(" and operation = ");
        dq.appendString(operation);
        dq.append(" and current_revision = ");
        dq.appendString("true");
        rs = base.executeQueryAsResultSet(dq);

        if (rs.next()) {
            return rs.getString("handle");
        }

        return null;
    }

    private String getNcData( String sfcBo, String operationBo, String resourceBo ) throws SQLException {
        dq.flush();
        dq.append(" select * from NC_DATA ");
        dq.append(" where NC_CONTEXT_GBO = ");
        dq.appendString(sfcBo);
        dq.append(" and OPERATION_BO = ");
        dq.appendString(operationBo);
        dq.append(" and RESOURCE_BO = ");
        dq.appendString(resourceBo);
        dq.append(" order by DATE_TIME desc ");
        rs = base.executeQueryAsResultSet(dq);
        if (rs.next()) {
            return rs.getString("HANDLE");
        }

        return null;
    }

    private void insertSfcNcData( String site, String ncDataBo ) {
        Data data = new Data();
        data.put("SID", FwUtils.getUid());
        data.put("SITE", site);
        data.put("NC_DATA_BO", ncDataBo);
        base.insertGeneric("Z_SFC_NC_DATA", data);
    }
}
