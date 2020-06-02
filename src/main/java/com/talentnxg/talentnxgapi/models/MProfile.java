package com.talentnxg.talentnxgapi.models;

import java.util.Date;

public class MProfile {
	private Integer profilesid;
	private String profilesname;
	private Integer tenantid;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	
	
	public MProfile() {
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

}
