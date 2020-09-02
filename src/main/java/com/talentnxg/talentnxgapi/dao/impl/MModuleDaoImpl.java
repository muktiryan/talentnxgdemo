package com.talentnxg.talentnxgapi.dao.impl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.talentnxg.talentnxgapi.configs.AppConfig;
import com.talentnxg.talentnxgapi.dao.MModuleDao;
import com.talentnxg.talentnxgapi.models.MModule;
import com.talentnxg.talentnxgapi.models.MModuleForMenu;

@Repository
public class MModuleDaoImpl implements MModuleDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//insert
	@Override
    public long save(MModule mModule) {
        KeyHolder moduleKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement temp = connection.prepareStatement(AppConfig.saveModule, new String[]{"modid"});
            temp.setString(1, mModule.getModname());
            temp.setInt(2, mModule.getModtype());
            temp.setString(3, mModule.getModtitle());
            temp.setString(4, mModule.getModroute());
            temp.setString(5, mModule.getModrealpath());
            temp.setString(6, mModule.getModicon());
            temp.setString(7, mModule.getCreatedBy());
            return temp;
          }, moduleKeyHolder);     
        return moduleKeyHolder.getKey().longValue();
      }
	
	//update
	@Override
	public MModule update(MModule module, Integer updatedModId) {
		if(module.getGroupid() == null) {
			module.setGroupid(0);
		}
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.updateModule, new String[] {"modid"});
            temp.setString(1, module.getModname());
            temp.setInt(2, module.getModtype());
            temp.setString(3, module.getModtitle());
            temp.setString(4, module.getModroute());
            temp.setString(5, module.getModrealpath());
            temp.setString(6, module.getModicon());
            temp.setString(7, module.getUpdatedBy());
            temp.setInt(8, module.getGroupid());
            temp.setInt(9, updatedModId);
			return temp;
		});
		MModule result = getModuleById(updatedModId);
		return result;
	}
	

	@Override
	public long updateByGroupid(Integer groupId) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.updateModuleByGroupid);
            temp.setInt(1, 0);
            temp.setInt(2, 0);
            temp.setInt(3, groupId);
			return temp;
		});
		return 1;
	}

	//find by id
	@Override
	public MModule getModuleById(Integer modId) {
		MModule module = new MModule();
		Object[] parameters = new Object[] {new Integer(modId.toString())};
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.findModuleById, parameters);
		if (rows.size() > 0) {
			for (Map<String, Object> row : rows) {
				module.setModid(Integer.parseInt(row.get("modid").toString()));
				module.setModname((String)row.get("modname"));
				module.setModtype(Integer.parseInt(row.get("modtype").toString()));
				module.setModtitle((String)row.get("modtitle"));
				module.setModroute((String)row.get("modroute"));
				module.setModrealpath((String)row.get("modrealpath"));
				module.setModicon((String)row.get("modicon"));
				module.setCreatedBy((String)row.get("created_by"));
				module.setCreatedDate((Date)row.get("created_date"));
				module.setUpdatedBy((String)row.get("updated_by"));
				module.setUpdatedDate((Date)row.get("updated_date"));
			}
		}
		return module;
	}
	
	//retrieve all record
	@Override
	public Iterable<MModule> getModules() {
		List<MModule> result = new ArrayList<MModule>();
		List<Map<String, Object>> rows = (ArrayList<Map<String, Object>>)jdbcTemplate.queryForList(AppConfig.selectModule);
		for (Map<String, Object> row : rows) {
			MModule mModule = new MModule();
			mModule.setModid(Integer.parseInt(row.get("modid").toString()));
			mModule.setModname((String)row.get("modname"));
			mModule.setModtype(Integer.parseInt(row.get("modtype").toString()));
			mModule.setModtitle((String)row.get("modtitle"));
			mModule.setModroute((String)row.get("modroute"));
			mModule.setModrealpath((String)row.get("modrealpath"));
			mModule.setModicon((String)row.get("modicon"));
			mModule.setCreatedBy((String)row.get("created_by"));
			mModule.setCreatedDate((Date)row.get("created_date"));
			mModule.setUpdatedBy((String)row.get("updated_by"));
			mModule.setUpdatedDate((Date)row.get("updated_date"));
			result.add(mModule);
		}
		return (Iterable<MModule>) result;
	}

	
	
	@Override
	public Iterable<MModule> getMModulesSelectedApplication(Integer appid) {
		Object[] parameter = new Object[] { new Integer(appid)};
		List<MModule> result = new ArrayList<MModule>();
		List<Map<String, Object>> rows = (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.selectMModuleByApplication, parameter);
		for (Map<String, Object> row : rows) {
			MModule mModule = new MModule();
			mModule.setModid(Integer.parseInt(row.get("modid").toString()));
			mModule.setModname((String)row.get("modname"));
			mModule.setModtype(Integer.parseInt(row.get("modtype").toString()));
			mModule.setModtitle((String)row.get("modtitle"));
			mModule.setModroute((String)row.get("modroute"));
			mModule.setModrealpath((String)row.get("modrealpath"));
			mModule.setModicon((String)row.get("modicon"));
			mModule.setCreatedBy((String)row.get("created_by"));
			mModule.setCreatedDate((Date)row.get("created_date"));
			mModule.setUpdatedBy((String)row.get("updated_by"));
			mModule.setUpdatedDate((Date)row.get("updated_date"));
			mModule.setSelectedApplication(Integer.parseInt(row.get("isselect").toString()));
			result.add(mModule);
		}
		return (Iterable<MModule>) result;
	}

	//delete
	@Override
	public void deleteModule(Integer modId) {
		Object[] parameter = new Object[] {new Integer(modId)};
		jdbcTemplate.update(AppConfig.deleteModuleById, parameter);
	}
	
	@Override
	public long deletModule(Integer modId) {
		// TODO Auto-generated method stub
		
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.deleteModuleById);
            temp.setInt(1, modId);
			return temp;
		});
		return 1;
	}

	@Override
	public Iterable<MModule> getModuleByType(Integer typeId) {
		List<MModule> result = new ArrayList<MModule>();
		Object[] parameters = new Object[] {new Integer(typeId)};
//		System.out.println("############# "+AppConfig.selectModuleByType+", "+typeId);
		List<Map<String, Object>> rows = (ArrayList<Map<String, Object>>)jdbcTemplate.queryForList(AppConfig.selectModuleByType, parameters);
		for (Map<String, Object> row : rows) {
			MModule mModule = new MModule();
			mModule.setModid(Integer.parseInt(row.get("modid").toString()));
			mModule.setModname((String)row.get("modname"));
			mModule.setModtype(Integer.parseInt(row.get("modtype").toString()));
			mModule.setModtitle((String)row.get("modtitle"));
			mModule.setModroute((String)row.get("modroute"));
			mModule.setIsapprove(Integer.parseInt(row.get("isapprove").toString()));
			mModule.setGroupid(Integer.parseInt(row.get("groupid").toString()));
			mModule.setModrealpath((String)row.get("modrealpath"));
			mModule.setModicon((String)row.get("modicon"));
			mModule.setCreatedBy((String)row.get("created_by"));
			mModule.setCreatedDate((Date)row.get("created_date"));
			mModule.setUpdatedBy((String)row.get("updated_by"));
			mModule.setUpdatedDate((Date)row.get("updated_date"));
			result.add(mModule);
		}
		return (Iterable<MModule>) result;
	}

	
	@Override
	public Iterable<MModule> getModuleByGroupAndType(Integer groupid, Integer typeId) {
		List<MModule> result = new ArrayList<MModule>();
		Object[] parameters = new Object[] {new Integer(groupid), new Integer(typeId)};
//		System.out.println("############# "+AppConfig.selectModuleByType+", "+typeId);
		List<Map<String, Object>> rows = (ArrayList<Map<String, Object>>)jdbcTemplate.queryForList(AppConfig.selectModuleByGroupAndType, parameters);
		for (Map<String, Object> row : rows) {
			MModule mModule = new MModule();
			mModule.setModid(Integer.parseInt(row.get("modid").toString()));
			mModule.setModname((String)row.get("modname"));
			mModule.setModtype(Integer.parseInt(row.get("modtype").toString()));
			mModule.setModtitle((String)row.get("modtitle"));
			mModule.setModroute((String)row.get("modroute"));
			mModule.setIsapprove(Integer.parseInt(row.get("isapprove").toString()));
			mModule.setGroupid(Integer.parseInt(row.get("groupid").toString()));
			mModule.setModrealpath((String)row.get("modrealpath"));
			mModule.setModicon((String)row.get("modicon"));
			mModule.setCreatedBy((String)row.get("created_by"));
			mModule.setCreatedDate((Date)row.get("created_date"));
			mModule.setUpdatedBy((String)row.get("updated_by"));
			mModule.setUpdatedDate((Date)row.get("updated_date"));
			result.add(mModule);
		}
		return (Iterable<MModule>) result;
	}

	@Override
	public Iterable<MModule> getModuleByGroupOrType(Integer groupid, Integer typeId) {
		List<MModule> result = new ArrayList<MModule>();
		Object[] parameters = new Object[] {new Integer(groupid), new Integer(typeId)};
//		System.out.println("############# "+AppConfig.selectModuleByType+", "+typeId);
		List<Map<String, Object>> rows = (ArrayList<Map<String, Object>>)jdbcTemplate.queryForList(AppConfig.selectModuleByGroupOrType, parameters);
		for (Map<String, Object> row : rows) {
			MModule mModule = new MModule();
			mModule.setModid(Integer.parseInt(row.get("modid").toString()));
			mModule.setModname((String)row.get("modname"));
			mModule.setModtype(Integer.parseInt(row.get("modtype").toString()));
			mModule.setModtitle((String)row.get("modtitle"));
			mModule.setModroute((String)row.get("modroute"));
			mModule.setIsapprove(Integer.parseInt(row.get("isapprove").toString()));
			mModule.setGroupid(Integer.parseInt(row.get("groupid").toString()));
			mModule.setModrealpath((String)row.get("modrealpath"));
			mModule.setModicon((String)row.get("modicon"));
			mModule.setCreatedBy((String)row.get("created_by"));
			mModule.setCreatedDate((Date)row.get("created_date"));
			mModule.setUpdatedBy((String)row.get("updated_by"));
			mModule.setUpdatedDate((Date)row.get("updated_date"));
			result.add(mModule);
		}
		return (Iterable<MModule>) result;
	}

	@Override
	public Iterable<MModuleForMenu> getListMenuByAppid(Integer appid) {
		Object [] activeAppid = new Object [] { new Integer (appid)};
		List<MModuleForMenu> tabMenus = new ArrayList<MModuleForMenu>();
		List<Map<String, Object>> temp = (ArrayList<Map<String,Object>>)(jdbcTemplate.queryForList(AppConfig.retrieveMenuByAppid, activeAppid));
		for(Map<String,Object> row:temp){
			MModuleForMenu module = new MModuleForMenu();
			module.setModid(Integer.parseInt(row.get("modid").toString()));
			module.setModname((String)row.get("modname"));
			module.setModtype(Integer.parseInt(row.get("modtype").toString()));
			module.setModtitle((String)row.get("modtitle"));
			module.setModroute((String)row.get("modroute"));
			module.setModrealpath((String)row.get("modrealpath"));
			
			List<MModule> childItem = new ArrayList<MModule>();
			if(module.getModtype() == 1) {
				List<Map<String, Object>> itemTemp = (ArrayList<Map<String,Object>>)(jdbcTemplate.queryForList(AppConfig.retrieveMenuByGroupid, module.getModid()));
				for(Map<String,Object> rowChild:itemTemp){
					MModule childModule = new MModule();
					childModule.setModid(Integer.parseInt(rowChild.get("modid").toString()));
					childModule.setModname((String)rowChild.get("modname"));
					childModule.setModtype(Integer.parseInt(rowChild.get("modtype").toString()));
					childModule.setModtitle((String)rowChild.get("modtitle"));
					childModule.setModroute((String)rowChild.get("modroute"));
					childModule.setModrealpath((String)rowChild.get("modrealpath"));
					childModule.setGroupid(Integer.parseInt(rowChild.get("groupid").toString()));
					childItem.add(childModule);
				}
				module.setSubitems(childItem);
			} else {
				module.setSubitems(childItem);
			}
			tabMenus.add(module);
	    }
		return tabMenus;
	}

	@Override
	public Long checkModNameForUpdate(MModule module, long modid) {
		Object[] parameter = new Object[] {new Long(modid)}; 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.findModuleById, parameter);
		if (rows.size() > 0) {
			for (Map<String, Object> row:rows) {
				if((String) row.get("modname") == module.getModname()) {
					return (long) 1;
				}
				else {
					Long id;
					Object[] parameter1 = new Object[] {new String(module.getModname())}; 
					List<Map<String, Object>> temps = jdbcTemplate.queryForList(AppConfig.findModuleByModname, parameter1);
					if (rows.size() > 0) {
						for (Map<String, Object> temp:temps) {
							id = (Long) temp.get("modid");
							if(id == modid){
								return (long) 1;
							}
							else {
								return (long) 0;
							}
						}
					}
				}
			}
		}
		return (long) 1;
	}

	@Override
	public Long checkModName(MModule module) {
		Long id;
		Object[] parameter = new Object[] {new String(module.getModname())}; 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.findModuleByModname, parameter);
		if (rows.size() > 0) {
			for (Map<String, Object> row:rows) {
				id = (Long) row.get("modid");
				if(id > 0 ) {
					return (long) 0;
				}
				else {
					return (long) 1;
				}
			}
		}
		return (long) 1;
	}

	


}
