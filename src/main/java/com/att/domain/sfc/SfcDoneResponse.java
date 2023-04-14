package com.att.domain.sfc;

import com.att.repository.entity.ZVwSfcDone;

import java.util.ArrayList;
import java.util.List;

public class SfcDoneResponse {

	private String operationDesc;
	private String resourceDesc;
	private List<ZVwSfcDone> zVwSfcDoneList;

	public String getOperationDesc() {
		return operationDesc;
	}

	public void setOperationDesc(String operationDesc) {
		this.operationDesc = operationDesc;
	}

	public String getResourceDesc() {
		return resourceDesc;
	}

	public void setResourceDesc(String resourceDesc) {
		this.resourceDesc = resourceDesc;
	}

	public List<ZVwSfcDone> getzVwSfcDoneList() {
		if(this.zVwSfcDoneList == null)
			this.zVwSfcDoneList = new ArrayList<>();
		return zVwSfcDoneList;
	}

	public void setzVwSfcDoneList(List<ZVwSfcDone> zVwSfcDoneList) {
		this.zVwSfcDoneList = zVwSfcDoneList;
	}
}
