package com.talentnxg.talentnxgapi.pojos;

import java.util.List;

import com.talentnxg.talentnxgapi.models.DApplication;

public class ReqSaveDApplicationsCst1 {
	private Integer appid;
	private List<DApplication> datarequest;
	
	public ReqSaveDApplicationsCst1() {
		
	}

	public Integer getAppid() {
		return appid;
	}

	public void setAppid(Integer appid) {
		this.appid = appid;
	}

	public List<DApplication> getDatarequest() {
		return datarequest;
	}

	public void setDatarequest(List<DApplication> datarequest) {
		this.datarequest = datarequest;
	}
	
	

}
