package com.att.service;

import com.att.domain.packCheckOut.PackCheckOutMasterResponse;
import com.att.domain.packCheckOut.PackCheckOutRequest;
import com.att.domain.packCheckOut.PackCheckOutResponse;

import java.util.List;

public interface PackCheckOutService {

	void checkPackCheckOut(PackCheckOutRequest packCheckOutRequest);

	PackCheckOutMasterResponse checkOut(List<PackCheckOutRequest> requestList, String locale);
}
