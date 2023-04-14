package com.att.nwds.hook;

import com.att.nwds.service.CommonService;
import com.att.nwds.service.domain.DcInfo;
import com.sap.me.demand.SFCBOHandle;
import com.sap.me.extension.Services;
import com.sap.me.frame.domain.BusinessException;
import com.sap.me.production.PostCompleteHookDTO;
import com.visiprise.frame.service.ext.ActivityInterface;
import org.springframework.transaction.annotation.Transactional;

public class BatchNumberHook implements ActivityInterface<PostCompleteHookDTO> {

	@Override
	@Transactional
	public void execute(PostCompleteHookDTO request) throws BusinessException {
		DcInfo dcInfo = new DcInfo();
		dcInfo.setSite(request.getSite());
		dcInfo.setDcGroup("BATCH_NUMBER");
		dcInfo.setSfcBo(request.getSfcBO().getValue());
		dcInfo.setOperationBo(request.getOperationBO().getValue());
		dcInfo.setResourceBo(request.getResourceBO().getValue());
		dcInfo.setMeasureGroup("BATCH_NUMBER");
		dcInfo.setMeasureName("BATCH_NUMBER");
		dcInfo.setActual(new SFCBOHandle(request.getSfcBO().getValue()).getSFC());
		CommonService commonService = Services.getService("com.att.service", "CommonService");

		commonService.deleteDcCollection(dcInfo);
		commonService.dcCollection(dcInfo);
	}

}
