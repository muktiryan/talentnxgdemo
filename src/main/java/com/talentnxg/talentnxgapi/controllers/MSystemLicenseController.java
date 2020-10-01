package com.talentnxg.talentnxgapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentnxg.talentnxgapi.dao.MSystemLicenseDao;
import com.talentnxg.talentnxgapi.models.MSystemLicense;
import com.talentnxg.talentnxgapi.response.DefaultResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "${v1API}")
public class MSystemLicenseController {
	@Autowired
	private MSystemLicenseDao mSystemLicenseDao;
	
	// insert 
	@PostMapping("license")
	public ResponseEntity<DefaultResponse> saveMSystemLicense(@RequestBody MSystemLicense mSystemLicense){
		Integer result = mSystemLicenseDao.saveMSystemLicense(mSystemLicense);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	//retrieve all
	@GetMapping("license")
	public ResponseEntity<DefaultResponse> retrieveMSystemLicense(){
		Iterable<MSystemLicense> result = mSystemLicenseDao.retrieveMSystemLicense();
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	//find by id
	@GetMapping("license/{id}")
	public ResponseEntity<DefaultResponse> findMSystemLicenseById(@PathVariable ("id") Integer id ){
		MSystemLicense result = mSystemLicenseDao.findMSystemLicenseById(id);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	//delete
	@DeleteMapping("license/{id}")
	public void deleteMSystemLicense(@PathVariable ("id") Integer id) {
		mSystemLicenseDao.deleteMSystemLicense(id);
	}
	
	//update
	@PutMapping("license/{id}")
	public ResponseEntity<DefaultResponse> updateMSystemLicenseById(@RequestBody MSystemLicense mSystemLicense, @PathVariable ("id") Integer id){
		MSystemLicense result = mSystemLicenseDao.updateMSystemLicenseById(mSystemLicense, id);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	

}
