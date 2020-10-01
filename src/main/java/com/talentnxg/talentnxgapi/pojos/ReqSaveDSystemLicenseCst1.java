package com.talentnxg.talentnxgapi.pojos;

import java.util.List;

import com.talentnxg.talentnxgapi.models.DSystemLicense;

public class ReqSaveDSystemLicenseCst1 {
	private Integer licenseId;
	private List<DSystemLicense> datarequest;
	
	
	public ReqSaveDSystemLicenseCst1() {


	}


	public Integer getLicenseId() {
		return licenseId;
	}


	public void setLicenseId(Integer licenseId) {
		this.licenseId = licenseId;
	}


	public List<DSystemLicense> getDatarequest() {
		return datarequest;
	}


	public void setDatarequest(List<DSystemLicense> datarequest) {
		this.datarequest = datarequest;
	}
	

}
