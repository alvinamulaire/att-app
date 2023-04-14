package com.att.nwds.hook;

import com.att.nwds.service.CommonService;
import com.att.nwds.service.domain.DcInfo;
import com.fw.mes.util.DateUtil;
import com.fw.mes.util.FwUtils;
import com.sap.me.activity.HookContextInterface;
import com.sap.me.activity.HookContextSetter;
import com.sap.me.common.ObjectReference;
import com.sap.me.demand.SFCBOHandle;
import com.sap.me.extension.Services;
import com.sap.me.frame.domain.BusinessException;
import com.sap.me.plant.SiteConfigurationServiceInterface;
import com.sap.me.plant.SiteFullConfiguration;
import com.sap.me.production.PostCompleteHookDTO;
import com.visiprise.frame.service.ext.ActivityInterface;
import com.visiprise.globalization.DateGlobalizationServiceInterface;
import com.visiprise.globalization.GlobalizationService;
import com.visiprise.globalization.util.DateTimeInterface;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DcProductDateHook implements ActivityInterface<PostCompleteHookDTO>, HookContextSetter {

	private String saveDays;
	private DateGlobalizationServiceInterface dateService;
	private SiteConfigurationServiceInterface siteService;
	private CommonService commonService;
	@Override
	public void setHookContext( HookContextInterface hookContextInterface ) {
		saveDays = hookContextInterface.getUserArguments();
	}

	private void initServices() throws BusinessException {
		dateService = (DateGlobalizationServiceInterface) GlobalizationService.getInvariantService("com.visiprise.globalization.DateGlobalizationService");
		siteService = Services.getService("com.sap.me.plant", "SiteConfigurationService");
		commonService = Services.getService("com.att.service", "CommonService");
	}

	@Override
	@Transactional
	public void execute(PostCompleteHookDTO request) throws BusinessException {
		initServices();

		dc(request,"ZB_MFDATE",getDcValue(request.getSite(),"ZB_MFDATE"));
		dc(request,"ZB_EXPDATE",getDcValue(request.getSite(),"ZB_EXPDATE"));
		dc(request,"DAY",getDcValue(request.getSite(),"DAY"));
		dc(request,"WEEK",getDcValue(request.getSite(),"WEEK"));

	}

	private String getDcValue(String site, String measureName) throws BusinessException {
		ObjectReference siteReference = new ObjectReference();
		siteReference.setRef("SiteBO:"+site);
		SiteFullConfiguration siteFullConfiguration = siteService.readSite(siteReference);

		DateTimeInterface now = dateService.createDateTime();
		long timeMillis = now.getTimeInMillis();
		Date date = new Date(timeMillis);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(convertDateTimeToDate( now));
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setMinimalDaysInFirstWeek(4);
		int week = calendar.get(Calendar.WEEK_OF_YEAR);
		int mouth = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_YEAR);
		if (mouth >= 11 && week <= 1) {
			week += 52;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone(siteFullConfiguration.getTimeZone()));;

		switch (measureName){
			case "ZB_MFDATE":
				return simpleDateFormat.format(date);
			case "ZB_EXPDATE":
				if(FwUtils.isNullOrEmpty(saveDays)){
					return "";
				}else {
					try {
						Date saveDate = DateUtil.addDay(date, Integer.parseInt(saveDays));
						return simpleDateFormat.format(saveDate);
					}catch (Exception e){
						return "";
					}
				}

			case "DAY":
				return String.valueOf(day);
			case "WEEK":
				return String.valueOf(week);
			default:
				return "";
		}
	}

	private void dc(PostCompleteHookDTO request, String measureName, String actual) throws BusinessException {
		if(FwUtils.isNullOrEmpty(actual)){
			return;
		}

		DcInfo dcInfo = new DcInfo();
		dcInfo.setSite(request.getSite());
		dcInfo.setDcGroup("PRODUCT_DATE");
		dcInfo.setSfcBo(request.getSfcBO().getValue());
		dcInfo.setOperationBo(request.getOperationBO().getValue());
		dcInfo.setResourceBo(request.getResourceBO().getValue());
		dcInfo.setMeasureGroup("PRODUCT_DATE");
		dcInfo.setMeasureName(measureName);
		dcInfo.setActual(actual);

		commonService.deleteDcCollection(dcInfo);
		commonService.dcCollection(dcInfo);
	}

	private Date convertDateTimeToDate(DateTimeInterface dateTimeInterface){
		long timeMillis = dateTimeInterface.getTimeInMillis();
		Date date = new Date(timeMillis);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = simpleDateFormat.format(date);
		try {
			return simpleDateFormat.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}
}
