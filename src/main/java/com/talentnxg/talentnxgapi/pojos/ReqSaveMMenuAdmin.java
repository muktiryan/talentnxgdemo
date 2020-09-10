package com.talentnxg.talentnxgapi.pojos;

import java.util.List;

import com.talentnxg.talentnxgapi.models.MMenuAdminToUser;

public class ReqSaveMMenuAdmin {
	private List<MMenuAdminToUser> datarequest;

	public ReqSaveMMenuAdmin() {

	}

	public List<MMenuAdminToUser> getDatarequest() {
		return datarequest;
	}

	public void setDatarequest(List<MMenuAdminToUser> datarequest) {
		this.datarequest = datarequest;
	}
	
	
}
