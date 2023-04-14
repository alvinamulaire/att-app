package com.att.domain.report;

import java.util.List;

public class ProductionDateReportRequest {

	private String site;
	private String startDate;
	private String endDate;
	private String item;
	private List<String> itemList;
	private String shopOrder;
	private String operation;
	private String erpOperation;
	private String router;
	private String routerRevision;

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getShopOrder() {
		return shopOrder;
	}

	public void setShopOrder(String shopOrder) {
		this.shopOrder = shopOrder;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getErpOperation() {
		return erpOperation;
	}

	public void setErpOperation(String erpOperation) {
		this.erpOperation = erpOperation;
	}

	public String getRouter() {
		return router;
	}

	public void setRouter(String router) {
		this.router = router;
	}

	public String getRouterRevision() {
		return routerRevision;
	}

	public void setRouterRevision(String routerRevision) {
		this.routerRevision = routerRevision;
	}

	public List<String> getItemList() {
		return itemList;
	}

	public void setItemList(List<String> itemList) {
		this.itemList = itemList;
	}
}
