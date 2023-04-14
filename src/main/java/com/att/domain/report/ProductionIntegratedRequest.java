package com.att.domain.report;

public class ProductionIntegratedRequest {

	private String site;
	private String item;
	private String router;
	private String routerReversion;

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

	public String getRouter() {
		return router;
	}

	public void setRouter(String router) {
		this.router = router;
	}

	public String getRouterReversion() {
		return routerReversion;
	}

	public void setRouterReversion(String routerReversion) {
		this.routerReversion = routerReversion;
	}
}
