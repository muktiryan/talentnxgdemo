package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.MCompany;
import com.talentnxg.talentnxgapi.models.MModule;
import com.talentnxg.talentnxgapi.models.MUserprofile;
import com.talentnxg.talentnxgapi.pojos.ReqLogin;
import com.talentnxg.talentnxgapi.pojos.RespLogin;

public interface AuthenticationDao {
	public String insertUser(MUserprofile userprofile);
	public RespLogin getAuthentication(ReqLogin reqLogin);
	
	
	
	public Iterable<MModule> getMenuAppWorkStructure();
	public Iterable<MModule> getMenuAppEmployee();
	public Iterable<MModule> getMenuAppPayroll();
	public Object[] getNewReqSetup(MCompany mCompany, MUserprofile mUserprofile);
}
