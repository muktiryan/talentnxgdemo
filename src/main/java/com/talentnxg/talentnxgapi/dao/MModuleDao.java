package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.MModule;

public interface MModuleDao {
	public long save(MModule module);
	public MModule update(MModule module, Integer updatedModId);
	public Iterable<MModule> getModules();
	public MModule getModuleById(Integer modId);
	public void deleteModule(Integer modId);


}
