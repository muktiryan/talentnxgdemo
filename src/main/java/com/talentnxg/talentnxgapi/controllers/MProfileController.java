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

import com.talentnxg.talentnxgapi.dao.MProfileDao;
import com.talentnxg.talentnxgapi.models.MProfile;
import com.talentnxg.talentnxgapi.models.MProfileCustom1;
import com.talentnxg.talentnxgapi.response.DefaultResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "${v1API}")
public class MProfileController {
	@Autowired
	private MProfileDao mProfileDao;
	
	//insert
	@PostMapping("/mprofiles")
	public ResponseEntity<DefaultResponse> saveMProfiles(@RequestBody MProfile mProfile){
		long profilesid = mProfileDao.save(mProfile);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", profilesid));
	}
	
	//retrieve all record
	@GetMapping("/mprofiles")
	public ResponseEntity<DefaultResponse> getMProfile(){
		Iterable<MProfile> result = mProfileDao.getMProfile();
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
	
	//retrieve all record custom
	@GetMapping("/mprofilescst1")
	public ResponseEntity<DefaultResponse> getMProfileCst1(){
		Iterable<MProfileCustom1> result = mProfileDao.getMProfileCst1();
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
		
	//find by id
	@GetMapping("/mprofiles/{profilesid}")
	public ResponseEntity<DefaultResponse> getMProfileById(@PathVariable("profilesid") Integer profilesid){
		MProfile result = mProfileDao.getMProfileById(profilesid);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
		
	//update
	@PutMapping("/mprofiles/{profilesid}")
	public ResponseEntity<DefaultResponse> updateMProfile(@RequestBody MProfile mProfile, @PathVariable("profilesid") Integer profilesid){
		MProfile result = mProfileDao.updateMProfile(mProfile, profilesid);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
		
	//delete
	@DeleteMapping("/mprofiles/{profilesid}")
	public void deleteMProfile(@PathVariable("profilesid") Integer profilesid) {
		mProfileDao.deleteMProfile(profilesid);
	}

}
