package com.talentnxg.talentnxgapi.models;

import java.util.Date;

public class MMenuAdmin {
	private Integer id;
	private String menuAdminName;
	private String menuAdminGroup;
	private Integer createdBy;
	private Date createdDate;
	private Integer updatedBy;
	private Date updatedDate;
	
	
	
	public MMenuAdmin() {

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMenuAdminName() {
		return menuAdminName;
	}
	public void setMenuAdminName(String menuAdminName) {
		this.menuAdminName = menuAdminName;
	}
	public String getMenuAdminGroup() {
		return menuAdminGroup;
	}
	public void setMenuAdminGroup(String menuAdminGroup) {
		this.menuAdminGroup = menuAdminGroup;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
