package com.talentnxg.talentnxgapi.models;


import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MSystem {
	private Integer sysId;
	private String appName;
	private Integer language;
	private Integer calendarFmt;
	private Integer dateInFmt;
	private Integer dateOutFmt;
	private Integer timeFmt;
	private Integer decimalSeparator;
	private Integer numericFmt;
	private Integer rowView;
	private Integer rowFilter;
	private String PIC;
	private Integer pageLogging;
	private Integer uniqueChar;
	private Integer keepUserLog;
	private Integer periodExpWeb;
	private Integer periodExpMobile;
	private Integer newDeviceDetectEmail;
	private Integer newDeviceDetectSms;
	private Integer newDeviceDetectGoogle;
	private Integer themes;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date effectiveStartDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date effectiveEndDate;
	
	private String remark;
	
	private String createdBy;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	
	private String updatedBy;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateDate;
	

	public MSystem() {
		// TODO Auto-generated constructor stub
	}
	

	public Integer getLanguage() {
		return language;
	}


	public void setLanguage(Integer language) {
		this.language = language;
	}


	public Integer getSysId() {
		return sysId;
	}

	public void setSysId(Integer sysId) {
		this.sysId = sysId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public Integer getCalendarFmt() {
		return calendarFmt;
	}

	public void setCalendarFmt(Integer calendarFmt) {
		this.calendarFmt = calendarFmt;
	}

	public Integer getDateInFmt() {
		return dateInFmt;
	}

	public void setDateInFmt(Integer dateInFmt) {
		this.dateInFmt = dateInFmt;
	}

	public Integer getDateOutFmt() {
		return dateOutFmt;
	}

	public void setDateOutFmt(Integer dateOutFmt) {
		this.dateOutFmt = dateOutFmt;
	}

	public Integer getTimeFmt() {
		return timeFmt;
	}

	public void setTimeFmt(Integer timeFmt) {
		this.timeFmt = timeFmt;
	}

	public Integer getDecimalSeparator() {
		return decimalSeparator;
	}

	public void setDecimalSeparator(Integer decimalSeparator) {
		this.decimalSeparator = decimalSeparator;
	}

	public Integer getNumericFmt() {
		return numericFmt;
	}

	public void setNumericFmt(Integer numericFmt) {
		this.numericFmt = numericFmt;
	}

	public Integer getRowView() {
		return rowView;
	}

	public void setRowView(Integer rowView) {
		this.rowView = rowView;
	}

	public Integer getRowFilter() {
		return rowFilter;
	}

	public void setRowFilter(Integer rowFilter) {
		this.rowFilter = rowFilter;
	}

	public String getPIC() {
		return PIC;
	}

	public void setPIC(String pIC) {
		PIC = pIC;
	}

	public Integer getPageLogging() {
		return pageLogging;
	}

	public void setPageLogging(Integer pageLogging) {
		this.pageLogging = pageLogging;
	}

	public Integer getUniqueChar() {
		return uniqueChar;
	}

	public void setUniqueChar(Integer uniqueChar) {
		this.uniqueChar = uniqueChar;
	}

	public Integer getKeepUserLog() {
		return keepUserLog;
	}

	public void setKeepUserLog(Integer keepUserLog) {
		this.keepUserLog = keepUserLog;
	}

	public Integer getPeriodExpWeb() {
		return periodExpWeb;
	}

	public void setPeriodExpWeb(Integer periodExpWeb) {
		this.periodExpWeb = periodExpWeb;
	}

	public Integer getPeriodExpMobile() {
		return periodExpMobile;
	}

	public void setPeriodExpMobile(Integer periodExpMobile) {
		this.periodExpMobile = periodExpMobile;
	}

	public Integer getNewDeviceDetectEmail() {
		return newDeviceDetectEmail;
	}

	public void setNewDeviceDetectEmail(Integer newDeviceDetectEmail) {
		this.newDeviceDetectEmail = newDeviceDetectEmail;
	}

	public Integer getNewDeviceDetectSms() {
		return newDeviceDetectSms;
	}

	public void setNewDeviceDetectSms(Integer newDeviceDetectSms) {
		this.newDeviceDetectSms = newDeviceDetectSms;
	}

	public Integer getNewDeviceDetectGoogle() {
		return newDeviceDetectGoogle;
	}

	public void setNewDeviceDetectGoogle(Integer newDeviceDetectGoogle) {
		this.newDeviceDetectGoogle = newDeviceDetectGoogle;
	}

	public Integer getThemes() {
		return themes;
	}

	public void setThemes(Integer themes) {
		this.themes = themes;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
