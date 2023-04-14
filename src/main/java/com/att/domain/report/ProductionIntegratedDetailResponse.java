package com.att.domain.report;

import com.att.repository.entity.ZVwProductionIntegratedKanban3;

public class ProductionIntegratedDetailResponse extends ZVwProductionIntegratedKanban3 {

	private String inQtyStr;
	private String qtyCompletedStr;
	private String qtyScrappedStr;

	public String getInQtyStr() {
		return inQtyStr;
	}

	public void setInQtyStr(String inQtyStr) {
		this.inQtyStr = inQtyStr;
	}

	public String getQtyCompletedStr() {
		return qtyCompletedStr;
	}

	public void setQtyCompletedStr(String qtyCompletedStr) {
		this.qtyCompletedStr = qtyCompletedStr;
	}

	public String getQtyScrappedStr() {
		return qtyScrappedStr;
	}

	public void setQtyScrappedStr(String qtyScrappedStr) {
		this.qtyScrappedStr = qtyScrappedStr;
	}
}
