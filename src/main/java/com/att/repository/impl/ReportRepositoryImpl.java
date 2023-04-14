package com.att.repository.impl;

import com.att.domain.report.ProductionDateReportRequest;
import com.att.domain.shopOrder.SoCustomRequest;
import com.att.repository.ReportRepository;
import com.att.repository.entity.*;
import com.att.repository.mapper.*;
import com.fw.mes.me.controller.site.SiteRepo;
import com.fw.mes.util.DateUtil;
import com.fw.mes.util.FwUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ReportRepositoryImpl implements ReportRepository {

	@Autowired
	private ZVwProductionQtyMapper zVwProductionQtyMapper;

	@Autowired
	private ZVwProductionQtyNcMapper zVwProductionQtyNcMapper;

	@Autowired
	private ZVwProductionQtyDetailMapper zVwProductionQtyDetailMapper;

	@Autowired
	private ZVwSoCustomMapper zVwSoCustomMapper;

	@Autowired
	private SiteRepo siteRepo;

	@Autowired
	private ZVwProductionIntegratedKanban1Mapper zVwProductionIntegratedKanban1Mapper;

	@Autowired
	private ZVwProductionIntegratedKanban2Mapper zVwProductionIntegratedKanban2Mapper;

	@Autowired
	private ZVwProductionIntegratedKanban3Mapper zVwProductionIntegratedKanban3Mapper;

	@Override
	public List<ZVwProductionQty> findZVwProductionQty(ProductionDateReportRequest productRackRequest, String locale) {
		String timeZone = siteRepo.getTimeZone(productRackRequest.getSite());

		ZVwProductionQtyExample example = new ZVwProductionQtyExample();
		ZVwProductionQtyExample.Criteria criteria = example.createCriteria();
		criteria.andSiteEqualTo(productRackRequest.getSite());
		if(!FwUtils.isEmpty(productRackRequest.getItemList())){
			criteria.andItemIn(productRackRequest.getItemList());
		}
		if(!FwUtils.isNullOrEmpty(productRackRequest.getItem())){
			criteria.andItemEqualTo(productRackRequest.getItem());
		}
		if(!FwUtils.isNullOrEmpty(productRackRequest.getShopOrder())){
			criteria.andShopOrderEqualTo(productRackRequest.getShopOrder());
		}
		if(!FwUtils.isNullOrEmpty(productRackRequest.getOperation())){
			criteria.andOperationEqualTo(productRackRequest.getOperation());
		}
		if(!FwUtils.isNullOrEmpty(productRackRequest.getErpOperation())){
			criteria.andErpOperationEqualTo(productRackRequest.getErpOperation());
		}
		if(!FwUtils.isNullOrEmpty(productRackRequest.getRouter())){
			criteria.andRouterEqualTo(productRackRequest.getRouter());
		}
		return zVwProductionQtyMapper.selectByExample(example, locale, DateUtil.toGmtDate(productRackRequest.getStartDate(),timeZone), DateUtil.toGmtDate(productRackRequest.getEndDate(),timeZone));
	}

	@Override
	public List<ZVwProductionQtyNc> findZVwProductionQtyNc(ZVwProductionQty zVwProductionQty, String locale, Date startDate, Date endDate) {
		ZVwProductionQtyNcExample example = new ZVwProductionQtyNcExample();
		example.createCriteria()
				.andShopOrderEqualTo(zVwProductionQty.getShopOrder())
				.andRouterEqualTo(zVwProductionQty.getRouter())
				.andRouterRevisionEqualTo(zVwProductionQty.getRouterRevision())
				.andOperationEqualTo(zVwProductionQty.getOperation())
				.andDateEqualTo(zVwProductionQty.getDate());

		return zVwProductionQtyNcMapper.selectByExample(example, locale, startDate, endDate);
	}

	@Override
	public List<ZVwProductionQtyDetail> findZVwProductionQtyDetail(ProductionDateReportRequest productRackRequest, String locale) {
		String timeZone = siteRepo.getTimeZone(productRackRequest.getSite());
		ZVwProductionQtyDetailExample example = new ZVwProductionQtyDetailExample();
		example.createCriteria()
				.andShopOrderEqualTo(productRackRequest.getShopOrder())
				.andRouterEqualTo(productRackRequest.getRouter())
				.andRouterRevisionEqualTo(productRackRequest.getRouterRevision())
				.andOperationEqualTo(productRackRequest.getOperation());
		return zVwProductionQtyDetailMapper.selectByExample(example, locale, DateUtil.toGmtDate(productRackRequest.getStartDate(),timeZone), DateUtil.toGmtDate(productRackRequest.getEndDate(),timeZone));
	}

	@Override
	public ZVwProductionIntegratedKanban1 findZVwProductionIntegratedKanban1(ZVwProductionIntegratedKanban1 zVwProductionIntegratedKanban1) {
		ZVwProductionIntegratedKanban1Example example = new ZVwProductionIntegratedKanban1Example();
		ZVwProductionIntegratedKanban1Example.Criteria criteria = example.createCriteria();
		if(!FwUtils.isNullOrEmpty(zVwProductionIntegratedKanban1.getSite())){
			criteria.andSiteEqualTo(zVwProductionIntegratedKanban1.getSite());
		}
		if(!FwUtils.isNullOrEmpty(zVwProductionIntegratedKanban1.getItem())){
			criteria.andItemEqualTo(zVwProductionIntegratedKanban1.getItem());
		}
		List<ZVwProductionIntegratedKanban1> zVwProductionIntegratedKanban1List = zVwProductionIntegratedKanban1Mapper.selectByExample(example);
		return FwUtils.isEmpty(zVwProductionIntegratedKanban1List) ? null : zVwProductionIntegratedKanban1List.get(0);
	}

	@Override
	public ZVwProductionIntegratedKanban2 findZVwProductionIntegratedKanban2(ZVwProductionIntegratedKanban2 zVwProductionIntegratedKanban2, Date startDate, Date endDate) {
		ZVwProductionIntegratedKanban2Example example = new ZVwProductionIntegratedKanban2Example();
		ZVwProductionIntegratedKanban2Example.Criteria criteria = example.createCriteria();
		if(!FwUtils.isNullOrEmpty(zVwProductionIntegratedKanban2.getSite())){
			criteria.andSiteEqualTo(zVwProductionIntegratedKanban2.getSite());
		}
		if(!FwUtils.isNullOrEmpty(zVwProductionIntegratedKanban2.getItem())){
			criteria.andItemEqualTo(zVwProductionIntegratedKanban2.getItem());
		}
		List<ZVwProductionIntegratedKanban2> zVwProductionIntegratedKanban2List = zVwProductionIntegratedKanban2Mapper.selectByExample(example, startDate, endDate);
		return FwUtils.isEmpty(zVwProductionIntegratedKanban2List) ? null : zVwProductionIntegratedKanban2List.get(0);
	}

	@Override
	public List<ZVwProductionIntegratedKanban3> findZVwProductionIntegratedKanban3(ZVwProductionIntegratedKanban3 zVwProductionIntegratedKanban3, Date startDate, Date endDate) {
		ZVwProductionIntegratedKanban3Example example = new ZVwProductionIntegratedKanban3Example();
		ZVwProductionIntegratedKanban3Example.Criteria criteria = example.createCriteria();
		if(!FwUtils.isNullOrEmpty(zVwProductionIntegratedKanban3.getSite())){
			criteria.andSiteEqualTo(zVwProductionIntegratedKanban3.getSite());
		}
		if(!FwUtils.isNullOrEmpty(zVwProductionIntegratedKanban3.getItem())){
			criteria.andItemEqualTo(zVwProductionIntegratedKanban3.getItem());
		}
		if(!FwUtils.isNullOrEmpty(zVwProductionIntegratedKanban3.getRouter())){
			criteria.andRouterEqualTo(zVwProductionIntegratedKanban3.getRouter());
		}
		if(!FwUtils.isNullOrEmpty(zVwProductionIntegratedKanban3.getRouterRevision())){
			criteria.andRouterRevisionEqualTo(zVwProductionIntegratedKanban3.getRouterRevision());
		}
		return zVwProductionIntegratedKanban3Mapper.selectByExample(example, startDate, endDate);
	}
}
