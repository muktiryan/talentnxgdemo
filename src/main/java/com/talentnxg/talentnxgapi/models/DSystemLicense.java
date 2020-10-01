package com.talentnxg.talentnxgapi.models;

public class DSystemLicense {
	private Integer id;
	private Long licenseId;
	private Long moduleId;
	
	
	public DSystemLicense() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Long getLicenseId() {
		return licenseId;
	}


	public void setLicenseId(Long licenseId) {
		this.licenseId = licenseId;
	}


	public Long getModuleId() {
		return moduleId;
	}


	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
	
}
