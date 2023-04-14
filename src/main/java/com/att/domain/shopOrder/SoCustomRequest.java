package com.att.domain.shopOrder;

import com.att.repository.entity.ZVwSoCustom;

import java.util.Date;

public class SoCustomRequest extends ZVwSoCustom {

	private String plannedCompDateStartStr;
	private String plannedCompDateEndStr;

	private Date plannedCompDateStart;
	private Date plannedCompDateEnd;

	public String getPlannedCompDateStartStr() {
		return plannedCompDateStartStr;
	}

	public void setPlannedCompDateStartStr(String plannedCompDateStartStr) {
		this.plannedCompDateStartStr = plannedCompDateStartStr;
	}

	public String getPlannedCompDateEndStr() {
		return plannedCompDateEndStr;
	}

	public void setPlannedCompDateEndStr(String plannedCompDateEndStr) {
		this.plannedCompDateEndStr = plannedCompDateEndStr;
	}

	public Date getPlannedCompDateStart() {
		return plannedCompDateStart;
	}

	public void setPlannedCompDateStart(Date plannedCompDateStart) {
		this.plannedCompDateStart = plannedCompDateStart;
	}

	public Date getPlannedCompDateEnd() {
		return plannedCompDateEnd;
	}

	public void setPlannedCompDateEnd(Date plannedCompDateEnd) {
		this.plannedCompDateEnd = plannedCompDateEnd;
	}
}
