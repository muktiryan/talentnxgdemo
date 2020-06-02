package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.MApplication;

public interface MApplicationDao {
	public long save(MApplication mApplications);
	public Iterable<MApplication> getMApplication();
	public MApplication getMApplicationById(Integer appid);
	public MApplication updateMApplication(MApplication mApplication, Integer appid);
	void deleteMApplication(Integer appid);

}
