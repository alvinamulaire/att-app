package com.att.nwds.service.impl;

import com.att.nwds.service.CommonService;
import com.att.nwds.service.domain.*;
import com.fw.mes.util.FwUtils;
import com.sap.me.datacollection.*;
import com.sap.me.extension.Services;
import com.sap.me.frame.BasicBOBeanException;
import com.sap.me.frame.Data;
import com.sap.me.frame.SystemBase;
import com.sap.me.frame.domain.BusinessException;
import com.sap.me.frame.jdbc.DynamicQuery;
import com.sap.me.frame.jdbc.DynamicQueryFactory;
import com.sap.me.frame.transitionutils.Exceptions;
import com.sap.me.plant.StorageLocationBOHandle;
import com.sap.me.productdefinition.ItemBOHandle;
import com.sap.me.productdefinition.OperationBOHandle;
import com.sap.me.status.StatusBOHandle;
import com.sap.me.wpmf.MessageType;
import com.sap.me.wpmf.util.MessageHandler;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CommonServiceImpl implements CommonService {

    private final SystemBase base = SystemBase.createSystemBase("jdbc/jts/wipPool");
    private final DynamicQuery dq = DynamicQueryFactory.newInstance();
    private ResultSet rs;

    @Override
    public SfcInfo getSfcInfo( String sfcBo ) throws SQLException {
        SfcInfo sfcInfo = new SfcInfo();

        dq.flush();
        dq.append("select * from sfc ");
        dq.append(" where handle = ");
        dq.appendString(sfcBo);
        rs = base.executeQueryAsResultSet(dq);

        while (rs.next()) {
            sfcInfo.setShopOrderBo(rs.getString("SHOP_ORDER_BO"));
            sfcInfo.setQty(rs.getBigDecimal("qty"));
        }

        return sfcInfo;
    }

    @Override
    public List<BomComponent> getComponent( String sfcBo, String operationBo ) throws SQLException {
        List<BomComponent> bomComponentList = new ArrayList<>();
        String bomBo = "";

        // get sfc bom
        dq.flush();
        dq.append("select * from sfc_bom ");
        dq.append(" where sfc_bo = ");
        dq.appendString(sfcBo);
        rs = base.executeQueryAsResultSet(dq);

        while (rs.next()) {
            bomBo = rs.getString("bom_bo");
        }

        OperationBOHandle operationBOHandle = new OperationBOHandle(operationBo);
        String operationBOHandleHashtag = new OperationBOHandle(operationBOHandle.getSite(), operationBOHandle.getOperation(), "#").getValue();

        // get sfc bom material
        dq.flush();
        dq.append("select * from Z_VW_BOM_COMPONENT_OPERATION ");
        dq.append(" where bom_bo = ");
        dq.appendString(bomBo);
        dq.append(" and operation_bo = ");
        dq.appendString(operationBOHandleHashtag);
        dq.append("and component_type != 'P'");
        rs = base.executeQueryAsResultSet(dq);

        while (rs.next()) {
            BomComponent component = new BomComponent();
            component.setComponentBo(rs.getString("bom_component_bo"));
            component.setItemBo(rs.getString("component_gbo"));
            component.setQty(rs.getBigDecimal("qty"));
            component.setLocation(rs.getString("lgort"));

            bomComponentList.add(component);
        }

        // get alternative materials
        for (BomComponent bomComponent : bomComponentList) {
            dq.flush();
            dq.append("select * from Z_VW_ALTERNATE_COMPONENT ");
            dq.append(" where SUBSTITUTE = 'true' ");
            dq.append(" and BOM_COMPONENT_BO = ");
            dq.appendString(bomComponent.getComponentBo());
            rs = base.executeQueryAsResultSet(dq);

            while (rs.next()) {
                String item = rs.getString("ITEM_BO");

                if (FwUtils.isEmpty(bomComponent.getAlternateItemBoList())) {
                    List<String> alternateItems = new ArrayList<>();
                    alternateItems.add(item);

                    bomComponent.setAlternateItemBoList(alternateItems);
                } else {
                    bomComponent.getAlternateItemBoList().add(item);
                }
            }
        }

        return bomComponentList;
    }

    @Override
    public void checkResourceMaterial( String resourceBo ) throws SQLException, BusinessException {
        dq.flush();
        dq.append(" SELECT * FROM INVENTORY ");
        dq.append(" where RESOURCE_LOC_RES = 'true' ");
        dq.append(" and RESOURCE_LOC_BO = ");
        dq.appendString(resourceBo);
        rs = base.executeQueryAsResultSet(dq);

        boolean flag = true;
        if (rs.next()) {
            // 有上料
            flag = false;
        }

        if (flag) {
            BasicBOBeanException exception = new BasicBOBeanException(20102, new Data());
            throw Exceptions.convert(exception);
        }
    }

    @Override
    public Map<String, List<InvInfo>> getItemInventory( InvInfo invInfo ) throws SQLException {
        Map<String, List<InvInfo>> invMap = new HashMap<>();

        String shopOrderBo = invInfo.getShopOrderBo();
        String resourceBo = invInfo.getResourceBo();
        List<String> shopOrderBoList = invInfo.getShopOrderBoList();
        String statusBo = new StatusBOHandle(invInfo.getSite(), "1001").getValue();

        if (FwUtils.isEmpty(invInfo.getComponentList())) {
            return new HashMap<>();
        }

        dq.flush();
        dq.append(" select * from Z_VW_INVENTORY ");
        dq.append(" where qty_on_hand > 0 ");
        dq.append(" and STATUS_BO = ");
        dq.appendString(statusBo);
        dq.append(" and item_bo in ( ");
        this.appendList(invInfo.getComponentList());
        dq.append(" ) ");

        if (!FwUtils.isNullOrEmpty(shopOrderBo)) {
            dq.append(" and ( SHOP_ORDER_LOC_BO = ");
            dq.appendString(shopOrderBo);
            dq.append(" or SHOP_ORDER_LOC_BO is null ) ");
        } else if (!FwUtils.isEmpty(shopOrderBoList)) {
            dq.append(" and ( SHOP_ORDER_LOC_BO in ( ");
            this.appendList(shopOrderBoList);
            dq.append(" ) or SHOP_ORDER_LOC_BO is null ) ");
        } else {
            dq.append(" and SHOP_ORDER_LOC_BO is null ");
        }

        if (!FwUtils.isNullOrEmpty(resourceBo)) {
            dq.append(" and RESOURCE_LOC_RES = 'true' ");
            dq.append(" and RESOURCE_LOC_BO = ");
            dq.appendString(resourceBo);
        } else {
            dq.append(" and RESOURCE_LOC_BO is null ");
            dq.append(" and RESOURCE_LOC_RES = 'false' ");
        }

        rs = base.executeQueryAsResultSet(dq);

        while (rs.next()) {
            String invId = rs.getString("inventory_id");
            String itemBo = rs.getString("ITEM_BO");
            String soBo = rs.getString("SHOP_ORDER_LOC_BO");
            String resBo = rs.getString("RESOURCE_LOC_BO");
            boolean resLocRes = "true".equals(rs.getString("RESOURCE_LOC_RES"));
            BigDecimal supplyQty = rs.getBigDecimal("QTY_ON_HAND");
            String location = new StorageLocationBOHandle(rs.getString("STORAGE_LOCATION_BO")).getStorageLocation();

            InvInfo iInfo = new InvInfo();
            iInfo.setInventoryId(invId);
            iInfo.setItemBo(itemBo);
            iInfo.setShopOrderBo(soBo);
            iInfo.setResourceBo(resBo);
            iInfo.setResourceLocRes(resLocRes);
            iInfo.setSupplyQty(supplyQty);
            iInfo.setStorageLocation(location);

            if (!invMap.containsKey(itemBo)) {
                List<InvInfo> invList = new ArrayList<>();
                invList.add(iInfo);

                invMap.put(itemBo, invList);
            } else {
                invMap.get(itemBo).add(iInfo);
            }
        }

        return invMap;
    }

    @Override
    public List<InvInfo> getInventoryList(InvInfo invInfo) throws SQLException {
        List<InvInfo> response = new ArrayList<>();

        String shopOrderBo = invInfo.getShopOrderBo();
        String resourceBo = invInfo.getResourceBo();
        List<String> shopOrderBoList = invInfo.getShopOrderBoList();
        String statusBo = new StatusBOHandle(invInfo.getSite(), "1001").getValue();

        if (FwUtils.isEmpty(invInfo.getComponentList())) {
            return response;
        }

        dq.flush();
        dq.append(" select * from Z_VW_INVENTORY ");
        dq.append(" where qty_on_hand > 0 ");
        dq.append(" and STATUS_BO = ");
        dq.appendString(statusBo);
        dq.append(" and item_bo in ( ");
        this.appendList(invInfo.getComponentList());
        dq.append(" ) ");

        if (!FwUtils.isNullOrEmpty(shopOrderBo)) {
            dq.append(" and ( SHOP_ORDER_LOC_BO = ");
            dq.appendString(shopOrderBo);
            dq.append(" or SHOP_ORDER_LOC_BO is null ) ");
        } else if (!FwUtils.isEmpty(shopOrderBoList)) {
            dq.append(" and ( SHOP_ORDER_LOC_BO in ( ");
            this.appendList(shopOrderBoList);
            dq.append(" ) or SHOP_ORDER_LOC_BO is null ) ");
        } else {
            dq.append(" and SHOP_ORDER_LOC_BO is null ");
        }

        if (!FwUtils.isNullOrEmpty(resourceBo)) {
            dq.append(" and RESOURCE_LOC_RES = 'true' ");
            dq.append(" and RESOURCE_LOC_BO = ");
            dq.appendString(resourceBo);
        } else {
            dq.append(" and RESOURCE_LOC_BO is null ");
            dq.append(" and RESOURCE_LOC_RES = 'false' ");
        }

        rs = base.executeQueryAsResultSet(dq);

        while (rs.next()) {
            String invId = rs.getString("inventory_id");
            String itemBo = rs.getString("ITEM_BO");
            String soBo = rs.getString("SHOP_ORDER_LOC_BO");
            String resBo = rs.getString("RESOURCE_LOC_BO");
            boolean resLocRes = "true".equals(rs.getString("RESOURCE_LOC_RES"));
            BigDecimal supplyQty = rs.getBigDecimal("QTY_ON_HAND");
            String location = new StorageLocationBOHandle(rs.getString("STORAGE_LOCATION_BO")).getStorageLocation();

            InvInfo iInfo = new InvInfo();
            iInfo.setInventoryId(invId);
            iInfo.setItemBo(itemBo);
            iInfo.setShopOrderBo(soBo);
            iInfo.setResourceBo(resBo);
            iInfo.setResourceLocRes(resLocRes);
            iInfo.setSupplyQty(supplyQty);
            iInfo.setStorageLocation(location);

            response.add(iInfo);
        }

        return response;
    }

    @Override
    public void checkInventory( List<RequestBase> requestBaseList ) throws BusinessException {
        try {
            // false:INV，true:不為INV
            boolean flag = false;
            String site = requestBaseList.get(0).getSite();
            String operationBo = requestBaseList.get(0).getOperationBo();
            String resourceBo = requestBaseList.get(0).getResourceBo();
            String isInv = requestBaseList.get(0).getIsInv();
            String mode = this.getSystemConfig(site, "MATERIALS_CONSUME_MODE");

            if (FwUtils.isNullOrEmpty(isInv) || !"INV".equals(isInv)) {
                // 預設或不是INV，檢查資源是否上料
                flag = true;
            }

            // 1:依照原邏輯進行扣料, 非1:可混用
            boolean customFlag = "1".equals(mode);

            List<String> soList = new ArrayList<>();
            List<String> componentList = new ArrayList<>();
            Map<String, SfcInfo> sfcInfoMap = new HashMap<>();
            // 整理扣料SFC
            for (RequestBase requestBase : requestBaseList) {
                String sfcBo = requestBase.getSfcBo();
                BigDecimal qty = requestBase.getRequestQty();

                // 取得SFC資訊
                SfcInfo sfcInfo = this.getSfcInfo(sfcBo);
                String shopOrderBo = sfcInfo.getShopOrderBo();
                BigDecimal sfcQty = qty == null || qty.compareTo(BigDecimal.ZERO) == 0 ? sfcInfo.getQty() : qty;
                sfcInfo.setQty(sfcQty);

                // 工單清單
                this.addToList(soList, shopOrderBo);

                // 取得BOM
                List<BomComponent> bomComponentList = this.getComponent(sfcBo, operationBo);
                for (BomComponent bomComponent : bomComponentList) {
                    // 主料
                    String component = bomComponent.getItemBo();
                    this.addToList(componentList, component);
                    if (!FwUtils.isEmpty(bomComponent.getAlternateItemBoList())) {
                        List<String> alternateItems = bomComponent.getAlternateItemBoList();
                        for (String alternate : alternateItems) {
                            // 替代料
                            this.addToList(componentList, alternate);
                        }
                    }
                }
                sfcInfo.setBomComponentList(bomComponentList);

                sfcInfoMap.put(sfcBo, sfcInfo);
            }

            if (!FwUtils.isEmpty(componentList)) {
                if (flag) {
                    this.checkResourceMaterial(resourceBo);
                }
            }

            // 取得庫存清單
            InvInfo invInfo = new InvInfo();
            invInfo.setSite(site);
            invInfo.setShopOrderBoList(soList);
            invInfo.setComponentList(componentList);
            if (flag) {
                invInfo.setResourceBo(resourceBo);
                invInfo.setResourceLocRes(true);
            }
            Map<String, List<InvInfo>> invMap = this.getItemInventory(invInfo);

            List<String> none = new ArrayList<>();
            List<String> notEnough = new ArrayList<>();
            // 檢查需求數量
            for (RequestBase requestBase : requestBaseList) {
                String sfcBO = requestBase.getSfcBo();
                SfcInfo sfcInfo = sfcInfoMap.get(sfcBO);
                String soBo = sfcInfo.getShopOrderBo();
                BigDecimal sfcQty = sfcInfo.getQty();
                List<BomComponent> bomComponentList = sfcInfo.getBomComponentList();

                for (BomComponent component : bomComponentList) {
                    String itemBo = component.getItemBo();
                    String item = new ItemBOHandle(itemBo).getItem();
                    List<String> alternateItems = component.getAlternateItemBoList();
                    BigDecimal demandQty = sfcQty.multiply(component.getQty());
                    String location = component.getLocation();

                    // 沒庫存
                    if (invMap.isEmpty()) {
                        this.addToList(none, item);
                        continue;
                    }

                    // 檢查是否有庫存
                    // 無物料庫存
                    if (!invMap.containsKey(itemBo)) {
                        // 主件有替代料
                        if (!FwUtils.isEmpty(alternateItems)) {
                            int i = 0;
                            for (String aItemBo : alternateItems) {
                                // 無替代料庫存
                                if (!invMap.containsKey(aItemBo)) {
                                    i++;
                                } else {
                                    // 有替代料庫存
                                    int k = 0;
                                    List<InvInfo> alternateInv = invMap.get(aItemBo);
                                    for (InvInfo alternateInvInfo : alternateInv) {
                                        String alternateSoBo = alternateInvInfo.getShopOrderBo();
                                        String alternateStorageLocation = alternateInvInfo.getStorageLocation();

                                        // 不可混用
                                        if (customFlag) {
                                            if (!FwUtils.isNullOrEmpty(location) && !location.equals(alternateStorageLocation) ||
                                                    FwUtils.isNullOrEmpty(location) && !FwUtils.isNullOrEmpty(alternateStorageLocation)) {
                                                // 儲存地點不同
                                                k++;
                                            } else {
                                                if (!FwUtils.isNullOrEmpty(alternateSoBo) && !soBo.equals(alternateSoBo)) {
                                                    // 工單不同
                                                    k++;
                                                }
                                            }
                                        }
                                    }

                                    if (k == alternateInv.size()) {
                                        // 無可用替代料庫存
                                        i++;
                                    }
                                }
                            }

                            if (i == alternateItems.size()) {
                                // 無主件庫存且無替代料庫存
                                this.addToList(none, item);
                                continue;
                            }
                        } else {
                            // 無主件庫存且無替代料
                            this.addToList(none, item);
                            continue;
                        }
                    }

                    boolean noneFlag = true;
                    // 主件
                    if (invMap.containsKey(itemBo)) {
                        // 主件庫存
                        List<InvInfo> invInfoList = invMap.get(itemBo);
                        // 扣除需求
                        CheckInfo checkInfo = this.loopInventory(invInfoList, soBo, location, demandQty, customFlag);
                        demandQty = checkInfo.getDemandQty();
                        noneFlag = checkInfo.isFlag();
                    }

                    // 替代料
                    if (demandQty.compareTo(BigDecimal.ZERO) > 0 && !FwUtils.isEmpty(alternateItems)) {
                        for (String alternateItemBo : alternateItems) {
                            if (invMap.containsKey(alternateItemBo)) {
                                // 替代料庫存
                                List<InvInfo> alternateInv = invMap.get(alternateItemBo);
                                // 扣除需求
                                CheckInfo checkInfo = this.loopInventory(alternateInv, soBo, location, demandQty, customFlag);
                                demandQty = checkInfo.getDemandQty();
                                noneFlag = checkInfo.isFlag();
                            }
                        }
                    }

                    // 需求>0，不足料
                    if (demandQty.compareTo(BigDecimal.ZERO) > 0) {
                        if (noneFlag) {
                            // 未扣過，不足
                            this.addToList(none, item);
                        } else {
                            // 已扣過料，但不足
                            this.addToList(notEnough, item);
                        }
                    }
                }
            }

            if (!FwUtils.isEmpty(none)) {
                // 查無庫存
                BasicBOBeanException exception;
                if (flag) {
                    exception = new BasicBOBeanException(20104, new Data("items", this.joinComma(none)));
                } else {
                    exception = new BasicBOBeanException(20103, new Data("items", this.joinComma(none)));
                }
                throw Exceptions.convert(exception);
            }

            if (!FwUtils.isEmpty(notEnough)) {
                // 庫存不足
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("%items%", this.joinComma(notEnough));
                if (flag) {
                    MessageHandler.handle("inv.not.enough2", map, MessageType.WARNING);
                } else {
                    MessageHandler.handle("inv.not.enough1", map, MessageType.WARNING);
                }
            }
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            BasicBOBeanException exception = new BasicBOBeanException(20101, new Data("message", e.getMessage()));
            throw Exceptions.convert(exception);
        }
    }

    @Override
    public void dcCollection( DcInfo dcInfo ) throws BusinessException {
        try {
            DataCollectionConfigurationServiceInterface dcConfigService =
                    Services.getService("com.sap.me.datacollection", "DataCollectionConfigurationService");
            DataCollectionServiceInterface dcService =
                    Services.getService("com.sap.me.datacollection", "DataCollectionService");

            String site = dcInfo.getSite();
            String dcGroup = dcInfo.getDcGroup();
            String sfcBo = dcInfo.getSfcBo();
            String operationBo = dcInfo.getOperationBo();
            String resourceBo = dcInfo.getResourceBo();
            String measureGroup = dcInfo.getMeasureGroup();
            String measureName = dcInfo.getMeasureName();
            String actual = dcInfo.getActual();

            String dcGroupBo = this.getDcGroupBo(site, dcGroup);
            if (FwUtils.isNullOrEmpty(dcGroupBo)) {
                // 沒有DC群組的話，創建
                DataCollectionConfiguration configuration = new DataCollectionConfiguration();
                configuration.setDcGroup(dcGroup);
                configuration.setRevision("A");
                configuration.setCollectDataAt(DcGroupCollectDataAtEnum.ANYTIME);
                configuration.setCollectType(DcGroupCollectTypeEnum.SFC);
                configuration.setStatus(DataCollectionGroupStatusEnum.RELEASABLE);
                configuration.setCurrentRevision(true);

                DataCollectionFullConfiguration response = dcConfigService.createDCGroup(configuration);
                dcGroupBo = response.getRef();
            }

            CreateParametricRequest createParamRequest = new CreateParametricRequest();
            createParamRequest.setGboRef(sfcBo);
            createParamRequest.setOperationRef(operationBo);
            createParamRequest.setResourceRef(resourceBo);
            createParamRequest.setDcGroupRef(dcGroupBo);
            createParamRequest.setType(DataCollectionType.MANUAL);
            createParamRequest.setTestStatus(ParametricTestStatus.PASS);
            createParamRequest.setTestPassed(true);
            createParamRequest.setValidate(true);
            createParamRequest.setExistingParametricRecord(false);

            CreateParametricMeasure createParametricMeasure = new CreateParametricMeasure();
            createParametricMeasure.setMeasureGroup(measureGroup);
            createParametricMeasure.setMeasureName(measureName);
            createParametricMeasure.setMeasureStatus(ParametricTestStatus.PASS);
            createParametricMeasure.setDataType(ParameterDataType.TEXT);
            createParametricMeasure.setActual(actual);
            createParametricMeasure.setEdited(false);
            createParametricMeasure.setExistingPMRecord(false);
            createParametricMeasure.setExistingPMStringNotCollected(false);
            createParametricMeasure.setFirstSequence(false);

            createParamRequest.setParametricMeasureList(Collections.singletonList(createParametricMeasure));
            dcService.createParametricData(createParamRequest);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            BasicBOBeanException exception = new BasicBOBeanException(20101, new Data("message", e.getMessage()));
            throw Exceptions.convert(exception);
        }

    }

    @Override
    public void deleteDcCollection( DcInfo dcInfo ) throws BusinessException {
        try {
            String dcGroupBo = this.getDcGroupBo(dcInfo.getSite(), dcInfo.getDcGroup());

            dq.flush();
            dq.append("select * from Z_VW_PARAMETRIC ");
            dq.append(" where para_context_gbo = ");
            dq.appendString(dcInfo.getSfcBo());
            dq.append(" and operation_bo = ");
            dq.appendString(dcInfo.getOperationBo());
            dq.append(" and resource_bo = ");
            dq.appendString(dcInfo.getResourceBo());
            dq.append(" and dc_group_bo = ");
            dq.appendString(dcGroupBo);
            dq.append(" and measure_name = ");
            dq.appendString(dcInfo.getMeasureName());
            dq.append(" and edited != 'C' ");
            rs = base.executeQueryAsResultSet(dq);
            while (rs.next()) {
                String paBo = rs.getString("pa_bo");
                String pmBo = rs.getString("pm_bo");
                DynamicQuery dq1 = DynamicQueryFactory.newInstance();
                dq1.append("delete from PARAMETRIC where handle = ");
                dq1.appendString(paBo);
                base.executeUpdate(dq1);
                DynamicQuery dq2 = DynamicQueryFactory.newInstance();
                dq2.append("delete from PARAMETRIC_MEASURE where handle = ");
                dq2.appendString(pmBo);
                base.executeUpdate(dq2);
            }
        } catch (Exception e) {
            BasicBOBeanException exception = new BasicBOBeanException(20101, new Data("message", e.getMessage()));
            throw Exceptions.convert(exception);
        }


    }

    private CheckInfo loopInventory( List<InvInfo> invList, String shopOrderBo, String location, BigDecimal demandQty, boolean customFlag ) {
        boolean flag = true;
        for (InvInfo inv : invList) {
            BigDecimal supplyQty = inv.getSupplyQty();
            String invSoBo = inv.getShopOrderBo();
            String storageLocation = inv.getStorageLocation();

            // 需求已足夠
            if (demandQty.compareTo(BigDecimal.ZERO) == 0) {
                break;
            }

            // 無庫存
            if (supplyQty.compareTo(BigDecimal.ZERO) == 0) {
                flag = false;
                continue;
            }

            // 不可混用
            if (customFlag) {
                // 有地點
                if (!FwUtils.isNullOrEmpty(location)) {
                    // 庫存相同地點
                    if (!FwUtils.isNullOrEmpty(storageLocation) && location.equals(storageLocation)) {
                        // 與庫存工單相同 or 庫存無工單
                        if (shopOrderBo.equals(invSoBo) || FwUtils.isNullOrEmpty(invSoBo)) {
                            // 庫存數量 >= 需求數量
                            if (supplyQty.compareTo(demandQty) >= 0) {
                                inv.setSupplyQty(supplyQty.subtract(demandQty));
                                demandQty = BigDecimal.ZERO;
                            } else {
                                inv.setSupplyQty(BigDecimal.ZERO);
                                demandQty = demandQty.subtract(supplyQty);
                            }
                            flag = false;
                        }
                    }
                } else {
                    // 庫存也無地點
                    if (FwUtils.isNullOrEmpty(storageLocation)) {
                        // 與庫存工單相同
                        if (shopOrderBo.equals(invSoBo)) {
                            // 庫存數量 >= 需求數量
                            if (supplyQty.compareTo(demandQty) >= 0) {
                                inv.setSupplyQty(supplyQty.subtract(demandQty));
                                demandQty = BigDecimal.ZERO;
                            } else {
                                inv.setSupplyQty(BigDecimal.ZERO);
                                demandQty = demandQty.subtract(supplyQty);
                            }
                            flag = false;
                        }
                    }
                }
            } else {
                // 可混用
                if (supplyQty.compareTo(demandQty) >= 0) {
                    inv.setSupplyQty(supplyQty.subtract(demandQty));
                    demandQty = BigDecimal.ZERO;
                } else {
                    inv.setSupplyQty(BigDecimal.ZERO);
                    demandQty = demandQty.subtract(supplyQty);
                }
                flag = false;
            }
        }

        CheckInfo checkInfo = new CheckInfo();
        checkInfo.setDemandQty(demandQty);
        checkInfo.setFlag(flag);

        return checkInfo;
    }

    private String joinComma( List<String> list ) {
        StringBuilder stringBuffer = new StringBuilder();

        boolean first = false;
        for (String s : list) {
            if (first) {
                stringBuffer.append(", ");
            } else {
                first = true;
            }

            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }

    private void appendList( List<String> parameters ) {
        if (!FwUtils.isEmpty(parameters)) {
            boolean first = false;
            for (String param : parameters) {
                if (first) {
                    dq.append(",");
                } else {
                    first = true;
                }
                dq.appendString(param.trim());
            }
        }
    }

    private void addToList( List<String> list, String str ) {
        if (!list.contains(str)) {
            list.add(str);
        }
    }

    /**
     * 檢查是否存在DC，並取得dc group bo
     *
     * @throws SQLException
     */
    private String getDcGroupBo( String site, String dcGroup ) throws SQLException {
        String dcGroupBo = "";

        dq.flush();
        dq.append(" select * from dc_group ");
        dq.append(" where site = ");
        dq.appendString(site);
        dq.append(" and DC_GROUP = ");
        dq.appendString(dcGroup);
        dq.append(" and CURRENT_REVISION = 'true' ");

        rs = base.executeQueryAsResultSet(dq);

        while (rs.next()) {
            dcGroupBo = rs.getString("handle");
        }

        return dcGroupBo;
    }

    @Override
    public String getSystemConfig( String site, String rule ) throws SQLException {
        String value = "";

        dq.flush();
        dq.append(" select * from Z_SYSTEM_CONFIG ");
        dq.append(" where site = ");
        dq.appendString(site);
        dq.append(" and SYSTEM_RULE = ");
        dq.appendString(rule);
        rs = base.executeQueryAsResultSet(dq);

        while (rs.next()) {
            value = rs.getString("SYSTEM_VALUE");
        }

        return value;
    }
}
