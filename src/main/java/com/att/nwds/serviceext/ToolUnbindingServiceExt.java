package com.att.nwds.serviceext;

import com.sap.me.activity.ServiceExtension;
import com.sap.me.demand.SFCBOHandle;
import com.sap.me.frame.BasicBOBeanException;
import com.sap.me.frame.Data;
import com.sap.me.frame.SystemBase;
import com.sap.me.frame.domain.BusinessException;
import com.sap.me.frame.jdbc.DynamicQuery;
import com.sap.me.frame.jdbc.DynamicQueryFactory;
import com.sap.me.frame.service.CommonMethods;
import com.sap.me.frame.transitionutils.Exceptions;
import com.sap.me.nonconformance.CreateNCBatchRequest;
import com.sap.me.nonconformance.CreateNCRequest;
import com.sap.me.plant.ResourceBOHandle;
import com.sap.me.productdefinition.OperationBOHandle;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ToolUnbindingServiceExt extends ServiceExtension<Object> {

    private SystemBase base;
    private DynamicQuery dq;
    private ResultSet rs;

    private void init() {
        base = SystemBase.createSystemBase("jdbc/jts/wipPool");
        dq = DynamicQueryFactory.newInstance();
    }

    @Override
    public void execute( Object request ) throws Exception {
        if (request instanceof CreateNCBatchRequest) {
            execute((CreateNCBatchRequest) request);
        }
    }

    private void execute( CreateNCBatchRequest createNCBatchRequest ) throws SQLException, BusinessException {
        try {
            init();
            String site = CommonMethods.getSite();
            List<CreateNCRequest> createNCRequestList = createNCBatchRequest.getCreateNCRequestList();

            for (CreateNCRequest createNCRequest : createNCRequestList) {
                String sfcBo = createNCRequest.getSfcRef();
                String sfc = new SFCBOHandle(sfcBo).getSFC();
                String resourceBo = createNCRequest.getProdCtx().getResourceRef();
                String resource = new ResourceBOHandle(resourceBo).getResource();
                String operation = createNCRequest.getProdCtx().getStepIdentifier().getOperationId();
                String operationBo = new OperationBOHandle(site, operation, "#").getValue();
                BigDecimal qty = createNCRequest.getQty();

                BigDecimal inWorkQty = this.getInWorkQty(sfcBo, operationBo, resourceBo);

                BigDecimal toolQty = this.getToolQty(site, sfc, operation, resource);
                if (toolQty != null && toolQty.compareTo(BigDecimal.ZERO) > 0) {
                    BigDecimal subtractToolQty = inWorkQty.subtract(toolQty);
                    if (subtractToolQty.compareTo(qty) < 0) {
                        throw Exceptions.convert(new BasicBOBeanException(20107, new Data("sfc", sfc)));
                    }
                }

                BigDecimal shelfQty = this.getShelfQty(site, sfc, operation, resource);
                if (shelfQty != null && shelfQty.compareTo(BigDecimal.ZERO) > 0) {
                    BigDecimal subtractShelfQty = inWorkQty.subtract(shelfQty);
                    if (subtractShelfQty.compareTo(qty) < 0) {
                        throw Exceptions.convert(new BasicBOBeanException(20108, new Data("sfc", sfc)));
                    }
                }
            }
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            BasicBOBeanException exception = new BasicBOBeanException(20101, new Data("message", e.getMessage()));
            throw Exceptions.convert(exception);
        }
    }

    private BigDecimal getToolQty( String site, String sfc, String operation, String resource ) throws SQLException {
        BigDecimal toolQty = BigDecimal.ZERO;
        dq.flush();
        dq.append(" select count(*) cnt from Z_SN_TOOL_STATE ");
        dq.append(" where site =  ");
        dq.appendString(site);
        dq.append(" and operation = ");
        dq.appendString(operation);
        dq.append(" and resource = ");
        dq.appendString(resource);
        dq.append(" and sfc = ");
        dq.appendString(sfc);
        dq.append(" and status = '1' ");
        ResultSet rs = base.executeQueryAsResultSet(dq);
        while (rs.next()) {
            toolQty = rs.getBigDecimal("cnt");
        }

        return toolQty;
    }

    private BigDecimal getInWorkQty( String sfcBo, String operationBo, String resourceBo ) throws SQLException {
        BigDecimal inWorkQty = BigDecimal.ZERO;
        dq.flush();
        dq.append(" select * from VIEW_SFC_IN_WORK ");
        dq.append(" where handle =  ");
        dq.appendString(sfcBo);
        dq.append(" and operation_bo = ");
        dq.appendString(operationBo);
        dq.append(" and resource_bo = ");
        dq.appendString(resourceBo);
        ResultSet rs = base.executeQueryAsResultSet(dq);
        while (rs.next()) {
            inWorkQty = rs.getBigDecimal("QTY_IN_WORK");
        }

        return inWorkQty;
    }

    private BigDecimal getShelfQty( String site, String sfc, String operation, String resource ) throws SQLException {
        BigDecimal shelfQty = BigDecimal.ZERO;
        dq.flush();
        dq.append(" select sum(qty) sum from Z_MATERIAL_SHELF_STATE ");
        dq.append(" where site =  ");
        dq.appendString(site);
        dq.append(" and operation = ");
        dq.appendString(operation);
        dq.append(" and resource = ");
        dq.appendString(resource);
        dq.append(" and sfc = ");
        dq.appendString(sfc);
        ResultSet rs = base.executeQueryAsResultSet(dq);
        while (rs.next()) {
            shelfQty = rs.getBigDecimal("sum");
        }

        return shelfQty;
    }
}
