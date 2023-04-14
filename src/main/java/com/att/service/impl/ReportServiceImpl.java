package com.att.service.impl;

import com.att.converent.ProductionDateReportConverter;
import com.att.converent.ProductionIntegratedConverter;
import com.att.converent.SoReleaseConverter;
import com.att.domain.report.*;
import com.att.domain.shopOrder.SoCustomRequest;
import com.att.domain.soRelease.SoCustom;
import com.att.repository.ReportRepository;
import com.att.repository.ShopOrderReleaseRepository;
import com.att.repository.entity.*;
import com.att.service.ReportService;
import com.fw.mes.me.controller.customFields.CustomFieldsRepo;
import com.fw.mes.me.controller.item.ItemRepo;
import com.fw.mes.me.controller.site.SiteRepo;
import com.fw.mes.me.entity.CustomFields;
import com.fw.mes.me.entity.Item;
import com.fw.mes.util.DateUtil;
import com.fw.mes.util.FwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private ShopOrderReleaseRepository shopOrderReleaseRepository;

    @Autowired
    private SiteRepo siteRepo;

    @Autowired
    private CustomFieldsRepo customFieldsRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public List<ProductionDateReportResponse> productionDateReport( ProductionDateReportRequest request, String locale ) {
        //撈出生產歷程
        List<ZVwProductionQty> zVwProductionQtyList = reportRepository.findZVwProductionQty(request, locale);

        List<ProductionDateReportResponse> responseList = ProductionDateReportConverter.INSTANCE.toResponse(zVwProductionQtyList);

        String timeZone = siteRepo.getTimeZone(request.getSite());

        responseList.forEach(zVwProductionQty -> {
            //重工數
            if (zVwProductionQty.getQtyStarted().compareTo(zVwProductionQty.getQtyCompleted().add(zVwProductionQty.getQtyScrapped().add(zVwProductionQty.getQtyDone()))) != 0) {
                List<ZVwProductionQtyNc> zVwProductionQtyNcList = reportRepository.findZVwProductionQtyNc(zVwProductionQty, locale, DateUtil.toGmtDate(request.getStartDate(), timeZone), DateUtil.toGmtDate(request.getEndDate(), timeZone));
                zVwProductionQty.setQtyRework(zVwProductionQtyNcList.stream().map(ZVwProductionQtyNc::getQty).reduce(BigDecimal.ZERO, BigDecimal::add));
            } else {
                zVwProductionQty.setQtyRework(BigDecimal.ZERO);
            }

            //良率
            if (!(BigDecimal.ZERO.compareTo(zVwProductionQty.getQtyStarted()) == 0)) {
                zVwProductionQty.setYield((zVwProductionQty.getQtyStarted().subtract(zVwProductionQty.getQtyScrapped())).divide(zVwProductionQty.getQtyStarted(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).stripTrailingZeros().toPlainString());
            }

            //報廢率
            if (!(BigDecimal.ZERO.compareTo(zVwProductionQty.getQtyStarted()) == 0)) {
                zVwProductionQty.setScrapRate(zVwProductionQty.getQtyScrapped().divide(zVwProductionQty.getQtyStarted(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).stripTrailingZeros().toPlainString());
            }
            //直通率
            if (!(BigDecimal.ZERO.compareTo(zVwProductionQty.getQtyStarted()) == 0)) {
                zVwProductionQty.setThroughRate(zVwProductionQty.getQtyStarted().subtract(zVwProductionQty.getQtyScrapped()).subtract(zVwProductionQty.getQtyRework()).divide(zVwProductionQty.getQtyStarted(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).stripTrailingZeros().toPlainString());
            }
            //重工率
            if (!(BigDecimal.ZERO.compareTo(zVwProductionQty.getQtyStarted()) == 0)) {
                zVwProductionQty.setReworkRate(zVwProductionQty.getQtyRework().divide(zVwProductionQty.getQtyStarted(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).stripTrailingZeros().toPlainString());
            }

            //預設工時
            if (FwUtils.objIsEmpty(zVwProductionQty.getLaborH())) {
                zVwProductionQty.setLaborH(BigDecimal.ZERO);
            }
            if (FwUtils.objIsEmpty(zVwProductionQty.getLaborM())) {
                zVwProductionQty.setLaborM(BigDecimal.ZERO);
            }

            //UPH
            if (!(BigDecimal.ZERO.compareTo(zVwProductionQty.getLaborH()) == 0)) {
                zVwProductionQty.setUph(zVwProductionQty.getQtyCompleted().divide(zVwProductionQty.getLaborH(), 2, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());
            }

            //HPU
            if (!(BigDecimal.ZERO.compareTo(zVwProductionQty.getQtyCompleted()) == 0)) {
                zVwProductionQty.setHpu(zVwProductionQty.getLaborH().divide(zVwProductionQty.getQtyCompleted(), 2, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());
            }

        });

        return responseList;
    }

    @Override
    public List<ProductionQtyDetailResponse> productionDateReportDetail( ProductionDateReportRequest request, String locale ) {
        List<ZVwProductionQtyDetail> zVwProductionQtyDetailList = reportRepository.findZVwProductionQtyDetail(request, locale);
        List<ProductionQtyDetailResponse> responseList = ProductionDateReportConverter.INSTANCE.toResponseByDetail(zVwProductionQtyDetailList);
        responseList.forEach(productionQtyDetailResponse -> productionQtyDetailResponse.setDateTimeStr(DateUtil.dateToString(productionQtyDetailResponse.getDateTime())));
        return responseList;
    }

    @Override
    public List<SoCustom> getSoCustomList( SoCustomRequest request, String locale ) {
        String timeZone = siteRepo.getTimeZone(request.getSite());
        if (!FwUtils.isNullOrEmpty(request.getPlannedCompDateStartStr())) {
            request.setPlannedCompDateStart(DateUtil.toGmtDate(request.getPlannedCompDateStartStr(), timeZone));
        }
        if (!FwUtils.isNullOrEmpty(request.getPlannedCompDateEndStr())) {
            request.setPlannedCompDateEnd(DateUtil.toGmtDate(request.getPlannedCompDateEndStr(), timeZone));
        }
        List<ZVwSoCustom> zVwSoCustomList = shopOrderReleaseRepository.getSoReleaseDesc(locale, request);
        return zVwSoCustomList.stream().map(zVwSoCustom -> {
            SoCustom soCustom = SoReleaseConverter.INSTANCE.daoToDomain(zVwSoCustom);
            if (!FwUtils.objIsEmpty(soCustom.getPlannedCompDate())) {
                soCustom.setPlannedCompDateStr(DateUtil.dateToString(soCustom.getPlannedCompDate()));
            }
            return soCustom;
        }).collect(Collectors.toList());
    }

    @Override
    public ProductionIntegratedResponse productionIntegratedInfo( ProductionIntegratedRequest request ) {
        ProductionIntegratedResponse response = new ProductionIntegratedResponse();
        response.setSite(request.getSite());
        response.setItem(request.getItem());
        String timeZone = siteRepo.getTimeZone(request.getSite());
        ZVwProductionIntegratedKanban1 zVwProductionIntegratedKanban1W = new ZVwProductionIntegratedKanban1();
        zVwProductionIntegratedKanban1W.setSite(request.getSite());
        zVwProductionIntegratedKanban1W.setItem(request.getItem());
        ZVwProductionIntegratedKanban1 zVwProductionIntegratedKanban1 = reportRepository.findZVwProductionIntegratedKanban1(zVwProductionIntegratedKanban1W);
        if (!FwUtils.objIsEmpty(zVwProductionIntegratedKanban1)) {
            //在製生產數
            if (!FwUtils.objIsEmpty(zVwProductionIntegratedKanban1.getInQty())) {
                response.setTotalInQty(zVwProductionIntegratedKanban1.getInQty());
            }
            //在製重工數
            if (!FwUtils.objIsEmpty(zVwProductionIntegratedKanban1.getReworkQty())) {
                response.setTotalInReworkQty(zVwProductionIntegratedKanban1.getReworkQty());
            }
            //在製保留數
            if (!FwUtils.objIsEmpty(zVwProductionIntegratedKanban1.getHoldQty())) {
                response.setTotalInHoldQty(zVwProductionIntegratedKanban1.getHoldQty());
            }
        }

        //本月
        ZVwProductionIntegratedKanban2 zVwProductionIntegratedKanban2W = new ZVwProductionIntegratedKanban2();
        zVwProductionIntegratedKanban2W.setSite(request.getSite());
        zVwProductionIntegratedKanban2W.setItem(request.getItem());
        Calendar first = Calendar.getInstance();
        first.set(Calendar.DAY_OF_MONTH, 1);
        first.set(Calendar.HOUR, 12);
        first.set(Calendar.MINUTE, 0);
        first.set(Calendar.SECOND, 0);
        Calendar last = Calendar.getInstance();
        last.set(Calendar.DAY_OF_MONTH, last.getActualMaximum(Calendar.DAY_OF_MONTH));
        last.set(Calendar.HOUR_OF_DAY, 23);
        last.set(Calendar.MINUTE, 59);
        last.set(Calendar.SECOND, 59);
        ZVwProductionIntegratedKanban2 zVwProductionIntegratedKanban2Monthly = reportRepository.findZVwProductionIntegratedKanban2(zVwProductionIntegratedKanban2W, DateUtil.toGmtDate(first.getTime(), timeZone), DateUtil.toGmtDate(last.getTime(), timeZone));
        if (!FwUtils.objIsEmpty(zVwProductionIntegratedKanban2Monthly)) {
            //本月實際生產KPI
            if (!FwUtils.objIsEmpty(zVwProductionIntegratedKanban2Monthly.getActualProductionKpi())) {
                response.setMonthlyActualProductionKpi(zVwProductionIntegratedKanban2Monthly.getActualProductionKpi());
            }
            //本月實際生產
            if (!FwUtils.objIsEmpty(zVwProductionIntegratedKanban2Monthly.getQtyCompleted())) {
                response.setMonthlyActualProductionQty(zVwProductionIntegratedKanban2Monthly.getQtyCompleted());
            }
            //本月達成率
            if (BigDecimal.ZERO.compareTo(response.getMonthlyActualProductionKpi()) != 0) {
                response.setMonthlyAchievementRate(response.getMonthlyActualProductionQty().divide(response.getMonthlyActualProductionKpi(), 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
            }

            if (!FwUtils.objIsEmpty(zVwProductionIntegratedKanban2Monthly.getQtyStarted()) &&
                    BigDecimal.ZERO.compareTo(zVwProductionIntegratedKanban2Monthly.getQtyStarted()) != 0) {
                BigDecimal qtyStarted = zVwProductionIntegratedKanban2Monthly.getQtyStarted();

                BigDecimal qtyScrapped = FwUtils.objIsEmpty(zVwProductionIntegratedKanban2Monthly.getQtyScrapped()) ? BigDecimal.ZERO : zVwProductionIntegratedKanban2Monthly.getQtyScrapped();

                BigDecimal reworkQty = FwUtils.objIsEmpty(zVwProductionIntegratedKanban2Monthly.getReworkQty()) ? BigDecimal.ZERO : zVwProductionIntegratedKanban2Monthly.getReworkQty();
                //本月直通良率
                response.setMonthlyThruYield(qtyStarted.subtract(qtyScrapped).subtract(reworkQty).divide(qtyStarted, 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
                //本月良率
                response.setMonthlyYield(qtyStarted.subtract(qtyScrapped).divide(qtyStarted, 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
            }
            //本月報廢數
            if (!FwUtils.objIsEmpty(zVwProductionIntegratedKanban2Monthly.getQtyScrapped())) {
                response.setMonthlyQtyScrapped(zVwProductionIntegratedKanban2Monthly.getQtyScrapped());
            }
            //本月重工數
            if (!FwUtils.objIsEmpty(zVwProductionIntegratedKanban2Monthly.getReworkQty())) {
                response.setMonthlyReworkQty(zVwProductionIntegratedKanban2Monthly.getReworkQty());
            }
            //本月重工率
            if (!FwUtils.objIsEmpty(zVwProductionIntegratedKanban2Monthly.getQtyCompleted()) &&
                    BigDecimal.ZERO.compareTo(zVwProductionIntegratedKanban2Monthly.getQtyCompleted()) != 0) {
                response.setMonthlyReworkRate(response.getMonthlyReworkQty().divide(zVwProductionIntegratedKanban2Monthly.getQtyCompleted(), 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
            }
        }

        //本日
        Calendar todayFirst = Calendar.getInstance();
        todayFirst.set(Calendar.HOUR_OF_DAY, 0);
        todayFirst.set(Calendar.MINUTE, 0);
        todayFirst.set(Calendar.SECOND, 0);
        Calendar todayLast = Calendar.getInstance();
        todayLast.set(Calendar.HOUR_OF_DAY, 23);
        todayLast.set(Calendar.MINUTE, 59);
        todayLast.set(Calendar.SECOND, 59);
        ZVwProductionIntegratedKanban2 zVwProductionIntegratedKanban2Today = reportRepository.findZVwProductionIntegratedKanban2(zVwProductionIntegratedKanban2W, DateUtil.toGmtDate(todayFirst.getTime(), timeZone), DateUtil.toGmtDate(todayLast.getTime(), timeZone));
        if (!FwUtils.objIsEmpty(zVwProductionIntegratedKanban2Today)) {
            //本日實際生產KPI
            if (!FwUtils.objIsEmpty(zVwProductionIntegratedKanban2Today.getActualProductionKpi())) {
                response.setActualProductionKpi(zVwProductionIntegratedKanban2Today.getActualProductionKpi());
            }
            //本日實際生產
            if (!FwUtils.objIsEmpty(zVwProductionIntegratedKanban2Today.getQtyCompleted())) {
                response.setActualProductionQty(zVwProductionIntegratedKanban2Today.getQtyCompleted());
            }
            //本日達成率
            if (BigDecimal.ZERO.compareTo(response.getActualProductionKpi()) != 0) {
                BigDecimal completeQty = zVwProductionIntegratedKanban2Today.getQtyCompleted();

                if (!FwUtils.objIsEmpty(completeQty)) {
                    response.setAchievementRate(completeQty.divide(zVwProductionIntegratedKanban2Today.getActualProductionKpi(), 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
                }
            }
            if (!FwUtils.objIsEmpty(zVwProductionIntegratedKanban2Today.getQtyStarted())
                    && BigDecimal.ZERO.compareTo(zVwProductionIntegratedKanban2Today.getQtyStarted()) != 0) {
                BigDecimal qtyStarted = zVwProductionIntegratedKanban2Today.getQtyStarted();

                BigDecimal qtyScrapped = FwUtils.objIsEmpty(zVwProductionIntegratedKanban2Today.getQtyScrapped()) ? BigDecimal.ZERO : zVwProductionIntegratedKanban2Today.getQtyScrapped();

                BigDecimal reworkQty = FwUtils.objIsEmpty(zVwProductionIntegratedKanban2Today.getReworkQty()) ? BigDecimal.ZERO : zVwProductionIntegratedKanban2Today.getReworkQty();
                //本日直通率
                response.setThruYield(qtyStarted.subtract(qtyScrapped).subtract(reworkQty).divide(qtyStarted, 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
                //本日良率
                response.setYield(qtyStarted.subtract(qtyScrapped).divide(qtyStarted, 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
            }
            //本日報廢數
            if (!FwUtils.objIsEmpty(zVwProductionIntegratedKanban2Today.getQtyScrapped())) {
                response.setQtyScrapped(zVwProductionIntegratedKanban2Today.getQtyScrapped());
            }
            //本日重工數
            if (!FwUtils.objIsEmpty(zVwProductionIntegratedKanban2Today.getReworkQty())) {
                response.setReworkQty(zVwProductionIntegratedKanban2Today.getReworkQty());
            }
            //本日重工率
            if (!FwUtils.objIsEmpty(zVwProductionIntegratedKanban2Today.getQtyCompleted())
                    && BigDecimal.ZERO.compareTo(zVwProductionIntegratedKanban2Today.getQtyCompleted()) != 0) {
                response.setReworkRate(response.getReworkQty().divide(zVwProductionIntegratedKanban2Today.getQtyCompleted(), 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
            }


            //途程
            ZVwProductionIntegratedKanban3 zVwProductionIntegratedKanban3W = new ZVwProductionIntegratedKanban3();
            zVwProductionIntegratedKanban3W.setSite(request.getSite());
            zVwProductionIntegratedKanban3W.setItem(request.getItem());
            zVwProductionIntegratedKanban3W.setRouter(request.getRouter());
            zVwProductionIntegratedKanban3W.setRouterRevision(request.getRouterReversion());
            List<ZVwProductionIntegratedKanban3> zVwProductionIntegratedKanban3List = reportRepository.findZVwProductionIntegratedKanban3(zVwProductionIntegratedKanban3W, DateUtil.toGmtDate(todayFirst.getTime(), timeZone), DateUtil.toGmtDate(todayLast.getTime(), timeZone));
            zVwProductionIntegratedKanban3List.forEach(zVwProductionIntegratedKanban3 -> {
                ProductionIntegratedDetailResponse detailResponse = ProductionIntegratedConverter.INSTANCE.detailToDomain(zVwProductionIntegratedKanban3);
                if (FwUtils.objIsEmpty(zVwProductionIntegratedKanban3.getInQty())) {
                    zVwProductionIntegratedKanban3.setInQty(BigDecimal.ZERO);
                }
                if (FwUtils.objIsEmpty(zVwProductionIntegratedKanban3.getQtyCompleted())) {
                    zVwProductionIntegratedKanban3.setQtyCompleted(BigDecimal.ZERO);
                }
                if (FwUtils.objIsEmpty(zVwProductionIntegratedKanban3.getQtyScrapped())) {
                    zVwProductionIntegratedKanban3.setQtyScrapped(BigDecimal.ZERO);
                }
                detailResponse.setInQtyStr(zVwProductionIntegratedKanban3.getInQty().stripTrailingZeros().toPlainString());
                detailResponse.setQtyCompletedStr(zVwProductionIntegratedKanban3.getQtyCompleted().stripTrailingZeros().toPlainString());
                detailResponse.setQtyScrappedStr(zVwProductionIntegratedKanban3.getQtyScrapped().stripTrailingZeros().toPlainString());
                response.getRouterList().add(detailResponse);
            });


            //自定義
            List<Item> itemList = itemRepo.findCurrentItem(request.getSite(), request.getItem());
            if (!FwUtils.isEmpty(itemList)) {
                String itemBo = itemList.get(0).getHandle();
                List<CustomFields> customFieldsList = customFieldsRepo.findCustomFields(itemBo);
                customFieldsList.forEach(customFields -> {
                    switch (customFields.getAttribute()) {
                        case "MONTH_WIP_UPPER":
                            response.setMonthWipUpper(customFields.getValue());
                            break;
                        case "MONTH_WIP_LOWER":
                            response.setMonthWipLower(customFields.getValue());
                            break;
                        case "MONTH_WIP_REWORK":
                            response.setMonthWipRework(customFields.getValue());
                            break;
                        case "MONTH_WIP_HOLD":
                            response.setMonthWipHold(customFields.getValue());
                            break;
                        case "MONTH_ACHIEVEMENT_RATE":
                            response.setMonthAchievementRate(customFields.getValue());
                            break;
                        case "MONTH_FPY":
                            response.setMonthFpy(customFields.getValue());
                            break;
                        case "MONTH_YIELD":
                            response.setMonthYield(customFields.getValue());
                            break;
                        case "MONTH_SCRAP":
                            response.setMonthScrap(customFields.getValue());
                            break;
                        case "MONTH_REWORK_RATE":
                            response.setMonthReworkRate(customFields.getValue());
                            break;
                        case "MONTH_REWORK":
                            response.setMonthRework(customFields.getValue());
                            break;
                        case "DAY_ACHIEVEMENT_RATE":
                            response.setDayAchievementRate(customFields.getValue());
                            break;
                        case "DAY_FPY":
                            response.setDayFpy(customFields.getValue());
                            break;
                        case "DAY_YIELD":
                            response.setDayYield(customFields.getValue());
                            break;
                        case "DAY_SCRAP":
                            response.setDayScrap(customFields.getValue());
                            break;
                        case "DAY_REWORK_RATE":
                            response.setDayReworkRate(customFields.getValue());
                            break;
                        case "DAY_REWORK":
                            response.setDayRework(customFields.getValue());
                            break;
                    }
                });
            }
        }

        return response;
    }
}
