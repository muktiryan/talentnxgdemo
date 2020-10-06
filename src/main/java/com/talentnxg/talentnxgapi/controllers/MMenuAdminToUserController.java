package com.talentnxg.talentnxgapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentnxg.talentnxgapi.dao.MMenuAdminToUserDao;
import com.talentnxg.talentnxgapi.models.MMenuAdmin;
import com.talentnxg.talentnxgapi.models.MMenuAdminToUser;
import com.talentnxg.talentnxgapi.pojos.ReqSaveMMenuAdminCst1;
import com.talentnxg.talentnxgapi.response.DefaultResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "${v1API}")
public class MMenuAdminToUserController {
	
	@Autowired
	private MMenuAdminToUserDao mMenuAdminToUserDao;
	
	//insert
	@PostMapping("menuadmintouser")
	public ResponseEntity<DefaultResponse> saveMMenuAdminToUser(@RequestBody MMenuAdminToUser mMenuAdminToUser){
		long id = mMenuAdminToUserDao.saveMMenuAdminToUser(mMenuAdminToUser);
		return ResponseEntity.ok(new DefaultResponse(1, "success", id));
	}
	
	//retrieve all
	@GetMapping("menuadmintouser")
	public ResponseEntity<DefaultResponse> getMMenuAdminToUser(){
		Iterable<MMenuAdminToUser> result = mMenuAdminToUserDao.getMMenuAdminToUser();
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	//find by user id
	@GetMapping("menuadmintouser/findbyuserid/{userid}")
	public ResponseEntity<DefaultResponse> findMMenuAdminToUserByUserId(@PathVariable ("userid") Integer userId){
		Iterable<MMenuAdminToUser> result = mMenuAdminToUserDao.findMMenuAdminToUserByUserId(userId);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	@PutMapping("resetmenuadmintouser/{userid}")
	public void resetMenuAdminByUserId(@PathVariable ("userid") Integer userId) {
		mMenuAdminToUserDao.deleteMenuAdminByUserId(userId);
	}
	
	@PostMapping("menuadmintouserarray")
	public ResponseEntity<DefaultResponse> saveMenuAdminArray(@RequestBody ReqSaveMMenuAdminCst1 mAdmin){
		ReqSaveMMenuAdminCst1 menuAdminCst1 = mAdmin;
//		System.out.println("Delete menu admin member where userId : "+menuAdminCst1.getUserId());
		mMenuAdminToUserDao.deleteMenuAdminByUserId(menuAdminCst1.getUserId());
		List<MMenuAdminToUser> listObj = menuAdminCst1.getDatarequest();
		if(listObj.size() > 0) {
			for (MMenuAdminToUser item : listObj) {
//				System.out.println("menu Id "+item.getMenuAdminId());
				long id = mMenuAdminToUserDao.saveMMenuAdminToUser(item);
				
			}
//			long rmemid = dRoleDao.save(dRole);
		}
		return ResponseEntity.ok(new DefaultResponse(1, "success", menuAdminCst1));
	}
	
	// menu admin
	//find by menu admin group
	@GetMapping("menuadmin/findbygroupname/{groupname}")
	public ResponseEntity<DefaultResponse> findMMenuAdminToUserByGroupName(@PathVariable ("groupname") String groupName){
		Iterable<MMenuAdmin> result = mMenuAdminToUserDao.findMMenuAdminToUserByGroupName(groupName);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	

}
