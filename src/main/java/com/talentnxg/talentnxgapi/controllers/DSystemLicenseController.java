package com.talentnxg.talentnxgapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentnxg.talentnxgapi.dao.DSystemLicenseDao;
import com.talentnxg.talentnxgapi.models.DSystemLicense;
import com.talentnxg.talentnxgapi.models.MApplicationCustom2;
import com.talentnxg.talentnxgapi.pojos.ReqSaveDSystemLicenseCst1;
import com.talentnxg.talentnxgapi.response.DefaultResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "${v1API}")
public class DSystemLicenseController {
	
	@Autowired
	private DSystemLicenseDao dSystemLicenseDao;
	
	//retrieve all
	@RequestMapping("/dlicense")
	public ResponseEntity<DefaultResponse> retrieveDSystemLicense(){
		Iterable<DSystemLicense> result = dSystemLicenseDao.retrieveDSystemLicense();
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	//insert
	@PostMapping("/dlicense")
	public ResponseEntity<DefaultResponse> saveDSystemLicense(@RequestBody DSystemLicense dSystemLicense){
		Integer result = 0;
		result = dSystemLicenseDao.saveDSystemLicense(dSystemLicense);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	//insert array
	@PostMapping("/dlicensearray")
	public ResponseEntity<DefaultResponse> saveDSystemLicenseArray(@RequestBody ReqSaveDSystemLicenseCst1 reqSaveDSystemLicenseCst1){
		List<DSystemLicense> listObj = reqSaveDSystemLicenseCst1.getDatarequest();
		dSystemLicenseDao.deleteDSystemLicenseByLicenseId(reqSaveDSystemLicenseCst1.getLicenseId());
		if(listObj.size() > 0) {
			for (DSystemLicense item : listObj) {
				Integer result = dSystemLicenseDao.saveDSystemLicense(item);
			}
		}
		return ResponseEntity.ok(new DefaultResponse(1, "success", reqSaveDSystemLicenseCst1));
	}
	
	//find By id
	@GetMapping("/dlicense/{id}")
	public ResponseEntity<DefaultResponse> findDSystemLicenseById(@PathVariable ("id") Integer id){
		DSystemLicense result = dSystemLicenseDao.findDSystemLicenseById(id);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	//find By License id
	@GetMapping("/dlicense/licenseid/{id}")
	public ResponseEntity<DefaultResponse> findDSystemLicenseByLicenseId(@PathVariable ("id") Integer licenseid){
		Iterable<MApplicationCustom2> result = dSystemLicenseDao.findDSystemLicenseByLicenseId(licenseid);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	//delete by id
	@DeleteMapping("/dlicense/{id}")
	public void deleteDSystemLicenseById(@PathVariable ("id") Integer id){
		dSystemLicenseDao.deleteDSystemLicenseById(id);
	}
	
	//delete by license id
	@DeleteMapping("/dlicense/licenseid/{id}")
	public void deleteDSystemLicenseByLicenseId(@PathVariable ("id") Integer licenseid) {
		dSystemLicenseDao.deleteDSystemLicenseByLicenseId(licenseid);
	}

}
