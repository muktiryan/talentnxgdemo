package com.talentnxg.talentnxgapi.pojos;

import java.util.List;

import com.talentnxg.talentnxgapi.models.MMenuAdminToUser;

public class ReqSaveMMenuAdminCst1 {
	private Integer userId;
	private List<MMenuAdminToUser> datarequest;
	
	public ReqSaveMMenuAdminCst1() {

	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<MMenuAdminToUser> getDatarequest() {
		return datarequest;
	}

	public void setDatarequest(List<MMenuAdminToUser> datarequest) {
		this.datarequest = datarequest;
	}
	
}
