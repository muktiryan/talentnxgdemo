package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.DApplication;

public interface DApplicationDao {

	long save(DApplication dApplication);

	Iterable<DApplication> getDApplication();

	DApplication getDApplicationById(Integer integid);

	DApplication updateDApplication(DApplication dApplication, Integer integid);

	void deleteDApplication(Integer integid);

}
