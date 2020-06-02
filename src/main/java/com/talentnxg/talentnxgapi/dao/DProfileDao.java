package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.DProfile;

public interface DProfileDao {

	long save(DProfile dProfile);

	Iterable<DProfile> getDProfile();

	DProfile getDProfileById(Integer objid);

	DProfile updateDProfile(DProfile dProfile, Integer objid);

	void deleteDProfile(Integer objid);

}
