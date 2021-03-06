package com.talentnxg.talentnxgapi.controllers;

import java.util.List;

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
import com.talentnxg.talentnxgapi.models.MModuleForMenu;
import com.talentnxg.talentnxgapi.pojos.ReqSaveMenuCst1;
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
		Long validUsername = moduleDao.checkModName(module);
		if(validUsername == 0) {
			return ResponseEntity.ok(new DefaultResponse(0, "mod name already used", validUsername));
		}
		else {
			long moduleId = moduleDao.save(module);
			return ResponseEntity.ok(new DefaultResponse(1, "Success", moduleId));
		}
//		long moduleId = moduleDao.save(module);
//		return ResponseEntity.ok(new DefaultResponse(1, "Success", moduleId));
	}
	
	//update
	@PostMapping("/mmodulesmember")
	public ResponseEntity<DefaultResponse> updateModuleMember (@RequestBody ReqSaveMenuCst1 mCustMenu){
			ReqSaveMenuCst1 mModulecust = mCustMenu;
			
			List<MModule> listObj = mModulecust.getDatarequest();
		
			if(listObj.size() > 0) {
				for (MModule item : listObj) {
					System.out.println("Update menu ID "+item.getModid());
					MModule rmemid = moduleDao.update(item, item.getModid());
					
				}
			}
			return ResponseEntity.ok(new DefaultResponse(1, "Success", mCustMenu.getRoleid()));
	}
	//update
	@PutMapping("/mmodules/{modid}")
	public ResponseEntity<DefaultResponse> updateModule (@RequestBody MModule module, @PathVariable ("modid") Integer updatedModId){
		long modid = updatedModId;
		Long validUsername = moduleDao.checkModNameForUpdate(module, modid);
		if(validUsername == 0) {
			return ResponseEntity.ok(new DefaultResponse(0, "mod name already used", validUsername));
		}
		else {
			MModule newModule = moduleDao.update(module, updatedModId);
			return ResponseEntity.ok(new DefaultResponse(1, "Success", newModule));
		}
//		MModule newModule = moduleDao.update(module, updatedModId);
//		return ResponseEntity.ok(new DefaultResponse(1, "Success", newModule));
	}
	//update
		@PutMapping("/mmodulesmember/{groupid}")
		public ResponseEntity<DefaultResponse> resetModule (@RequestBody Integer idx, @PathVariable ("groupid") Integer groupid){
			long newModule = moduleDao.updateByGroupid(groupid);
			return ResponseEntity.ok(new DefaultResponse(1, "Success", newModule));
		}
	//retrieve all
	@GetMapping("/mmodules")
	public ResponseEntity<DefaultResponse> getModules(){
		Iterable<MModule> result = moduleDao.getModules();
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));	
	}
	@GetMapping("/mmodulesByType/{typeid}")
	public ResponseEntity<DefaultResponse> getModulesByType(@PathVariable ("typeid") Integer typeid){
		Iterable<MModule> result = moduleDao.getModuleByType(typeid);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));	
	}
	@GetMapping("/mmodulesByGroupAndType/{groupid}/{typeid}")
	public ResponseEntity<DefaultResponse> getModulesByGroupType(@PathVariable ("groupid") Integer groupid, @PathVariable ("typeid") Integer typeid){
		Iterable<MModule> result = moduleDao.getModuleByGroupAndType(groupid, typeid);
		return ResponseEntity.ok(new DefaultResponse(1, "Success", result));	
	}
	@GetMapping("/mmodulesByGroupOrType/{groupid}/{typeid}")
	public ResponseEntity<DefaultResponse> getModulesByGroupTypeOr(@PathVariable ("groupid") Integer groupid, @PathVariable ("typeid") Integer typeid){
		Iterable<MModule> result = moduleDao.getModuleByGroupOrType(groupid, typeid);
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
	
	//retrieve list of menu and group menu by appid
	@GetMapping("mmodulesByAppid/{appid}")
	public ResponseEntity<DefaultResponse> getListMenuByAppid(@PathVariable ("appid") Integer appid){
		Iterable<MModuleForMenu> result = moduleDao.getListMenuByAppid(appid);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	//delete
	@DeleteMapping("/mmodules/{modid}")
	public void deleteModule (@PathVariable("modid") Integer modId) {
		moduleDao.deleteModule(modId);
	}
	//delete
		@DeleteMapping("/mmodulesgroup/{modid}")
		public ResponseEntity<DefaultResponse> deleteModuleGroup (@PathVariable("modid") Integer modId) {
			long result = moduleDao.deletModule(modId);
			return ResponseEntity.ok(new DefaultResponse(1, "Success", result));
		}

}
