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

import com.talentnxg.talentnxgapi.dao.MUserprofileDao;
import com.talentnxg.talentnxgapi.models.MUserprofile;
import com.talentnxg.talentnxgapi.response.DefaultResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "${v1API}")
public class MUserprofileController {
	@Autowired
	private MUserprofileDao mUserprofileDao;
	
	@PostMapping("/muserprofiles")
	public ResponseEntity<DefaultResponse> save (@RequestBody MUserprofile mUserprofile){
		long userid = mUserprofileDao.saveMUserProfile(mUserprofile);
		return ResponseEntity.ok(new DefaultResponse(1, "success", userid));
	}
	
	@GetMapping("/muserprofiles")
	public ResponseEntity<DefaultResponse> getMUserprofile(){
		Iterable<MUserprofile> result = mUserprofileDao.getMUserprofile();
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	@GetMapping("/muserprofiles/{userid}")
	public ResponseEntity<DefaultResponse> findMUserprofile(@PathVariable("userid") Integer userid){
		MUserprofile result = mUserprofileDao.findMUserprofileById(userid);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));		
	}
	
	@PutMapping("/muserprofiles/{userid}")
	public ResponseEntity<DefaultResponse> updateMUserprofile(@RequestBody MUserprofile mUserprofile, @PathVariable("userid") Integer userid){
		MUserprofile result = mUserprofileDao.updateMUserprofile(mUserprofile, userid);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	@DeleteMapping("/muserprofiles/{userid}")
	public void deleteMUserprofile(@PathVariable("userid")Integer userid) {
		mUserprofileDao.deleteMUserprofile(userid);
	}

}
