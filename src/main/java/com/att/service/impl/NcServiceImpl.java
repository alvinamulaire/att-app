package com.att.service.impl;

import com.att.domain.nc.NcRequest;
import com.att.domain.nc.NcResponse;
import com.att.service.NcService;
import com.fw.mes.me.controller.dataField.FwDataFieldRepo;
import com.fw.mes.me.controller.dataType.FwDataTypeRepo;
import com.fw.mes.me.controller.disiption.FwDispositionRepo;
import com.fw.mes.me.controller.ncCode.FwNcCodeRepo;
import com.fw.mes.me.controller.operation.OperationRepo;
import com.fw.mes.me.controller.resource.ResourceRepo;
import com.fw.mes.me.controller.sfc.SfcRepo;
import com.fw.mes.me.entity.*;
import com.fw.mes.util.FwUtils;
import com.sap.me.demand.SFCBOHandle;
import com.sap.me.frame.domain.BusinessException;
import com.sap.me.nonconformance.*;
import com.sap.me.plant.ResourceBOHandle;
import com.sap.me.productdefinition.OperationBOHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class NcServiceImpl implements NcService {

    @Autowired
    private SfcRepo sfcRepo;

    @Autowired
    private OperationRepo operationRepo;

    @Autowired
    private ResourceRepo resourceRepo;

    @Autowired
    private FwDataTypeRepo fwDataTypeRepo;

    @Autowired
    private FwNcCodeRepo fwNcCodeRepo;

    @Autowired
    private FwDataFieldRepo fwDataFieldRepo;

    @Autowired
    private FwDispositionRepo fwDispositionRepo;

    private final String functionNames = "IMMEDIATE_HOLD,LOCAL_REWORK,NO_DEFECT_FOUND,NO_DEFECT_FOUND_COMPLETE,NO_DEFECT_FOUND_NO_RET," +
            "RETURN_TO_NEXT,RETURN_TO_ORIGINAL,RETURN_TO_PREVIOUS,SCRAP,USEABLE_AS_IS,USEABLE_AS_IS_NO_RET";
    private final List<String> functions = new ArrayList<>(Arrays.asList(functionNames.split(",")));
    private final String TRUE = "true";
    private final String FALSE = "false";

    @Override
    public NcResponse getSfcInfo( NcRequest ncRequest ) {
        String site = ncRequest.getSite();
        String sfc = ncRequest.getSfc();
        String operation = ncRequest.getOperation();
        String resource = ncRequest.getResource();
        String locale = ncRequest.getLan().toLowerCase();

        List<ViewSfcRoutingStep> sfcRoutingStepList = sfcRepo.getSfcStepInWork(site, sfc).stream()
                .filter(f -> {
                    String stepOperation = new OperationBOHandle(f.getOperationBo()).getOperation();
                    return stepOperation.equals(operation);
                })
                .collect(Collectors.toList());

        if (FwUtils.isEmpty(sfcRoutingStepList)) {
            FwUtils.getCustomException("nc.error1");
        }
        BigDecimal inWorkQty = sfcRoutingStepList.get(0).getQtyInWork();

        NcResponse response = new NcResponse();
        response.setSite(site);
        response.setSfc(sfc);
        response.setInWorkQty(inWorkQty);
        response.setOperation(operation);
        response.setResource(resource);

        List<ViewOperationDesc> operationDescList = operationRepo.findByCurrentRevision(site, operation, locale);
        if (!FwUtils.isEmpty(operationDescList)) {
            response.setOperationDesc(operationDescList.get(0).getDescription());
        }

        List<Resrce> resrceList = resourceRepo.findById(site, resource);
        if (!FwUtils.isEmpty(resrceList)) {
            response.setResourceDesc(resrceList.get(0).getDescription());
        }

        return response;
    }

    @Override
    public List<ViewDataTypeField> getColumn( NcRequest ncRequest ) {
        String site = ncRequest.getSite();
        String locale = ncRequest.getLan().toLowerCase();
        return fwDataTypeRepo.getDataTypeByCategory(site, "NC", "SIMPLE", locale);
    }

    @Transactional
    @Override
    public void save( NcRequest ncRequest ) {
        String site = ncRequest.getSite();
        String user = ncRequest.getUser();
        String sfc = ncRequest.getSfc();
        String sfcBo = new SFCBOHandle(site, sfc).getValue();
        String operation = ncRequest.getOperation();
        String resource = ncRequest.getResource();
        String resourceBo = new ResourceBOHandle(site, resource).getValue();
        List<Map<String, String>> ncList = ncRequest.getNcList();
        List<ViewDataTypeField> dataTypeList = this.getColumn(ncRequest);

        NCProductionServiceInterface ncProductionService = FwUtils.getService("com.sap.me.nonconformance", "NCProductionService", user, site);

        ProductionContext productionContext = new ProductionContext();
        productionContext.setStepIdentifier(new StepIdentifier(operation));
        productionContext.setResourceRef(resourceBo);

        for (Map<String, String> map : ncList) {
            String ncCode = map.getOrDefault("ncCode", null);
            String ncCodeBo = new NCCodeBOHandle(site, ncCode).getValue();
            BigDecimal qty = new BigDecimal(map.getOrDefault("qty", null));

            NcCode nc = new NcCode();
            nc.setSite(site);
            nc.setNcCode(ncCode);
            if (FwUtils.isEmpty(fwNcCodeRepo.findNcCode(nc))) {
                FwUtils.getCustomException("nc.error2", new Object[]{ ncCode });
            }

            List<NCCustomField> customValues = this.checkValue(site, map, dataTypeList);
            this.checkNcOperation(site, ncCode, operation);

            List<ViewNcCodeDefValidOper> dispositionList = fwNcCodeRepo.getNcDisposition(site, ncCode);
            String valid = dispositionList.get(0).getValidAtAllOperations();
            List<ViewNcCodeDefValidOper> filtersByEnabled = dispositionList.stream()
                    .filter(f -> "true".equals(f.getEnabled()))
                    .collect(Collectors.toList());

            List<ViewNcCodeDispRouter> routerList = fwNcCodeRepo.getNcRouter(site, ncCode);
            if (!"true".equals(valid) && FwUtils.isEmpty(filtersByEnabled) && FwUtils.isEmpty(routerList)) {
                FwUtils.getCustomException("nc.error19", new Object[]{ ncCode });
            }

            String disposition = null;
            if (!FwUtils.isEmpty(filtersByEnabled) || "true".equals(valid)) {
                disposition = this.checkDisposition(ncCode, operation, dispositionList, filtersByEnabled);
                this.checkFunction(site, disposition);
            }

            if (!FwUtils.isEmpty(routerList) && FwUtils.isNullOrEmpty(disposition)) {
                this.checkNcRouter(ncCode, routerList);
            }

            // Create NC
            CreateNCRequest createNCRequest = new CreateNCRequest();
            createNCRequest.setSfcRef(sfcBo);
            createNCRequest.setValidateNCCodeOperation(true);
            createNCRequest.setNcCodeRef(ncCodeBo);
            createNCRequest.setDefectCount(qty);
            createNCRequest.setQty(qty);
            createNCRequest.setCustomValues(customValues);
            createNCRequest.setProdCtx(productionContext);

            String comments = map.getOrDefault("COMMENTS", null);
            if (!FwUtils.isNullOrEmpty(comments)) {
                createNCRequest.setComments(comments);
            }

            try {
                ncProductionService.createNC(createNCRequest);
            } catch (BusinessException e) {
                FwUtils.getMeException(e);
            }

            DispositionMultipleSfcsRequest dispositionMultipleSfcsRequest = new DispositionMultipleSfcsRequest();
            dispositionMultipleSfcsRequest.getSfcs().add(sfcBo);
            dispositionMultipleSfcsRequest.setProdCtx(productionContext);
            dispositionMultipleSfcsRequest.setPerformAutoSplit(true);

            try {
                ncProductionService.dispositionMultipleSfcs(dispositionMultipleSfcsRequest);
            } catch (BusinessException e) {
                FwUtils.getMeException(e);
            }
        }
    }

    private List<NCCustomField> checkValue( String site, Map<String, String> map, List<ViewDataTypeField> list ) {
        String ncCode = map.getOrDefault("ncCode", null);

        List<NCCustomField> customFields = new ArrayList<>();
        for (ViewDataTypeField dataTypeField : list) {
            String key = dataTypeField.getDataField();
            String column = dataTypeField.getDataTag();
            String type = dataTypeField.getValidationType();
            String required = dataTypeField.getRequired();

            String value = map.getOrDefault(key, null);
            if ("true".equals(required)) {
                if (FwUtils.isNullOrEmpty(value)) {
                    FwUtils.getCustomException("nc.error3", new Object[]{ column });
                }
            }

            NCCustomField ncCustomField = new NCCustomField();
            ncCustomField.setFieldName(key);
            ncCustomField.setValue(value);

            switch (type) {
                case "D":
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    sdf.setLenient(false);
                    try {
                        sdf.parse(value);
                    } catch (ParseException e) {
                        FwUtils.getCustomException("nc.error4", new Object[]{ ncCode, column });
                    }
                    break;
                case "N":
                    if (!value.matches("[+-]?\\d*(\\.\\d+)?")) {
                        FwUtils.getCustomException("nc.error5", new Object[]{ ncCode, column });
                    }
                    break;
                case "C":
                    if (!FwUtils.isNullOrEmpty(value) && !"Y".equals(value)) {
                        FwUtils.getCustomException("nc.error6", new Object[]{ ncCode, column });
                    }

                    if ("Y".equals(value)) {
                        ncCustomField.setValue(TRUE);
                    } else {
                        ncCustomField.setValue(FALSE);
                    }
                    break;
                case "L":
                    ViewDataFieldList viewDataFieldList = new ViewDataFieldList();
                    viewDataFieldList.setSite(site);
                    viewDataFieldList.setDataField(key);
                    List<ViewDataFieldList> dataFieldList = fwDataFieldRepo.getDataFiledList(viewDataFieldList, "").stream()
                            .filter(f -> {
                                String dataValue = f.getDataValue();
                                if (!FwUtils.isNullOrEmpty(dataValue)) {
                                    return dataValue.equals(value);
                                }
                                return false;
                            })
                            .collect(Collectors.toList());

                    if (FwUtils.isEmpty(dataFieldList)) {
                        FwUtils.getCustomException("nc.error7", new Object[]{ ncCode, column });
                    }
                    break;
                default:
                    break;
            }

            if (!FwUtils.isNullOrEmpty(ncCustomField.getValue()) && !"COMMENTS".equals(ncCustomField.getFieldName())) {
                customFields.add(ncCustomField);
            }
        }

        return customFields;
    }

    private void checkNcOperation( String site, String ncCode, String operation ) {
        List<ViewNcCodeGroupOperation> ncOperationList = fwNcCodeRepo.getNcCodeOperation(site, ncCode);
        if (FwUtils.isEmpty(ncOperationList)) {
            FwUtils.getCustomException("nc.error8", new Object[]{ ncCode });
        }

        String allOperation = ncOperationList.get(0).getValidAtAllOperations();
        if (!"true".equals(allOperation)) {
            List<String> operationList = ncOperationList.stream()
                    .filter(f -> !FwUtils.isNullOrEmpty(f.getOperationBo()))
                    .map(obj -> new OperationBOHandle(obj.getOperationBo()).getOperation())
                    .collect(Collectors.toList());

            if (FwUtils.isEmpty(operationList) || !operationList.contains(operation)) {
                FwUtils.getCustomException("nc.error9", new Object[]{ operation, ncCode });
            }
        }
    }

    private String checkDisposition( String ncCode, String operation,
                                     List<ViewNcCodeDefValidOper> dispositionList, List<ViewNcCodeDefValidOper> filters ) {
        String valid = dispositionList.get(0).getValidAtAllOperations();
        String dispositionBo = dispositionList.get(0).getAllDispositionGroupBo();
        String dispositionOperation = dispositionList.get(0).getOperationBo();
        if ("true".equals(valid)) {
            if (filters.size() >= 1) {
                FwUtils.getCustomException("nc.error10", new Object[]{ ncCode });
            }
        } else {
            if (filters.size() > 1) {
                FwUtils.getCustomException("nc.error10", new Object[]{ ncCode });
            }

            dispositionBo = filters.get(0).getDispositionGroupBo();

            if (!FwUtils.isNullOrEmpty(dispositionBo) && !dispositionOperation.equals(operation)) {
                FwUtils.getCustomException("nc.error13", new Object[]{ operation, ncCode });
            }
        }

        return new DispositionGroupBOHandle(dispositionBo).getDispositionGroup();
    }

    private void checkNcRouter( String ncCode, List<ViewNcCodeDispRouter> routerList ) {
        if (routerList.size() > 1) {
            FwUtils.getCustomException("nc.error14", new Object[]{ ncCode });
        }
    }

    private void checkFunction( String site, String disposition ) {
        if (FwUtils.isNullOrEmpty(disposition)) {
            return;
        }

        List<ViewDispositionGroupFunction> functionList = fwDispositionRepo.getDisposition(site, disposition);
        if (FwUtils.isEmpty(functionList)) {
            FwUtils.getCustomException("nc.error16", new Object[]{ disposition });
        }

        if (functionList.size() > 1) {
            FwUtils.getCustomException("nc.error17", new Object[]{ disposition });
        }

        String functionName = functionList.get(0).getDispositionFunction();

        if (!functions.contains(functionName)) {
            FwUtils.getCustomException("nc.error18", new Object[]{ disposition, functionName });
        }
    }
}
