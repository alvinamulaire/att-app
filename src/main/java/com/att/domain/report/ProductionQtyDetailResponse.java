package com.att.domain.report;

import com.att.repository.entity.ZVwProductionQtyDetail;

public class ProductionQtyDetailResponse extends ZVwProductionQtyDetail {

	private String dateTimeStr;

	public String getDateTimeStr() {
		return dateTimeStr;
	}

	public void setDateTimeStr(String dateTimeStr) {
		this.dateTimeStr = dateTimeStr;
	}
}
