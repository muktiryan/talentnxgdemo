package com.talentnxg.talentnxgapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.talentnxg.talentnxgapi.dao.MSystemLicenseDao;
import com.talentnxg.talentnxgapi.models.MSystemLicense;
import com.talentnxg.talentnxgapi.response.DefaultResponse;

@CrossOrigin(origins = "*")
@RestController
public class MSystemLicenseController {
	@Autowired
	private MSystemLicenseDao mSystemLicenseDao;
	
	// insert 
	@PostMapping("license")
	public ResponseEntity<DefaultResponse> saveMSystemLicense(@RequestBody MSystemLicense mUserLicense){
		Integer result = mSystemLicenseDao.saveMSystemLicense(mUserLicense);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}

}
