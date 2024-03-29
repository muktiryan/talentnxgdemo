package com.talentnxg.talentnxgapi.models;

import java.util.Date;

public class LogGeneric {
	private Integer id;
	private Date logDatetime;
	private Integer logTypeId;
	private Integer logActionId;
	private Integer userId;
	private Integer menuId;
	private Integer trxId;
	private Integer tenantId;
	private Integer companyId;
	private String description;
	private String ipcontroller;
	private String location;
	private String createdBy;
	private Date createdDate;
	
	public LogGeneric() {
		// TODO Auto-generated constructor stub
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getLogDatetime() {
		return logDatetime;
	}

	public void setLogDatetime(Date logDatetime) {
		this.logDatetime = logDatetime;
	}

	public Integer getLogTypeId() {
		return logTypeId;
	}

	public void setLogTypeId(Integer logTypeId) {
		this.logTypeId = logTypeId;
	}

	public Integer getLogActionId() {
		return logActionId;
	}

	public void setLogActionId(Integer logActionId) {
		this.logActionId = logActionId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getTrxId() {
		return trxId;
	}

	public void setTrxId(Integer trxId) {
		this.trxId = trxId;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIpcontroller() {
		return ipcontroller;
	}

	public void setIpcontroller(String ipcontroller) {
		this.ipcontroller = ipcontroller;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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


	

}
