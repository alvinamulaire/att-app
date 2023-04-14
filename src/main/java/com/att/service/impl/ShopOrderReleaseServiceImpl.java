package com.att.service.impl;

import com.att.converent.SoReleaseConverter;
import com.att.domain.print.RunCardRequest;
import com.att.domain.shopOrder.SoCustomRequest;
import com.att.domain.soRelease.ReleaseSfcResponse;
import com.att.domain.soRelease.SoCustom;
import com.att.domain.soRelease.SoInfo;
import com.att.repository.ShopOrderReleaseRepository;
import com.att.repository.entity.ZVwBomComponent;
import com.att.repository.entity.ZVwSoCustom;
import com.att.service.ShopOrderReleaseService;
import com.fw.mes.me.controller.document.DocumentRepo;
import com.fw.mes.me.controller.item.ItemRepo;
import com.fw.mes.me.controller.operation.OperationRepo;
import com.fw.mes.me.controller.site.SiteRepo;
import com.fw.mes.me.controller.usr.FwUsrRepo;
import com.fw.mes.me.entity.Item;
import com.fw.mes.me.entity.UserPreferences;
import com.fw.mes.me.entity.ViewDocumentLink;
import com.fw.mes.me.entity.ViewOperationDesc;
import com.fw.mes.util.DateUtil;
import com.fw.mes.util.FwUtils;
import com.sap.me.demand.*;
import com.sap.me.document.*;
import com.sap.me.extension.Services;
import com.sap.me.frame.domain.BusinessException;
import com.sap.me.productdefinition.BOMBOHandle;
import com.sap.me.productdefinition.ItemBOHandle;
import com.sap.me.productdefinition.OperationBOHandle;
import com.sap.me.productdefinition.RouterBOHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopOrderReleaseServiceImpl implements ShopOrderReleaseService {

    private final Logger logger = LoggerFactory.getLogger(ShopOrderReleaseServiceImpl.class);

    @Autowired
    private SiteRepo siteRepo;

    @Autowired
    private ShopOrderReleaseRepository shopOrderReleaseRepository;

    @Autowired
    private OperationRepo operationRepo;

    @Autowired
    private DocumentRepo documentRepo;

    @Autowired
    private FwUsrRepo fwUsrRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public SoCustom getReleaseSo( SoInfo soInfo ) {
        String site = soInfo.getSite();
        String so = soInfo.getSo();
        String timeZone = siteRepo.getTimeZone(site);

        if (FwUtils.isNullOrEmpty(so)) {
            FwUtils.getCustomException("so.release.error1");
        }

        SoCustomRequest zVwSoCustom = new SoCustomRequest();
        zVwSoCustom.setSite(site);
        zVwSoCustom.setShopOrder(so);
        List<ZVwSoCustom> soList = shopOrderReleaseRepository.getSoReleaseDesc(soInfo.getLan().toLowerCase(), zVwSoCustom);

        if (FwUtils.isEmpty(soList)) {
            FwUtils.getCustomException("so.release.error2");
        }

        ZVwSoCustom vwSoCustom = soList.get(0);
        SoCustom soCustom = SoReleaseConverter.INSTANCE.daoToDomain(vwSoCustom);
        if (!soCustom.getStatus().equals("501")) {
            FwUtils.getCustomException("so.release.error3");
        }

        if (FwUtils.objIsEmpty(soCustom.getReleaseQty()) || soCustom.getReleaseQty().compareTo(BigDecimal.ZERO) <= 0) {
            FwUtils.getCustomException("so.release.error4");
        }

        soCustom.setBom(new BOMBOHandle(vwSoCustom.getBomBo()).getBOM());
        soCustom.setBomVer(vwSoCustom.getBomRevision());
        if (FwUtils.isNullOrEmpty(vwSoCustom.getBomBo()) && !FwUtils.isNullOrEmpty(vwSoCustom.getPlannedBomBo())) {
            soCustom.setBom(new BOMBOHandle(vwSoCustom.getPlannedBomBo()).getBOM());
            soCustom.setBomVer(vwSoCustom.getPlannedBomRevision());
        } else if (FwUtils.isNullOrEmpty(vwSoCustom.getBomBo()) && FwUtils.isNullOrEmpty(vwSoCustom.getPlannedBomBo())) {
            soCustom.setBom(vwSoCustom.getPlannedItemBom());
            soCustom.setBomVer(vwSoCustom.getPlannedItemBomRevision());
        }

        soCustom.setRouter(new RouterBOHandle(vwSoCustom.getRouterBo()).getRouter());
        soCustom.setRouterVer(vwSoCustom.getRouterRevision());
        if (FwUtils.isNullOrEmpty(vwSoCustom.getRouterBo()) && !FwUtils.isNullOrEmpty(vwSoCustom.getPlannedRouterBo())) {
            soCustom.setRouter(new RouterBOHandle(vwSoCustom.getPlannedRouterBo()).getRouter());
            soCustom.setRouterVer(vwSoCustom.getPlannedRouterRevision());
        } else if (FwUtils.isNullOrEmpty(vwSoCustom.getRouterBo()) && FwUtils.isNullOrEmpty(vwSoCustom.getPlannedRouterBo())) {
            soCustom.setRouter(vwSoCustom.getPlannedItemRouter());
            soCustom.setRouterVer(vwSoCustom.getPlannedItemRouterRevision());
        }

        soCustom.setPlannedStartDateStr(DateUtil.toLocalDate(soCustom.getPlannedStartDate(), timeZone));
        soCustom.setPlannedCompDateStr(DateUtil.toLocalDate(soCustom.getPlannedCompDate(), timeZone));

        return soCustom;
    }

    @Override
    public List<SoCustom> getSo( SoInfo soInfo ) {
        String site = soInfo.getSite();

        SoCustomRequest zVwSoCustom = new SoCustomRequest();
        zVwSoCustom.setSite(site);
        zVwSoCustom.setShopOrder(soInfo.getSo());
        zVwSoCustom.setStatus("501");
        List<ZVwSoCustom> soList = shopOrderReleaseRepository.getSoReleaseDesc(soInfo.getLan().toLowerCase(), zVwSoCustom);

        return soList.stream()
                .filter(f -> !FwUtils.objIsEmpty(f.getReleaseQty()) && f.getReleaseQty().compareTo(BigDecimal.ZERO) > 0)
                .map(SoReleaseConverter.INSTANCE::daoToDomain)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<ReleaseSfcResponse> release( SoCustom soCustom ) {
        String site = soCustom.getSite();
        String user = soCustom.getUser();
        String so = soCustom.getShopOrder();
        String soBo = new ShopOrderBOHandle(site, so).getValue();
        String item = soCustom.getPlannedItem();
        String itemVer = soCustom.getItemVer();
        BigDecimal lotSize = soCustom.getLotSize();
        String bom = soCustom.getBom();
        String bomVer = soCustom.getBomVer();
        String router = soCustom.getRouter();
        String routerVer = soCustom.getRouterVer();
        BigDecimal releaseQty = soCustom.getReleaseQty();

        String locale = soCustom.getLan().toLowerCase();

        SoCustomRequest zVwSoCustom = new SoCustomRequest();
        zVwSoCustom.setSite(site);
        zVwSoCustom.setShopOrder(so);
        List<ZVwSoCustom> soList = shopOrderReleaseRepository.getSoReleaseDesc(soCustom.getLan().toLowerCase(), zVwSoCustom);
        if (!FwUtils.isEmpty(soList)) {
            ZVwSoCustom vwSoCustom = soList.get(0);

            BigDecimal approvedQty = vwSoCustom.getReleaseQty();
            if (releaseQty.compareTo(approvedQty) > 0) {
                FwUtils.getCustomException("so.release.error10");
            }

            if (FwUtils.isNullOrEmpty(item)) {
                FwUtils.getCustomException("so.release.error5");
            }

            if (FwUtils.isNullOrEmpty(bom)) {
                FwUtils.getCustomException("so.release.error6");
            }

            ZVwBomComponent zVwBomComponent = new ZVwBomComponent();
            zVwBomComponent.setSite(site);
            zVwBomComponent.setBom(bom);
            zVwBomComponent.setRevision(bomVer);
            List<ZVwBomComponent> bomComponents = shopOrderReleaseRepository.getBomComponent(zVwBomComponent);
            if (FwUtils.isEmpty(bomComponents)) {
                FwUtils.getCustomException("so.release.error11");
            }

            String bomBo = bomComponents.get(0).getHandle();
            for (ZVwBomComponent bomComponent : bomComponents) {
                if (FwUtils.isNullOrEmpty(bomComponent.getOperationBo())) {
                    FwUtils.getCustomException("so.release.error7");
                }
            }

            if (FwUtils.isNullOrEmpty(router)) {
                FwUtils.getCustomException("so.release.error8");
            }

            if (releaseQty.compareTo(BigDecimal.ZERO) == 0) {
                FwUtils.getCustomException("so.release.error9");
            }

            List<Item> itemInfo = itemRepo.findCurrentItem(site, item);
            if ("W".equals(itemInfo.get(0).getQuantityRestriction())) {
                // 標準批量為正整數
                String release = String.valueOf(releaseQty);
                if (!FwUtils.isNumeric(release)) {
                    // 不是正整數
                    FwUtils.getCustomException("so.release.error13", new Object[]{ item });
                }
            }

            ShopOrderServiceInterface shopOrderService = FwUtils.getService("com.sap.me.demand", "ShopOrderService", user, site);
            try {
                // 核發
                ReleaseShopOrderRequest releaseShopOrderRequest = new ReleaseShopOrderRequest();
                releaseShopOrderRequest.setShopOrderRef(soBo);
                releaseShopOrderRequest.setQuantityToRelease(releaseQty);
                List<SfcIdentifier> newSfcList = new ArrayList<>();

                int lastNo = shopOrderReleaseRepository.getLastSfcSerialNo(site, so);
                while (releaseQty.compareTo(BigDecimal.ZERO) > 0) {
                    ++lastNo;
                    SfcIdentifier sfcIdentifier = new SfcIdentifier();
                    sfcIdentifier.setId(so + "-" + String.format("%02d", lastNo));

                    newSfcList.add(sfcIdentifier);
                    releaseShopOrderRequest.setNewSfcList(newSfcList);

                    if (releaseQty.compareTo(lotSize) > 0) {
                        releaseQty = releaseQty.subtract(lotSize);
                    } else {
                        releaseQty = BigDecimal.ZERO;
                    }
                }

                ReleaseShopOrderResponse releaseShopOrderResponse = shopOrderService.releaseShopOrder(releaseShopOrderRequest);

                List<ReleaseSfcResponse> responses = new ArrayList<>();
                releaseShopOrderResponse.getReleasedSfcList().forEach(sfc -> {
                    ReleaseSfcResponse releaseSfcResponse = new ReleaseSfcResponse();
                    releaseSfcResponse.setShopOrder(so);
                    releaseSfcResponse.setItem(new ItemBOHandle(releaseShopOrderResponse.getItemRef()).getItem());
                    releaseSfcResponse.setRouter(new RouterBOHandle(releaseShopOrderResponse.getRouterRef()).getRouter());
                    releaseSfcResponse.setSfc(new SFCBOHandle(sfc.getSfcRef()).getSFC());
                    releaseSfcResponse.setQty(sfc.getQuantity());
                    String operation = new OperationBOHandle(sfc.getOperationRef()).getOperation();
                    releaseSfcResponse.setOperation(operation);

                    List<ViewOperationDesc> operationList = operationRepo.findByCurrentRevision(site, operation, locale);
                    if (!FwUtils.isEmpty(operationList)) {
                        releaseSfcResponse.setOperationDesc(operationList.get(0).getDescription());
                    }

                    responses.add(releaseSfcResponse);
                });

                return responses;
            } catch (BusinessException e) {
                FwUtils.getMeException(e);
            }
        }
        return new ArrayList<>();
    }

    @Async
    @Override
    public void printRunCard( RunCardRequest runCardRequest ) {
        logger.info("Print run card start");
        String site = runCardRequest.getSite();
        String user = runCardRequest.getUser();
        String itemBo = runCardRequest.getItemBo();
        List<ReleaseSfcResponse> releaseSfcResponses = runCardRequest.getReleaseSfcResponses();

        DocumentPrintServiceInterface documentPrintService = Services.getService("com.sap.me.document", "DocumentPrintService", site);

        ViewDocumentLink viewDocumentLink = new ViewDocumentLink();
        viewDocumentLink.setSite(site);
        viewDocumentLink.setDocContextGbo(itemBo);
        viewDocumentLink.setDocumentTypeBo(new DocumentTypeBOHandle(site, "DOCUMENT").getValue());

        List<ViewDocumentLink> docs = documentRepo.getDocument(viewDocumentLink);
        if (!FwUtils.isEmpty(docs)) {
            UserPreferences userPreferences = fwUsrRepo.findUserPreferences(site, user);

            if (FwUtils.objIsEmpty(userPreferences) || FwUtils.isNullOrEmpty(userPreferences.getDocumentPrinterBo())) {
                logger.info("The user is not equipped with a printer");
                return;
            }

            PrintForSFCRequest printForSFCRequest = new PrintForSFCRequest();
            printForSFCRequest.setAllowAutomaticPrintOnly(false);

            List<DocumentPrintObject> documentList = new ArrayList<>();
            for (ViewDocumentLink doc : docs) {
                DocumentPrintObject documentPrintObject = new DocumentPrintObject();
                // 文件
                documentPrintObject.setDocumentName(doc.getDocument());
                // 列印數量
                documentPrintObject.setPrintQty(doc.getPrintQty());
                // 印表機
                documentPrintObject.setPrinter(new PrinterBOHandle(userPreferences.getDocumentPrinterBo()).getPrinter());
                documentList.add(documentPrintObject);
            }

            List<String> sfcList = releaseSfcResponses.stream()
                    .map(obj -> {
                        return new SFCBOHandle(site, obj.getSfc()).getValue();
                    })
                    .collect(Collectors.toList());

            printForSFCRequest.setDocumentList(documentList);
            printForSFCRequest.setSfcList(sfcList);

            try {
                documentPrintService.printForSFC(printForSFCRequest);
                logger.info("Print run card complete");
            } catch (BusinessException e) {
                logger.info(e.getMessage());
            }
        }
    }
}
