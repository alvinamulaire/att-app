package com.att.domain.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductionIntegratedResponse {

	private String site;

	private String item;

	private BigDecimal totalInQty;

	private BigDecimal totalInHoldQty;

	private BigDecimal totalInReworkQty;

	private BigDecimal monthlyActualProductionKpi;

	private BigDecimal monthlyActualProductionQty;

	private BigDecimal monthlyQtyStarted;

	private BigDecimal monthlyQtyScrapped;

	private BigDecimal monthlyReworkQty;

	private BigDecimal monthlyAchievementRate;

	private BigDecimal monthlyThruYield;

	private BigDecimal monthlyYield;

	private BigDecimal monthlyReworkRate;

	private BigDecimal actualProductionKpi;

	private BigDecimal actualProductionQty;

	private BigDecimal qtyStarted;

	private BigDecimal qtyScrapped;

	private BigDecimal reworkQty;

	private BigDecimal achievementRate;

	private BigDecimal thruYield;

	private BigDecimal yield;

	private BigDecimal reworkRate;

	private String monthWipUpper;

	private String monthWipLower;

	private String monthWipRework;

	private String monthWipHold;

	private String monthAchievementRate;

	private String monthFpy;

	private String monthYield;

	private String monthScrap;

	private String monthRework;

	private String monthReworkRate;

	private String dayAchievementRate;

	private String dayFpy;

	private String dayYield;

	private String dayScrap;

	private String dayReworkRate;

	private String dayRework;

	private List<ProductionIntegratedDetailResponse> routerList;

	public ProductionIntegratedResponse() {
		this.totalInQty = BigDecimal.ZERO;
		this.totalInHoldQty = BigDecimal.ZERO;
		this.totalInReworkQty = BigDecimal.ZERO;
		this.monthlyActualProductionKpi = BigDecimal.ZERO;
		this.monthlyActualProductionQty = BigDecimal.ZERO;
		this.monthlyQtyStarted = BigDecimal.ZERO;
		this.monthlyQtyScrapped = BigDecimal.ZERO;
		this.monthlyReworkQty = BigDecimal.ZERO;
		this.monthlyAchievementRate = BigDecimal.ZERO;
		this.monthlyThruYield = BigDecimal.ZERO;
		this.monthlyYield = BigDecimal.ZERO;
		this.monthlyReworkRate = BigDecimal.ZERO;
		this.actualProductionKpi = BigDecimal.ZERO;
		this.actualProductionQty = BigDecimal.ZERO;
		this.qtyStarted = BigDecimal.ZERO;
		this.qtyScrapped = BigDecimal.ZERO;
		this.reworkQty = BigDecimal.ZERO;
		this.achievementRate = BigDecimal.ZERO;
		this.thruYield = BigDecimal.ZERO;
		this.yield = BigDecimal.ZERO;
		this.reworkRate = BigDecimal.ZERO;
		this.routerList = new ArrayList<>();
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public BigDecimal getTotalInQty() {
		return totalInQty;
	}

	public void setTotalInQty(BigDecimal totalInQty) {
		this.totalInQty = totalInQty;
	}

	public BigDecimal getTotalInHoldQty() {
		return totalInHoldQty;
	}

	public void setTotalInHoldQty(BigDecimal totalInHoldQty) {
		this.totalInHoldQty = totalInHoldQty;
	}

	public BigDecimal getTotalInReworkQty() {
		return totalInReworkQty;
	}

	public void setTotalInReworkQty(BigDecimal totalInReworkQty) {
		this.totalInReworkQty = totalInReworkQty;
	}

	public BigDecimal getMonthlyActualProductionKpi() {
		return monthlyActualProductionKpi;
	}

	public void setMonthlyActualProductionKpi(BigDecimal monthlyActualProductionKpi) {
		this.monthlyActualProductionKpi = monthlyActualProductionKpi;
	}

	public BigDecimal getMonthlyActualProductionQty() {
		return monthlyActualProductionQty;
	}

	public void setMonthlyActualProductionQty(BigDecimal monthlyActualProductionQty) {
		this.monthlyActualProductionQty = monthlyActualProductionQty;
	}

	public BigDecimal getMonthlyQtyStarted() {
		return monthlyQtyStarted;
	}

	public void setMonthlyQtyStarted(BigDecimal monthlyQtyStarted) {
		this.monthlyQtyStarted = monthlyQtyStarted;
	}

	public BigDecimal getMonthlyQtyScrapped() {
		return monthlyQtyScrapped;
	}

	public void setMonthlyQtyScrapped(BigDecimal monthlyQtyScrapped) {
		this.monthlyQtyScrapped = monthlyQtyScrapped;
	}

	public BigDecimal getMonthlyReworkQty() {
		return monthlyReworkQty;
	}

	public void setMonthlyReworkQty(BigDecimal monthlyReworkQty) {
		this.monthlyReworkQty = monthlyReworkQty;
	}

	public BigDecimal getMonthlyAchievementRate() {
		return monthlyAchievementRate;
	}

	public void setMonthlyAchievementRate(BigDecimal monthlyAchievementRate) {
		this.monthlyAchievementRate = monthlyAchievementRate;
	}

	public BigDecimal getMonthlyThruYield() {
		return monthlyThruYield;
	}

	public void setMonthlyThruYield(BigDecimal monthlyThruYield) {
		this.monthlyThruYield = monthlyThruYield;
	}

	public BigDecimal getMonthlyYield() {
		return monthlyYield;
	}

	public void setMonthlyYield(BigDecimal monthlyYield) {
		this.monthlyYield = monthlyYield;
	}

	public BigDecimal getMonthlyReworkRate() {
		return monthlyReworkRate;
	}

	public void setMonthlyReworkRate(BigDecimal monthlyReworkRate) {
		this.monthlyReworkRate = monthlyReworkRate;
	}

	public BigDecimal getActualProductionKpi() {
		return actualProductionKpi;
	}

	public void setActualProductionKpi(BigDecimal actualProductionKpi) {
		this.actualProductionKpi = actualProductionKpi;
	}

	public BigDecimal getActualProductionQty() {
		return actualProductionQty;
	}

	public void setActualProductionQty(BigDecimal actualProductionQty) {
		this.actualProductionQty = actualProductionQty;
	}

	public BigDecimal getQtyStarted() {
		return qtyStarted;
	}

	public void setQtyStarted(BigDecimal qtyStarted) {
		this.qtyStarted = qtyStarted;
	}

	public BigDecimal getQtyScrapped() {
		return qtyScrapped;
	}

	public void setQtyScrapped(BigDecimal qtyScrapped) {
		this.qtyScrapped = qtyScrapped;
	}

	public BigDecimal getReworkQty() {
		return reworkQty;
	}

	public void setReworkQty(BigDecimal reworkQty) {
		this.reworkQty = reworkQty;
	}

	public BigDecimal getAchievementRate() {
		return achievementRate;
	}

	public void setAchievementRate(BigDecimal achievementRate) {
		this.achievementRate = achievementRate;
	}

	public BigDecimal getThruYield() {
		return thruYield;
	}

	public void setThruYield(BigDecimal thruYield) {
		this.thruYield = thruYield;
	}

	public BigDecimal getYield() {
		return yield;
	}

	public void setYield(BigDecimal yield) {
		this.yield = yield;
	}

	public BigDecimal getReworkRate() {
		return reworkRate;
	}

	public void setReworkRate(BigDecimal reworkRate) {
		this.reworkRate = reworkRate;
	}

	public List<ProductionIntegratedDetailResponse> getRouterList() {
		return routerList;
	}

	public void setRouterList(List<ProductionIntegratedDetailResponse> routerList) {
		this.routerList = routerList;
	}

	public String getMonthWipUpper() {
		return monthWipUpper;
	}

	public void setMonthWipUpper(String monthWipUpper) {
		this.monthWipUpper = monthWipUpper;
	}

	public String getMonthWipLower() {
		return monthWipLower;
	}

	public void setMonthWipLower(String monthWipLower) {
		this.monthWipLower = monthWipLower;
	}

	public String getMonthWipRework() {
		return monthWipRework;
	}

	public void setMonthWipRework(String monthWipRework) {
		this.monthWipRework = monthWipRework;
	}

	public String getMonthWipHold() {
		return monthWipHold;
	}

	public void setMonthWipHold(String monthWipHold) {
		this.monthWipHold = monthWipHold;
	}

	public String getMonthAchievementRate() {
		return monthAchievementRate;
	}

	public void setMonthAchievementRate(String monthAchievementRate) {
		this.monthAchievementRate = monthAchievementRate;
	}

	public String getMonthFpy() {
		return monthFpy;
	}

	public void setMonthFpy(String monthFpy) {
		this.monthFpy = monthFpy;
	}

	public String getMonthYield() {
		return monthYield;
	}

	public void setMonthYield(String monthYield) {
		this.monthYield = monthYield;
	}

	public String getMonthScrap() {
		return monthScrap;
	}

	public void setMonthScrap(String monthScrap) {
		this.monthScrap = monthScrap;
	}

	public String getMonthRework() {
		return monthRework;
	}

	public void setMonthRework(String monthRework) {
		this.monthRework = monthRework;
	}

	public String getDayAchievementRate() {
		return dayAchievementRate;
	}

	public void setDayAchievementRate(String dayAchievementRate) {
		this.dayAchievementRate = dayAchievementRate;
	}

	public String getDayFpy() {
		return dayFpy;
	}

	public void setDayFpy(String dayFpy) {
		this.dayFpy = dayFpy;
	}

	public String getDayYield() {
		return dayYield;
	}

	public void setDayYield(String dayYield) {
		this.dayYield = dayYield;
	}

	public String getDayScrap() {
		return dayScrap;
	}

	public void setDayScrap(String dayScrap) {
		this.dayScrap = dayScrap;
	}

	public String getDayReworkRate() {
		return dayReworkRate;
	}

	public void setDayReworkRate(String dayReworkRate) {
		this.dayReworkRate = dayReworkRate;
	}

	public String getDayRework() {
		return dayRework;
	}

	public void setDayRework(String dayRework) {
		this.dayRework = dayRework;
	}

	public String getMonthReworkRate() {
		return monthReworkRate;
	}

	public void setMonthReworkRate(String monthReworkRate) {
		this.monthReworkRate = monthReworkRate;
	}
}