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

import com.talentnxg.talentnxgapi.dao.MUserEmployeeDao;
import com.talentnxg.talentnxgapi.models.MUserEmployee;
import com.talentnxg.talentnxgapi.response.DefaultResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "${v1API}")
public class MUserEmployeeController {
	@Autowired
	private MUserEmployeeDao mUserEmployeeDao;
	
	// retrieve all
	@RequestMapping("/museremployee")
	public ResponseEntity<DefaultResponse> getMUserEmployee(){
		Iterable<MUserEmployee> result = mUserEmployeeDao.getMUserEmployee();
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	//insert
	@PostMapping("/museremployee")
	public ResponseEntity<DefaultResponse> saveMUseremployee(@RequestBody MUserEmployee mUseremployee){
		Integer result = mUserEmployeeDao.saveMUserEmployee(mUseremployee);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	@GetMapping("/museremployee/{ueid}")
	public ResponseEntity<DefaultResponse> findMUserEmployee(@PathVariable ("ueid") Integer ueid){
		MUserEmployee result = mUserEmployeeDao.findMUserEmployee(ueid);
		return ResponseEntity.ok( new DefaultResponse(1, "success", result));
	}
	
	@PutMapping("/museremployee/{ueid}")
	public ResponseEntity<DefaultResponse> updateMUserEmployee(@RequestBody MUserEmployee mUserEmployee, @PathVariable ("ueid") Integer ueid){
		MUserEmployee result = mUserEmployeeDao.updateMUserEmployee(mUserEmployee, ueid);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	@DeleteMapping("/museremployee/{ueid}")
	public void deleteMUserEmployee(@PathVariable ("ueid") Integer ueid) {
		mUserEmployeeDao.deleteMUserEmployee(ueid);
	}

}
