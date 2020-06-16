package com.talentnxg.talentnxgapi.pojos;

import java.util.List;

import com.talentnxg.talentnxgapi.models.DApplication;

public class ReqSaveDApplications {
	private List<DApplication> datarequest;
	private ReqSaveDApplications () {
		
	}
	public List<DApplication> getDatarequest() {
		return datarequest;
	}
	public void setDatarequest(List<DApplication> datarequest) {
		this.datarequest = datarequest;
	}
	
}
