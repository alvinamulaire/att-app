package com.att.nwds.hook;

import com.att.nwds.service.CommonService;
import com.att.nwds.service.domain.DcInfo;
import com.fw.mes.util.FwUtils;
import com.sap.me.activity.HookContextInterface;
import com.sap.me.activity.HookContextSetter;
import com.sap.me.extension.Services;
import com.sap.me.frame.service.CommonMethods;
import com.sap.me.production.PostCompleteHookDTO;
import com.visiprise.frame.service.ext.ActivityInterface;

public class ProductionLevelHook implements ActivityInterface<PostCompleteHookDTO>, HookContextSetter {

    private String userArgument;

    @Override
    public void setHookContext( HookContextInterface hookContextInterface ) {
        userArgument = hookContextInterface.getUserArguments();
    }

    @Override
    public void execute( PostCompleteHookDTO request ) throws Exception {
        String site = CommonMethods.getSite();
        String sfcBo = request.getSfcBO().getValue();
        String operationBo = request.getOperationBO().getValue();
        String resourceBo = request.getResourceBO().getValue();

        if (!FwUtils.isNullOrEmpty(userArgument)) {
            CommonService commonService = Services.getService("com.att.service", "CommonService");

            DcInfo dcInfo = new DcInfo();
            dcInfo.setSite(site);
            dcInfo.setDcGroup("PRODUCT_RANK");
            dcInfo.setSfcBo(sfcBo);
            dcInfo.setOperationBo(operationBo);
            dcInfo.setResourceBo(resourceBo);
            dcInfo.setMeasureGroup("PRODUCT_RANK");
            dcInfo.setMeasureName("RANK");
            dcInfo.setActual(userArgument);

            // 資料收集
            commonService.dcCollection(dcInfo);
        }
    }
}
