package com.att.domain.print;

import java.util.List;

public class AttPrintRequest {

	private String site;
	private String printer;
	private String sfc;
	private String shopOrder;
	private String tlSn;
	private String carton;
	private String pallet;
	private String labelType;
	private String user;
	private String activity;

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getPrinter() {
		return printer;
	}

	public void setPrinter(String printer) {
		this.printer = printer;
	}

	public String getSfc() {
		return sfc;
	}

	public void setSfc(String sfc) {
		this.sfc = sfc;
	}

	public String getShopOrder() {
		return shopOrder;
	}

	public void setShopOrder(String shopOrder) {
		this.shopOrder = shopOrder;
	}

	public String getTlSn() {
		return tlSn;
	}

	public void setTlSn(String tlSn) {
		this.tlSn = tlSn;
	}

	public String getCarton() {
		return carton;
	}

	public void setCarton(String carton) {
		this.carton = carton;
	}

	public String getPallet() {
		return pallet;
	}

	public void setPallet(String pallet) {
		this.pallet = pallet;
	}

	public String getLabelType() {
		return labelType;
	}

	public void setLabelType(String labelType) {
		this.labelType = labelType;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}
}
