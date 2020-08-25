package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.MProfile;
import com.talentnxg.talentnxgapi.models.MProfileCustom1;

public interface MProfileDao {

	long save(MProfile mProfile);

	Iterable<MProfile> getMProfile();

	MProfile getMProfileById(Integer profilesid);

	MProfile updateMProfile(MProfile mProfile, Integer profilesid);

	void deleteMProfile(Integer profilesid);

	Iterable<MProfileCustom1> getMProfileCst1();

	Iterable<MProfileCustom1> getMProfileCst1BySuperAdmin();

}
