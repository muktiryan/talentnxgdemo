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

import com.talentnxg.talentnxgapi.dao.DApplicationDao;
import com.talentnxg.talentnxgapi.models.DApplication;
import com.talentnxg.talentnxgapi.response.DefaultResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "${v1API}")
public class DApplicationController {
	@Autowired
	private DApplicationDao dApplicationDao;
	
	//insert
	@PostMapping("/dapplications")
	public ResponseEntity<DefaultResponse> saveDApplication(@RequestBody DApplication dApplication){
		long dAppId = dApplicationDao.save(dApplication);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", dAppId));
	}
	
	//retrieve all record
	@GetMapping("/dapplications")
	public ResponseEntity<DefaultResponse> getDApplication(){
		Iterable<DApplication> result = dApplicationDao.getDApplication();
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
		
	//find by id
	@GetMapping("/dapplications/{integid}")
	public ResponseEntity<DefaultResponse> getDApplicationById(@PathVariable("integid") Integer integid){
		DApplication result = dApplicationDao.getDApplicationById(integid);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
		
	//update
	@PutMapping("/dapplications/{integid}")
	public ResponseEntity<DefaultResponse> updateDApplication(@RequestBody DApplication dApplication, @PathVariable("integid") Integer integid){
		DApplication result = dApplicationDao.updateDApplication(dApplication, integid);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
		
	//delete
	@DeleteMapping("/dapplications/{integid}")
	public void deleteDApplication(@PathVariable("integid") Integer integid) {
		dApplicationDao.deleteDApplication(integid);
	}

}
