package com.talentnxg.talentnxgapi.dao.impl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
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
import com.talentnxg.talentnxgapi.models.DRole;
import com.talentnxg.talentnxgapi.models.MModule;

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
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.updateModule, new String[] {"modid"});
            temp.setString(1, module.getModname());
            temp.setInt(2, module.getModtype());
            temp.setString(3, module.getModtitle());
            temp.setString(4, module.getModroute());
            temp.setString(5, module.getModrealpath());
            temp.setString(6, module.getModicon());
            temp.setString(7, module.getUpdatedBy());
            temp.setInt(8, updatedModId);
			return temp;
		});
		MModule result = getModuleById(updatedModId);
		return result;
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
	@SuppressWarnings("unchecked")
	@Override
	public Iterable<MModule> getModules() {
		List<MModule> result = new ArrayList<MModule>();
		List<Map<String, Object>> rows = (ArrayList<Map<String, Object>>)jdbcTemplate.queryForList(AppConfig.selectModule);
//		result.addAll((Collection<? extends MModule>) rows);
		
		for(Map<String,Object> row:rows){
//			result.add((MModule) i.values());
			MModule module = new MModule();
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
			result.add(module);
	    }
		
		
		return (Iterable<MModule>) result;
	}

	//delete
	@Override
	public void deleteModule(Integer modId) {
		Object[] parameter = new Object[] {new Integer(modId)};
		jdbcTemplate.update(AppConfig.deleteModuleById, parameter);
	}



}
