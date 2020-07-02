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

import com.talentnxg.talentnxgapi.dao.DProfileDao;
import com.talentnxg.talentnxgapi.models.DProfile;
import com.talentnxg.talentnxgapi.response.DefaultResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/${v1API}")
public class DProfileController {
	@Autowired
	private DProfileDao dProfileDao;
	
	//insert
	@PostMapping("/dprofiles")
	public ResponseEntity<DefaultResponse> saveDProfile(@RequestBody DProfile dProfile){
		long objid = dProfileDao.save(dProfile);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", objid));
	}
	
	//retrieve all record
	@GetMapping("/dprofiles")
	public ResponseEntity<DefaultResponse> getDProfile(){
		Iterable<DProfile> result = dProfileDao.getDProfile();
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
		
	//find by profile id
	@GetMapping("/dprofiles/{profileid}")
	public ResponseEntity<DefaultResponse> getDProfileByProfileId(@PathVariable("profileid") Integer profileid){
		Iterable<DProfile> result = dProfileDao.getDProfileByProfileid(profileid);
		if (result!=null) {
			return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
		}
		return ResponseEntity.ok(new DefaultResponse(-1, "No Data", result));
	}
	
	//find dprofile by objid
	@GetMapping("/dprofiles/id/{objid}")
	public ResponseEntity<DefaultResponse> findDProfileById(@PathVariable ("objid") Integer objid){
		DProfile result = dProfileDao.getDProfileById(objid);
		return ResponseEntity.ok( new DefaultResponse(1, "success", result));
	}
		
	//update
	@PutMapping("/dprofiles/{objid}")
	public ResponseEntity<DefaultResponse> updateDProfile(@RequestBody DProfile dProfile, @PathVariable("objid") Integer objid){
		DProfile result = dProfileDao.updateDProfile(dProfile, objid);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
		
	//delete
	@DeleteMapping("/dprofiles/{objid}")
	public void deleteDProfile(@PathVariable("objid") Integer objid) {
		dProfileDao.deleteDProfile(objid);
	}

}
