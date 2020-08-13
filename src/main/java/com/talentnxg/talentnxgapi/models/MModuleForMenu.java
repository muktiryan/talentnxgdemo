package com.talentnxg.talentnxgapi.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MModuleForMenu { 
	private Integer modid;
	private String modname;
	private Integer modtype;
	private Integer groupid;
	private Integer isapprove;
	private String modtitle;
	private String modroute;
	private String modrealpath;
	private String modicon;
	private String createdBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	private String updatedBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedDate;
	private Integer selectedApplication;
	private List<MModule> subitems;
	
	
	
	public List<MModule> getSubitems() {
		return subitems;
	}

	public void setSubitems(List<MModule> subitems) {
		this.subitems = subitems;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public Integer getIsapprove() {
		return isapprove;
	}

	public void setIsapprove(Integer isapprove) {
		this.isapprove = isapprove;
	}

	public MModuleForMenu() {
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

	public Integer getSelectedApplication() {
		return selectedApplication;
	}

	public void setSelectedApplication(Integer selectedApplication) {
		this.selectedApplication = selectedApplication;
	}
	

}
