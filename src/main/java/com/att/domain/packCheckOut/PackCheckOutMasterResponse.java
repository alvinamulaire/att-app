package com.att.domain.packCheckOut;

import com.att.repository.entity.ZVwSfcDone;

import java.util.ArrayList;
import java.util.List;

public class PackCheckOutMasterResponse {

	private List<PackCheckOutResponse> packCheckOutResponseList;

	private List<ZVwSfcDone> zVwSfcDoneList;

	public List<PackCheckOutResponse> getPackCheckOutResponseList() {
		if(this.packCheckOutResponseList == null)
			this.packCheckOutResponseList = new ArrayList<>();
		return packCheckOutResponseList;
	}

	public void setPackCheckOutResponseList(List<PackCheckOutResponse> packCheckOutResponseList) {
		this.packCheckOutResponseList = packCheckOutResponseList;
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
