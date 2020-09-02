package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.MModule;
import com.talentnxg.talentnxgapi.models.MModuleForMenu;

public interface MModuleDao {
	public long save(MModule module);
	public MModule update(MModule module, Integer updatedModId);
	public long updateByGroupid(Integer groupId);
	public Iterable<MModule> getModules();
	public MModule getModuleById(Integer modId);
	public void deleteModule(Integer modId);
	public long deletModule(Integer modId);
	public Iterable<MModule> getMModulesSelectedApplication(Integer appid);
	public Iterable<MModule> getModuleByType(Integer typeId);
	public Iterable<MModule> getModuleByGroupAndType(Integer groupid, Integer typeId);
	public Iterable<MModule> getModuleByGroupOrType(Integer groupid, Integer typeId);
	public Iterable<MModuleForMenu> getListMenuByAppid(Integer appid);
	public Long checkModName(MModule module);
	public Long checkModNameForUpdate(MModule module, long modid);

}
