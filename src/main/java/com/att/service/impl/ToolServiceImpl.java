package com.att.service.impl;

import com.att.converent.ToolConverter;
import com.att.domain.tool.ToolRequest;
import com.att.domain.tool.ToolResponse;
import com.att.repository.ToolRepository;
import com.att.repository.entity.ZSnToolLog;
import com.att.repository.entity.ZSnToolState;
import com.att.service.ToolService;
import com.fw.mes.me.controller.activity.ActivityRepo;
import com.fw.mes.me.controller.operation.OperationRepo;
import com.fw.mes.me.controller.resource.ResourceRepo;
import com.fw.mes.me.controller.sfc.SfcRepo;
import com.fw.mes.me.controller.systemConfig.SystemConfigRepo;
import com.fw.mes.me.entity.*;
import com.fw.mes.me.tms.domain.base.*;
import com.fw.mes.me.tms.method.FixtureOnlineStatusChange;
import com.fw.mes.me.tms.method.LifeSync;
import com.fw.mes.util.DateUtil;
import com.fw.mes.util.FwUtils;
import com.sap.me.demand.SFCBOHandle;
import com.sap.me.frame.domain.BusinessException;
import com.sap.me.plant.ResourceBOHandle;
import com.sap.me.productdefinition.ItemBOHandle;
import com.sap.me.productdefinition.OperationBOHandle;
import com.sap.me.production.*;
import com.sap.me.status.StatusBOHandle;
import com.sap.me.user.UserBOHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ToolServiceImpl implements ToolService {

    @Autowired
    private ToolRepository toolRepository;

    @Autowired
    private ResourceRepo resourceRepo;

    @Autowired
    private OperationRepo operationRepo;

    @Autowired
    private SfcRepo sfcRepo;

    @Autowired
    private SystemConfigRepo systemConfigRepo;

    @Autowired
    private ActivityRepo activityRepo;

    private String url;

    private final List<String> statusList = Arrays.asList("401", "402", "403");

    @Override
    public ToolResponse getOpResInfo( ToolRequest toolRequest ) {
        String site = toolRequest.getSite();
        String resource = toolRequest.getResource();
        String operation = toolRequest.getOperation();
        String locale = toolRequest.getLan().toLowerCase();

        ToolResponse response = new ToolResponse();

        if (!FwUtils.isNullOrEmpty(operation)) {
            List<ViewOperationDesc> operationDescs = operationRepo.findByCurrentRevision(site, operation, locale);
            if (!FwUtils.isEmpty(operationDescs)) {
                response.setOperationDesc(operationDescs.get(0).getDescription());
            }
        }

        if (!FwUtils.isNullOrEmpty(resource)) {
            List<Resrce> resrces = resourceRepo.findById(site, resource);
            if (!FwUtils.isEmpty(resrces)) {
                response.setResourceDesc(resrces.get(0).getDescription());
            }
        }

        return response;
    }

    @Override
    public ToolResponse scanSfc( ToolRequest toolRequest ) {
        String site = toolRequest.getSite();
        String operation = toolRequest.getOperation();
        String sfc = toolRequest.getSfc();
        String type = toolRequest.getType();

        ToolResponse response = new ToolResponse();

        Sfc sfcInfo = sfcRepo.findById(site, sfc);

        ZSnToolState zSnToolState = new ZSnToolState();
        zSnToolState.setSite(site);
        zSnToolState.setSfc(sfc);

        if (!"complete".equals(type)) {
            ViewSfcInQueueInfo viewSfcInQueueInfo = new ViewSfcInQueueInfo();
            viewSfcInQueueInfo.setSite(site);
            viewSfcInQueueInfo.setSfc(sfc);
            viewSfcInQueueInfo.setOperation(operation);
            List<ViewSfcInQueueInfo> inQueueInfoList = sfcRepo.getSfcInQueueInfo(viewSfcInQueueInfo, "");

            response.setQtyInQueue(0);
            if (!FwUtils.isEmpty(inQueueInfoList)) {
                BigDecimal inQueueQty = inQueueInfoList.get(0).getQtyInQueue();
                response.setQtyInQueue(inQueueQty.intValue());
            }

            zSnToolState.setStatus("0");
        } else {
            List<ViewSfcRoutingStep> inWorkInfoList = sfcRepo.getSfcStepInWork(site, sfc).stream()
                    .filter(f -> {
                        String inOp = new OperationBOHandle(f.getOperationBo()).getOperation();
                        return inOp.equals(operation);
                    })
                    .collect(Collectors.toList());

            if (FwUtils.isEmpty(inWorkInfoList)) {
                FwUtils.getCustomException("tool.error9", new Object[]{ sfc });
            }

            BigDecimal inWorkQty = inWorkInfoList.get(0).getQtyInWork();
            if (inWorkQty.compareTo(BigDecimal.ZERO) == 0) {
                FwUtils.getCustomException("tool.error9", new Object[]{ sfc });
            }
            response.setQtyInWork(inWorkQty.intValue());
            zSnToolState.setStatus("1");
        }

        List<ZSnToolState> toolStateList = toolRepository.getToolList(zSnToolState);

        response.setToolStateList(toolStateList);
        response.setSnQty(toolStateList.size());

        String sfcStatus = new StatusBOHandle(sfcInfo.getStatusBo()).getStatus();
        response.setSfcStatus(sfcStatus);

        return response;
    }

    @Transactional
    @Override
    public ToolResponse scan( ToolRequest toolRequest ) {
        String site = toolRequest.getSite();
        String user = toolRequest.getUser();
        String sfc = toolRequest.getSfc();
        String tool = toolRequest.getTool();
        String sn = toolRequest.getSn();
        String operation = toolRequest.getOperation();
        String resource = toolRequest.getResource();

        ZSnToolState zSnToolState = new ZSnToolState();
        zSnToolState.setSite(site);
        // 檢查工具
        zSnToolState.setToolNumber(tool);
        if (!FwUtils.isEmpty(toolRepository.getToolList(zSnToolState))) {
            FwUtils.getCustomException("tool.error3", new Object[]{ tool });
        }

        if (!FwUtils.isNullOrEmpty(sn)) {
            ZSnToolState checkSn = new ZSnToolState();
            checkSn.setSite(site);
            checkSn.setSn(sn);

            if (!FwUtils.isEmpty(toolRepository.getToolList(checkSn))) {
                FwUtils.getCustomException("tool.error4", new Object[]{ sn });
            }

            ToolResponse sfcResponse = this.scanSfc(toolRequest);
            String sfcStatus = sfcResponse.getSfcStatus();

            if (!statusList.contains(sfcStatus)) {
                FwUtils.getCustomException("tool.error2", new Object[]{ sfc });
            }

            if (sfcResponse.getQtyInQueue() <= sfcResponse.getSnQty()) {
                FwUtils.getCustomException("tool.error5");
            }

            zSnToolState.setSid(FwUtils.getUid());
            zSnToolState.setOperation(operation);
            zSnToolState.setResource(resource);
            zSnToolState.setSfc(sfc);
            zSnToolState.setSn(sn);
            zSnToolState.setCreatedDateTime(DateUtil.getGmtTime());
            zSnToolState.setCreatedUser(user);
            toolRepository.insertSnToolState(zSnToolState);

            return this.scanSfc(toolRequest);
        }

        return null;
    }

    @Transactional
    @Override
    public ToolResponse delTool( ToolRequest toolRequest ) {
        String site = toolRequest.getSite();
        String sfc = toolRequest.getSfc();
        List<ZSnToolState> list = toolRequest.getToolStateList();

        list.forEach(obj -> {
            obj.setSite(site);
            obj.setSfc(sfc);
            ZSnToolState snToolState = toolRepository.getToolList(obj).get(0);
            toolRepository.deleteSnToolState(snToolState.getSid());
        });

        return this.scanSfc(toolRequest);
    }

    @Override
    public ToolResponse scanResource( ToolRequest toolRequest ) {
        String site = toolRequest.getSite();
        String resource = toolRequest.getResource();
        String operation = toolRequest.getOperation();

        ToolResponse response = new ToolResponse();

        List<Operation> opInfo = operationRepo.findCurrentOperation(site, operation);
        if (FwUtils.isEmpty(opInfo)) {
            FwUtils.getCustomException("tool.error6", new Object[]{ operation });
        }

        List<Resrce> resrces = resourceRepo.findById(site, resource);
        if (FwUtils.isEmpty(resrces)) {
            FwUtils.getCustomException("tool.error6", new Object[]{ resource });
        }
        response.setResourceDesc(resrces.get(0).getDescription());

        if (FwUtils.isEmpty(resourceRepo.findResrceByOperation(site, operation, resource))) {
            FwUtils.getCustomException("tool.error1", new Object[]{ resource, operation });
        }

        ZSnToolState zSnToolState = new ZSnToolState();
        zSnToolState.setSite(site);
        zSnToolState.setResource(resource);
        zSnToolState.setOperation(operation);
        zSnToolState.setStatus("1");
        List<ZSnToolState> toolList = toolRepository.getToolList(zSnToolState);

        if (FwUtils.isEmpty(toolList)) {
            FwUtils.getCustomException("tool.error7");
        }
        response.setToolStateList(toolList);

        return response;
    }

    @Transactional
    @Override
    public String start( ToolRequest toolRequest ) {
        String site = toolRequest.getSite();
        String user = toolRequest.getUser();
        String operation = toolRequest.getOperation();
        String resource = toolRequest.getResource();
        String sfc = toolRequest.getSfc();
        List<ZSnToolState> list = toolRequest.getToolStateList();
        int startQty = list.size();

        Sfc sfcInfo = sfcRepo.findById(site, sfc);
        String item = new ItemBOHandle(sfcInfo.getItemBo()).getItem();
        String sfcStatus = new StatusBOHandle(sfcInfo.getStatusBo()).getStatus();
        if (!statusList.contains(sfcStatus)) {
            FwUtils.getCustomException("tool.error2", new Object[]{ sfc });
        }

        // SFC進站
        List<Operation> opInfo = operationRepo.findCurrentOperation(site, operation);
        String operationBo = opInfo.get(0).getHandle();
        String resourceBo = new ResourceBOHandle(site, resource).getValue();

        SfcStartServiceInterface sfcService = FwUtils.getService("com.sap.me.production", "SfcStartService", user, site);
        List<StartSfcRequest> sfcRequestList = new ArrayList<>();
        StartSfcRequest startSfcRequest = new StartSfcRequest();
        startSfcRequest.setSfcRef(new SFCBOHandle(site, sfc).getValue());
        startSfcRequest.setOperationRef(operationBo);
        startSfcRequest.setResourceRef(resourceBo);
        startSfcRequest.setQty(new BigDecimal(startQty));
        startSfcRequest.setUserRef(new UserBOHandle(site, user).getValue());
        sfcRequestList.add(startSfcRequest);
        try {
            sfcService.start(sfcRequestList);
        } catch (BusinessException e) {
            FwUtils.getMeException(e);
        }

        // 更新Tool State 進站
        Date now = DateUtil.getGmtTime();
        list.forEach(obj -> {
            obj.setSite(site);
            obj.setSfc(sfc);
            obj.setStatus("1");
            obj.setStartDateTime(now);
            obj.setStartUser(user);
            toolRepository.updateSnToolState(obj);
        });

        String msg = "";
        url = this.getTmsUrl(site);
        if (!FwUtils.isNullOrEmpty(url)) {
            // TMS
            TmsExecuteRequest tmsExecuteRequest = new TmsExecuteRequest();
            tmsExecuteRequest.setUrl(url);
            tmsExecuteRequest.setSite(site);
            tmsExecuteRequest.setUser(user);
            tmsExecuteRequest.setSfc(sfc);
            tmsExecuteRequest.setOperation(operation);
            tmsExecuteRequest.setResource(resource);
            tmsExecuteRequest.setQty(new BigDecimal(startQty));
            tmsExecuteRequest.setItem(item);
            tmsExecuteRequest.setWorkMode("3");
            tmsExecuteRequest.setToolList(list.stream()
                                                  .map(ZSnToolState::getToolNumber)
                                                  .collect(Collectors.toList()));

            // 查核
            TmsExecuteResponse tmsExecuteResponse = FixtureOnlineStatusChange.execute(tmsExecuteRequest);
            msg = this.throwTmsError(tmsExecuteResponse);

            // 上機
            tmsExecuteRequest.setWorkMode("1");
            tmsExecuteResponse = FixtureOnlineStatusChange.execute(tmsExecuteRequest);
            String executeMsg = this.throwTmsError(tmsExecuteResponse);

            if (!FwUtils.isNullOrEmpty(msg)) {
                msg = "\n" + executeMsg;
            } else {
                msg = executeMsg;
            }
        }

        return msg;
    }

    @Transactional
    @Override
    public String complete( ToolRequest toolRequest ) {
        String site = toolRequest.getSite();
        String user = toolRequest.getUser();
        String operation = toolRequest.getOperation();
        String resource = toolRequest.getResource();
        String sfc = toolRequest.getSfc();
        List<ZSnToolState> list = toolRequest.getToolStateList();
        int completeQty = list.size();
        Date now = DateUtil.getGmtTime();

        Sfc sfcInfo = sfcRepo.findById(site, sfc);
        String item = new ItemBOHandle(sfcInfo.getItemBo()).getItem();

        ViewResrceType viewResrceType = new ViewResrceType();
        viewResrceType.setSite(site);
        viewResrceType.setResrce(resource);

        // SFC出站
        List<Operation> opInfo = operationRepo.findCurrentOperation(site, operation);
        String operationBo = opInfo.get(0).getHandle();
        String resourceBo = new ResourceBOHandle(site, resource).getValue();

        SfcCompleteServiceInterface sfcCompleteService =
                FwUtils.getService("com.sap.me.production", "SfcCompleteService", user, site);
        CompleteSfcBatchRequest sfcBatchRequest = new CompleteSfcBatchRequest();
        CompleteSfcBasicRequest sfcBasicRequest = new CompleteSfcBasicRequest();
        sfcBasicRequest.setSfcRef(new SFCBOHandle(site, sfc).getValue());
        sfcBasicRequest.setOperationRef(operationBo);
        sfcBasicRequest.setResourceRef(resourceBo);
        sfcBasicRequest.setQuantity(new BigDecimal(completeQty));

        sfcBatchRequest.setCompleteSfcList(Collections.singletonList(sfcBasicRequest));
        try {
            sfcCompleteService.completeSfcBatch(sfcBatchRequest);
        } catch (BusinessException e) {
            FwUtils.getMeException(e);
        }

        String msg = "";
        url = this.getTmsUrl(site);
        if (!FwUtils.isNullOrEmpty(url)) {
            // TMS
            TmsExecuteRequest tmsExecuteRequest = new TmsExecuteRequest();
            tmsExecuteRequest.setUrl(url);
            tmsExecuteRequest.setSite(site);
            tmsExecuteRequest.setUser(user);
            tmsExecuteRequest.setSfc(sfc);
            tmsExecuteRequest.setOperation(operation);
            tmsExecuteRequest.setResource(resource);
            tmsExecuteRequest.setQty(new BigDecimal(completeQty));
            tmsExecuteRequest.setItem(item);

            // 取的作業時間
            toolRequest.setStatus("1");
            toolRequest.setToolList(list.stream()
                                            .map(ZSnToolState::getToolNumber)
                                            .collect(Collectors.toList()));
            tmsExecuteRequest.setLifeSyncToolList(this.getLifeSyncTool(now, toolRequest));

            TmsExecuteResponse tmsExecuteResponse = LifeSync.execute(tmsExecuteRequest);
            msg = this.throwTmsError(tmsExecuteResponse);
        }

        // 更新Tool State 出站
        list.forEach(obj -> {
            obj.setSite(site);
            obj.setSfc(sfc);
            ZSnToolState snToolState = toolRepository.getToolList(obj).get(0);
            ZSnToolLog zSnToolLog = ToolConverter.INSTANCE.toLog(snToolState);
            zSnToolLog.setStatus("2");
            zSnToolLog.setCompleteDateTime(now);
            zSnToolLog.setCompleteUser(user);

            toolRepository.insertSnToolLog(zSnToolLog);
            toolRepository.deleteSnToolState(snToolState.getSid());
        });

        return msg;
    }

    @Transactional
    @Override
    public String off( ToolRequest toolRequest ) {
        String site = toolRequest.getSite();
        String resource = toolRequest.getResource();
        String operation = toolRequest.getOperation();
        String activity = toolRequest.getActivity();
        String user = toolRequest.getUser();
        List<ZSnToolState> list = toolRequest.getToolStateList();
        Date now = DateUtil.getGmtTime();

        // 檢查資源
        this.scanResource(toolRequest);

        // Tool live
        String live = "N";
        ActivityOption activityOption = activityRepo.findOption(activity, "TOOL_LIFE");
        if (!FwUtils.objIsEmpty(activityOption) && !FwUtils.isNullOrEmpty(activityOption.getSetting())) {
            live = activityOption.getSetting();
        }

        String msg = "";
        url = this.getTmsUrl(site);
        if (!FwUtils.isNullOrEmpty(url)) {
            // TMS
            TmsExecuteRequest tmsExecuteRequest = new TmsExecuteRequest();
            tmsExecuteRequest.setUrl(url);
            tmsExecuteRequest.setSite(site);
            tmsExecuteRequest.setUser(user);
            tmsExecuteRequest.setOperation(operation);
            tmsExecuteRequest.setResource(resource);
            tmsExecuteRequest.setWorkMode("2");

            List<TmsExecuteDetail> details = new ArrayList<>();

            // 依SFC分組
            Map<String, List<ZSnToolState>> map = list
                    .stream()
                    .collect(Collectors.groupingBy(ZSnToolState::getSfc));
            map.forEach(( k, v ) -> {
                Sfc sfcInfo = sfcRepo.findById(site, k);
                TmsExecuteDetail tmsExecuteDetail = new TmsExecuteDetail();
                tmsExecuteDetail.setSfc(k);
                tmsExecuteDetail.setItem(new ItemBOHandle(sfcInfo.getItemBo()).getItem());
                tmsExecuteDetail.setQty(new BigDecimal(v.size()));
                tmsExecuteDetail.setToolList(v.stream()
                                                     .map(ZSnToolState::getToolNumber)
                                                     .collect(Collectors.toList()));
                details.add(tmsExecuteDetail);
            });
            tmsExecuteRequest.setTmsExecuteDetailList(details);

            TmsExecuteResponse tmsExecuteResponse = null;
            if ("Y".equals(live)) {
                ViewResrceType viewResrceType = new ViewResrceType();
                viewResrceType.setSite(site);
                viewResrceType.setResrce(resource);
                List<ViewResrceType> resrceTypes = resourceRepo.findResrceByEntity(viewResrceType);
                String resourceType = "";
                if (!FwUtils.isEmpty(resrceTypes)) {
                    resourceType = resrceTypes.get(0).getResourceType();
                }
                tmsExecuteRequest.setResourceType(resourceType);

                // 取的作業時間
                toolRequest.setStatus("1");
                toolRequest.setToolList(list.stream()
                                                .map(ZSnToolState::getToolNumber)
                                                .collect(Collectors.toList()));
                tmsExecuteRequest.setLifeSyncToolList(this.getLifeSyncTool(now, toolRequest));

                // 扣除壽命
                tmsExecuteResponse = LifeSync.execute(tmsExecuteRequest);
                msg = this.throwTmsError(tmsExecuteResponse);
            }

            // 下機
            tmsExecuteResponse = FixtureOnlineStatusChange.execute(tmsExecuteRequest);
            String executeMsg = this.throwTmsError(tmsExecuteResponse);

            if (!FwUtils.isNullOrEmpty(msg)) {
                msg = "\n" + executeMsg;
            } else {
                msg = executeMsg;
            }
        }

        // 下機
        list.forEach(obj -> {
            obj.setSite(site);
            obj.setResource(resource);
            ZSnToolState snToolState = toolRepository.getToolList(obj).get(0);
            ZSnToolLog zSnToolLog = ToolConverter.INSTANCE.toLog(snToolState);
            zSnToolLog.setStatus("3");
            zSnToolLog.setCompleteDateTime(now);
            zSnToolLog.setCompleteUser(user);

            toolRepository.insertSnToolLog(zSnToolLog);
            toolRepository.deleteSnToolState(snToolState.getSid());
        });

        return msg;
    }

    private String getTmsUrl( String site ) {
        ZSystemConfig systemConfig = systemConfigRepo.systemConfig(site, "TMS_RESTFUL_URL");
        if (FwUtils.objIsEmpty(systemConfig)) {
            return null;
        }

        return systemConfig.getSystemValue();
    }

    private String throwTmsError( TmsExecuteResponse tmsExecuteResponse ) {
        if (!FwUtils.objIsEmpty(tmsExecuteResponse)) {
            String resultCode = tmsExecuteResponse.getResultCode();
            String responseMessage = tmsExecuteResponse.getMessage();

            if (!"1".equals(resultCode)) {
                FwUtils.getCustomException("message", new Object[]{ responseMessage });
            } else {
                ResultData resultData = tmsExecuteResponse.getResultData();
                if (!FwUtils.objIsEmpty(resultData)) {
                    String result = resultData.getResult();
                    String message = resultData.getMessage();

                    if (!"1".equals(result)) {
                        if (!"2".equals(result)) {
                            FwUtils.getCustomException("message", new Object[]{ message });
                        } else {
                            return message;
                        }
                    }
                }
            }
        } else {
            FwUtils.getCustomException("g.http.fail", new Object[]{ url });
        }

        return "";
    }

    private List<LifeSyncTool> getLifeSyncTool( Date now, ToolRequest toolRequest ) {
        List<ZSnToolState> toolInfoList = toolRepository.getToolInfo(toolRequest);
        return toolInfoList.stream()
                .map(obj -> {
                    String sn = obj.getSn();
                    String tool = obj.getToolNumber();
                    Date startTime = obj.getStartDateTime();
                    long workTime = (now.getTime() - startTime.getTime()) / (60 * 1000);

                    LifeSyncTool lifeSyncTool = new LifeSyncTool();
                    lifeSyncTool.setTool(tool);
                    lifeSyncTool.setOffLine("Y");
                    lifeSyncTool.setWorkTime(String.valueOf(workTime));
                    lifeSyncTool.setSn(sn);
                    lifeSyncTool.setQty("1");

                    return lifeSyncTool;
                }).collect(Collectors.toList());
    }
}
