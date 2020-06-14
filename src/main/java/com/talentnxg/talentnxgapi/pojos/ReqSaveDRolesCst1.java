package com.talentnxg.talentnxgapi.pojos;

import java.util.List;

import com.talentnxg.talentnxgapi.models.DRole;

public class ReqSaveDRolesCst1 {
	private Integer roleid;
	private List<DRole> datarequest;
	public ReqSaveDRolesCst1() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public List<DRole> getDatarequest() {
		return datarequest;
	}
	public void setDatarequest(List<DRole> datarequest) {
		this.datarequest = datarequest;
	}
	
}
