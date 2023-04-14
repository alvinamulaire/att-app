package com.att.nwds.serviceext;

import com.att.nwds.service.CommonService;
import com.att.nwds.service.domain.RequestBase;
import com.sap.me.activity.ServiceExtension;
import com.sap.me.extension.Services;
import com.sap.me.frame.domain.BusinessException;
import com.sap.me.frame.service.CommonMethods;
import com.sap.me.production.CompleteSfcBasicRequest;
import com.sap.me.production.CompleteSfcBatchRequest;

import java.util.ArrayList;
import java.util.List;

public class MaterialCheckServiceExt extends ServiceExtension<Object> {

    @Override
    public void execute( Object request ) throws Exception {
        if (request instanceof CompleteSfcBatchRequest) {
            execute((CompleteSfcBatchRequest) request);
        }
    }

    public void execute( CompleteSfcBatchRequest request ) throws BusinessException {
        CommonService commonService = Services.getService("com.att.service", "CommonService");

        List<RequestBase> requestBaseList = new ArrayList<>();
        for (CompleteSfcBasicRequest sfcRequest : request.getCompleteSfcList()) {
            RequestBase requestBase = new RequestBase();
            requestBase.setSite(CommonMethods.getSite());
            requestBase.setSfcBo(sfcRequest.getSfcRef());
            requestBase.setOperationBo(sfcRequest.getOperationRef());
            requestBase.setResourceBo(sfcRequest.getResourceRef());
            requestBase.setRequestQty(sfcRequest.getQuantity());
            requestBase.setIsInv(null);
            requestBaseList.add(requestBase);
        }

        // 檢查庫存
        commonService.checkInventory(requestBaseList);
    }
}
