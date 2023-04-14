package com.att.controller;

import com.att.domain.report.*;
import com.att.domain.shopOrder.SoCustomRequest;
import com.att.domain.soRelease.SoCustom;
import com.att.service.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@Api(tags = "報表相關api")
@RestController
@CrossOrigin(origins = { "*" })
public class ReportController {


	@Autowired
	private ReportService reportService;

	@ApiOperation("生產日報表-檢索")
	@PostMapping("/report/production/date/info")
	public List<ProductionDateReportResponse> productionDateReportInfo(@RequestBody ProductionDateReportRequest productRackRequest , Locale locale) {
		return reportService.productionDateReport(productRackRequest, locale.toString().toLowerCase());
	}

	@ApiOperation("生產日報表-明細-檢索")
	@PostMapping("/report/production/date/detail/info")
	public List<ProductionQtyDetailResponse> productionDateReportDetailInfo(@RequestBody ProductionDateReportRequest productRackRequest , Locale locale) {
		return reportService.productionDateReportDetail(productRackRequest, locale.toString().toLowerCase());
	}

	@ApiOperation("生產日報表-工單開窗")
	@PostMapping("/so/custom/list")
	public List<SoCustom> getSoCustomList(@RequestBody SoCustomRequest request , Locale locale) {
		return reportService.getSoCustomList(request, locale.toString().toLowerCase());
	}

	@ApiOperation("生產綜合看板-檢索")
	@PostMapping("/report/production/integrated/info")
	public ProductionIntegratedResponse productionIntegratedInfo(@RequestBody ProductionIntegratedRequest request) {
		return reportService.productionIntegratedInfo(request);
	}
}
