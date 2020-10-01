package com.talentnxg.talentnxgapi.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MApplicationCustom2 {
	private Integer appid;
	private String appname;
	private String description;
	private String createdBy;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date createdDate;
	private Integer tenantid;
	private String updatedBy;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date updatedDate;
	private Integer apptype;
	private Long licenseId;
	
	
	public MApplicationCustom2() {

	}


	public Integer getAppid() {
		return appid;
	}


	public void setAppid(Integer appid) {
		this.appid = appid;
	}


	public String getAppname() {
		return appname;
	}


	public void setAppname(String appname) {
		this.appname = appname;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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


	public Integer getTenantid() {
		return tenantid;
	}


	public void setTenantid(Integer tenantid) {
		this.tenantid = tenantid;
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


	public Integer getApptype() {
		return apptype;
	}


	public void setApptype(Integer apptype) {
		this.apptype = apptype;
	}


	public Long getLicenseId() {
		return licenseId;
	}


	public void setLicenseId(Long licenseId) {
		this.licenseId = licenseId;
	}
	
	

}
