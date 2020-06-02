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

import com.talentnxg.talentnxgapi.dao.DRoleDao;
import com.talentnxg.talentnxgapi.models.DRole;
import com.talentnxg.talentnxgapi.response.DefaultResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/${v1API}")
public class DRoleController {
	@Autowired
	private DRoleDao dRoleDao;
	
	//insert
	@PostMapping("/droles")
	public ResponseEntity<DefaultResponse> saveDRole(@RequestBody DRole dRole){
		long rmemid = dRoleDao.save(dRole);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", rmemid));
	}
	
	//retrieve all record
	@GetMapping("/droles")
	public ResponseEntity<DefaultResponse> getDRole(){
		Iterable<DRole> result = dRoleDao.getDRole();
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
	
	//find by id
	@GetMapping("/droles/{rmemid}")
	public ResponseEntity<DefaultResponse> getDRoleById(@PathVariable("rmemid") Integer rmemid){
		DRole result = dRoleDao.getDRoleById(rmemid);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
		
	//update
	@PutMapping("/droles/{rmemid}")
	public ResponseEntity<DefaultResponse> updateDRole(@RequestBody DRole dRole, @PathVariable("rmemid") Integer rmemid){
		DRole result = dRoleDao.updateDRole(dRole, rmemid);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
		
	//delete
	@DeleteMapping("/droles/{rmemid}")
	public void deleteDRoles(@PathVariable("rmemid") Integer rmemid) {
		dRoleDao.deleteDRole(rmemid);
	}

}
