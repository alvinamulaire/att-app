package com.att.nwds.serviceext;

import com.att.nwds.service.AssemblyService;
import com.att.nwds.service.CommonService;
import com.att.nwds.service.domain.BomComponent;
import com.att.nwds.service.domain.InvInfo;
import com.fw.mes.util.FwUtils;
import com.sap.me.activity.ServiceExtension;
import com.sap.me.demand.SFCBOHandle;
import com.sap.me.extension.Services;
import com.sap.me.frame.SystemBase;
import com.sap.me.frame.domain.BusinessException;
import com.sap.me.frame.jdbc.DynamicQuery;
import com.sap.me.frame.jdbc.DynamicQueryFactory;
import com.sap.me.frame.service.CommonMethods;
import com.sap.me.productdefinition.OperationBOHandle;
import com.sap.me.production.*;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ReduceInventoryExtension extends ServiceExtension<Object> {

    private SystemBase base;
    private DynamicQuery dq;
    private AssemblyService assemblyService;
    private SfcStateServiceInterface sfcStateService;

    private CommonService commonService;


    private void init() {
        dq = DynamicQueryFactory.newInstance();
        base = SystemBase.createSystemBase("jdbc/jts/wipPool");
        assemblyService = Services.getService("com.att.service", "AssemblyService");
        sfcStateService = Services.getService("com.sap.me.production", "SfcStateService");
        commonService = Services.getService("com.att.service", "CommonService");
    }

    @Override
    @Transactional
    public void execute( Object request ) throws Exception {
        if (request instanceof CompleteSfcBatchRequest) {
            execute((CompleteSfcBatchRequest) request);
        }
    }

    private void execute( CompleteSfcBatchRequest request ) throws BusinessException, SQLException {
        init();
        String site = CommonMethods.getSite();
        String operationBo = request.getCompleteSfcList().get(0).getOperationRef();
        String resourceBo = request.getCompleteSfcList().get(0).getResourceRef();
        //sfcBo,SfcBasicData
        Map<String, SfcBasicData> sfcBasicDataMap = new HashMap<>();
        //sfcBo,List<BomComponent>
        Map<String, List<BomComponent>> sfcBomComponentMap = new HashMap<>();
        Map<String, Integer> shopOrderBoMap = new HashMap<>();

        String mode = commonService.getSystemConfig(site, "MATERIALS_CONSUME_MODE");

        // 1:依照原邏輯進行扣料, 非1:可混用
        boolean customFlag = "1".equals(mode);

        for (CompleteSfcBasicRequest completeSfcBasicRequest : request.getCompleteSfcList()) {

            FindSfcByNameRequest findSfcByNameRequest = new FindSfcByNameRequest();
            findSfcByNameRequest.setSfc(new SFCBOHandle(completeSfcBasicRequest.getSfcRef()).getSFC());
            SfcBasicData sfcBasicData = sfcStateService.findSfcByName(findSfcByNameRequest);
            sfcBasicDataMap.put(completeSfcBasicRequest.getSfcRef(), sfcBasicData);
            shopOrderBoMap.put(sfcBasicData.getShopOrderRef(), 1);

            sfcBomComponentMap.put(completeSfcBasicRequest.getSfcRef(), commonService.getComponent(completeSfcBasicRequest.getSfcRef(), completeSfcBasicRequest.getOperationRef()));
        }

        //扣料
        for (CompleteSfcBasicRequest completeSfcBasicRequest : request.getCompleteSfcList()) {
            OperationBOHandle operationBOHandle = new OperationBOHandle(completeSfcBasicRequest.getOperationRef());
            SfcBasicData sfcBasicData = sfcBasicDataMap.get(completeSfcBasicRequest.getSfcRef());
            BigDecimal sfcQty = FwUtils.objIsEmpty(completeSfcBasicRequest.getQuantity()) ? findSfcQty(completeSfcBasicRequest.getSfcRef(), new OperationBOHandle(operationBOHandle.getSite(), operationBOHandle.getOperation(), "#").getValue(), completeSfcBasicRequest.getResourceRef()) : completeSfcBasicRequest.getQuantity();
            for (BomComponent bomComponent : sfcBomComponentMap.get(completeSfcBasicRequest.getSfcRef())) {
                // sfc.qty * 標準量
                BigDecimal total = sfcQty.multiply(bomComponent.getQty());
                boolean haveLocation = FwUtils.isNullOrEmpty(bomComponent.getLocation());

                //撈庫存
                InvInfo invInfo = new InvInfo();
                invInfo.setSite(site);
                invInfo.setShopOrderBoList(new ArrayList<>(shopOrderBoMap.keySet()));
                invInfo.setResourceBo(resourceBo);
                invInfo.setResourceLocRes(true);
                invInfo.setComponentList(Collections.singletonList(bomComponent.getItemBo()));
                List<InvInfo> invList = commonService.getInventoryList(invInfo);

                invInfo.setComponentList(bomComponent.getAlternateItemBoList());

                List<InvInfo> alternateInvList = commonService.getInventoryList(invInfo);

                //主料
                if (!FwUtils.isEmpty(invList)) {
                    for (InvInfo inv : invList) {
                        // 扣完料, break
                        if (total.compareTo(BigDecimal.ZERO) == 0) {
                            break;
                        }
                        // 庫存數=0, continue
                        if (inv.getSupplyQty().compareTo(BigDecimal.ZERO) == 0) {
                            continue;
                        }

                        if (customFlag) {
                            // 依照原本邏輯扣料
                            if (haveLocation) {
                                //沒有值：
                                //庫存資訊的現場訂單等於出站SFC的現場訂單
                                if (sfcBasicData.getShopOrderRef().equals(inv.getShopOrderBo())) {
                                    if (total.compareTo(inv.getSupplyQty()) > 0) {
                                        // 需求 > 庫存
                                        assemblyService.assembly(sfcBasicData.getSfcRef(), inv.getInventoryId(), inv.getItemBo(), bomComponent.getComponentBo(), operationBo, resourceBo, inv.getSupplyQty());
                                        total = total.subtract(inv.getSupplyQty());
                                        inv.setSupplyQty(BigDecimal.ZERO);
                                    } else {
                                        // 需求 < 庫存
                                        assemblyService.assembly(sfcBasicData.getSfcRef(), inv.getInventoryId(), inv.getItemBo(), bomComponent.getComponentBo(), operationBo, resourceBo, total);
                                        inv.setSupplyQty(inv.getSupplyQty().subtract(total));
                                        total = BigDecimal.ZERO;
                                    }
                                }
                            }else{
                                //工單一致 或 工單為空
                                if (sfcBasicData.getShopOrderRef().equals(inv.getShopOrderBo()) || FwUtils.isNullOrEmpty(inv.getShopOrderBo())) {
                                    // 庫存地點相同
                                    if (!FwUtils.isNullOrEmpty(inv.getStorageLocation()) && inv.getStorageLocation().equals(bomComponent.getLocation())) {
                                        if (total.compareTo(inv.getSupplyQty()) > 0) {
                                            // 需求 > 庫存
                                            assemblyService.assembly(sfcBasicData.getSfcRef(), inv.getInventoryId(), inv.getItemBo(), bomComponent.getComponentBo(), operationBo, resourceBo, inv.getSupplyQty());
                                            total = total.subtract(inv.getSupplyQty());
                                            inv.setSupplyQty(BigDecimal.ZERO);
                                        } else {
                                            // 需求 < 庫存
                                            assemblyService.assembly(sfcBasicData.getSfcRef(), inv.getInventoryId(), inv.getItemBo(), bomComponent.getComponentBo(), operationBo, resourceBo, total);
                                            inv.setSupplyQty(inv.getSupplyQty().subtract(total));
                                            total = BigDecimal.ZERO;
                                        }
                                    }
                                }
                            }
                        } else {
                            // 混用
                            if (total.compareTo(inv.getSupplyQty()) > 0) {
                                // 需求 > 庫存
                                assemblyService.assembly(sfcBasicData.getSfcRef(), inv.getInventoryId(), inv.getItemBo(), bomComponent.getComponentBo(), operationBo, resourceBo, inv.getSupplyQty());
                                total = total.subtract(inv.getSupplyQty());
                                inv.setSupplyQty(BigDecimal.ZERO);
                            } else {
                                // 需求 < 庫存
                                assemblyService.assembly(sfcBasicData.getSfcRef(), inv.getInventoryId(), inv.getItemBo(), bomComponent.getComponentBo(), operationBo, resourceBo, total);
                                inv.setSupplyQty(inv.getSupplyQty().subtract(total));
                                total = BigDecimal.ZERO;
                            }

                        }
                    }
                }
                //還未扣足
                if (total.compareTo(BigDecimal.ZERO) > 0) {
                    //替代料
                    if (!FwUtils.isEmpty(alternateInvList)) {
                        for (InvInfo inv : alternateInvList) {
                            // 扣完料, break
                            if (total.compareTo(BigDecimal.ZERO) == 0) {
                                break;
                            }
                            // 庫存數=0, continue
                            if (inv.getSupplyQty().compareTo(BigDecimal.ZERO) == 0) {
                                continue;
                            }
                            if (customFlag) {
                                // 依照原本邏輯扣料
                                if (haveLocation) {
                                    if (sfcBasicData.getShopOrderRef().equals(inv.getShopOrderBo())) {
                                        if (total.compareTo(inv.getSupplyQty()) > 0) {
                                            // 需求 > 庫存
                                            assemblyService.assembly(sfcBasicData.getSfcRef(), inv.getInventoryId(), inv.getItemBo(), bomComponent.getComponentBo(), operationBo, resourceBo, inv.getSupplyQty());
                                            total = total.subtract(inv.getSupplyQty());
                                            inv.setSupplyQty(BigDecimal.ZERO);
                                        } else {
                                            // 需求 < 庫存
                                            assemblyService.assembly(sfcBasicData.getSfcRef(), inv.getInventoryId(), inv.getItemBo(), bomComponent.getComponentBo(), operationBo, resourceBo, total);
                                            inv.setSupplyQty(inv.getSupplyQty().subtract(total));
                                            total = BigDecimal.ZERO;
                                            break;
                                        }
                                    }
                                }else{
                                    //工單一致 或 工單為空
                                    if (sfcBasicData.getShopOrderRef().equals(inv.getShopOrderBo()) || FwUtils.isNullOrEmpty(inv.getShopOrderBo())) {
                                        // 庫存地點相同
                                        if (!FwUtils.isNullOrEmpty(inv.getStorageLocation()) && inv.getStorageLocation().equals(bomComponent.getLocation())) {
                                            if (total.compareTo(inv.getSupplyQty()) > 0) {
                                                // 需求 > 庫存
                                                assemblyService.assembly(sfcBasicData.getSfcRef(), inv.getInventoryId(), inv.getItemBo(), bomComponent.getComponentBo(), operationBo, resourceBo, inv.getSupplyQty());
                                                total = total.subtract(inv.getSupplyQty());
                                                inv.setSupplyQty(BigDecimal.ZERO);
                                            } else {
                                                // 需求 < 庫存
                                                assemblyService.assembly(sfcBasicData.getSfcRef(), inv.getInventoryId(), inv.getItemBo(), bomComponent.getComponentBo(), operationBo, resourceBo, total);
                                                inv.setSupplyQty(inv.getSupplyQty().subtract(total));
                                                total = BigDecimal.ZERO;
                                                break;
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (total.compareTo(inv.getSupplyQty()) > 0) {
                                    // 需求 > 庫存
                                    assemblyService.assembly(sfcBasicData.getSfcRef(), inv.getInventoryId(), inv.getItemBo(), bomComponent.getComponentBo(), operationBo, resourceBo, inv.getSupplyQty());
                                    total = total.subtract(inv.getSupplyQty());
                                    inv.setSupplyQty(BigDecimal.ZERO);
                                } else {
                                    // 需求 < 庫存
                                    assemblyService.assembly(sfcBasicData.getSfcRef(), inv.getInventoryId(), inv.getItemBo(), bomComponent.getComponentBo(), operationBo, resourceBo, total);
                                    inv.setSupplyQty(inv.getSupplyQty().subtract(total));
                                    total = BigDecimal.ZERO;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private BigDecimal findSfcQty( String sfcBo, String operationBo, String reousrceBo ) throws SQLException {
        BigDecimal response = BigDecimal.ZERO;
        dq.flush();
        dq.append("select e.qty_in_work from sfc a " +
                          "join SFC_ROUTING b on a.handle = b.sfc_bo " +
                          "join SFC_ROUTER c on b.handle = c.sfc_routing_bo " +
                          "join SFC_STEP d on c.handle = d.sfc_router_bo " +
                          "join sfc_in_work e on d.handle = e.sfc_step_bo ");
        dq.append("where a.handle = ");
        dq.appendString(sfcBo);
        dq.append(" and d.operation_bo = ");
        dq.appendString(operationBo);
        dq.append(" and e.resource_bo = ");
        dq.appendString(reousrceBo);
        ResultSet rs = base.executeQueryAsResultSet(dq);
        while (rs.next()) {
            response = rs.getBigDecimal("qty_in_work");
        }
        return response;
    }
}
