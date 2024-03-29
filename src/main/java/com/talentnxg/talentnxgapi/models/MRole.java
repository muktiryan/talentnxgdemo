package com.talentnxg.talentnxgapi.models;

import java.util.Date;

public class MRole {
	private Integer rolesid;
	private String rolename;
	private Integer tenantid;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	private Integer isadmin;
	private Integer roleidrpt;
	
	public MRole() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getRolesid() {
		return rolesid;
	}
	public void setRolesid(Integer rolesid) {
		this.rolesid = rolesid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Integer getTenantid() {
		return tenantid;
	}
	public void setTenantid(Integer tenantid) {
		this.tenantid = tenantid;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date date) {
		this.updatedDate = date;
	}
	public Integer getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(Integer isadmin) {
		this.isadmin = isadmin;
	}

	public Integer getRoleidrpt() {
		return roleidrpt;
	}

	public void setRoleidrpt(Integer roleidrpt) {
		this.roleidrpt = roleidrpt;
	}

}
