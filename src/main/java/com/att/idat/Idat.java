package com.att.idat;

import com.fw.mes.me.domain.idat.IdatRequest;
import com.fw.mes.me.sevice.impl.IdatService;
import com.sap.me.activity.ActivityExecutionType;
import com.sap.me.frame.domain.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Idat {

    @Autowired
    private IdatService idatService;

    private IdatRequest idatRequest;

    public void getActivity() {
        // hook
        idatRequest.setActivity("Z_PP02", "I18N[Z_PP02]", ActivityExecutionType.SERVICE, "com.att.hook$AutoShelfTakeOffHook", false);
        idatRequest.setActivity("Z_PP03", "I18N[Z_PP03]", ActivityExecutionType.SERVICE, "com.att.hook$ProductionLevelHook", false);
        idatRequest.setActivity("Z_PP07", "I18N[Z_PP07]", ActivityExecutionType.SERVICE, "com.att.hook$MaterialCheckHook", false);
        idatRequest.setActivity("Z_PP18", "I18N[Z_PP18]", ActivityExecutionType.SERVICE, "com.att.hook$BatchNumberHook", false);
        idatRequest.setActivity("Z_PP22", "I18N[Z_PP22]", ActivityExecutionType.SERVICE, "com.att.hook$DcProductDateHook", false);
        idatRequest.setActivity("Z_MM02", "I18N[Z_MM02]", ActivityExecutionType.SERVICE, "com.att.hook$ClearInvHook", false);

        // service ext
        idatRequest.setActivity("Z_PP09", "I18N[Z_PP09.desc]", ActivityExecutionType.SERVICE, "com.att.serviceext$MaterialCheckServiceExt", false);
        idatRequest.setActivity("Z_PP10", "I18N[Z_PP10.desc]", ActivityExecutionType.SERVICE, "com.att.serviceext$ReduceInventoryExtension", false);
        idatRequest.setActivity("Z_PP13", "I18N[Z_PP13.desc]", ActivityExecutionType.SERVICE, "com.att.serviceext$YieldNotificationExtension", false);
        idatRequest.setActivity("Z_PP12", "I18N[Z_PP12.desc]", ActivityExecutionType.SERVICE, "com.att.serviceext$ToolUnbindingServiceExt", false);
        idatRequest.setActivity("Z_PP30", "I18N[Z_PP30.desc]", ActivityExecutionType.SERVICE, "com.att.serviceext$ChangeAutoSplitSfcNumber", false);
        idatRequest.setActivity("Z_PP32", "I18N[Z_PP32.desc]", ActivityExecutionType.SERVICE, "com.att.serviceext$DispositionLogNcExtend", false);

        // web
        idatRequest.setActivity("Z_SO02", "I18N[Z_SO02]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#sfcRelease", true);
        idatRequest.setActivity("Z_MD01", "I18N[Z_MD01]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#yieldMaintain", true);
        idatRequest.setActivity("Z_MM01", "I18N[Z_MM01]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#returnMaterial", true);
        idatRequest.setActivity("Z_PP01", "I18N[Z_PP01]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#materialShelf", true);
        idatRequest.setActivity("Z_PP14", "I18N[Z_PP14]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#sn", true);
        idatRequest.setActivity("Z_PP15", "I18N[Z_PP15]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#packing", true);
        idatRequest.setActivity("Z_PP16", "I18N[Z_PP16]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#stacking", true);
        idatRequest.setActivity("Z_PP28", "I18N[Z_PP28]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#tlSn", true);
        idatRequest.setActivity("Z_PP24", "I18N[Z_PP24]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#print", true);
        idatRequest.setActivity("Z_PP21", "I18N[Z_PP21]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#packCheckOut", false);
        idatRequest.setActivity("Z_PP20", "I18N[Z_PP20]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#packagingProd", true);
        idatRequest.setActivity("Z_PP25", "I18N[Z_PP25]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#clampStart", false);
        idatRequest.setActivity("Z_PP26", "I18N[Z_PP26]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#clampOff", false);
        idatRequest.setActivity("Z_PP27", "I18N[Z_PP27]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#clampComplete", false);
        idatRequest.setActivity("Z_MM03", "I18N[Z_MM03]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#sfcDone", false);
        idatRequest.setActivity("Z_RM05", "I18N[Z_RM05]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#shippingReport", false);
        idatRequest.setActivity("Z_RM02", "I18N[Z_RM02]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#productionDailyReport", true);
        idatRequest.setActivity("Z_QM06", "I18N[Z_QM06]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#ncOperation", false);
        idatRequest.setActivity("Z_RM06", "I18N[Z_RM06]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#ncReport", true);
        idatRequest.setActivity("Z_RM06", "I18N[Z_RM06]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#ncReport", true);
        idatRequest.setActivity("Z_RM03", "I18N[Z_RM03]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#equipmentKanban", true);
        idatRequest.setActivity("Z_RM01", "I18N[Z_RM01]", ActivityExecutionType.STANDALONE_JSP, "%PROTOCOL%://%SERVER%:%PORT%/manufacturing-app/att-frontend/index.html#productionKanban", true);
    }

    public void run() {
        idatRequest = new IdatRequest();

        this.getActivity();

        try {
            idatService.invokeIdat(idatRequest.all());
        } catch (BusinessException e) {
        }
    }
}
