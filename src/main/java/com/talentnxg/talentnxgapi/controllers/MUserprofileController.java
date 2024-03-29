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
		Long validUsername = mUserprofileDao.checkUsername(mUserprofile);
		if(validUsername == 0) {
			return ResponseEntity.ok(new DefaultResponse(0, "username already used", validUsername));
		}
		else {
			long userid = mUserprofileDao.saveMUserProfile(mUserprofile);
			return ResponseEntity.ok(new DefaultResponse(1, "succes", userid));
		}
//		long userid = mUserprofileDao.saveMUserProfile(mUserprofile);
//		return ResponseEntity.ok(new DefaultResponse(1, "succes", userid));
	}
	
	
	@GetMapping("/muserprofiles")
	public ResponseEntity<DefaultResponse> getMUserprofile(){
		Iterable<MUserprofile> result = mUserprofileDao.getMUserprofile();
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	@GetMapping("/muserprofiles/findRecordByUserAdmin/{isadmin}")
	public ResponseEntity<DefaultResponse> getMUserprofileByUserAdmin(@PathVariable("isadmin") Integer isadmin){
		if(isadmin == 1) {
			Iterable<MUserprofile> result = mUserprofileDao.getMUserprofileBySuperAdmin();
			return ResponseEntity.ok(new DefaultResponse(1, "success", result));
		}
		else {
			Iterable<MUserprofile> result = mUserprofileDao.getMUserprofile();
			return ResponseEntity.ok(new DefaultResponse(1, "success", result));
		}
	}
	
	@GetMapping("/muserprofilesSelectedRole/{roleid}")
	public ResponseEntity<DefaultResponse> getMUserprofileSelectedRole(@PathVariable("roleid") Integer roleid){
		Iterable<MUserprofile> result = mUserprofileDao.getMUserprofileSelected(roleid);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	@GetMapping("/muserprofilesSelectedRole/{roleid}/{isadmin}")
	public ResponseEntity<DefaultResponse> getMUserprofileSelectedRoleByUserAdmin(@PathVariable("roleid") Integer roleid, @PathVariable("isadmin") Integer isadmin){
		if(isadmin == 1) {
			Iterable<MUserprofile> result = mUserprofileDao.getMUserprofileSelectedBySuperUser(roleid);
			return ResponseEntity.ok(new DefaultResponse(1, "success", result));
		}
		else {
			Iterable<MUserprofile> result = mUserprofileDao.getMUserprofileSelected(roleid);
			return ResponseEntity.ok(new DefaultResponse(1, "success", result));
		}
	}
	
	@GetMapping("/muserprofiles/{userid}")
	public ResponseEntity<DefaultResponse> findMUserprofile(@PathVariable("userid") Integer userid){
		MUserprofile result = mUserprofileDao.findMUserprofileById(userid);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));		
	}
	
	@PutMapping("/muserprofiles/{userid}")
	public ResponseEntity<DefaultResponse> updateMUserprofile(@RequestBody MUserprofile mUserprofile, @PathVariable("userid") Integer userid){
		long id = userid;
		Long validUsername = mUserprofileDao.checkUsernameForUpdate(mUserprofile, id);
		if(validUsername == 0) {
			return ResponseEntity.ok(new DefaultResponse(0, "username already used", validUsername));
		}
		else {
			MUserprofile result = mUserprofileDao.updateMUserprofile(mUserprofile, userid);
			return ResponseEntity.ok(new DefaultResponse(1, "success", result));
		}
//		MUserprofile result = mUserprofileDao.updateMUserprofile(mUserprofile, userid);
//		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	@DeleteMapping("/muserprofiles/{userid}")
	public void deleteMUserprofile(@PathVariable("userid")Integer userid) {
		mUserprofileDao.deleteMUserprofile(userid);
	}

}
