package com.att.service.impl;

import com.att.domain.packCheckOut.PackCheckOutMasterResponse;
import com.att.domain.packCheckOut.PackCheckOutRequest;
import com.att.domain.packCheckOut.PackCheckOutResponse;
import com.att.repository.PackagingRepository;
import com.att.repository.SfcDoneRepository;
import com.att.repository.entity.ZPackDetail;
import com.att.repository.entity.ZPackMaster;
import com.att.repository.entity.ZVwPackPallet;
import com.att.repository.entity.ZVwSfcDone;
import com.att.service.PackCheckOutService;
import com.fw.mes.me.controller.activity.ActivityRepo;
import com.fw.mes.me.controller.dcGroup.FwDcGroupRepo;
import com.fw.mes.me.controller.inventory.InventoryRepo;
import com.fw.mes.me.controller.sfc.SfcRepo;
import com.fw.mes.me.entity.ActivityOption;
import com.fw.mes.me.entity.ViewFwSfcInfo;
import com.fw.mes.me.entity.ViewParametricMeasure;
import com.fw.mes.me.entity.ViewSfcRoutingStep;
import com.fw.mes.util.DateUtil;
import com.fw.mes.util.FwUtils;
import com.sap.me.demand.SFCBOHandle;
import com.sap.me.extension.Services;
import com.sap.me.frame.domain.BusinessException;
import com.sap.me.productdefinition.OperationBOHandle;
import com.sap.me.production.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PackCheckOutServiceImpl implements PackCheckOutService {

	@Autowired
	private PackagingRepository packagingRepository;

	@Autowired
	private SfcRepo sfcRepo;

	@Autowired
	private ActivityRepo activityRepo;

	@Autowired
	private InventoryRepo inventoryRepo;

	@Autowired
	private SfcDoneRepository sfcDoneRepository;

	@Autowired
	private FwDcGroupRepo fwDcGroupRepo;

	@Override
	public void checkPackCheckOut(PackCheckOutRequest packCheckOutRequest) {
		switch (packCheckOutRequest.getType()){
			case "C":
				checkPackCheckOutByCarton(packCheckOutRequest);
				break;
			case "P":
				checkPackCheckOutByPallet(packCheckOutRequest);
				break;
			default:
				break;
		}
	}

	@Override
	@Transactional
	public PackCheckOutMasterResponse checkOut(List<PackCheckOutRequest> requestList, String locale) {
		PackCheckOutRequest request = requestList.get(0);
		switch (request.getType()){
			case "C":
				return checkOutByCarton(requestList, locale);
			case "P":
				return checkOutByPallet(requestList, locale);
			default:
				return new PackCheckOutMasterResponse();
		}
	}

	private PackCheckOutMasterResponse checkOutByPallet(List<PackCheckOutRequest> requestList, String locale) {
		PackCheckOutMasterResponse response = new PackCheckOutMasterResponse();
		String site = requestList.get(0).getSite();
		String operation = requestList.get(0).getOperation();
		String operationBo = new OperationBOHandle(site,operation,"#").getValue();

		List<ZVwPackPallet> zVwPackPalletList = packagingRepository.findPackPallet(site, requestList.stream().map(PackCheckOutRequest::getPallet).collect(Collectors.toList()), locale);

		Map<String, Long> detailListGroupBySfc = zVwPackPalletList.stream().collect(Collectors.groupingBy(ZVwPackPallet::getSfc,Collectors.counting()));
		for(String sfc : detailListGroupBySfc.keySet()){
			List<ViewSfcRoutingStep> sfcStepList = sfcRepo.getSfcStepInWork(site, sfc);
			List<ViewSfcRoutingStep> sfcInOpList = sfcStepList.stream().filter(x-> x.getOperationBo().equals(operationBo)).collect(Collectors.toList());
			if(sfcInOpList.get(0).getQtyInWork().compareTo(new BigDecimal(detailListGroupBySfc.get(sfc)))<0){
				FwUtils.getCustomException("pack.check.out.error4", new Object[]{sfc});
			}
		}

		//Map<CartonNo,Map<Sfc,List>>
		Map<String, Map<String, List<ZVwPackPallet>>> detailListGroupByCartonNo = zVwPackPalletList.stream().collect(Collectors.groupingBy(ZVwPackPallet::getDetailContainerNo,Collectors.groupingBy(ZVwPackPallet::getSfc)));
		for(String cartonNo : detailListGroupByCartonNo.keySet()){
			for(String sfc : detailListGroupByCartonNo.get(cartonNo).keySet()){
				List<ZVwPackPallet> zVwPackPallets = detailListGroupByCartonNo.get(cartonNo).get(sfc);
				PackCheckOutResponse responseObj = new PackCheckOutResponse();
				responseObj.setItem(zVwPackPallets.get(0).getItem());
				responseObj.setItemDesc(zVwPackPallets.get(0).getDescription());
				responseObj.setShopOrder(zVwPackPallets.get(0).getShopOrder());
				responseObj.setSfc(zVwPackPallets.get(0).getSfc());
				responseObj.setQty(new BigDecimal(zVwPackPallets.size()));
				responseObj.setPallet(zVwPackPallets.get(0).getMasterCartonNo());
				responseObj.setCarton(cartonNo);
				responseObj.setMfgDate(zVwPackPallets.get(0).getDetailMfgDate());
				responseObj.setExpDate(zVwPackPallets.get(0).getDetailExpDate());
				response.getPackCheckOutResponseList().add(responseObj);
			}
		}

		try {
			SfcStateServiceInterface sfcStateService = Services.getService("com.sap.me.production", "SfcStateService", site);
			SfcCompleteServiceInterface sfcCompleteService = Services.getService("com.sap.me.production", "SfcCompleteService", site);
			CompleteSfcBatchRequest sfcBatchRequest = new CompleteSfcBatchRequest();
			//出站
			for(String sfc : detailListGroupBySfc.keySet()){
				//找資源
				Collection<SfcStep> sfcInWorkDetailList = sfcStateService.findStepsSFCIsInWorkFor(new SfcIdentifier(new SFCBOHandle(site,sfc).getValue()));
				String resourceBo = sfcInWorkDetailList.stream().filter(x -> !FwUtils.isNullOrEmpty(x.getResourceRef()) && x.getOperationRef().equals(operationBo)).map(SfcStep::getResourceRef).collect(Collectors.toList()).get(0);

				//入庫單查詢條件
				ZVwSfcDone zVwSfcDone = new ZVwSfcDone();
				zVwSfcDone.setSite(site);
				zVwSfcDone.setOperationBo(operationBo);
				zVwSfcDone.setResourceBo(resourceBo);
				zVwSfcDone.setSfc(sfc);
				List<ZVwSfcDone> zVwSfcDoneList = sfcDoneRepository.findSfcDoneInfo(zVwSfcDone, locale);
				if(!FwUtils.isEmpty(zVwSfcDoneList)){
					zVwSfcDoneList.forEach(x-> x.setQtyInWork(new BigDecimal(detailListGroupBySfc.get(sfc))));
					response.getzVwSfcDoneList().addAll(zVwSfcDoneList);
				}

				CompleteSfcBasicRequest sfcBasicRequest= new CompleteSfcBasicRequest();
				String sfcBo = new SFCBOHandle(site, sfc).getValue();
				sfcBasicRequest.setSfcRef(sfcBo);
				sfcBasicRequest.setOperationRef(operationBo);
				sfcBasicRequest.setResourceRef(resourceBo);
				sfcBasicRequest.setQuantity( new BigDecimal(detailListGroupBySfc.get(sfc)));
				sfcBatchRequest.getCompleteSfcList().add(sfcBasicRequest);
			}
			sfcCompleteService.completeSfcBatch(sfcBatchRequest);
		}catch (BusinessException e){
			FwUtils.getMeException(e);
		}

		//檢索batch_number、product_rank
		response.getzVwSfcDoneList().forEach(x->{
			ViewParametricMeasure batchNumberMeasure = new ViewParametricMeasure();
			batchNumberMeasure.setSite(site);
			batchNumberMeasure.setMeasureGroup("BATCH_NUMBER");
			batchNumberMeasure.setMeasureName("BATCH_NUMBER");
			batchNumberMeasure.setParaContextGbo(new SFCBOHandle(site,x.getSfc()).getValue());
			List<ViewParametricMeasure> batchNumberList = fwDcGroupRepo.getParametricMeasure(batchNumberMeasure);
			if(!FwUtils.isEmpty(batchNumberList)){
				x.setBatchNumber(batchNumberList.get(0).getActual());
			}
			ViewParametricMeasure rankMeasure = new ViewParametricMeasure();
			rankMeasure.setSite(site);
			rankMeasure.setMeasureGroup("PRODUCT_RANK");
			rankMeasure.setMeasureName("RANK");
			rankMeasure.setParaContextGbo(new SFCBOHandle(site,x.getSfc()).getValue());
			List<ViewParametricMeasure> rankList = fwDcGroupRepo.getParametricMeasure(rankMeasure);
			if(!FwUtils.isEmpty(rankList)){
				x.setProductRank(rankList.get(0).getActual());
			}
		});

		//修改狀態
		//Map<PalletSid, Map<CartonSid, List<>>>
		Map<String, Map<String, List<ZVwPackPallet>>> detailListGroupByPallet = zVwPackPalletList.stream().collect(Collectors.groupingBy(ZVwPackPallet::getMasterSid,Collectors.groupingBy(ZVwPackPallet::getDetailSid)));
		List<String> sidList = new ArrayList<>();
		for(String palletNoSid : detailListGroupByPallet.keySet()){
			sidList.add(palletNoSid);
			sidList.addAll(detailListGroupByPallet.get(palletNoSid).keySet());
		}
		packagingRepository.updatePackMasterStatus(sidList,"2");

		return response;
	}

	private PackCheckOutMasterResponse checkOutByCarton(List<PackCheckOutRequest> requestList, String locale) {
		PackCheckOutMasterResponse response = new PackCheckOutMasterResponse();
		String site = requestList.get(0).getSite();
		String operation = requestList.get(0).getOperation();
		String operationBo = new OperationBOHandle(site,operation,"#").getValue();
		List<ZPackDetail> detailList = new ArrayList<>();
		Map<ZPackMaster, List<ZPackDetail>> masterListMap = new HashMap<>();

		for(PackCheckOutRequest request : requestList){
			ZPackMaster carton = new ZPackMaster();
			carton.setSite(request.getSite());
			carton.setContainerNo(request.getCarton());
			carton.setContainerType("C");
			ZPackMaster zPackMaster = packagingRepository.getPackMaster(carton);
			zPackMaster.setModifiedUser(request.getUser());
			zPackMaster.setModifiedDateTime(DateUtil.getGmtTime());
			zPackMaster.setStatus("2");
			packagingRepository.updatePackMaster(zPackMaster);
			List<ZPackDetail> zPackDetailList = packagingRepository.getPackDetail(zPackMaster.getSid());
			detailList.addAll(zPackDetailList);
			masterListMap.put(zPackMaster, zPackDetailList);
		}

		Map<String, Long> detailListGroupBySfc = detailList.stream().collect(Collectors.groupingBy(ZPackDetail::getSfc,Collectors.counting()));
		for(String sfc : detailListGroupBySfc.keySet()){
			List<ViewSfcRoutingStep> sfcStepList = sfcRepo.getSfcStepInWork(site, sfc);
			List<ViewSfcRoutingStep> sfcInOpList = sfcStepList.stream().filter(x-> x.getOperationBo().equals(operationBo)).collect(Collectors.toList());
			if(sfcInOpList.get(0).getQtyInWork().compareTo(new BigDecimal(detailListGroupBySfc.get(sfc)))<0){
				FwUtils.getCustomException("pack.check.out.error4", new Object[]{sfc});
			}
		}

		for(ZPackMaster zPackMaster : masterListMap.keySet()){
			Map<String, List<ZPackDetail>> detailGroupBySfc = detailList.stream().collect(Collectors.groupingBy(ZPackDetail::getSfc));
			for(String sfc : detailGroupBySfc.keySet()){
				ViewFwSfcInfo sfcInfo = sfcRepo.findFwSfcInfo(site, locale, null, null, null, sfc, null, null, null).get(0);
				PackCheckOutResponse responseObj = new PackCheckOutResponse();
				responseObj.setItem(sfcInfo.getItem());
				responseObj.setItemDesc(sfcInfo.getItemDesc());
				responseObj.setShopOrder(sfcInfo.getShopOrder());
				responseObj.setSfc(sfc);
				responseObj.setQty(new BigDecimal(masterListMap.get(zPackMaster).size()));
				ZPackDetail zPackDetail = new ZPackDetail();
				zPackDetail.setSite(site);
				zPackDetail.setCartonNo(zPackMaster.getContainerNo());
				List<ZPackDetail> zPackDetails = packagingRepository.getPackDetail(zPackDetail);
				if(!FwUtils.isEmpty(zPackDetails)){
					ZPackMaster master = new ZPackMaster();
					master.setSite(site);
					master.setSid(zPackDetails.get(0).getMasterSid());
					responseObj.setPallet(packagingRepository.getPackMaster(master).getContainerNo());
				}
				responseObj.setCarton(zPackMaster.getContainerNo());
				responseObj.setMfgDate(zPackMaster.getMfgDate());
				responseObj.setExpDate(zPackMaster.getExpDate());
				response.getPackCheckOutResponseList().add(responseObj);
			}
		}

		try {
			SfcStateServiceInterface sfcStateService = Services.getService("com.sap.me.production", "SfcStateService", site);
			SfcCompleteServiceInterface sfcCompleteService = Services.getService("com.sap.me.production", "SfcCompleteService", site);
			CompleteSfcBatchRequest sfcBatchRequest = new CompleteSfcBatchRequest();
			//出站
			for(String sfc : detailListGroupBySfc.keySet()){
				//找資源
				Collection<SfcStep> sfcInWorkDetailList = sfcStateService.findStepsSFCIsInWorkFor(new SfcIdentifier(new SFCBOHandle(site,sfc).getValue()));
				String resourceBo = sfcInWorkDetailList.stream().filter(x -> !FwUtils.isNullOrEmpty(x.getResourceRef()) && x.getOperationRef().equals(operationBo)).map(SfcStep::getResourceRef).collect(Collectors.toList()).get(0);

				//入庫單查詢條件
				ZVwSfcDone zVwSfcDone = new ZVwSfcDone();
				zVwSfcDone.setSite(site);
				zVwSfcDone.setOperationBo(operationBo);
				zVwSfcDone.setResourceBo(resourceBo);
				zVwSfcDone.setSfc(sfc);
				List<ZVwSfcDone> zVwSfcDoneList = sfcDoneRepository.findSfcDoneInfo(zVwSfcDone, locale);
				if(!FwUtils.isEmpty(zVwSfcDoneList)){
					zVwSfcDoneList.forEach(x-> x.setQtyInWork(new BigDecimal(detailListGroupBySfc.get(sfc))));
					response.getzVwSfcDoneList().addAll(zVwSfcDoneList);
				}

				CompleteSfcBasicRequest sfcBasicRequest= new CompleteSfcBasicRequest();
				String sfcBo = new SFCBOHandle(site, sfc).getValue();
				sfcBasicRequest.setSfcRef(sfcBo);
				sfcBasicRequest.setOperationRef(operationBo);
				sfcBasicRequest.setResourceRef(resourceBo);
				sfcBasicRequest.setQuantity( new BigDecimal(detailListGroupBySfc.get(sfc)));
				sfcBatchRequest.getCompleteSfcList().add(sfcBasicRequest);
			}
			sfcCompleteService.completeSfcBatch(sfcBatchRequest);
		}catch (BusinessException e){
			FwUtils.getMeException(e);
		}

		//檢索batch_number、product_rank
		response.getzVwSfcDoneList().forEach(x->{
			ViewParametricMeasure batchNumberMeasure = new ViewParametricMeasure();
			batchNumberMeasure.setSite(site);
			batchNumberMeasure.setMeasureGroup("BATCH_NUMBER");
			batchNumberMeasure.setMeasureName("BATCH_NUMBER");
			batchNumberMeasure.setParaContextGbo(new SFCBOHandle(site,x.getSfc()).getValue());
			List<ViewParametricMeasure> batchNumberList = fwDcGroupRepo.getParametricMeasure(batchNumberMeasure);
			if(!FwUtils.isEmpty(batchNumberList)){
				x.setBatchNumber(batchNumberList.get(0).getActual());
			}
			ViewParametricMeasure rankMeasure = new ViewParametricMeasure();
			rankMeasure.setSite(site);
			rankMeasure.setMeasureGroup("PRODUCT_RANK");
			rankMeasure.setMeasureName("RANK");
			rankMeasure.setParaContextGbo(new SFCBOHandle(site,x.getSfc()).getValue());
			List<ViewParametricMeasure> rankList = fwDcGroupRepo.getParametricMeasure(rankMeasure);
			if(!FwUtils.isEmpty(rankList)){
				x.setProductRank(rankList.get(0).getActual());
			}
		});
		return response;
	}

	private void checkPackCheckOutByPallet(PackCheckOutRequest packCheckOutRequest){
		ZPackMaster carton = new ZPackMaster();
		carton.setSite(packCheckOutRequest.getSite());
		carton.setContainerNo(packCheckOutRequest.getPallet());
		carton.setContainerType("P");
		ZPackMaster zPackMaster = packagingRepository.getPackMaster(carton);
		if(FwUtils.objIsEmpty(zPackMaster)){
			FwUtils.getCustomException("pack.check.out.error5");
		}

		if("0".equals(zPackMaster.getStatus())){
			FwUtils.getCustomException("pack.check.out.error6", new Object[]{zPackMaster.getContainerNo()});
		}

		if("2".equals(zPackMaster.getStatus())){
			FwUtils.getCustomException("pack.check.out.error7", new Object[]{zPackMaster.getContainerNo()});
		}

		List<ZPackDetail> detailList =  packagingRepository.getPackDetail(zPackMaster.getSid());

		List<String> cartonList = detailList.stream().map(ZPackDetail::getCartonNo).collect(Collectors.toList());

		List<ZPackMaster> cartonMasterList = packagingRepository.getPackMaster(packCheckOutRequest.getSite(), cartonList);

		List<ZPackDetail> sfcDetail = new ArrayList<>();

		for(ZPackMaster cartonMaster : cartonMasterList){
			if("2".equals(cartonMaster.getStatus())){
				FwUtils.getCustomException("pack.check.out.error8", new Object[]{zPackMaster.getContainerNo(), cartonMaster.getContainerNo()});
			}
			sfcDetail.addAll(packagingRepository.getPackDetail(cartonMaster.getSid()));
		}

		Map<String, Long> detailListGroupBySfc = sfcDetail.stream().collect(Collectors.groupingBy(ZPackDetail::getSfc,Collectors.counting()));
		for(String sfc : detailListGroupBySfc.keySet()){
			List<ViewSfcRoutingStep> sfcStepList = sfcRepo.getSfcStepInWork(packCheckOutRequest.getSite(), sfc);
			List<ViewSfcRoutingStep> sfcInOpList = sfcStepList.stream().filter(x-> x.getOperationBo().equals(new OperationBOHandle(packCheckOutRequest.getSite(),packCheckOutRequest.getOperation(),"#").getValue())).collect(Collectors.toList());
			if(FwUtils.isEmpty(sfcInOpList)){
				FwUtils.getCustomException("pack.check.out.error4", new Object[]{sfc});
			}
			if(sfcInOpList.get(0).getQtyInWork().compareTo(new BigDecimal(detailListGroupBySfc.get(sfc)))<0){
				FwUtils.getCustomException("pack.check.out.error4", new Object[]{sfc});
			}
		}
	}

	private void checkPackCheckOutByCarton(PackCheckOutRequest packCheckOutRequest){
		ZPackMaster carton = new ZPackMaster();
		carton.setSite(packCheckOutRequest.getSite());
		carton.setContainerNo(packCheckOutRequest.getCarton());
		carton.setContainerType("C");
		ZPackMaster zPackMaster = packagingRepository.getPackMaster(carton);

		if(FwUtils.objIsEmpty(zPackMaster)){
			FwUtils.getCustomException("pack.check.out.error1");
		}

		if("0".equals(zPackMaster.getStatus())){
			FwUtils.getCustomException("pack.check.out.error2", new Object[]{zPackMaster.getContainerNo()});
		}

		if("2".equals(zPackMaster.getStatus())){
			FwUtils.getCustomException("pack.check.out.error3", new Object[]{zPackMaster.getContainerNo()});
		}

		List<ZPackDetail> detailList =  packagingRepository.getPackDetail(zPackMaster.getSid());
		Map<String, Long> detailListGroupBySfc = detailList.stream().collect(Collectors.groupingBy(ZPackDetail::getSfc,Collectors.counting()));
		for(String sfc : detailListGroupBySfc.keySet()){
			List<ViewSfcRoutingStep> sfcStepList = sfcRepo.getSfcStepInWork(packCheckOutRequest.getSite(), sfc);
			List<ViewSfcRoutingStep> sfcInOpList = sfcStepList.stream().filter(x-> x.getOperationBo().equals(new OperationBOHandle(packCheckOutRequest.getSite(),packCheckOutRequest.getOperation(),"#").getValue())).collect(Collectors.toList());
			if(FwUtils.isEmpty(sfcInOpList)){
				FwUtils.getCustomException("pack.check.out.error4", new Object[]{sfc});
			}
			if(sfcInOpList.get(0).getQtyInWork().compareTo(new BigDecimal(detailListGroupBySfc.get(sfc)))<0){
				FwUtils.getCustomException("pack.check.out.error4", new Object[]{sfc});
			}
		}

	}
}
