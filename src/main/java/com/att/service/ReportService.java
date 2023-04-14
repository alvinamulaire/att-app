package com.att.service;

import com.att.domain.report.*;
import com.att.domain.shopOrder.SoCustomRequest;
import com.att.domain.soRelease.SoCustom;
import com.att.repository.entity.ZVwProductionQty;
import com.att.repository.entity.ZVwProductionQtyDetail;

import java.util.List;

public interface ReportService {

	List<ProductionDateReportResponse> productionDateReport(ProductionDateReportRequest request, String locale);

	/**
	 * 生產日報表-生產歷程
	 * @return
	 */
	List<ProductionQtyDetailResponse> productionDateReportDetail(ProductionDateReportRequest request, String locale);

	/**
	 * 工單開窗
	 * @return
	 */
	List<SoCustom> getSoCustomList(SoCustomRequest request, String locale);

	ProductionIntegratedResponse productionIntegratedInfo(ProductionIntegratedRequest request);
}
