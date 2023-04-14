package com.att.domain.print;

public class AttPrintResponse {

	private String site;
	private String shopOrder;
	private String sfc;
	private String tlSn;
	private String pallet;
	private String carton;

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getShopOrder() {
		return shopOrder;
	}

	public void setShopOrder(String shopOrder) {
		this.shopOrder = shopOrder;
	}

	public String getSfc() {
		return sfc;
	}

	public void setSfc(String sfc) {
		this.sfc = sfc;
	}

	public String getTlSn() {
		return tlSn;
	}

	public void setTlSn(String tlSn) {
		this.tlSn = tlSn;
	}

	public String getPallet() {
		return pallet;
	}

	public void setPallet(String pallet) {
		this.pallet = pallet;
	}

	public String getCarton() {
		return carton;
	}

	public void setCarton(String carton) {
		this.carton = carton;
	}
}
