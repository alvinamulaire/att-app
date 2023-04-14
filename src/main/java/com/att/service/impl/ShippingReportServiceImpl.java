package com.att.service.impl;

import com.att.domain.shipping.PackingInfo;
import com.att.domain.shipping.ShippingInfo;
import com.att.domain.shipping.SnInfo;
import com.att.repository.InspecRepository;
import com.att.repository.PackagingProductRepository;
import com.att.repository.ShippingReportRepository;
import com.att.repository.entity.*;
import com.att.service.ShippingReportService;
import com.fw.mes.me.controller.customFields.CustomFieldsRepo;
import com.fw.mes.me.controller.sfc.SfcRepo;
import com.fw.mes.me.controller.site.SiteRepo;
import com.fw.mes.me.entity.CustomFields;
import com.fw.mes.util.DateUtil;
import com.fw.mes.util.FwUtils;
import com.sap.me.demand.ShopOrderBOHandle;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class ShippingReportServiceImpl implements ShippingReportService {

    private final ShippingReportRepository shippingReportRepository;

    private final SiteRepo siteRepo;

    private final InspecRepository inspecRepository;

    private final PackagingProductRepository packagingProductRepository;

    private final SfcRepo sfcRepo;

    private final CustomFieldsRepo customFieldsRepo;

    @Autowired
    public ShippingReportServiceImpl( ShippingReportRepository shippingReportRepository,
                                      SiteRepo siteRepo,
                                      InspecRepository inspecRepository,
                                      PackagingProductRepository packagingProductRepository,
                                      SfcRepo sfcRepo,
                                      CustomFieldsRepo customFieldsRepo ) {
        this.shippingReportRepository = shippingReportRepository;
        this.siteRepo = siteRepo;
        this.inspecRepository = inspecRepository;
        this.packagingProductRepository = packagingProductRepository;
        this.sfcRepo = sfcRepo;
        this.customFieldsRepo = customFieldsRepo;
    }

    @Override
    public List<ZVwShopOrderPackingInfo> getPackingShopOrder( PackingInfo packingInfo ) {
        return shippingReportRepository.getShippingInfo(this.setPackingInfo(packingInfo),
                                                        packingInfo.getLan().toLowerCase()).stream()
                .filter(FwUtils.distinctByKey(ZVwShopOrderPackingInfo::getShopOrder))
                .sorted(Comparator.comparing(ZVwShopOrderPackingInfo::getShopOrder))
                .collect(Collectors.toList());
    }

    @Override
    public List<ZVwShopOrderPackingInfo> getPackingCarton( PackingInfo packingInfo ) {
        return shippingReportRepository.getShippingInfo(packingInfo, packingInfo.getLan().toLowerCase()).stream()
                .filter(f -> !FwUtils.isNullOrEmpty(f.getCartonNo()))
                .filter(FwUtils.distinctByKey(ZVwShopOrderPackingInfo::getCartonNo))
                .sorted(Comparator.comparing(ZVwShopOrderPackingInfo::getCartonNo))
                .collect(Collectors.toList());
    }

    @Override
    public List<ZVwShopOrderPackingInfo> getPackingPallet( PackingInfo packingInfo ) {
        return shippingReportRepository.getShippingInfo(packingInfo, packingInfo.getLan().toLowerCase()).stream()
                .filter(f -> !FwUtils.isNullOrEmpty(f.getPalletNo()))
                .filter(FwUtils.distinctByKey(ZVwShopOrderPackingInfo::getPalletNo))
                .sorted(Comparator.comparing(ZVwShopOrderPackingInfo::getPalletNo))
                .collect(Collectors.toList());
    }

    @Override
    public List<ZVwShopOrderPackingInfo> getPackingSn( PackingInfo packingInfo ) {
        return shippingReportRepository.getShippingInfo(packingInfo, packingInfo.getLan().toLowerCase()).stream()
                .filter(f -> !FwUtils.isNullOrEmpty(f.getSn()))
                .sorted(Comparator.comparing(ZVwShopOrderPackingInfo::getSn))
                .collect(Collectors.toList());
    }

    @Override
    public List<Map<String, String>> retrieve( PackingInfo packingInfo ) {
        String site = packingInfo.getSite();
        String shopOrderBo = new ShopOrderBOHandle(site, packingInfo.getShopOrder()).getValue();

        CustomFields customFields = customFieldsRepo.findCustomFields(shopOrderBo, "AUART");
        if (FwUtils.objIsEmpty(customFields) || !"Z512".equals(customFields.getValue())) {
            FwUtils.getCustomException("report.error2");
        }

        List<ZVwShopOrderPackingInfo> list =
                shippingReportRepository.getShippingInfo(this.setPackingInfo(packingInfo), packingInfo.getLan().toLowerCase()).stream()
                        .filter(f -> !FwUtils.isNullOrEmpty(f.getSn()))
                        .collect(Collectors.toList());

        if (FwUtils.isEmpty(list)) {
            FwUtils.getCustomException("report.error1");
        }

        String item = list.get(0).getItem();
        // 取得包裝工單檢驗項目
        List<ZPackInspecItem> inspecItemList = this.getPackInspecItemList(site, item);

        List<SnInfo> snInfoList = new ArrayList<>();
        for (ZVwShopOrderPackingInfo obj : list) {
            String sn = obj.getSn();

            // 找新舊SN
            ZSfcSnRelation sfcSnRelation = new ZSfcSnRelation();
            sfcSnRelation.setSite(site);
            sfcSnRelation.setNewSn(sn);
            List<ZSfcSnRelation> snRelationList = shippingReportRepository.getSn(sfcSnRelation);

            String oldSn = "";
            if (!FwUtils.isEmpty(snRelationList)) {
                oldSn = snRelationList.get(0).getSn();
            }

            // 放入新舊SN對應
            SnInfo snInfo = new SnInfo();
            snInfo.setNewSn(sn);
            snInfo.setOldSn(oldSn);
            snInfoList.add(snInfo);
        }

        if (FwUtils.isEmpty(inspecItemList)) {
            FwUtils.getCustomException("report.error1");
        }

        // 過濾重複檢驗項目
        inspecItemList = inspecItemList.stream()
                .filter(FwUtils.distinctByKey(ZPackInspecItem::getQcItemSid))
                .collect(Collectors.toList());

        Map<String, Map<String, List<ShippingInfo>>> allMap = new HashMap<>();
        // 取得檢驗結果
        for (SnInfo sn : snInfoList) {
            String newSn = sn.getNewSn();
            String oldSn = sn.getOldSn();

            inspecItemList.forEach(inspecItem -> {
                // 取得新SN檢驗結果
                ZVwQmsInspecJobResult newSnResult = this.getInspecResult(site, newSn, inspecItem.getQcItemSid());
                Date newSnInspecDate = null;
                if (!FwUtils.objIsEmpty(newSnResult)) {
                    newSnInspecDate = newSnResult.getInspecDateTime();
                }

                // 取得舊SN檢驗結果
                ZVwQmsInspecJobResult oldSnResult = this.getInspecResult(site, oldSn, inspecItem.getQcItemSid());
                Date oldSnInspecDate = null;
                if (!FwUtils.objIsEmpty(oldSnResult)) {
                    oldSnInspecDate = oldSnResult.getInspecDateTime();
                }

                ZVwQmsInspecJobResult result = null;
                // 取得最新的檢驗結果
                if (!FwUtils.objIsEmpty(newSnInspecDate) && !FwUtils.objIsEmpty(oldSnInspecDate)) {
                    if (newSnInspecDate.compareTo(oldSnInspecDate) > 0) {
                        result = newSnResult;
                    } else if (newSnInspecDate.compareTo(oldSnInspecDate) < 0) {
                        result = oldSnResult;
                    }
                } else {
                    if (!FwUtils.objIsEmpty(newSnInspecDate)) {
                        result = newSnResult;
                    }

                    if (!FwUtils.objIsEmpty(oldSnInspecDate)) {
                        result = oldSnResult;
                    }
                }

                if (!FwUtils.objIsEmpty(result)) {
                    // 檢驗類型
                    String itemType = result.getItemType();

                    // 只找計量
                    if ("1".equals(itemType)) {
                        // 檢驗項目
                        String qcItem = result.getQcItem();
                        // 檢驗計畫
                        String[] qcPlanDetailArr = result.getQcPlanDetailBo().split("QCPlanBO");
                        String[] qcPlanArr = qcPlanDetailArr[1].split(",");
                        String qcPlan = qcPlanArr[1];
                        // 取得檢驗任務作業站
                        ZVwQmsInspecJob qmsInspecJob = inspecRepository.getInspecJob(result.getInspecJobBo());
                        String operation = qmsInspecJob.getOperation();

                        // 依照檢驗時間最大的JOB_DETAIL_BO重檢索取得SN檢驗結果
                        ZVwQmsInspecJobResult inspecJobResult = new ZVwQmsInspecJobResult();
                        inspecJobResult.setSite(site);
                        inspecJobResult.setSn(result.getSn());
                        inspecJobResult.setQcItemSid(result.getQcItemSid());
                        inspecJobResult.setHandle(result.getHandle());
                        List<ZVwQmsInspecJobResult> results = inspecRepository.getInspecDetail(inspecJobResult);

                        results.forEach(res -> {
                            BigDecimal maxValue = !FwUtils.objIsEmpty(res.getMaxValue()) ? res.getMaxValue() : BigDecimal.ZERO;
                            BigDecimal minValue = !FwUtils.objIsEmpty(res.getMinValue()) ? res.getMinValue() : BigDecimal.ZERO;
                            BigDecimal center = !FwUtils.objIsEmpty(res.getCenterValue()) ? res.getCenterValue() : null;
                            String memo = res.getMemo();
                            short points = res.getSeries();
                            String inspecResult = res.getInspecResult().stripTrailingZeros().toPlainString();

                            ShippingInfo shippingInfo = new ShippingInfo();
                            shippingInfo.setQcPlan(qcPlan);
                            shippingInfo.setQcItem(qcItem);
                            shippingInfo.setSn(newSn);
                            shippingInfo.setResult(inspecResult);
                            shippingInfo.setCenterValue(center);
                            shippingInfo.setMaxValue(maxValue);
                            shippingInfo.setMinValue(minValue);
                            if (!FwUtils.objIsEmpty(center)) {
                                shippingInfo.setMaxTol(maxValue.add(center));
                                shippingInfo.setMinTol(center.subtract(minValue));
                            }
                            shippingInfo.setOperation(operation);
                            shippingInfo.setMemo(memo);
                            shippingInfo.setPoints(points);

                            // 放入Map
                            String no = this.getNo(shippingInfo);
                            if (FwUtils.objIsEmpty(allMap.get(qcPlan))) {
                                List<ShippingInfo> infos = new ArrayList<>();
                                infos.add(shippingInfo);

                                Map<String, List<ShippingInfo>> itemMap = new HashMap<>();
                                itemMap.put(no, infos);

                                allMap.put(qcPlan, itemMap);
                            } else {
                                if (!FwUtils.isEmpty(allMap.get(qcPlan).get(no))) {
                                    allMap.get(qcPlan).get(no).add(shippingInfo);
                                } else {
                                    List<ShippingInfo> infos = new ArrayList<>();
                                    infos.add(shippingInfo);

                                    allMap.get(qcPlan).put(no, infos);
                                }
                            }
                        });
                    }
                }
            });
        }

        if (allMap.isEmpty()) {
            FwUtils.getCustomException("report.error1");
        }

        List<Map<String, String>> aList = new ArrayList<>();
        // 前7行
        Map<String, String> itemMap = new HashMap<>();
        itemMap.put("key", "Item");
        Map<String, String> noMap = new HashMap<>();
        noMap.put("key", "NO");
        Map<String, String> centerMap = new HashMap<>();
        centerMap.put("key", "Specification Value");
        Map<String, String> maxTolMap = new HashMap<>();
        maxTolMap.put("key", "+TOL");
        Map<String, String> minTolMap = new HashMap<>();
        minTolMap.put("key", "-TOL");
        Map<String, String> maxMap = new HashMap<>();
        maxMap.put("key", "USL");
        Map<String, String> minMap = new HashMap<>();
        minMap.put("key", "LSL");

        AtomicInteger i = new AtomicInteger();
        // 依照檢驗計畫排序
        allMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()).forEach(m1 -> {
                    String qcPlan = m1.getKey();
                    // 依照檢驗項目排序
                    m1.getValue().entrySet().stream()
                            .sorted(Map.Entry.comparingByKey())
                            .forEach(m2 -> {
                                // 放置前七行
                                String qcItem = m2.getKey();
                                ShippingInfo shippingInfo = m2.getValue().get(0);

                                String key = "key" + i.incrementAndGet();
                                itemMap.put(key, qcPlan);
                                noMap.put(key, qcItem);
                                centerMap.put(key, !FwUtils.objIsEmpty(shippingInfo.getCenterValue()) ? shippingInfo.getCenterValue().stripTrailingZeros().toPlainString() : "");
                                maxTolMap.put(key, !FwUtils.objIsEmpty(shippingInfo.getMaxTol()) ? shippingInfo.getMaxTol().stripTrailingZeros().toPlainString() : "NA");
                                minTolMap.put(key, !FwUtils.objIsEmpty(shippingInfo.getMinTol()) ? shippingInfo.getMinTol().stripTrailingZeros().toPlainString() : "NA");
                                maxMap.put(key, shippingInfo.getMaxValue().stripTrailingZeros().toPlainString());
                                minMap.put(key, shippingInfo.getMinValue().stripTrailingZeros().toPlainString());
                            });
                });

        aList.add(itemMap);
        aList.add(noMap);
        aList.add(centerMap);
        aList.add(maxTolMap);
        aList.add(minTolMap);
        aList.add(maxMap);
        aList.add(minMap);

        // 整理SN資訊
        Map<String, Map<String, String>> allSnMap = new HashMap<>();
        itemMap.forEach(( k1, v1 ) -> {
            // v1:檢驗項目
            if (!"key".equals(k1)) {
                String qcItem = noMap.get(k1);
                // 取得檢驗項目底下的SN
                List<ShippingInfo> infos = allMap.get(v1).get(qcItem);

                infos.forEach(sn -> {
                    String s = sn.getSn();
                    if (FwUtils.objIsEmpty(allSnMap.get(s))) {
                        Map<String, String> snMap = new HashMap<>();
                        snMap.put(k1, sn.getResult());

                        allSnMap.put(s, snMap);
                    } else {
                        allSnMap.get(s).put(k1, sn.getResult());
                    }
                });
            }
        });

        // 排序SN
        allSnMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(map -> {
                    Map<String, String> snResult = new HashMap<>();
                    snResult.put("key", map.getKey());
                    snResult.putAll(map.getValue());
                    aList.add(snResult);
                });

        return aList;
    }

    @Override
    public byte[] readExcel( List<Map<String, String>> maps ) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            String path = Objects.requireNonNull(this.getClass().getClassLoader().getResource("DeliveryReport.xlsx")).getPath();
            File file = new File(path);
            String tempPath = Objects.requireNonNull(this.getClass().getClassLoader().getResource("TempDeliveryReport.xlsx")).getPath();
            File tempFile = new File(tempPath);
            tempFile.delete();
            Files.copy(file.toPath(), tempFile.toPath());

            Workbook wb = WorkbookFactory.create(tempFile);
            // 開啟Excel時計算公式
            wb.setForceFormulaRecalculation(true);

            // 取得sheet
            Sheet sheet = wb.getSheet("Delivery Report");

            // 取所有key*,不包含key
            List<String> keys = new ArrayList<>(maps.get(0).keySet()).stream()
                    .filter(str -> !"key".equals(str))
                    .sorted()
                    .collect(Collectors.toList());

            int row10 = 9;
            int row22 = 21;

            int cellA = 0;
            int cellC = 2;

            // 前7行
            for (int i = 0; i < 7; i++) {
                Map<String, String> m = maps.get(i);

                Row row = sheet.getRow(row10 + i);

                for (int k = 0; k < keys.size(); k++) {
                    String key = "key" + (k + 1);
                    String value = m.getOrDefault(key, "");
                    Cell cell = row.getCell(cellC + k);
                    if (i <= 1) {
                        cell.setCellValue(value);
                    } else {
                        if (!FwUtils.isNullOrEmpty(value) && !"NA".equals(value)) {
                            cell.setCellValue(new BigDecimal(value).doubleValue());
                        } else {
                            cell.setCellValue(value);
                        }
                    }
                }
            }

            // SN Loop
            int k = 0;
            for (int i = 7; i < maps.size(); i++) {
                Map<String, String> m = maps.get(i);

                // 寫入SN
                Row row = sheet.getRow(row22 + k);
                row.getCell(cellA).setCellValue(m.get("key"));

                for (int x = 0; x < keys.size(); x++) {
                    String key = "key" + (x + 1);
                    String value = m.getOrDefault(key, "");
                    if (!FwUtils.isNullOrEmpty(value)) {
                        row.getCell(cellC + x).setCellValue(new BigDecimal(value).doubleValue());
                    }
                }
                k++;
            }

            wb.write(bos);
            bos.close();
            wb.close();
        } catch (IOException e) {
            FwUtils.getCustomException("message", new Object[]{ e.getMessage() });
        }

        return Base64.getEncoder().encode(bos.toByteArray());
    }

    private PackingInfo setPackingInfo( PackingInfo packingInfo ) {
        String timeZone = siteRepo.getTimeZone(packingInfo.getSite());
        String start = packingInfo.getPlanStartDate();
        String end = packingInfo.getPlanEndDate();

        if (!FwUtils.isNullOrEmpty(start)) {
            packingInfo.setPlannedStartDate(DateUtil.toGmtDate(start, timeZone));
        }

        if (!FwUtils.isNullOrEmpty(end)) {
            packingInfo.setPlannedCompDate(DateUtil.toGmtDate(end, timeZone));
        }

        return packingInfo;
    }

    private List<ZPackInspecItem> getPackInspecItemList( String site, String item ) {
        ZPackInspecItem packInspecItem = new ZPackInspecItem();
        packInspecItem.setSite(site);
        packInspecItem.setItem(item);
        return packagingProductRepository.getPackInspec(packInspecItem);
    }

    private String getNo( ShippingInfo shippingInfo ) {
        return shippingInfo.getOperation() + "-" + shippingInfo.getQcItem() +
                (FwUtils.isNullOrEmpty(shippingInfo.getMemo()) ? "" : "-" + shippingInfo.getMemo());
    }

    private ZVwQmsInspecJobResult getInspecResult( String site, String sn, String qcItemSid ) {
        if (!FwUtils.isNullOrEmpty(sn)) {
            ZVwQmsInspecJobResult snResult = new ZVwQmsInspecJobResult();
            snResult.setSite(site);
            snResult.setSn(sn);
            snResult.setQcItemSid(qcItemSid);
            List<ZVwQmsInspecJobResult> results = inspecRepository.getInspecDetail(snResult);
            return !FwUtils.isEmpty(results) ? results.get(0) : null;
        }

        return null;
    }
}
