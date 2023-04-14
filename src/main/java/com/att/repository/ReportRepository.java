package com.att.repository;

import com.att.domain.report.ProductionDateReportRequest;
import com.att.domain.shopOrder.SoCustomRequest;
import com.att.repository.entity.*;

import java.util.Date;
import java.util.List;

public interface ReportRepository {

	List<ZVwProductionQty> findZVwProductionQty(ProductionDateReportRequest productRackRequest, String locale);

	List<ZVwProductionQtyNc> findZVwProductionQtyNc(ZVwProductionQty zVwProductionQty, String locale, Date startDate, Date endDate);

	List<ZVwProductionQtyDetail> findZVwProductionQtyDetail(ProductionDateReportRequest productRackRequest, String locale);

	ZVwProductionIntegratedKanban1 findZVwProductionIntegratedKanban1(ZVwProductionIntegratedKanban1 zVwProductionIntegratedKanban1);

	ZVwProductionIntegratedKanban2 findZVwProductionIntegratedKanban2(ZVwProductionIntegratedKanban2 zVwProductionIntegratedKanban2, Date startDate, Date endDate);

	List<ZVwProductionIntegratedKanban3> findZVwProductionIntegratedKanban3(ZVwProductionIntegratedKanban3 zVwProductionIntegratedKanban3, Date startDate, Date endDate);

}
