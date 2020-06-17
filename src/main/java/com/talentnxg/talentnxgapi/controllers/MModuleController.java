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

import com.talentnxg.talentnxgapi.dao.MModuleDao;
import com.talentnxg.talentnxgapi.models.MModule;
import com.talentnxg.talentnxgapi.response.DefaultResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "${v1API}")
public class MModuleController {
	
	@Autowired
	private MModuleDao moduleDao;
	
	//insert
	@PostMapping("/mmodules")
	public ResponseEntity<DefaultResponse> saveModule (@RequestBody MModule module) {
		long moduleId = moduleDao.save(module);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", moduleId));
	}
	
	//update
	@PutMapping("/mmodules/{modid}")
	public ResponseEntity<DefaultResponse> updateModule (@RequestBody MModule module, @PathVariable ("modid") Integer updatedModId){
		MModule newModule = moduleDao.update(module, updatedModId);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", newModule));
	}
	
	//retrieve all
	@GetMapping("/mmodules")
	public ResponseEntity<DefaultResponse> getModules(){
		Iterable<MModule> result = moduleDao.getModules();
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));	
	}
	
	@GetMapping("mmodulesSelectedApplication/{appid}")
	public ResponseEntity<DefaultResponse> getMModulesSelectedApplication(@PathVariable ("appid") Integer appid){
		Iterable<MModule> result = moduleDao.getMModulesSelectedApplication(appid);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
	
	//find by id
	@GetMapping("/mmodules/{modid}")
	public ResponseEntity<DefaultResponse> getModuleById(@PathVariable ("modid") Integer modId){
		MModule result = moduleDao.getModuleById(modId);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
	}
	
	//delete
	@DeleteMapping("/mmodules/{modid}")
	public void deleteModule (@PathVariable("modid") Integer modId) {
		moduleDao.deleteModule(modId);
	}


}
