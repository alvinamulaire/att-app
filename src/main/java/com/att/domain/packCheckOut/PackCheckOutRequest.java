package com.att.domain.packCheckOut;

public class PackCheckOutRequest {

	private String site;
	private String user;
	private String type;
	private String carton;
	private String pallet;
	private String operation;
	private String activity;

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}
}
