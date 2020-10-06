package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.MApplication;
import com.talentnxg.talentnxgapi.models.MApplicationCustom1;

public interface MApplicationDao {
	public long save(MApplication mApplications);
	public Iterable<MApplication> getMApplication();
	public MApplication getMApplicationById(Integer appid);
	public MApplication updateMApplication(MApplication mApplication, Integer appid);
	void deleteMApplication(Integer appid);
	public long deletMApplication(Integer appd);
	public Iterable<MApplicationCustom1> getMApplicationCustom1();
	public Iterable<MApplicationCustom1> getMApplicationByType(Integer typeid);
	public Iterable<MApplicationCustom1> getMApplicationCustom1BySuperAdmin();
	public Iterable<MApplication> getMApplicationByRoleId(Integer roleid);

}
