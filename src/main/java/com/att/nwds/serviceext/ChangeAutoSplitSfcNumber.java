package com.att.nwds.serviceext;

import com.sap.me.activity.ServiceExtension;
import com.sap.me.demand.ShopOrderBOHandle;
import com.sap.me.frame.BasicBOBeanException;
import com.sap.me.frame.Data;
import com.sap.me.frame.SystemBase;
import com.sap.me.frame.domain.BusinessException;
import com.sap.me.frame.jdbc.DynamicQuery;
import com.sap.me.frame.jdbc.DynamicQueryFactory;
import com.sap.me.frame.service.CommonMethods;
import com.sap.me.frame.transitionutils.Exceptions;
import com.sap.me.production.SplitSfcDetail;
import com.sap.me.production.SplitSfcRequest;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangeAutoSplitSfcNumber extends ServiceExtension<Object> {

    private SystemBase base;
    private final DynamicQuery dq = DynamicQueryFactory.newInstance();
    private ResultSet rs;
    private final String site = CommonMethods.getSite();

    @Override
    public void execute( Object request ) throws Exception {
        if (request instanceof SplitSfcRequest) {
            execute((SplitSfcRequest) request);
        }
    }

    public void execute( SplitSfcRequest request ) throws Exception {
        init();
        try {
            String shopOrder = getShopOrder(request.getSfcRef());
            String nextSeq = getNextSeq(shopOrder);


            for (SplitSfcDetail splitSfcDetail : request.getNewSfcList()) {
                String newSfc;
                do {
                    String firstNum = nextSeq.substring(0,1);
                    String seqStr = nextSeq.substring(1);
                    if(seqStr.equals("99")){
                        if(firstNum.equals("Z")){
                            // 超過99報錯
                            throw new BusinessException(20110);
                        }else {
                            firstNum = String.valueOf(((char)(firstNum.charAt(0)+1)));
                            seqStr = "01";
                        }
                    }else {
                        int seq = Integer.parseInt(seqStr);
                        seqStr = String.valueOf(seq+1);
                    }

                    newSfc = shopOrder + firstNum + "00".substring(seqStr.length()) + seqStr;
                } while (checkSfcExist(site, newSfc));

                splitSfcDetail.setSfc(newSfc);
            }
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            BasicBOBeanException exception = new BasicBOBeanException(20101, new Data("message", e.getMessage()));
            throw Exceptions.convert(exception);
        }
    }

    private void init() {
        base = SystemBase.createSystemBase("jdbc/jts/wipPool");
    }

    private String getShopOrder( String sfcBo ) throws SQLException {
        String shopOrder = null;

        dq.flush();
        dq.append(" SELECT shop_order_bo from sfc a ");
        dq.append(" WHERE a.handle = ");
        dq.appendString(sfcBo);
        rs = base.executeQueryAsResultSet(dq);
        while (rs.next()) {
            shopOrder = new ShopOrderBOHandle(rs.getString("shop_order_bo")).getShopOrder();
        }

        return shopOrder;
    }

    private String getNextSeq( String shopOrder ) throws SQLException {
        String nextSeq = "A00";

        dq.flush();
        dq.append(" select top 1 sfc from sfc ");
        dq.append("  where sfc LIKE_REGEXPR ");
        dq.appendString(shopOrder + "[A-Z]{1}[0-9]{2}$");
        dq.append(" order by sfc desc");
        rs = base.executeQueryAsResultSet(dq);
        while (rs.next()) {
            nextSeq = rs.getString("sfc").substring(shopOrder.length());
        }

        return nextSeq;
    }

    private boolean checkSfcExist( String site, String sfc ) throws SQLException {
        boolean sfcExist = false;

        dq.flush();
        dq.append(" SELECT sfc FROM sfc ");
        dq.append(" WHERE site = ");
        dq.appendString(site);
        dq.append(" AND sfc = ");
        dq.appendString(sfc);
        rs = base.executeQueryAsResultSet(dq);
        while (rs.next()) {
            sfcExist = true;
        }

        return sfcExist;
    }
}
