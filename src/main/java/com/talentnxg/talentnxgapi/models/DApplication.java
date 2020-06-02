package com.talentnxg.talentnxgapi.models;

import java.util.Date;

public class DApplication {
	private Integer integid;
	private Integer appid;
	private Integer modid;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	
	
	public DApplication() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getIntegid() {
		return integid;
	}
	public void setIntegid(Integer integid) {
		this.integid = integid;
	}
	public Integer getAppid() {
		return appid;
	}
	public void setAppid(Integer appid) {
		this.appid = appid;
	}
	public Integer getModid() {
		return modid;
	}
	public void setModid(Integer modid) {
		this.modid = modid;
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
