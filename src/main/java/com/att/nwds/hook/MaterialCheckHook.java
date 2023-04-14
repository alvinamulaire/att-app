package com.att.nwds.hook;

import com.att.nwds.service.CommonService;
import com.att.nwds.service.domain.RequestBase;
import com.fw.mes.util.FwUtils;
import com.sap.me.activity.HookContextInterface;
import com.sap.me.activity.HookContextSetter;
import com.sap.me.extension.Services;
import com.sap.me.production.StartHookDTO;
import com.visiprise.frame.service.ext.ActivityInterface;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MaterialCheckHook implements ActivityInterface<StartHookDTO>, HookContextSetter {

    private String isInv;

    @Override
    public void setHookContext( HookContextInterface hookContextInterface ) {
        String userArgument = hookContextInterface.getUserArguments();

        isInv = null;
        if (!FwUtils.isNullOrEmpty(userArgument)) {
            isInv = userArgument;
        }
    }

    @Override
    public void execute( StartHookDTO request ) throws Exception {
        CommonService commonService = Services.getService("com.att.service", "CommonService");

        String site = request.getSite();
        String sfcBo = request.getSfcBO().getValue();
        String operationBo = request.getOperationBO().getValue();
        String resourceBo = request.getResourceBO().getValue();
        BigDecimal qty = request.getQty();

        RequestBase requestBase = new RequestBase();
        requestBase.setSite(site);
        requestBase.setSfcBo(sfcBo);
        requestBase.setOperationBo(operationBo);
        requestBase.setResourceBo(resourceBo);
        requestBase.setRequestQty(qty);
        requestBase.setIsInv(isInv);

        List<RequestBase> requestBaseList = new ArrayList<>();
        requestBaseList.add(requestBase);

        // 檢查庫存
        commonService.checkInventory(requestBaseList);
    }
}
