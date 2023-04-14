package com.att.service.impl;

import com.att.domain.iqc.IqcBaseInfo;
import com.att.domain.iqc.IqcOutInfo;
import com.att.mssql.repository.IqcRepository;
import com.att.mssql.repository.entity.IqcInbound;
import com.att.mssql.repository.entity.IqcOutbound;
import com.att.repository.entity.ZSystemTransactionLog;
import com.att.repository.entity.ZVwQcPlanProd;
import com.att.repository.entity.ZVwQmsInspecJob;
import com.att.service.IqcService;
import com.fw.mes.me.controller.site.SiteRepo;
import com.fw.mes.me.controller.systemConfig.SystemConfigRepo;
import com.fw.mes.me.domain.http.HttpRequest;
import com.fw.mes.me.domain.http.HttpResponse;
import com.fw.mes.me.entity.ZSystemConfig;
import com.fw.mes.util.DateUtil;
import com.fw.mes.util.FwUtils;
import com.fw.mes.util.HttpUtil;
import com.fw.mes.util.JsonUtil;
import org.json.JSONObject;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class IqcServiceImpl implements IqcService {

    @Autowired
    private IqcRepository iqcRepository;

    @Autowired
    private SystemConfigRepo systemConfigRepo;

    @Autowired
    private SiteRepo siteRepo;

    @Autowired
    private MessageSource messageSource;


    private final String success = "Success";
    private final String fail = "Fail";

    @Override
    public void read( JobExecutionContext jobExecutionContext ) {
        IqcBaseInfo iqcBaseInfo = new IqcBaseInfo();
        init(jobExecutionContext, iqcBaseInfo);
        String site = iqcBaseInfo.getSite();
        String timeZone = iqcBaseInfo.getTimeZone();

        getUrl(site, iqcBaseInfo);
        String url = iqcBaseInfo.getUrl();

        String freq = "MANUAL";
        String isErp = "0";
        Locale locale = LocaleContextHolder.getLocale();
        String failMsg = messageSource.getMessage("iqc.error2", null, locale);

        IqcOutInfo iqcOutbound = new IqcOutInfo();
        iqcOutbound.setWerk(site);
        iqcOutbound.setStatustext("REL");
        iqcOutbound.setMeStatusList(Arrays.asList("0", "3"));
        List<IqcOutbound> list = iqcRepository.getIqcOutBound(iqcOutbound);

        if (!FwUtils.isEmpty(list)) {
            list.forEach(obj -> {
                String item = obj.getSelmatnr().trim();
                String jobNo = obj.getPrueflos().trim();
                String vendor = obj.getLifnr().trim();
                BigDecimal popQty = new BigDecimal(String.valueOf(obj.getLosmenge()));
                String purchase = obj.getEbeln().trim();
                String order = String.valueOf(obj.getEbelp());
                String batch = obj.getCharg().trim();
                // 1:處理中，2:成功，3:失敗
                String status = "3";
                String msg = "";

                ZSystemTransactionLog zSystemTransactionLog = new ZSystemTransactionLog();
                zSystemTransactionLog.setFunctionName("ReadIqcOutBound");
                zSystemTransactionLog.setKeyValue(jobNo);

                // 更新狀態:處理中
                updateStatus(site, obj, "1", timeZone);

                ZVwQcPlanProd zVwQcPlanProd = new ZVwQcPlanProd();
                zVwQcPlanProd.setSite(site);
                zVwQcPlanProd.setMaterialNo(item);
                List<ZVwQcPlanProd> qcPlanProds = iqcRepository.getQcPlanProd(zVwQcPlanProd);

                if (!FwUtils.isEmpty(qcPlanProds)) {
                    // 有檢驗計畫
                    if (qcPlanProds.size() > 1) {
                        // 多筆
                        msg = messageSource.getMessage("iqc.error1", new Object[]{ item }, locale);
                        errorLog(zSystemTransactionLog, msg);
                    } else {
                        // 單筆
                        ZVwQcPlanProd planProd = qcPlanProds.get(0);
                        String qcPlan = planProd.getQcPlan();
                        String qcType = planProd.getQcType();

                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("site", site);
                        jsonObject.put("qcPlan", qcPlan);
                        jsonObject.put("qcType", qcType);
                        jsonObject.put("qcFreq", freq);
                        jsonObject.put("materialNo", item);
                        jsonObject.put("jobNo", jobNo);
                        jsonObject.put("vendor", vendor);
                        jsonObject.put("qty", popQty);
                        jsonObject.put("isErp", isErp);
                        jsonObject.put("user", "IQC");
                        // new, only for iqc
                        jsonObject.put("purchaseNo", purchase);
                        jsonObject.put("itemOrder", order);
                        jsonObject.put("materialBatch", batch);

                        zSystemTransactionLog.setRequest(jsonObject.toString());

                        // 開立檢驗單
                        HttpRequest httpRequest = new HttpRequest();
                        httpRequest.setUrl(url + "qms/qms/inspec/job/create");
                        httpRequest.setLanguage(locale.getLanguage());
                        httpRequest.setRequest(jsonObject.toString());
                        try {
                            HttpResponse response = HttpUtil.doPost(httpRequest);
                            if (!FwUtils.objIsEmpty(response)) {
                                if (response.getStatusCode() == 200) {
                                    // 處理狀態:成功
                                    status = "2";
                                    zSystemTransactionLog.setResult(success);
                                } else {
                                    errorLog(zSystemTransactionLog, response.getResponse());
                                }
                            }
                        } catch (IOException e) {
                            errorLog(zSystemTransactionLog, messageSource.getMessage("iqc.error4", new Object[]{ url }, locale));
                        }
                    }
                } else {
                    msg = messageSource.getMessage("iqc.error3", new Object[]{ item }, locale);
                    errorLog(zSystemTransactionLog, msg);
                }

                if ("3".equals(status)) {
                    // 失敗
                    if (!FwUtils.isNullOrEmpty(msg)) {
                        obj.setMeMemo(msg);
                    } else {
                        obj.setMeMemo(failMsg);
                    }
                } else {
                    obj.setMeMemo("");
                }

                updateStatus(site, obj, status, timeZone);
                insertLog(zSystemTransactionLog);
            });
        }
    }

    @Override
    public void write( JobExecutionContext jobExecutionContext ) {
        IqcBaseInfo iqcBaseInfo = new IqcBaseInfo();
        init(jobExecutionContext, iqcBaseInfo);
        String site = iqcBaseInfo.getSite();
        String timeZone = iqcBaseInfo.getTimeZone();

        getUrl(site, iqcBaseInfo);
        String url = iqcBaseInfo.getUrl();

        Date now = DateUtil.toLocalDated(DateUtil.getGmtTime(), timeZone);
        Locale locale = LocaleContextHolder.getLocale();

        ZVwQmsInspecJob zVwQmsInspecJob = new ZVwQmsInspecJob();
        zVwQmsInspecJob.setSite(site);
        List<ZVwQmsInspecJob> list = iqcRepository.getInspecJob(zVwQmsInspecJob);

        if (!FwUtils.isEmpty(list)) {
            list.forEach(obj -> {
                String jobNo = obj.getJobNo();
                String materialNo = obj.getMaterialNo();
                String status = obj.getStatus();
                String ymd = DateUtil.dateToString(now, "yyyyMMdd");
                String hms = DateUtil.dateToString(now, "HHmmss");

                ZSystemTransactionLog zSystemTransactionLog = new ZSystemTransactionLog();
                zSystemTransactionLog.setFunctionName("WriteIqcInBound");
                zSystemTransactionLog.setKeyValue(jobNo);

                IqcOutbound iqcOutbound = new IqcOutbound();
                iqcOutbound.setWerk(site);
                iqcOutbound.setPrueflos(jobNo);
                iqcOutbound.setSelmatnr(materialNo);
                iqcOutbound.setLastUpdatedBy("ME");
                iqcOutbound.setLastUpdateDate(ymd);
                iqcOutbound.setLastUpdateTime(hms);

                if ("5".equals(status)) {
                    BigDecimal okQty = BigDecimal.ZERO;
                    BigDecimal ngQty = BigDecimal.ZERO;
                    BigDecimal testingQty = BigDecimal.ZERO;

                    if (!FwUtils.objIsEmpty(obj.getOkQty())) {
                        okQty = obj.getOkQty();
                    }

                    if (!FwUtils.objIsEmpty(obj.getNgQty())) {
                        ngQty = obj.getNgQty();
                    }

                    if (!FwUtils.objIsEmpty(obj.getTestingQty())) {
                        testingQty = obj.getTestingQty();
                    }

                    // 任務已判定
                    IqcInbound iqcInbound = new IqcInbound();
                    iqcInbound.setWerk(site);
                    iqcInbound.setPrueflos(jobNo);
                    iqcInbound.setSelmatnr(materialNo);
                    iqcInbound.setLmengezub(obj.getPopulationQty());
                    iqcInbound.setVcode(obj.getUdCode());
                    iqcInbound.setLmenge01(okQty);
                    iqcInbound.setLmenge08(ngQty);
                    iqcInbound.setLmenge03(testingQty);
                    iqcInbound.setStatustext("REL");
                    iqcInbound.setErpStatus("0");
                    iqcInbound.setCreatedBy("ME");
                    iqcInbound.setCreationDate(ymd);
                    iqcInbound.setCreationTime(hms);
                    iqcInbound.setLastUpdatedBy("ME");
                    iqcInbound.setLastUpdateDate(ymd);
                    iqcInbound.setLastUpdateTime(hms);

                    zSystemTransactionLog.setRequest(JsonUtil.converToString(iqcInbound));
                    zSystemTransactionLog.setResult(success);

                    try {
                        iqcRepository.insertIqcInBound(iqcInbound);

                        this.updateOutBound(iqcOutbound, "5");
                    } catch (Exception e) {
                        errorLog(zSystemTransactionLog, e.getMessage());
                    }
                } else if ("4".equals(status)) {
                    // 任務取消
                    zSystemTransactionLog.setRequest(JsonUtil.converToString(iqcOutbound));
                    zSystemTransactionLog.setResult(success);

                    try {
                        this.updateOutBound(iqcOutbound, "4");
                    } catch (Exception e) {
                        errorLog(zSystemTransactionLog, e.getMessage());
                    }
                }

                insertLog(zSystemTransactionLog);

                // 更新檢驗任務
                if (zSystemTransactionLog.getResult().equals(success)) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("site", site);
                    jsonObject.put("jobNo", jobNo);
                    jsonObject.put("isErp", "1");

                    HttpRequest httpRequest = new HttpRequest();
                    httpRequest.setUrl(url + "qms/qms/inspec/job/update");
                    httpRequest.setLanguage(locale.getLanguage());
                    httpRequest.setRequest(jsonObject.toString());

                    zSystemTransactionLog.setRequest(jsonObject.toString());

                    try {
                        HttpResponse response = HttpUtil.doPost(httpRequest);
                        if (!FwUtils.objIsEmpty(response)) {
                            if (response.getStatusCode() != 200) {
                                errorLog(zSystemTransactionLog, response.getResponse());
                            }
                        }
                    } catch (IOException e) {
                        errorLog(zSystemTransactionLog, messageSource.getMessage("iqc.error4", new Object[]{ url }, locale));
                    }

                    if (zSystemTransactionLog.getResult().equals(fail)) {
                        // 更新失敗
                        insertLog(zSystemTransactionLog);
                    }
                }
            });
        }
    }

    private void init( JobExecutionContext jobContext, IqcBaseInfo iqcBaseInfo ) {
        JobDataMap jobDataMap = jobContext.getTrigger().getJobDataMap();
        // get site
        iqcBaseInfo.setSite((String) jobDataMap.get("site"));
        iqcBaseInfo.setTimeZone(siteRepo.getTimeZone(iqcBaseInfo.getSite()));
    }

    private void getUrl( String site, IqcBaseInfo iqcBaseInfo ) {
        ZSystemConfig systemConfig = systemConfigRepo.systemConfig(site, "FW_API_URL");
        if (!FwUtils.objIsEmpty(systemConfig)) {
            String[] strings = systemConfig.getSystemValue().split("manufacturing-app");
            if (strings.length > 0) {
                iqcBaseInfo.setUrl(strings[0]);
            }
        }
    }

    private void insertLog( ZSystemTransactionLog zSystemTransactionLog ) {
        zSystemTransactionLog.setTransId(FwUtils.getUid());
        zSystemTransactionLog.setFromSystem("ME");
        zSystemTransactionLog.setToSystem("ERPIQC");
        zSystemTransactionLog.setCreatedDateTime(DateUtil.getGmtTime());
        iqcRepository.insertTransactionLog(zSystemTransactionLog);
    }

    private void errorLog( ZSystemTransactionLog zSystemTransactionLog, String msg ) {
        zSystemTransactionLog.setResult(fail);
        zSystemTransactionLog.setMessage(msg);
    }

    private void updateStatus( String site, IqcOutbound iqcOutbound, String status, String timeZone ) {
        Date now = DateUtil.toLocalDated(DateUtil.getGmtTime(), timeZone);

        IqcOutbound outbound = new IqcOutbound();
        outbound.setWerk(site);
        outbound.setSelmatnr(iqcOutbound.getSelmatnr());
        outbound.setPrueflos(iqcOutbound.getPrueflos());
        outbound.setMeStatus(status);
        outbound.setMeMemo(iqcOutbound.getMeMemo());
        outbound.setLastUpdatedBy("ME");
        outbound.setLastUpdateDate(DateUtil.dateToString(now, "yyyyMMdd"));
        outbound.setLastUpdateTime(DateUtil.dateToString(now, "HHmmss"));
        iqcRepository.updateIqcOutBound(outbound);
    }

    private void updateOutBound( IqcOutbound iqcOutbound, String status ) {
        if ("4".equals(status)) {
            iqcOutbound.setStatustext("LTCA");
        }
        iqcOutbound.setMeStatus(status);
        iqcRepository.updateIqcOutBound(iqcOutbound);
    }
}
