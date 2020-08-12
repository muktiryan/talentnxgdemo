package com.talentnxg.talentnxgapi.pojos;

import java.util.List;

import com.talentnxg.talentnxgapi.models.MModule;

public class ReqSaveMenuCst1 {
	private Integer roleid;
	private List<MModule> datarequest;
	public ReqSaveMenuCst1() {
		// TODO Auto-generated constructor stub
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public List<MModule> getDatarequest() {
		return datarequest;
	}
	public void setDatarequest(List<MModule> datarequest) {
		this.datarequest = datarequest;
	}
	
}
