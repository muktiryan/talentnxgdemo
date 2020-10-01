package com.talentnxg.talentnxgapi.models;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MSystemLicense {
	private Integer id;
	private Long tenantId;
	private Long companyId;
	private String companyCode;
	private String companyName;
	private String contactPerson;
	private String contactPersonPhone;
	private Long companyLicense;
	private String licenseCode;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date expiredDate;
	private Long activeEmployee;
	private Long hcmUser;
	private Long registeredActiveEmployee;
	private Long registeredHcmUser;
	private String remarks;
	@NotNull
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date effectiveStartDate;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date effectiveEndDate;
	private Long createdBy;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date createdDate;
	private Long updatedBy;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date updatedDate;
	private Long deletedBy;
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date deletedDate;
	private String tenantName;
	
	
	public MSystemLicense() {

	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Long getTenantId() {
		return tenantId;
	}


	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}


	public Long getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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


	public Long getCompanyLicense() {
		return companyLicense;
	}


	public void setCompanyLicense(Long companyLicense) {
		this.companyLicense = companyLicense;
	}


	public String getLicenseCode() {
		return licenseCode;
	}


	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}


	public Date getExpiredDate() {
		return expiredDate;
	}


	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}


	public Long getActiveEmployee() {
		return activeEmployee;
	}


	public void setActiveEmployee(Long activeEmployee) {
		this.activeEmployee = activeEmployee;
	}


	public Long getHcmUser() {
		return hcmUser;
	}


	public void setHcmUser(Long hcmUser) {
		this.hcmUser = hcmUser;
	}


	public Long getRegisteredActiveEmployee() {
		return registeredActiveEmployee;
	}


	public void setRegisteredActiveEmployee(Long registeredActiveEmployee) {
		this.registeredActiveEmployee = registeredActiveEmployee;
	}


	public Long getRegisteredHcmUser() {
		return registeredHcmUser;
	}


	public void setRegisteredHcmUser(Long registeredHcmUser) {
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


	public Long getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Long getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	public Long getDeletedBy() {
		return deletedBy;
	}


	public void setDeletedBy(Long deletedBy) {
		this.deletedBy = deletedBy;
	}


	public Date getDeletedDate() {
		return deletedDate;
	}


	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
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


	public String getTenantName() {
		return tenantName;
	}


	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}


}
