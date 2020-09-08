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

import com.talentnxg.talentnxgapi.dao.MRoleDao;
import com.talentnxg.talentnxgapi.models.MRole;
import com.talentnxg.talentnxgapi.models.MRoleCustom1;
import com.talentnxg.talentnxgapi.response.DefaultResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "${v1API}")
public class MRoleController {
	
	@Autowired
	private MRoleDao mRoleDao;
	
	//insert
	@PostMapping("/mroles")
	public ResponseEntity<DefaultResponse> saveMRole(@RequestBody MRole mRole){
		Long validRolename = mRoleDao.checkRoleName(mRole);
		if(validRolename == 0) {
			return ResponseEntity.ok(new DefaultResponse(0, "role name already used", validRolename));
		}
		else {
			long rolesid = mRoleDao.save(mRole);
			return ResponseEntity.ok(new DefaultResponse(1, "Success", rolesid));
		}
//		long rolesid = mRoleDao.save(mRole);
//		return ResponseEntity.ok(new DefaultResponse(1, "Success", rolesid));
	}
	
	//retrieve all record
	@GetMapping("/mroles")
	public ResponseEntity<DefaultResponse> getMRole(){
		Iterable<MRole> result = mRoleDao.getMRole();
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
	
	//retrieve custom record
	@GetMapping("/mrolescst1")
	public ResponseEntity<DefaultResponse> getMRoleCustom1(){
		Iterable<MRoleCustom1> result = mRoleDao.getMRoleCustom1();
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
	
	//retrieve custom record by admin status
	@GetMapping("/mrolescst1/findRecordByUserAdmin/{isadmin}")
	public ResponseEntity<DefaultResponse> getMRoleCustom1ByUserAdmin(@PathVariable("isadmin") Integer isadmin){
		if(isadmin == 1) {
			Iterable<MRoleCustom1> result = mRoleDao.getMRoleCustom1BySuperAdmin();
			return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
		}
		else {
			Iterable<MRoleCustom1> result = mRoleDao.getMRoleCustom1();
			return ResponseEntity.ok(new DefaultResponse(1, "success", result));
		}

	}
	
	//find by id
	@GetMapping("/mroles/{rolesid}")
	public ResponseEntity<DefaultResponse> getMRoleById(@PathVariable("rolesid") Integer rolesid){
		MRole result = mRoleDao.getMRoleById(rolesid);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
		
	//update
	@PutMapping("/mroles/{rolesid}")
	public ResponseEntity<DefaultResponse> updateMRole(@RequestBody MRole mRole, @PathVariable("rolesid") Integer rolesid){
		long updatedRolesid = rolesid;
		Long validRolename = mRoleDao.checkRoleNameForUpdate(mRole, updatedRolesid);
		if(validRolename == 0) {
			return ResponseEntity.ok(new DefaultResponse(0, "role name already used", validRolename));
		}
		else {
			MRole result = mRoleDao.updateMRole(mRole, rolesid);
			return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
		}
//		MRole result = mRoleDao.updateMRole(mRole, rolesid);
//		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
		
	//delete
	@DeleteMapping("/mroles/{rolesid}")
	public ResponseEntity<DefaultResponse> deleteMRole(@PathVariable("rolesid") Integer rolesid) {
		long checkrolesid = rolesid;
		Long canDeleteRole = mRoleDao.checkRoleMember(checkrolesid);
		if(canDeleteRole == 0) {
			return ResponseEntity.ok(new DefaultResponse(0, "This user group have member ", rolesid));
		}
		else {
			mRoleDao.deleteMRole(rolesid);
			return ResponseEntity.ok(new DefaultResponse(1, "success", rolesid));
		}
//		mRoleDao.deleteMRole(rolesid);
	}

}
