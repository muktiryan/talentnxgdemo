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

import com.talentnxg.talentnxgapi.dao.MTenantDao;
import com.talentnxg.talentnxgapi.models.MTenant;
import com.talentnxg.talentnxgapi.response.DefaultResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/${v1API}")
public class MTenantController {
	@Autowired
	private MTenantDao mTenantDao;
	
	//insert
	@PostMapping("/mtenants")
	public ResponseEntity<DefaultResponse> save(@RequestBody MTenant mTenant){
		long id = mTenantDao.save(mTenant);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", id));
	}
	
	//retrieve all record
	@GetMapping("/mtenants")
	public ResponseEntity<DefaultResponse> getMTenant(){
		Iterable<MTenant> result = mTenantDao.getMTenant();
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
	
	//find by id
	@GetMapping("/mtenants/{id}")
	public ResponseEntity<DefaultResponse> getMTenantById(@PathVariable("id") Integer id){
		MTenant result = mTenantDao.getMTenantById(id);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
		
	//update
	@PutMapping("/mtenants/{id}")
	public ResponseEntity<DefaultResponse> updateMTenant(@RequestBody MTenant mTenant, @PathVariable("id") Integer id){
		MTenant result = mTenantDao.updateMTenant(mTenant, id);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
		
	//delete
	@DeleteMapping("/mtenants/{id}")
	public void deleteMTenant(@PathVariable("id") Integer id) {
		mTenantDao.deleteMTenant(id);
	}
}
