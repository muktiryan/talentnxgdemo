package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.MCompany;
import com.talentnxg.talentnxgapi.models.MModule;
import com.talentnxg.talentnxgapi.models.MUserprofile;
import com.talentnxg.talentnxgapi.models.MUserprofileCustom1;
import com.talentnxg.talentnxgapi.pojos.ReqLogin;
import com.talentnxg.talentnxgapi.pojos.RespLogin;
import com.talentnxg.talentnxgapi.pojos.RespLoginCst1;

public interface AuthenticationDao {
	public String insertUser(MUserprofile userprofile);
//	public RespLogin getAuthentication(ReqLogin reqLogin);
	
	public RespLoginCst1 getAuthentication(ReqLogin reqLogin);
	
	public Iterable<MModule> getMenuAppWorkStructure();
	public Iterable<MModule> getMenuAppEmployee();
	public Iterable<MModule> getMenuAppPayroll();
	public Object[] getNewReqSetup(MCompany mCompany, MUserprofile mUserprofile);
	public Iterable<MModule> getListModulesByAppid(Integer appid);

	public String emailAuth(String email);

	public boolean changePassword(MUserprofileCustom1 mUserprofileCst1);
}
