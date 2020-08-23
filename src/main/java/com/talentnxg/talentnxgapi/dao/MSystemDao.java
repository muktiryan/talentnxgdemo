package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.MSystem;

public interface MSystemDao {

	Integer saveMSystem(MSystem mSystem);

	Iterable<MSystem> getMSystems();

	MSystem findMSystemById(Integer sysid);

	MSystem updateMSystem(MSystem mSystem, Integer sysid);

	void deleteMSystem(Integer sysid);

}
