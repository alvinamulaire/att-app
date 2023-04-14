package com.att.domain.sfc;

import java.util.List;

public class SfcDoneRequest {

	private String site;
	private String operation;
	private String resource;
	private List<String> sfcList;

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public List<String> getSfcList() {
		return sfcList;
	}

	public void setSfcList(List<String> sfcList) {
		this.sfcList = sfcList;
	}
}
