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

import com.talentnxg.talentnxgapi.dao.MApplicationDao;
import com.talentnxg.talentnxgapi.models.MApplication;
import com.talentnxg.talentnxgapi.models.MApplicationCustom1;
import com.talentnxg.talentnxgapi.response.DefaultResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "${v1API}")
public class MApplicationController {
	
	@Autowired
	private MApplicationDao mApplicationDao;
	
	//insert
	@PostMapping("/mapplications")
	public ResponseEntity<DefaultResponse> saveMApplication(@RequestBody MApplication mApplication){
		long mAppId = mApplicationDao.save(mApplication);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", mAppId));
	}
	
	//retrieve all record
	@GetMapping("/mapplications")
	public ResponseEntity<DefaultResponse> getMApplication(){
		Iterable<MApplication> result = mApplicationDao.getMApplication();
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
	
	//retrieve custom record
	@GetMapping("/mapplicationscst1")
	public ResponseEntity<DefaultResponse> getMApplicationCustom1(){
		Iterable<MApplicationCustom1> result = mApplicationDao.getMApplicationCustom1();
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	//retrieve custom record by user admin
	@GetMapping("/mapplicationscst1/{isadmin}")
	public ResponseEntity<DefaultResponse> getMApplicationCustom1ByUserAdmin(@PathVariable ("isadmin") Integer isadmin){
		if(isadmin == 1) {
			Iterable<MApplicationCustom1> result = mApplicationDao.getMApplicationCustom1BySuperAdmin();
			return ResponseEntity.ok(new DefaultResponse(1, "success", result));	
		}
		else {
			Iterable<MApplicationCustom1> result = mApplicationDao.getMApplicationCustom1();
			return ResponseEntity.ok(new DefaultResponse(1, "success", result));	
		}
	}
	
	//find by id
	@GetMapping("/mapplications/{appid}")
	public ResponseEntity<DefaultResponse> getMApplicationById(@PathVariable("appid") Integer appid){
		MApplication result = mApplicationDao.getMApplicationById(appid);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
	
	//find by type
		@GetMapping("/mapplicationsbytype/{typeid}")
		public ResponseEntity<DefaultResponse> getMApplicationByType(@PathVariable("typeid") Integer typeid){
			Iterable<MApplicationCustom1> result = mApplicationDao.getMApplicationByType(typeid);
			return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
		}
	
	//update
	@PutMapping("/mapplications/{appid}")
	public ResponseEntity<DefaultResponse> updateMApplication(@RequestBody MApplication mApplication, @PathVariable("appid") Integer appid){
		MApplication result = mApplicationDao.updateMApplication(mApplication, appid);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
	
	//delete
	@DeleteMapping("/mapplications/{appid}")
	public ResponseEntity<DefaultResponse> deleteMApplication(@PathVariable("appid") Integer appid) {
		long result = mApplicationDao.deletMApplication(appid);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}

}
