package com.talentnxg.talentnxgapi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.talentnxg.talentnxgapi.configs.EncryptDecryptJWT;
import com.talentnxg.talentnxgapi.dao.AuthenticationDao;
import com.talentnxg.talentnxgapi.models.MCompany;
import com.talentnxg.talentnxgapi.models.MModule;
import com.talentnxg.talentnxgapi.models.MUserprofile;
import com.talentnxg.talentnxgapi.pojos.ReqLogin;
import com.talentnxg.talentnxgapi.pojos.ReqSetup;
import com.talentnxg.talentnxgapi.pojos.RespLogin;
import com.talentnxg.talentnxgapi.response.DefaultResponse;

@CrossOrigin(origins = "*", exposedHeaders = "x-token")
@RestController
@RequestMapping(path = "${v1API}")
public class UserController {
	String jwtToken = "";
	@Autowired
	private Environment env;
	
	@Autowired
	AuthenticationDao authDao;
	
	@GetMapping("/getecho")
    @ResponseBody
    public String getAll(Pageable page) {
        return "{== Changing to Cloud SQL ==}";
    }
	
//	@PostMapping("/authentication")
//	public ResponseEntity<RespLogin> postLogin(@RequestBody ReqLogin reqLogin) {
//		RespLogin resCust = authDao.getAuthentication(reqLogin);
//		if(resCust.getCode() == 1) {
//			jwtToken = EncryptDecryptJWT.createJWT(reqLogin.getIdentifier(), resCust.getProfile().getTenantname(), "tokenToken", 
//					600000, env.getProperty("v1JWT"));
//		}
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.add("x-token", jwtToken);
//		resCust.setToken(jwtToken);
//	    return new ResponseEntity<>(resCust, responseHeaders, HttpStatus.OK);	
//	}
	@PostMapping("/authentication")
	public ResponseEntity<RespLogin> postLogin(@RequestBody ReqLogin reqLogin) {
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = null;
		RespLogin resCust = authDao.getAuthentication(reqLogin);
		try {
			jsonStr = Obj.writeValueAsString(resCust.getProfile());
		
		} catch (JsonProcessingException e) {
			return new ResponseEntity<>(resCust, HttpStatus.BAD_REQUEST);
		}
		if(resCust.getCode() == 1) {
			jwtToken = EncryptDecryptJWT.createJWT(reqLogin.getIdentifier(), jsonStr,
					"tokenToken", 
					600000, env.getProperty("v1JWT"));
		}
		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.setAccessControlAllowHeaders(allowedHeaders);
		responseHeaders.add("x-token", jwtToken);
	    return new ResponseEntity<>(resCust,responseHeaders, HttpStatus.OK);	
	}
	@PostMapping("/setup")
	public ResponseEntity<DefaultResponse> newSetup (@RequestBody ReqSetup newReqSetup){
		MCompany mCompany = newReqSetup.getmCompany();
		MUserprofile mUserprofile = newReqSetup.getmUserprofile();
		Object[] result = authDao.getNewReqSetup(mCompany,  mUserprofile);
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	@GetMapping("/menuappws")
	public ResponseEntity<DefaultResponse> getMenuAppWorkStructure() {
		Iterable<MModule> result = authDao.getMenuAppWorkStructure();
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	@GetMapping("/menuappemp")
	public ResponseEntity<DefaultResponse> getMenuAppEmployee() {
		Iterable<MModule> result = authDao.getMenuAppEmployee();
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	@GetMapping("/menuapppayroll")
	public ResponseEntity<DefaultResponse> getMenuAppPayroll() {
		Iterable<MModule> result = authDao.getMenuAppPayroll();
		return ResponseEntity.ok(new DefaultResponse(1, "success", result));
	}
	
	
	
}
