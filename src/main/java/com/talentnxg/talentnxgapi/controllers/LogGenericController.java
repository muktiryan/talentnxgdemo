package com.talentnxg.talentnxgapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentnxg.talentnxgapi.dao.LogGenericDao;
import com.talentnxg.talentnxgapi.models.LogGeneric;
import com.talentnxg.talentnxgapi.response.DefaultResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "${v1API}")
public class LogGenericController {
	@Autowired
	private LogGenericDao logGenericDao;

	//retrieve log generic by type
	@GetMapping("/loggeneric/{logtypeid}")
	public ResponseEntity<DefaultResponse> findLogGenericByLogTypeId(@PathVariable ("logtypeid") Integer logtypeid){
		Iterable<LogGeneric> result = logGenericDao.findLogGenericByLogTypeId(logtypeid);
		return ResponseEntity.ok( new DefaultResponse(1, "success", result));
	}
	
	//insert logger
	@PostMapping("/loggeneric")
	public ResponseEntity<DefaultResponse> saveLogGeneric(@RequestBody LogGeneric logGeneric){
		Integer id = logGenericDao.saveLogGeneric(logGeneric);
		return ResponseEntity.ok(new DefaultResponse(1, "success", id));
	}
	
//	//insert user logger
//	@PostMapping("/loggeneric/userlogger")
//	public ResponseEntity<DefaultResponse> saveUserLogger(@RequestBody LogGeneric userLogger){
//		Integer id = logGenericDao.saveUserLogger(userLogger);
//		return ResponseEntity.ok(new DefaultResponse(1, "success", id));
//	}
//	
//	//insert event logger
//	@PostMapping("/loggeneric/eventlogger")
//	public ResponseEntity<DefaultResponse> saveEventLogger(@RequestBody LogGeneric eventLogger){
//		Integer id = logGenericDao.saveEventLogger(eventLogger);
//		return ResponseEntity.ok(new DefaultResponse(1, "success", id));
//	}
//	
//	//insert task logger
//	@PostMapping("/loggeneric/tasklogger")
//	public ResponseEntity<DefaultResponse> saveTaskLogger(@RequestBody LogGeneric taskLogger){
//		Integer id = logGenericDao.saveTaskLogger(taskLogger);
//		return ResponseEntity.ok(new DefaultResponse(1, "success", id));
//	}
	
}
