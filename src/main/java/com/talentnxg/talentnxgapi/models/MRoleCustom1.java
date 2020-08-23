package com.talentnxg.talentnxgapi.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MRoleCustom1 {
	private Integer rolesid;
	private String rolename;
	private Integer tenantid;
	private String createdBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	private String updatedBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedDate;
	private Integer isadmin;
	private String tenantname;
	private String isadminStr;
	private Integer roleidrpt;
	private String companyname;
	
	public MRoleCustom1() {
		// TODO Auto-generated constructor stub
	}
	
	public String getTenantname() {
		return tenantname;
	}

	public void setTenantname(String tenantname) {
		this.tenantname = tenantname;
	}

	public String getIsadminStr() {
		return isadminStr;
	}

	public void setIsadminStr(String isadminStr) {
		this.isadminStr = isadminStr;
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

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

}
