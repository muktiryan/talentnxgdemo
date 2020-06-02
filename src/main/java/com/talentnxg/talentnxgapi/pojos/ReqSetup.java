package com.talentnxg.talentnxgapi.pojos;

import com.talentnxg.talentnxgapi.models.MCompany;
import com.talentnxg.talentnxgapi.models.MUserprofile;

public class ReqSetup {
	private MCompany mCompany;
	private MUserprofile mUserprofile;
	
	
	public ReqSetup() {
		// TODO Auto-generated constructor stub
	}
	
	public MUserprofile getmUserprofile() {
		return mUserprofile;
	}
	public void setmUserprofile(MUserprofile mUserprofile) {
		this.mUserprofile = mUserprofile;
	}

	public MCompany getmCompany() {
		return mCompany;
	}

	public void setmCompany(MCompany mCompany) {
		this.mCompany = mCompany;
	}
	
}
