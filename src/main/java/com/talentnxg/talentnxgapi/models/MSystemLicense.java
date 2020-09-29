package com.talentnxg.talentnxgapi.models;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MSystemLicense {
	private Integer id;
	private String companyCode;
	private String companyName;
	private String contactPerson;
	private String contactPersonPhone;
	private Integer companyLicense;
	private String licenseCode;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date expireDate;
	private Integer activeEmployee;
	private Integer hcmUser;
	private Integer registeredActiveEmployee;
	private Integer registeredHcmUser;
	private String remarks;
	@NotNull
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date effectiveStartDate;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date effectiveEndDate;
	private Integer createdBy;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date createdDate;
	private Integer updatedBy;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date updatedDate;
	private Integer deletedBy;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date deletedDate;
	
	
	public MSystemLicense() {

	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCompanyCode() {
		return companyCode;
	}


	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getContactPerson() {
		return contactPerson;
	}


	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}


	public String getContactPersonPhone() {
		return contactPersonPhone;
	}


	public void setContactPersonPhone(String contactPersonPhone) {
		this.contactPersonPhone = contactPersonPhone;
	}


	public Integer getCompanyLicense() {
		return companyLicense;
	}


	public void setCompanyLicense(Integer companyLicense) {
		this.companyLicense = companyLicense;
	}


	public String getLicenseCode() {
		return licenseCode;
	}


	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}


	public Date getExpireDate() {
		return expireDate;
	}


	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}


	public Integer getActiveEmployee() {
		return activeEmployee;
	}


	public void setActiveEmployee(Integer activeEmployee) {
		this.activeEmployee = activeEmployee;
	}


	public Integer getHcmUser() {
		return hcmUser;
	}


	public void setHcmUser(Integer hcmUser) {
		this.hcmUser = hcmUser;
	}


	public Integer getRegisteredActiveEmployee() {
		return registeredActiveEmployee;
	}


	public void setRegisteredActiveEmployee(Integer registeredActiveEmployee) {
		this.registeredActiveEmployee = registeredActiveEmployee;
	}


	public Integer getRegisteredHcmUser() {
		return registeredHcmUser;
	}


	public void setRegisteredHcmUser(Integer registeredHcmUser) {
		this.registeredHcmUser = registeredHcmUser;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public Date getEffectiveStartDate() {
		return effectiveStartDate;
	}


	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}


	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}


	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
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


	public Integer getDeletedBy() {
		return deletedBy;
	}


	public void setDeletedBy(Integer deletedBy) {
		this.deletedBy = deletedBy;
	}


	public Date getDeletedDate() {
		return deletedDate;
	}


	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}
	
}
