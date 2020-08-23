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

import com.talentnxg.talentnxgapi.dao.MUserToCompanyDao;
import com.talentnxg.talentnxgapi.models.MUserToCompany;
import com.talentnxg.talentnxgapi.response.DefaultResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "${v1API}")
public class MUserToCompanyController {
	@Autowired
	private MUserToCompanyDao mUserToCompanyDao;
	
	
	//retrieve all rows
	@GetMapping("/musertocompany")
	public ResponseEntity<DefaultResponse> getMUserToCompany(){
		Iterable<MUserToCompany> result = mUserToCompanyDao.getMUserToCompany();
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
	
	//insert
	@PostMapping("/musertocompany")
	public ResponseEntity<DefaultResponse> saveMUserToCompany(@RequestBody MUserToCompany mUsertoCompany){
		Long utcid = mUserToCompanyDao.saveMUserToCompany(mUsertoCompany);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", utcid));
	}

//	find by utcid
	@GetMapping("/musertocompany/{utcid}")
	public ResponseEntity<DefaultResponse> findMUserToCompanyById(@PathVariable ("utcid") Integer utcid){
		MUserToCompany result = mUserToCompanyDao.findMUserToCompanyById(utcid);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	//update
	@PutMapping("/musertocompany/{utcid}")
	public ResponseEntity<DefaultResponse> updateMUserToCompany(@RequestBody MUserToCompany mUserToCompany, @PathVariable ("utcid") Integer utcid){
		MUserToCompany result = mUserToCompanyDao.updateMUserToCompany(mUserToCompany, utcid);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
	
	//delete
	@DeleteMapping("/musertocompany/{utcid}")
	public void deleteMUserToCompany(@PathVariable ("utcid") Integer utcid) {
		mUserToCompanyDao.deleteMUserToCompany(utcid);
	}
	
}
