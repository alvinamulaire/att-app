package com.att.controller;

import com.att.domain.packCheckOut.PackCheckOutMasterResponse;
import com.att.domain.packCheckOut.PackCheckOutRequest;
import com.att.domain.packCheckOut.PackCheckOutResponse;
import com.att.service.PackCheckOutService;
import com.businessobjects.visualization.internal.org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@CrossOrigin(origins = { "*" })
public class PackCheckOutController {

	@Autowired
	private PackCheckOutService packCheckOutService;

	@PostMapping("packCheckOut/check")
	public void check(@RequestBody PackCheckOutRequest request) throws JSONException {
		packCheckOutService.checkPackCheckOut(request);
	}

	@PostMapping("packCheckOut/checkOut")
	@Transactional
	public PackCheckOutMasterResponse checkOut(@RequestBody List<PackCheckOutRequest> requestList, Locale locale) throws JSONException {
		return packCheckOutService.checkOut(requestList, locale.toString().toLowerCase());
	}
}
