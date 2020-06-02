package com.talentnxg.talentnxgapi.models;

import java.util.Date;

public class MModule { 
	private Integer modid;
	private String modname;
	private Integer modtype;
	private String modtitle;
	private String modroute;
	private String modrealpath;
	private String modicon;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	
	
	public MModule() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getModid() {
		return modid;
	}
	public void setModid(Integer modid) {
		this.modid = modid;
	}
	
	public String getModname() {
		return modname;
	}
	public void setModname(String modname) {
		this.modname = modname;
	}
	
	public Integer getModtype() {
		return modtype;
	}
	public void setModtype(Integer modtype) {
		this.modtype = modtype;
	}
	
	public String getModtitle() {
		return modtitle;
	}
	public void setModtitle(String modtitle) {
		this.modtitle = modtitle;
	}
	
	public String getModroute() {
		return modroute;
	}
	public void setModroute(String modroute) {
		this.modroute = modroute;
	}


	public String getModrealpath() {
		return modrealpath;
	}
	public void setModrealpath(String modrealpath) {
		this.modrealpath = modrealpath;
	}


	public String getModicon() {
		return modicon;
	}
	public void setModicon(String modicon) {
		this.modicon = modicon;
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
