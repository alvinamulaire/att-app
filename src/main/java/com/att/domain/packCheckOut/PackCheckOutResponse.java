package com.att.domain.packCheckOut;

import java.math.BigDecimal;

public class PackCheckOutResponse {
	private String item;
	private String itemDesc;
	private String shopOrder;
	private String sfc;
	private BigDecimal qty;
	private String pallet;
	private String carton;
	private String mfgDate;
	private String expDate;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
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

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
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

	public String getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
}
