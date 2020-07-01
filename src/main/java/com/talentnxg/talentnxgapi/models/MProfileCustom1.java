package com.talentnxg.talentnxgapi.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MProfileCustom1 {
	private Integer profilesid;
	private String profilesname;
	private Integer tenantid;
	private String createdBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	private String updatedBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedDate;
	private String tenantname;
	private String companyname;
	
	public MProfileCustom1() {
		// TODO Auto-generated constructor stub
	}

	public Integer getProfilesid() {
		return profilesid;
	}

	public void setProfilesid(Integer profilesid) {
		this.profilesid = profilesid;
	}

	public String getProfilesname() {
		return profilesname;
	}

	public void setProfilesname(String profilesname) {
		this.profilesname = profilesname;
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

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getTenantname() {
		return tenantname;
	}

	public void setTenantname(String tenantname) {
		this.tenantname = tenantname;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

}
