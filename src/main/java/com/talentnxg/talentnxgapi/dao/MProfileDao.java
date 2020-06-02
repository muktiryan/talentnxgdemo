package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.MProfile;

public interface MProfileDao {

	long save(MProfile mProfile);

	Iterable<MProfile> getMProfile();

	MProfile getMProfileById(Integer profilesid);

	MProfile updateMProfile(MProfile mProfile, Integer profilesid);

	void deleteMProfile(Integer profilesid);

}
