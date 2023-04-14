package com.att.service.impl;

import com.att.domain.yield.YieldDetailInfo;
import com.att.domain.yield.YieldRateRequest;
import com.att.repository.YieldRateRepository;
import com.att.repository.entity.ZMaterialYieldBasis;
import com.att.repository.entity.ZVwMaterialYieldItemDesc;
import com.att.repository.entity.ZVwYieldBasisRouter;
import com.att.repository.entity.ZVwYieldRouter;
import com.att.service.YieldRateService;
import com.fw.mes.me.controller.item.ItemRepo;
import com.fw.mes.me.controller.router.RouterRepo;
import com.fw.mes.me.entity.Router;
import com.fw.mes.me.entity.ViewRouterStepOperation;
import com.fw.mes.util.DateUtil;
import com.fw.mes.util.FwUtils;
import com.sap.me.productdefinition.OperationBOHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class YieldRateServiceImpl implements YieldRateService {

    @Autowired
    private YieldRateRepository yieldRateRepository;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private RouterRepo routerRepo;

    @Override
    public List<ZVwMaterialYieldItemDesc> getMaterialDesc( String site, String item, String locale ) {
        return yieldRateRepository.getMaterialDesc(site, item, locale);
    }

    @Override
    public List<ZVwYieldBasisRouter> getYieldRouter( String site, String item, String router ) {
        ZVwYieldBasisRouter zVwYieldBasisRouter = new ZVwYieldBasisRouter();
        zVwYieldBasisRouter.setSite(site);
        zVwYieldBasisRouter.setItem(item);
        zVwYieldBasisRouter.setRouter(router);

        List<ZVwYieldBasisRouter> list = yieldRateRepository.getYieldRouter(zVwYieldBasisRouter);

        if (FwUtils.isEmpty(list)) {
            FwUtils.getCustomException("yield.error9");
        }

        return list;
    }

    @Override
    public List<ZVwYieldRouter> getMaterialYield( YieldRateRequest yieldRateRequest ) {
        String site = yieldRateRequest.getSite();
        String locale = yieldRateRequest.getLan().toLowerCase();
        String item = yieldRateRequest.getItem();
        String router = yieldRateRequest.getRouter();

        ZMaterialYieldBasis zMaterialYieldBasis = new ZMaterialYieldBasis();
        zMaterialYieldBasis.setSite(site);
        zMaterialYieldBasis.setItem(item);
        zMaterialYieldBasis.setRouter(router);

        if (FwUtils.isEmpty(yieldRateRepository.getMaterialYield(zMaterialYieldBasis))) {
            if (FwUtils.isNullOrEmpty(router)) {
                FwUtils.getCustomException("yield.error1");
            }
            FwUtils.getCustomException("yield.error2");
        }

        ZVwYieldRouter zVwYieldRouter = new ZVwYieldRouter();
        zVwYieldRouter.setSite(site);
        zVwYieldRouter.setItem(item);
        zVwYieldRouter.setRouter(router);

        List<ZVwYieldRouter> list = yieldRateRepository.getYieldInfo(locale, zVwYieldRouter);

        if (FwUtils.isEmpty(list)) {
            FwUtils.getCustomException("yield.error3");
        }

        return list;
    }

    @Transactional
    @Override
    public void importYield( YieldRateRequest yieldRateRequest ) {
        String site = yieldRateRequest.getSite();
        String user = yieldRateRequest.getUser();
        String item = yieldRateRequest.getItem();
        List<YieldDetailInfo> detailInfoList = yieldRateRequest.getDetailInfoList();

        if (FwUtils.objIsEmpty(itemRepo.findByItem(site, item, ""))) {
            FwUtils.getCustomException("yield.error4", new Object[]{ item });
        }

        // 檢查重複
        Map<String, List<YieldDetailInfo>> checkRepeat = detailInfoList.stream()
                .collect(Collectors.groupingBy(this::fetchKey));
        checkRepeat.forEach(( k, v ) -> {
            if (!FwUtils.isEmpty(v) && v.size() > 1) {
                String[] key = k.split("\\^");
                FwUtils.getCustomException("yield.error10", new Object[]{ key[0], key[1], key[2] });
            }
        });

        // 刪除舊資料
        yieldRateRepository.deleteMaterialYield(site, item);

        // 寫入
        for (YieldDetailInfo detail : detailInfoList) {
            String router = detail.getRouter();
            String routerVer = detail.getRouterVer();
            String operation = detail.getOperation();
            BigDecimal yield = detail.getPlanYield();
            BigDecimal labor = detail.getStdLabor();

            if (FwUtils.isNullOrEmpty(router) && FwUtils.isNullOrEmpty(routerVer) && FwUtils.isNullOrEmpty(operation)) {
                continue;
            }

            List<Router> routers = routerRepo.findRouterByRouterAndVer(site, router, routerVer);
            if (FwUtils.isEmpty(routers)) {
                FwUtils.getCustomException("yield.error5", new Object[]{ router, routerVer });
            }

            List<ViewRouterStepOperation> stepOperations = routerRepo.getRouterOperation(site, router, routerVer);
            stepOperations = stepOperations.stream()
                    .filter(f -> {
                        String stepOperation = new OperationBOHandle(f.getOperationBo()).getOperation();
                        return stepOperation.equals(operation);
                    })
                    .collect(Collectors.toList());

            if (FwUtils.isEmpty(stepOperations)) {
                FwUtils.getCustomException("yield.error6", new Object[]{ router, routerVer, operation });
            }

            if (yield != null && yield.compareTo(BigDecimal.ZERO) <= 0) {
                FwUtils.getCustomException("yield.error7", new Object[]{ router, routerVer, operation });
            }

            if (labor != null && labor.compareTo(BigDecimal.ZERO) <= 0) {
                FwUtils.getCustomException("yield.error8", new Object[]{ router, routerVer, operation });
            }

            ZMaterialYieldBasis zMaterialYieldBasis = new ZMaterialYieldBasis();
            zMaterialYieldBasis.setSid(FwUtils.getUid());
            zMaterialYieldBasis.setSite(site);
            zMaterialYieldBasis.setItem(item);
            zMaterialYieldBasis.setRouter(router);
            zMaterialYieldBasis.setRouterRevision(routerVer);
            zMaterialYieldBasis.setOperation(operation);
            if (yield != null) {
                zMaterialYieldBasis.setPlanYield(yield.setScale(2, BigDecimal.ROUND_DOWN));
            }
            if (labor != null) {
                zMaterialYieldBasis.setStdLabor(labor.setScale(2, BigDecimal.ROUND_DOWN));
            }
            zMaterialYieldBasis.setCreatedDateTime(DateUtil.getGmtTime());
            zMaterialYieldBasis.setCreatedUser(user);

            yieldRateRepository.insertMaterialYield(zMaterialYieldBasis);
        }
    }

    private String fetchKey( YieldDetailInfo yieldDetailInfo ) {
        return yieldDetailInfo.getRouter() + "^" + yieldDetailInfo.getRouterVer() + "^" + yieldDetailInfo.getOperation();
    }
}
