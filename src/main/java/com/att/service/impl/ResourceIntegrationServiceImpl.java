package com.att.service.impl;

import com.att.domain.kanban.*;
import com.att.repository.AttributeRepository;
import com.att.repository.ResourceAbilityRepository;
import com.att.repository.entity.TdsResourceAbility;
import com.att.repository.entity.ZKanbanAttribute;
import com.att.service.ResourceIntegrationService;
import com.fw.mes.me.controller.activity.ActivityRepo;
import com.fw.mes.me.controller.customFields.CustomFieldsRepo;
import com.fw.mes.me.controller.productionLog.ProductionLogRepo;
import com.fw.mes.me.controller.resource.ResourceRepo;
import com.fw.mes.me.controller.site.SiteRepo;
import com.fw.mes.me.controller.workcenter.WorkCenterRepo;
import com.fw.mes.me.domain.production.ProductionInfo;
import com.fw.mes.me.entity.*;
import com.fw.mes.util.DateUtil;
import com.fw.mes.util.FwUtils;
import com.sap.me.plant.ResourceBOHandle;
import com.sap.me.plant.WorkCenterBOHandle;
import com.sap.me.productdefinition.RouterBOHandle;
import com.sap.me.status.StatusBOHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ResourceIntegrationServiceImpl implements ResourceIntegrationService {

    private final Logger logger = LoggerFactory.getLogger(ResourceIntegrationServiceImpl.class);

    @Autowired
    private ActivityRepo activityRepo;

    @Autowired
    private WorkCenterRepo workCenterRepo;

    @Autowired
    private CustomFieldsRepo customFieldsRepo;

    @Autowired
    private ResourceRepo resourceRepo;

    @Autowired
    private ProductionLogRepo productionLogRepo;

    @Autowired
    private SiteRepo siteRepo;

    @Autowired
    private ResourceAbilityRepository resourceAbilityRepository;

    @Autowired
    private AttributeRepository attributeRepository;

    @Autowired
    private HttpServletRequest httpServletRequest;

    private final BigDecimal HUNDRED = new BigDecimal("100");
    private final BigDecimal HOUR = new BigDecimal(String.valueOf(60 * 60 * 1000));

    private final List<String> ActivityList = new ArrayList<>(Arrays.asList("PR510", "EXTERNAL", "NC_DATA_ENTRY"));

    @Override
    public KanbanResponse getKanBanInfo( KanbanRequest kanBanRequest ) {
        String site = kanBanRequest.getSite();
        List<ActivityOption> optionList = activityRepo.findOption(kanBanRequest.getActivity());

        KanbanResponse response = new KanbanResponse();

        optionList.forEach(obj -> {
            String option = obj.getExecUnitOption();
            String value = obj.getSetting();

            switch (option) {
                case "WORK_CENTER":
                    if (FwUtils.isNullOrEmpty(value)) {
                        FwUtils.getCustomException("kanban.error1");
                    }

                    if (FwUtils.isEmpty(workCenterRepo.findWorkCenter(site, value))) {
                        FwUtils.getCustomException("kanban.error2");
                    }

                    response.setWorkCenter(value);
                    break;
                case "REFRESH_FREQUENCY":
                    response.setRefreshFrequency(10);

                    if (!FwUtils.isNullOrEmpty(value)) {
                        if (!FwUtils.isNumeric(value)) {
                            FwUtils.getCustomException("kanban.error3");
                        }

                        int refresh = Integer.parseInt(value);
                        if (refresh <= 0) {
                            FwUtils.getCustomException("kanban.error3");
                        }

                        response.setRefreshFrequency(refresh);
                    }
                    break;
                case "LIST_CHANGE_TIME":
                    response.setListChangeTime(2);

                    if (!FwUtils.isNullOrEmpty(value)) {
                        if (!FwUtils.isNumeric(value)) {
                            FwUtils.getCustomException("kanban.error4");
                        }

                        int change = Integer.parseInt(value);
                        if (change < 0) {
                            FwUtils.getCustomException("kanban.error4");
                        }

                        response.setListChangeTime(change);
                    }
                    break;
                case "KANBAN_TYPE":
                    if ("1".equals(value)) {
                        response.setKanbanType(value);
                    } else {
                        response.setKanbanType("0");
                    }
                    break;
                default:
                    break;
            }
        });

        return response;
    }

    @Override
    public KanbanResponse getWorkCenterInfo( KanbanRequest kanbanRequest ) {
        String site = kanbanRequest.getSite();
        String locale = kanbanRequest.getLan().toLowerCase();
        String workCenter = kanbanRequest.getWorkCenter();
        String workCenterBo = new WorkCenterBOHandle(site, workCenter).getValue();

        KanbanResponse response = new KanbanResponse();
        response.setWorkCenter(workCenter);

        List<ViewWorkCenterDesc> workCenterDescList = workCenterRepo.workCenterInfo(site, workCenter, locale);
        if (!FwUtils.isEmpty(workCenterDescList)) {
            response.setWorkCenterDesc(workCenterDescList.get(0).getDescription());
        }

        List<CustomFields> fieldList = customFieldsRepo.findCustomFields(workCenterBo);
        fieldList.forEach(obj -> {
            String attribute = obj.getAttribute();
            String value = obj.getValue();

            BigDecimal target = new BigDecimal("0");
            if (!FwUtils.isNullOrEmpty(value) && FwUtils.isNumber(value)) {
                target = new BigDecimal(value).setScale(2, RoundingMode.DOWN).stripTrailingZeros();
            }

            switch (attribute) {
                case "MONTH_EFFICIENCY":
                    response.setTargetMonthEfficiency(target);
                    break;
                case "MONTH_YIELD":
                    response.setTargetMonthYield(target);
                    break;
                case "MONTH_UTILIZATION_RATE":
                    response.setTargetMonthUtilizationRate(target);
                    break;
                case "MONTH_OEE":
                    response.setTargetMonthOee(target);
                    break;
                case "DAY_EFFICIENCY":
                    response.setTargetDayEfficiency(target);
                    break;
                case "DAY_YIELD":
                    response.setTargetDayYield(target);
                    break;
                case "DAY_UTILIZATION_RATE":
                    response.setTargetDayUtilizationRate(target);
                    break;
                case "DAY_OEE":
                    response.setTargetDayOee(target);
                    break;
                default:
                    break;
            }
        });

        return response;
    }

    @Override
    public KanbanResponse getResourceStatusInfo( KanbanRequest kanbanRequest ) {
        String site = kanbanRequest.getSite();
        String workCenter = kanbanRequest.getWorkCenter();
        String workCenterBo = new WorkCenterBOHandle(site, workCenter).getValue();
        List<ResourceStatusInfo> resourceStatusList = new ArrayList<>();

        KanbanResponse response = new KanbanResponse();

        this.findChildResource(workCenterBo, resourceStatusList);

        if (FwUtils.isEmpty(resourceStatusList)) {
            return response;
        }

        Map<String, List<ResourceStatusInfo>> map = resourceStatusList.stream()
                .filter(filters -> !FwUtils.isNullOrEmpty(filters.getStatus()))
                .collect(Collectors.groupingBy(ResourceStatusInfo::getStatus));

        List<ResourceStatusInfo> statusInfoList = new ArrayList<>();
        // k: status
        map.forEach(( k, v ) -> {
            ResourceStatusInfo resourceStatusInfo = new ResourceStatusInfo();
            resourceStatusInfo.setStatus(k);
            resourceStatusInfo.setResourceQty(v.size());
            statusInfoList.add(resourceStatusInfo);
        });

        response.setStatusInfoList(statusInfoList);
        response.setResourceTotalQty(resourceStatusList.size());

        return response;
    }

    @Override
    public KanbanResponse getMonthAvgEfficiency( KanbanRequest kanbanRequest ) {
        String site = kanbanRequest.getSite();
        String workCenter = kanbanRequest.getWorkCenter();
        String workCenterBo = new WorkCenterBOHandle(site, workCenter).getValue();
        // 計畫屬性
        List<AttributeRequest> attributeList = kanbanRequest.getAttributeList();
        // 設備可利用時間
        BigDecimal availableTime = this.getAvailableTime(site, workCenter);
        // 所有資源
        List<ResourceStatusInfo> resrceStatusList = new ArrayList<>();
        this.findChildResource(workCenterBo, resrceStatusList);
        List<String> resourceList = resrceStatusList.stream()
                .map(ResourceStatusInfo::getResource)
                .collect(Collectors.toList());

        String timeZone = siteRepo.getTimeZone(site);

        Date gmt = DateUtil.getGmtTime();
        Date now = DateUtil.toLocalDated(gmt, timeZone);
        Date localFirst = this.getFirstDate(now);
        Date first = DateUtil.toGmtDate(this.getFirstDate(now), timeZone);
        Date last = DateUtil.toGmtDate(this.getLastDate(now), timeZone);

        // 當前日天數
        BigDecimal days = new BigDecimal(String.valueOf(this.dayInterval(localFirst, now)));

        List<ProductionLog> productionLogList = this.getProduction(site, resourceList, first, last);
        Map<String, List<ProductionLog>> productionMap = productionLogList.stream()
                .collect(Collectors.groupingBy(ProductionLog::getResrce));

        List<ResourceEfficiency> efficiencyAll = new ArrayList<>();
        List<BigDecimal> yield = new ArrayList<>();
        productionMap.forEach(( k, v ) -> {
            // 依照年月日分組
            Map<String, List<ProductionLog>> dayProductionMap = v.stream()
                    .collect(Collectors.groupingBy(g -> {
                        Date local = DateUtil.toLocalDated(g.getDateTime(), timeZone);
                        return DateUtil.dateToString(local, "yyyy-MM-dd");
                    }));

            dayProductionMap.forEach(( k2, v2 ) -> {
                // 每日平均
                efficiencyAll.addAll(this.getEfficiency(v2));
                BigDecimal avgYield = this.getAvgYield(v2);

                if (this.isOverNegate(avgYield)) {
                    yield.add(avgYield);
                }
            });
        });

        // 過濾效率為0的資料
        List<BigDecimal> efficiency = efficiencyAll.stream()
                .map(ResourceEfficiency::getEfficiency)
                .filter(filtersEfficiency -> filtersEfficiency.compareTo(BigDecimal.ZERO) > 0)
                .collect(Collectors.toList());

        // 平均月生產效率 = 每日平均生產效率總和 / 資料筆數
        BigDecimal monthEfficiency = efficiency.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal avgMonthEfficiency = BigDecimal.ZERO;
        if (!isZero(monthEfficiency) && efficiency.size() > 0) {
            BigDecimal efficiencySize = new BigDecimal(efficiency.size());
            avgMonthEfficiency = monthEfficiency.divide(efficiencySize, 4, RoundingMode.HALF_UP)
                    .multiply(HUNDRED);
        }

        // 平均月生產良率 = 每日平均生產良率總和 / 資料筆數
        BigDecimal monthYield = yield.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal avgMonthYield = BigDecimal.ZERO;
        if (!isZero(monthYield) && yield.size() > 0) {
            BigDecimal yieldSize = new BigDecimal(yield.size());
            avgMonthYield = monthYield.divide(yieldSize, 2, RoundingMode.HALF_UP);
        }

        // 平均月資源稼動率 = 每日資源稼動率加總 / 資料筆數
        BigDecimal totalWorkTime = availableTime.multiply(days);

        List<ViewResourceTimeLogResrce> resourceTimeLogList = this.getResrceTime(site, resourceList, first, last, gmt);
        Map<String, List<ViewResourceTimeLogResrce>> timeLogMap = resourceTimeLogList.stream()
                .collect(Collectors.groupingBy(ViewResourceTimeLogResrce::getResrce));

        List<BigDecimal> avgRateList = new ArrayList<>();
        timeLogMap.forEach(( k, v ) -> {
            BigDecimal one = this.getProdTime(v);
            // 計畫性停機時間
            BigDecimal planningTime = this.getPlanningTime(v, attributeList);

            if (!isZero(totalWorkTime)) {
                // 計畫開機時間
                BigDecimal turnOnTime = totalWorkTime.subtract(planningTime);

                if (!isZero(one) && !isZero(turnOnTime)) {
                    BigDecimal avgRate = one.divide(turnOnTime, 4, RoundingMode.HALF_UP)
                            .multiply(HUNDRED);

                    avgRateList.add(avgRate);
                }
            }
        });

        BigDecimal rate = avgRateList.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal avgMonthRate = BigDecimal.ZERO;
        if (!isZero(rate) && avgRateList.size() > 0) {
            avgMonthRate = rate.divide(new BigDecimal(avgRateList.size()), 2, RoundingMode.HALF_UP);
        }

        KanbanResponse response = new KanbanResponse();
        response.setAvgMonthEfficiency(avgMonthEfficiency);
        response.setAvgMonthYield(avgMonthYield);
        response.setAvgMonthUtilizationRate(avgMonthRate);
        response.setAvgMonthOee(this.getAvgOee(response));

        return response;
    }

    @Override
    public KanbanResponse getDayAvgEfficiency( KanbanRequest kanbanRequest ) {
        String site = kanbanRequest.getSite();
        String workCenter = kanbanRequest.getWorkCenter();
        String workCenterBo = new WorkCenterBOHandle(site, workCenter).getValue();
        // 計畫屬性
        List<AttributeRequest> attributeList = kanbanRequest.getAttributeList();
        // 設備可利用時間
        BigDecimal availableTime = this.getAvailableTime(site, workCenter);
        // 所有資源
        List<ResourceStatusInfo> resrceStatusList = new ArrayList<>();
        this.findChildResource(workCenterBo, resrceStatusList);
        List<String> resourceList = resrceStatusList.stream()
                .map(ResourceStatusInfo::getResource)
                .collect(Collectors.toList());

        String timeZone = siteRepo.getTimeZone(site);

        Date gmt = DateUtil.getGmtTime();
        Date now = DateUtil.toLocalDated(gmt, timeZone);
        Date now00 = DateUtil.toGmtDate(this.getDate00(now), timeZone);
        Date now23 = DateUtil.toGmtDate(this.getTomorrow00(now), timeZone);

        List<ProductionLog> productionLogList = this.getProduction(site, resourceList, now00, now23);
        List<ViewResourceTimeLogResrce> resourceTimeLogList = this.getResrceTime(site, resourceList, now00, now23, gmt);

        // 依照資源分組
        Map<String, List<ProductionLog>> productionMap = productionLogList.stream()
                .collect(Collectors.groupingBy(ProductionLog::getResrce));

        List<ResourceEfficiency> efficiencyAll = new ArrayList<>();
        List<BigDecimal> yield = new ArrayList<>();
        productionMap.forEach(( k, v ) -> {
            // 依照年月日分組
            Map<String, List<ProductionLog>> dayProductionMap = v.stream()
                    .collect(Collectors.groupingBy(g -> {
                        Date local = DateUtil.toLocalDated(g.getDateTime(), timeZone);
                        return DateUtil.dateToString(local, "yyyy-MM-dd");
                    }));

            dayProductionMap.forEach(( k2, v2 ) -> {
                // 每日平均
                efficiencyAll.addAll(this.getEfficiency(v2));
                BigDecimal avgYield = this.getAvgYield(v2);

                if (this.isOverNegate(avgYield)) {
                    yield.add(avgYield);
                }
            });
        });

        // 過濾效率為0的資料
        List<BigDecimal> efficiency = efficiencyAll.stream()
                .map(ResourceEfficiency::getEfficiency)
                .filter(filterEfficiency -> filterEfficiency.compareTo(BigDecimal.ZERO) > 0)
                .collect(Collectors.toList());

        // 平均日生產效率 = 平均生產效率總和 / 資料筆數
        BigDecimal dayEfficiency = efficiency.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal avgDayEfficiency = BigDecimal.ZERO;
        if (!isZero(dayEfficiency) && efficiency.size() > 0) {
            BigDecimal efficiencySize = new BigDecimal(efficiency.size());
            avgDayEfficiency = dayEfficiency.divide(efficiencySize, 4, RoundingMode.HALF_UP)
                    .multiply(HUNDRED);
        }

        // 平均日生產良率 = 平均生產良率總和 / 資料筆數
        BigDecimal dayYield = yield.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal avgDayYield = BigDecimal.ZERO;
        if (!isZero(dayYield) && yield.size() > 0) {
            BigDecimal yieldSize = new BigDecimal(yield.size());
            avgDayYield = dayYield.divide(yieldSize, 2, RoundingMode.HALF_UP);
        }

        // 平均日資源稼動率 = 資源稼動率加總 / 資料筆數
        Map<String, List<ViewResourceTimeLogResrce>> timeLogMap = resourceTimeLogList.stream()
                .collect(Collectors.groupingBy(ViewResourceTimeLogResrce::getResrce));

        List<BigDecimal> avgRateList = new ArrayList<>();
        timeLogMap.forEach(( k, v ) -> {
            BigDecimal one = this.getProdTime(v);
            // 計畫性停機時間
            BigDecimal planningTime = this.getPlanningTime(v, attributeList);

            if (!isZero(availableTime)) {
                // 計畫開機時間
                BigDecimal turnOnTime = availableTime.subtract(planningTime);

                if (!isZero(one) && !isZero(turnOnTime)) {
                    BigDecimal avgRate = one.divide(turnOnTime, 4, RoundingMode.HALF_UP)
                            .multiply(HUNDRED);

                    avgRateList.add(avgRate);
                }
            }
        });

        BigDecimal rate = avgRateList.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal avgRate = BigDecimal.ZERO;
        if (!isZero(rate) && avgRateList.size() > 0) {
            avgRate = rate.divide(new BigDecimal(avgRateList.size()), 2, RoundingMode.HALF_UP);
        }

        KanbanResponse response = new KanbanResponse();
        response.setAvgDayEfficiency(avgDayEfficiency);
        response.setAvgDayYield(avgDayYield);
        response.setAvgDayUtilizationRate(avgRate);
        response.setAvgDayOee(this.getAvgOee(response));

        return response;
    }

    @Override
    public List<ResourceStatusInfo> getResourceDayEfficiency( KanbanRequest kanbanRequest ) {
        String site = kanbanRequest.getSite();
        String workCenter = kanbanRequest.getWorkCenter();
        // 計畫屬性
        List<AttributeRequest> attributeList = kanbanRequest.getAttributeList();
        // 設備可利用時間
        BigDecimal availableTime = this.getAvailableTime(site, workCenter);
        // 所有資源
        List<ResourceStatusInfo> resrceStatusList = this.getResrceStatusList(kanbanRequest);
        // 非停機資源
        List<String> resourceList = this.getResrceList(resrceStatusList);
        String timeZone = siteRepo.getTimeZone(site);

        Date gmt = DateUtil.getGmtTime();
        Date now = DateUtil.toLocalDated(gmt, timeZone);
        Date now00 = DateUtil.toGmtDate(this.getDate00(now), timeZone);
        Date now23 = DateUtil.toGmtDate(this.getTomorrow00(now), timeZone);

        List<ProductionLog> productionLogList = this.getProduction(site, resourceList, now00, now23);
        List<ViewResourceTimeLogResrce> resourceTimeLogList = this.getResrceTime(site, resourceList, now00, now23, gmt);

        // loop by resource
        List<ResourceStatusInfo> resrceList = new ArrayList<>();
        for (ResourceStatusInfo resourceStatusInfo : resrceStatusList) {
            String resource = resourceStatusInfo.getResource();
            String status = resourceStatusInfo.getStatus();
            if (!"302".equals(status)) {
                List<ProductionLog> filterProduction = productionLogList.stream()
                        .filter(filters -> resource.equals(filters.getResrce()))
                        .collect(Collectors.toList());

                List<ViewResourceTimeLogResrce> filterResourceTime = resourceTimeLogList.stream()
                        .filter(filters -> resource.equals(filters.getResrce()))
                        .collect(Collectors.toList());

                // 生產效率
                resourceStatusInfo.setEfficiency(this.getAvgEfficiency(filterProduction));
                // 生產良率
                resourceStatusInfo.setYield(this.getAvgYield(filterProduction));
                // 稼動率
                resourceStatusInfo.setUtilizationRate(
                        this.getAvgUtilizationRate(filterResourceTime, attributeList, availableTime));
                // OEE
                resourceStatusInfo.setOee(this.getAvgResourceOee(resourceStatusInfo));

                // 完成數總和
                BigDecimal complete = filterProduction.stream()
                        .map(ProductionLog::getQtyCompleted)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                // 生產時間總和
                BigDecimal productionTime = filterProduction.stream()
                        .map(ProductionLog::getElapsedTime)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

                // 以小時計算
                productionTime = productionTime.divide(HOUR, 4, RoundingMode.HALF_UP);
                // UPH
                resourceStatusInfo.setUph(this.getUph(complete, productionTime));
                // HPU
                resourceStatusInfo.setHpu(this.getHpu(complete, productionTime));

                resrceList.add(resourceStatusInfo);
            }
        }

        return resrceList.stream()
                .sorted(Comparator.comparing(ResourceStatusInfo::getResource))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void saveAttribute( String site, String user, String activity, List<AttributeRequest> attributeRequestList ) {
        Date now = DateUtil.getGmtTime();

        attributeRepository.delete(site, activity);

        attributeRequestList.forEach(obj -> {
            ZKanbanAttribute attribute = new ZKanbanAttribute();
            attribute.setSite(site);
            if (!FwUtils.isNullOrEmpty(obj.getWorkCenter())) {
                attribute.setAttribute1(obj.getWorkCenter());
                attribute.setType("0");
            }

            if (!FwUtils.isNullOrEmpty(obj.getStatus())) {
                attribute.setAttribute1(obj.getStatus());
                attribute.setAttribute2(obj.getStatusType());
                attribute.setType("1");
            }

            if (!FwUtils.isNullOrEmpty(obj.getItem())) {
                attribute.setAttribute1(obj.getItem());
                attribute.setAttribute2(obj.getRouterBo());
                attribute.setType("2");
            }

            attribute.setActivity(activity);
            attribute.setCreatedUser(user);
            attribute.setCreatedDateTime(now);
            attributeRepository.save(attribute);
        });
    }

    @Override
    public List<AttributeResponse> getAttribute( AttributeRequest attributeRequest, String locale ) {
        ZKanbanAttribute attribute = new ZKanbanAttribute();
        attribute.setSite(attributeRequest.getSite());
        attribute.setType(attributeRequest.getType());
        attribute.setActivity(attributeRequest.getActivity());

        return attributeRepository.getAttribute(attribute, locale).stream()
                .map(obj -> {
                    AttributeResponse response = new AttributeResponse();

                    String type = obj.getType();
                    switch (type) {
                        case "0":
                            response.setWorkCenter(obj.getAttribute1());
                            response.setDescription(obj.getDescription());
                            break;
                        case "1":
                            response.setStatus(obj.getAttribute1());
                            response.setStatusType(obj.getAttribute2());
                            break;
                        case "2":
                            RouterBOHandle routerBOHandle = new RouterBOHandle(obj.getAttribute2());
                            response.setItem(obj.getAttribute1());
                            response.setItemDesc(obj.getItemDesc());
                            response.setRouterBo(obj.getAttribute2());
                            response.setRouter(routerBOHandle.getRouter());
                            response.setRouterRevision(routerBOHandle.getRevision());
                            break;
                        default:
                            break;
                    }

                    return response;
                })
                .collect(Collectors.toList());
    }

    private List<String> getResrceList( List<ResourceStatusInfo> resourceStatusList ) {
        return resourceStatusList.stream()
                .filter(f -> !"302".equals(f.getStatus()))
                .map(ResourceStatusInfo::getResource)
                .collect(Collectors.toList());
    }

    private List<ResourceStatusInfo> getResrceStatusList( KanbanRequest kanbanRequest ) {
        String site = kanbanRequest.getSite();
        String workCenter = kanbanRequest.getWorkCenter();
        String workCenterBo = new WorkCenterBOHandle(site, workCenter).getValue();
        List<ResourceStatusInfo> resourceStatusList = new ArrayList<>();
        this.findChildResource(workCenterBo, resourceStatusList);

        return resourceStatusList.stream()
                .filter(filters -> !FwUtils.isNullOrEmpty(filters.getStatus()))
                .collect(Collectors.toList());
    }

    private void findChildResource( String workCenterBo, List<ResourceStatusInfo> resourceList ) {
        List<WorkCenterMember> memberList = workCenterRepo.getChildWorkCenterMember(Collections.singletonList(workCenterBo));

        for (WorkCenterMember workCenterMember : memberList) {
            String resourceBo = workCenterMember.getWorkCenterOrResourceGbo();
            ResourceBOHandle resourceBOHandle = new ResourceBOHandle(resourceBo);
            String site = resourceBOHandle.getSite();
            String resource = resourceBOHandle.getResource();

            if (resourceBo.startsWith("ResourceBO")) {
                ResourceStatusInfo resourceStatusInfo = new ResourceStatusInfo();
                resourceStatusInfo.setResource(resource);

                List<ResourceTimeLog> resourceTimeLogList = resourceRepo.getResourceTimeLogActive(resourceBo);
                if (!FwUtils.isEmpty(resourceTimeLogList)) {
                    resourceStatusInfo.setStatus(new StatusBOHandle(resourceTimeLogList.get(0).getResourceStatusBo()).getStatus());
                }

                List<Resrce> resrceList = resourceRepo.findById(site, resource);
                if (!FwUtils.isEmpty(resrceList)) {
                    resourceStatusInfo.setResourceDesc(resrceList.get(0).getDescription());
                }
                resourceList.add(resourceStatusInfo);
            }
        }
    }

    /**
     * 取得Production log
     *
     * @param site
     * @param resourceList
     * @param first
     * @param last
     * @return
     */
    private List<ProductionLog> getProduction( String site, List<String> resourceList, Date first, Date last ) {
        if (FwUtils.isEmpty(resourceList)) {
            return new ArrayList<>();
        }

        ProductionInfo productionInfo = new ProductionInfo();
        productionInfo.setSite(site);
        productionInfo.setResrceList(resourceList);
        productionInfo.setStart(first);
        productionInfo.setEnd(last);
        productionInfo.setActivityList(ActivityList);
        return productionLogRepo.getProduction(productionInfo);
    }

    /**
     * 取得Resource time log
     *
     * @param site
     * @param resourceList
     * @param first
     * @param last
     * @return
     */
    private List<ViewResourceTimeLogResrce> getResrceTime( String site, List<String> resourceList,
                                                           Date first, Date last, Date gmt ) {
        if (FwUtils.isEmpty(resourceList)) {
            return new ArrayList<>();
        }
        String start = DateUtil.dateToString(first, "yyyy/MM/dd HH:mm:ss");
        String end = DateUtil.dateToString(last, "yyyy/MM/dd HH:mm:ss");

        return resourceRepo.getResrceTimeLogByEndTime(site, resourceList, start, end).parallelStream()
                .peek(obj -> {
                    Date startDateTime = obj.getStartDateTime();
                    Date endDateTime = obj.getEndDateTime();

                    if (first.compareTo(startDateTime) > 0) {
                        // 開始時間小於起始時間，需用起始時間計算
                        startDateTime = first;
                        obj.setStartDateTime(startDateTime);
                    }

                    if (FwUtils.objIsEmpty(endDateTime)) {
                        // 無結束時間，以當下時間計算
                        endDateTime = gmt;
                        obj.setEndDateTime(endDateTime);
                    }

                    long mill = endDateTime.getTime() - startDateTime.getTime();
                    obj.setElapsedTime(new BigDecimal(String.valueOf(mill)));
                })
                .collect(Collectors.toList());

    }

    /**
     * 資源生產效率
     *
     * @param productionLogList
     * @return
     */
    private List<ResourceEfficiency> getEfficiency( List<ProductionLog> productionLogList ) {
        // 依物料+作業站+資源分組
        Map<String, List<ProductionLog>> groupMap = productionLogList.stream()
                .collect(Collectors.groupingBy(this::getGroupByKey));

        List<ResourceEfficiency> resourceEfficiencyList = new ArrayList<>();
        groupMap.forEach(( k, v ) -> {
            ResourceEfficiency resourceEfficiency = new ResourceEfficiency();
            String[] keyArr = k.split(";");
            String site = keyArr[0];
            String item = keyArr[1];
            String operation = keyArr[2];
            String resrce = keyArr[3];

            TdsResourceAbility resourceAbility = resourceAbilityRepository.getAbility(site, item, operation, resrce);

            resourceEfficiency.setItem(item);
            resourceEfficiency.setOperation(operation);
            resourceEfficiency.setResrce(resrce);
            resourceEfficiency.setTotalCompleteQty(v.stream()
                                                           .map(ProductionLog::getQtyCompleted)
                                                           .reduce(BigDecimal.ZERO, BigDecimal::add));
            resourceEfficiency.setTotalElapsedTime(v.stream()
                                                           .filter(filters -> filters.getQtyCompleted().compareTo(BigDecimal.ZERO) > 0)
                                                           .map(ProductionLog::getElapsedTime)
                                                           .reduce(BigDecimal.ZERO, BigDecimal::add)
                                                           .divide(HOUR, 8, RoundingMode.HALF_UP));
            resourceEfficiency.setActualUph(BigDecimal.ZERO);
            resourceEfficiency.setEfficiency(BigDecimal.ZERO);

            if (!FwUtils.objIsEmpty(resourceAbility)) {
                // 目標UPH
                resourceEfficiency.setUph(new BigDecimal(resourceAbility.getUph()));

                BigDecimal totalComplete = resourceEfficiency.getTotalCompleteQty();
                BigDecimal totalElapsed = resourceEfficiency.getTotalElapsedTime();
                if (!isZero(totalComplete) && !isZero(totalElapsed)) {
                    resourceEfficiency.setActualUph(totalComplete.divide(totalElapsed, 6, RoundingMode.HALF_UP));
                }

                BigDecimal uph = resourceEfficiency.getUph();
                BigDecimal actUph = resourceEfficiency.getActualUph();
                if (!isZero(actUph) && !isZero(uph)) {
                    // 生產效率 = 實際UPH / 目標UPH
                    resourceEfficiency.setEfficiency(actUph.divide(uph, 6, RoundingMode.HALF_UP));
                }
            }
            resourceEfficiencyList.add(resourceEfficiency);
        });

        return resourceEfficiencyList;
    }

    /**
     * 平均生產效率(日)
     *
     * @param filterProduction
     * @return
     */
    private BigDecimal getAvgEfficiency( List<ProductionLog> filterProduction ) {
        List<ResourceEfficiency> efficiencyList = this.getEfficiency(filterProduction);
        BigDecimal totalEfficiency = efficiencyList.stream()
                .map(ResourceEfficiency::getEfficiency)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (isZero(totalEfficiency)) {
            return BigDecimal.ONE.negate();
        }

        // 累計生產效率 = 資源生產效率加總 / 資料筆數
        int size = efficiencyList.size();
        BigDecimal avgEfficiency = totalEfficiency.divide(new BigDecimal(size), 4, RoundingMode.HALF_UP);

        return avgEfficiency.multiply(HUNDRED);
    }

    /**
     * 平均生產良率(日)
     *
     * @param productionLogList
     * @return
     */
    private BigDecimal getAvgYield( List<ProductionLog> productionLogList ) {
        // 報廢數
        BigDecimal totalScrappedQty = productionLogList.stream()
                .map(ProductionLog::getQtyScrapped)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        // 投入數
        BigDecimal inputQty = productionLogList.stream()
                .map(ProductionLog::getQtyStarted)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (isZero(inputQty)) {
            return BigDecimal.ONE.negate();
        }

        // 投入數 - 報廢數
        BigDecimal totalQty = inputQty.subtract(totalScrappedQty);

        if (isZero(totalQty)) {
            return BigDecimal.ONE.negate();
        }

        // (投入數 - 報廢數) / 投入數
        return totalQty.divide(inputQty, 4, RoundingMode.HALF_UP).multiply(HUNDRED);
    }

    /**
     * 平均資源稼動率(日)
     *
     * @param resourceTimeLogList
     * @return
     */
    private BigDecimal getAvgUtilizationRate( List<ViewResourceTimeLogResrce> resourceTimeLogList,
                                              List<AttributeRequest> attributeList, BigDecimal availableTime ) {
        // 狀態為1的時間加總
        BigDecimal one = this.getProdTime(resourceTimeLogList);

        // 計畫性停機時間
        BigDecimal planningTime = this.getPlanningTime(resourceTimeLogList, attributeList);

        if (isZero(availableTime) || isOver24H(availableTime)) {
            return BigDecimal.ZERO;
        }

        // 計畫開機時間
        BigDecimal turnOnTime = availableTime.subtract(planningTime);

        if (isZero(one) || isZero(turnOnTime)) {
            return BigDecimal.ZERO;
        }

        return one.divide(turnOnTime, 4, RoundingMode.HALF_UP).multiply(HUNDRED);
    }

    private BigDecimal getProdTime( List<ViewResourceTimeLogResrce> resourceTimeLogList ) {
        BigDecimal decimal = resourceTimeLogList.stream()
                .filter(filters -> "1".equals(filters.getStatus()))
                .map(ViewResourceTimeLogResrce::getElapsedTime)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (isZero(decimal)) {
            return BigDecimal.ZERO;
        }

        return decimal.divide(new BigDecimal(1000 * 60), 0, RoundingMode.HALF_DOWN);
    }

    /**
     * 計畫性停機時間
     *
     * @param resourceTimeLogList
     * @param attributeList
     * @return
     */
    private BigDecimal getPlanningTime( List<ViewResourceTimeLogResrce> resourceTimeLogList,
                                        List<AttributeRequest> attributeList ) {
        if (FwUtils.isEmpty(attributeList)) {
            return BigDecimal.ZERO;
        }

        List<String> statusList = attributeList.stream()
                .filter(filters -> "0".equals(filters.getStatusType()))
                .map(AttributeRequest::getStatus)
                .collect(Collectors.toList());

        BigDecimal decimal = resourceTimeLogList.stream()
                .filter(filters -> statusList.contains(filters.getStatus()))
                .map(ViewResourceTimeLogResrce::getElapsedTime)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (isZero(decimal)) {
            return BigDecimal.ZERO;
        }

        return decimal.divide(new BigDecimal(1000 * 60), 0, RoundingMode.HALF_DOWN);
    }

    /**
     * 平均OEE
     *
     * @param response
     * @return
     */
    private BigDecimal getAvgOee( KanbanResponse response ) {
        BigDecimal avgEfficiency = new BigDecimal("1");
        BigDecimal avgYield = new BigDecimal("1");
        BigDecimal avgRate = new BigDecimal("1");

        int i = 0;
        // 生產效率
        if (!FwUtils.objIsEmpty(response.getAvgMonthEfficiency()) &&
                response.getAvgMonthEfficiency().compareTo(BigDecimal.ZERO) >= 0) {
            avgEfficiency = response.getAvgMonthEfficiency().divide(HUNDRED, 4, RoundingMode.HALF_UP);
            i++;
        }
        if (!FwUtils.objIsEmpty(response.getAvgDayEfficiency()) &&
                response.getAvgDayEfficiency().compareTo(BigDecimal.ZERO) >= 0) {
            avgEfficiency = response.getAvgDayEfficiency().divide(HUNDRED, 4, RoundingMode.HALF_UP);
            i++;
        }

        // 生產良率
        if (!FwUtils.objIsEmpty(response.getAvgMonthYield()) &&
                response.getAvgMonthYield().compareTo(BigDecimal.ZERO) >= 0) {
            avgYield = response.getAvgMonthYield().divide(HUNDRED, 4, RoundingMode.HALF_UP);
            i++;
        }
        if (!FwUtils.objIsEmpty(response.getAvgDayYield()) &&
                response.getAvgDayYield().compareTo(BigDecimal.ZERO) >= 0) {
            avgYield = response.getAvgDayYield().divide(HUNDRED, 4, RoundingMode.HALF_UP);
            i++;
        }

        // 稼動率
        if (!FwUtils.objIsEmpty(response.getAvgMonthUtilizationRate()) &&
                response.getAvgMonthUtilizationRate().compareTo(BigDecimal.ZERO) >= 0) {
            avgRate = response.getAvgMonthUtilizationRate().divide(HUNDRED, 4, RoundingMode.HALF_UP);
            i++;
        }
        if (!FwUtils.objIsEmpty(response.getAvgDayUtilizationRate()) &&
                response.getAvgDayUtilizationRate().compareTo(BigDecimal.ZERO) >= 0) {
            avgRate = response.getAvgDayUtilizationRate().divide(HUNDRED, 4, RoundingMode.HALF_UP);
            i++;
        }

        if (i == 0) {
            return BigDecimal.ONE.negate();
        }

        BigDecimal oee = avgEfficiency.multiply(avgYield).multiply(avgRate).setScale(4, RoundingMode.HALF_UP);

        if (oee.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ONE.negate();
        }

        return oee.multiply(HUNDRED);
    }

    /**
     * 資源平均OEE(日)
     *
     * @param resourceStatusInfo
     * @return
     */
    private BigDecimal getAvgResourceOee( ResourceStatusInfo resourceStatusInfo ) {
        BigDecimal efficiency = new BigDecimal("1");
        BigDecimal yield = new BigDecimal("1");
        BigDecimal rate = new BigDecimal("1");

        int i = 0;
        if (!FwUtils.objIsEmpty(resourceStatusInfo.getEfficiency()) &&
                isOverNegate(resourceStatusInfo.getEfficiency())) {
            efficiency = resourceStatusInfo.getEfficiency().divide(HUNDRED, 4, RoundingMode.HALF_UP);
            i++;
        }
        if (!FwUtils.objIsEmpty(resourceStatusInfo.getYield()) &&
                isOverNegate(resourceStatusInfo.getYield())) {
            yield = resourceStatusInfo.getYield().divide(HUNDRED, 4, RoundingMode.HALF_UP);
            i++;
        }
        if (!FwUtils.objIsEmpty(resourceStatusInfo.getUtilizationRate()) &&
                isOverNegate(resourceStatusInfo.getUtilizationRate())) {
            rate = resourceStatusInfo.getUtilizationRate().divide(HUNDRED, 4, RoundingMode.HALF_UP);
            i++;
        }

        if (i < 3) {
            return BigDecimal.ZERO;
        }

        BigDecimal number = efficiency.multiply(yield).multiply(rate).setScale(4, RoundingMode.HALF_UP);
        return number.multiply(HUNDRED);
    }

    private BigDecimal getUph( BigDecimal complete, BigDecimal productionTime ) {
        if (isZero(productionTime)) {
            return BigDecimal.ZERO;
        }

        if (isZero(complete)) {
            return BigDecimal.ZERO;
        }

        return complete.divide(productionTime, 2, RoundingMode.HALF_UP);
    }

    private BigDecimal getHpu( BigDecimal complete, BigDecimal productionTime ) {
        if (isZero(productionTime)) {
            return BigDecimal.ZERO;
        }

        if (isZero(complete)) {
            return BigDecimal.ZERO;
        }

        return productionTime.divide(complete, 2, RoundingMode.HALF_UP);
    }

    private String getGroupByKey( ProductionLog productionLog ) {
        return productionLog.getSite() + ";" + productionLog.getItem() + ";" + productionLog.getOperation() + ";" + productionLog.getResrce();
    }

    private Date getFirstDate( Date now ) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    private Date getLastDate( Date now ) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    private Date getDate00( Date now ) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    private Date getTomorrow00( Date now ) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    private boolean isZero( BigDecimal bigDecimal ) {
        if (FwUtils.objIsEmpty(bigDecimal)) {
            return true;
        }

        return bigDecimal.compareTo(BigDecimal.ZERO) <= 0;
    }

    private boolean isOver24H( BigDecimal bigDecimal ) {
        if (FwUtils.objIsEmpty(bigDecimal)) {
            return true;
        }

        return bigDecimal.compareTo(new BigDecimal("1440")) > 0;
    }

    private boolean isOverNegate( BigDecimal bigDecimal ) {
        if (FwUtils.objIsEmpty(bigDecimal)) {
            return false;
        }

        return bigDecimal.compareTo(BigDecimal.ONE.negate()) > 0;
    }

    private BigDecimal getAvailableTime( String site, String workCenter ) {
        String workCenterBo = new WorkCenterBOHandle(site, workCenter).getValue();
        CustomFields customFields = customFieldsRepo.findCustomFields(workCenterBo, "EQP_AVAILABLE_TIME");
        BigDecimal availableTime = BigDecimal.ZERO;
        if (!FwUtils.objIsEmpty(customFields)) {
            String value = customFields.getValue();
            if (FwUtils.isNumeric(value)) {
                availableTime = new BigDecimal(value);
            }
        }
        return availableTime;
    }

    private int dayInterval( Date first, Date last ) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(first);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(last);
        int day1 = calendar1.get(Calendar.DAY_OF_YEAR);
        int day2 = calendar2.get(Calendar.DAY_OF_YEAR);

        return (day2 - day1) + 1;
    }
}
