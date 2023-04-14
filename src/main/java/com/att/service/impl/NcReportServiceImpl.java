package com.att.service.impl;

import com.att.converent.NcConverter;
import com.att.domain.nc.*;
import com.att.repository.NcReportRepository;
import com.att.repository.entity.ZSfcNcData;
import com.att.repository.entity.ZVwSfcNcData;
import com.att.service.NcReportService;
import com.fw.mes.me.controller.dataField.FwDataFieldRepo;
import com.fw.mes.me.controller.item.ItemRepo;
import com.fw.mes.me.controller.ncCode.FwNcCodeRepo;
import com.fw.mes.me.controller.operation.OperationRepo;
import com.fw.mes.me.controller.site.SiteRepo;
import com.fw.mes.me.entity.ViewDataFieldList;
import com.fw.mes.me.entity.ViewItemDesc;
import com.fw.mes.util.DateUtil;
import com.fw.mes.util.FwUtils;
import com.sap.me.user.UserBOHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NcReportServiceImpl implements NcReportService {

    @Autowired
    private NcReportRepository ncReportRepository;

    @Autowired
    private SiteRepo siteRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private OperationRepo operationRepo;

    @Autowired
    private FwNcCodeRepo fwNcCodeRepo;

    @Autowired
    private FwDataFieldRepo fwDataFieldRepo;

    @Override
    public List<SfcNcDataInfo> getSfcNcData( NcReportRequest ncReportRequest ) {
        String site = ncReportRequest.getSite();
        String locale = ncReportRequest.getLan().toLowerCase();
        String timeZone = siteRepo.getTimeZone(site);
        String start = ncReportRequest.getStartDateTime();
        String end = ncReportRequest.getEndDateTime();

        if (!FwUtils.isNullOrEmpty(start)) {
            ncReportRequest.setStart(DateUtil.toGmtDate(start, timeZone));
        }

        if (!FwUtils.isNullOrEmpty(end)) {
            ncReportRequest.setEnd(DateUtil.toGmtDate(end, timeZone));
        }

        return ncReportRepository.getSfcNcData(locale, ncReportRequest).stream()
                .map(obj -> {
                    SfcNcDataInfo sfcNcDataInfo = NcConverter.INSTANCE.daoToDomain(obj);

                    String userBo = obj.getUserBo();
                    String user = new UserBOHandle(userBo).getUser();
                    String userName = FwUtils.findUserName(site, user);

                    sfcNcDataInfo.setUser(user);
                    sfcNcDataInfo.setUserName(userName);

                    Date date = obj.getDateTime();
                    String dateTime = DateUtil.toLocalDate(date, timeZone, "yyyy/MM/dd HH:mm");
                    String[] dateTimeSplit = dateTime.split(" ");

                    sfcNcDataInfo.setDate(dateTimeSplit[0]);
                    sfcNcDataInfo.setTime(dateTimeSplit[1]);

                    return sfcNcDataInfo;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<SfcNcDataInfo> getNcShopOrder( NcReportRequest ncReportRequest ) {
        NcReportRequest request = new NcReportRequest();
        request.setSite(ncReportRequest.getSite());
        request.setStart(ncReportRequest.getStart());
        request.setEnd(ncReportRequest.getEnd());
        request.setLan(ncReportRequest.getLan());

        return this.getSfcNcData(request).stream()
                .filter(FwUtils.distinctByKey(ZVwSfcNcData::getShopOrder))
                .map(obj -> {
                    SfcNcDataInfo sfcNcDataInfo = new SfcNcDataInfo();
                    sfcNcDataInfo.setShopOrder(obj.getShopOrder());
                    sfcNcDataInfo.setItem(obj.getItem());
                    sfcNcDataInfo.setItemDesc(obj.getItemDesc());

                    return sfcNcDataInfo;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ViewItemDesc> getItem( String site, String locale ) {
        return itemRepo.currentList(site, locale).stream()
                .filter(f -> {
                    String itemType = f.getItemType();
                    return "M".equals(itemType) || "B".equals(itemType);
                })
                .collect(Collectors.toList());
    }

    @Override
    public NcReportResponse retrieve( NcReportRequest ncReportRequest ) {
        String site = ncReportRequest.getSite();
        String locale = ncReportRequest.getLan().toLowerCase();

        List<SfcNcDataInfo> sfcNcDataInfoList = this.getSfcNcData(ncReportRequest);
        List<SfcNcDataInfo> filters = sfcNcDataInfoList.stream()
                .filter(f -> "false".equals(f.getIsCancelled()))
                .collect(Collectors.toList());
        // 不良數量分布
        List<OperationNcInfo> operationNcInfoList = this.getOperationNcInfo(site, filters, locale);
        // 不良現象趨勢
        List<NcInfo> ncInfoList = this.getNcInfo(site, filters);

        NcReportResponse response = new NcReportResponse();
        response.setSfcNcDataInfoList(sfcNcDataInfoList);
        response.setOperationNcInfoList(operationNcInfoList);
        response.setNcInfoList(ncInfoList);

        return response;
    }

    @Override
    public String getUserName( String site, String user ) {
        return FwUtils.findUserName(site, user);
    }

    @Override
    public void updateSfcNcData( NcReportRequest request ) {
        String timeZone = siteRepo.getTimeZone(request.getSite());

        ZSfcNcData zSfcNcData = new ZSfcNcData();
        zSfcNcData.setSid(request.getSid());
        zSfcNcData.setIsCancelled(request.getIsCancelled());
        zSfcNcData.setCancelledUserBo(new UserBOHandle(request.getSite(), request.getUser()).getValue());
        zSfcNcData.setCancelledReason(request.getReason());
        zSfcNcData.setCancelledDateTime(DateUtil.toGmtDate(request.getExecuteTime(), timeZone));
        ncReportRepository.updateSfcNcData(zSfcNcData);
    }

    private List<String> getFieldList( String site, String dataFiled, String locale ) {
        ViewDataFieldList dataFieldList = new ViewDataFieldList();
        dataFieldList.setSite(site);
        dataFieldList.setDataField(dataFiled);

        return fwDataFieldRepo.getDataFiledList(dataFieldList, locale).stream()
                .map(ViewDataFieldList::getDataValue)
                .collect(Collectors.toList());
    }

    private List<OperationNcInfo> getOperationNcInfo( String site, List<SfcNcDataInfo> sfcNcDataInfoList, String locale ) {
        List<String> reworkList = this.getFieldList(site, "REWORK_CODE", locale);

        Map<String, List<ZVwSfcNcData>> operationMap = sfcNcDataInfoList.stream()
                .collect(Collectors.groupingBy(ZVwSfcNcData::getOperation));

        List<OperationNcInfo> operationNcInfoList = new ArrayList<>();
        operationMap.forEach(( k, v ) -> {
            OperationNcInfo operationNcInfo = new OperationNcInfo();
            operationNcInfo.setOperation(k);

            operationNcInfo.setReworkQty(v.stream()
                                                 .filter(f -> reworkList.contains(f.getActionCode()))
                                                 .map(ZVwSfcNcData::getNcQty)
                                                 .reduce(BigDecimal.ZERO, BigDecimal::add));

            operationNcInfo.setScrapQty(v.stream()
                                                .filter(f -> "SCRAP".equals(f.getActionCode()))
                                                .map(ZVwSfcNcData::getNcQty)
                                                .reduce(BigDecimal.ZERO, BigDecimal::add));
            operationNcInfoList.add(operationNcInfo);
        });

        return operationNcInfoList;
    }

    private List<NcInfo> getNcInfo( String site, List<SfcNcDataInfo> sfcNcDataInfoList ) {
        Map<String, List<ZVwSfcNcData>> ncMap = sfcNcDataInfoList.stream()
                .collect(Collectors.groupingBy(ZVwSfcNcData::getNcCode));

        List<NcInfo> ncInfoList = new ArrayList<>();
        ncMap.forEach(( k, v ) -> {
            NcInfo ncInfo = new NcInfo();
            ncInfo.setNcCode(k);
            ncInfo.setNcQty(v.stream()
                                    .map(ZVwSfcNcData::getNcQty)
                                    .reduce(BigDecimal.ZERO, BigDecimal::add));
            ncInfoList.add(ncInfo);
        });

        return ncInfoList;
    }
}
