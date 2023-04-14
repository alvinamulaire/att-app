package com.att.domain.report;

import com.att.repository.entity.ZVwProductionQty;

import java.math.BigDecimal;

public class ProductionDateReportResponse extends ZVwProductionQty {

	private BigDecimal qtyRework;
	private String yield;
	private String scrapRate;
	private String throughRate;
	private String reworkRate;
	private String uph;
	private String hpu;

	public BigDecimal getQtyRework() {
		return qtyRework;
	}

	public void setQtyRework(BigDecimal qtyRework) {
		this.qtyRework = qtyRework;
	}

	public String getYield() {
		return yield;
	}

	public void setYield(String yield) {
		this.yield = yield;
	}

	public String getScrapRate() {
		return scrapRate;
	}

	public void setScrapRate(String scrapRate) {
		this.scrapRate = scrapRate;
	}

	public String getThroughRate() {
		return throughRate;
	}

	public void setThroughRate(String throughRate) {
		this.throughRate = throughRate;
	}

	public String getReworkRate() {
		return reworkRate;
	}

	public void setReworkRate(String reworkRate) {
		this.reworkRate = reworkRate;
	}

	public String getUph() {
		return uph;
	}

	public void setUph(String uph) {
		this.uph = uph;
	}

	public String getHpu() {
		return hpu;
	}

	public void setHpu(String hpu) {
		this.hpu = hpu;
	}
}
