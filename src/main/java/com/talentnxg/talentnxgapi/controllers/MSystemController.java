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

import com.talentnxg.talentnxgapi.dao.MSystemDao;
import com.talentnxg.talentnxgapi.models.MSystem;
import com.talentnxg.talentnxgapi.response.DefaultResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "${v1API}")
public class MSystemController {
	@Autowired
	private MSystemDao mSystemDao;
	
	@PostMapping("/msystems")
	public ResponseEntity<DefaultResponse> saveMSystem(@RequestBody MSystem mSystem){
		Integer sysId = mSystemDao.saveMSystem(mSystem);
		return ResponseEntity.ok(new DefaultResponse(1, "success", sysId));
	}
	
	@GetMapping("/msystems")
	public ResponseEntity<DefaultResponse> getMSystem(){
		Iterable<MSystem> result = mSystemDao.getMSystems();
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	@GetMapping("/msystems/{sysid}")
	public ResponseEntity<DefaultResponse> findMSystemById(@PathVariable ("sysid") Integer sysid){
		MSystem result = mSystemDao.findMSystemById(sysid);
		return ResponseEntity.ok( new DefaultResponse(1, "success", result));
	}
	@GetMapping("/msystems/tn/{sysid}")
	public ResponseEntity<DefaultResponse> findMSystemByIdTenant(@PathVariable ("sysid") Integer sysid){
		MSystem result = mSystemDao.findMSystemById(sysid);
		return ResponseEntity.ok( new DefaultResponse(1, "success", result));
	}
	
	
	@PutMapping("/msystems/{sysid}")
	public ResponseEntity<DefaultResponse> updateMSystem(@RequestBody MSystem mSystem, @PathVariable ("sysid") Integer sysid){
		MSystem result = mSystemDao.updateMSystem(mSystem, sysid);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	@DeleteMapping("/msystems/{sysid}")
	public void deleteMSystem(@PathVariable ("sysid") Integer sysid) {
		mSystemDao.deleteMSystem(sysid);
	}
	
	

}
