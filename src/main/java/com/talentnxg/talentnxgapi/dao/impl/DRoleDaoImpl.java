package com.talentnxg.talentnxgapi.dao.impl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.talentnxg.talentnxgapi.configs.AppConfig;
import com.talentnxg.talentnxgapi.dao.DRoleDao;
import com.talentnxg.talentnxgapi.models.DRole;

@Repository
public class DRoleDaoImpl implements DRoleDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public long save(DRole dRole) {
		KeyHolder dRoleKey = new GeneratedKeyHolder();
		System.out.println("try");
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveDRole, new String[]{"rmemid"});
			temp.setInt(1, dRole.getRoleid());
			temp.setInt(2, dRole.getUsersid());
			return temp;
		}, dRoleKey);
		
		return dRoleKey.getKey().longValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<DRole> getDRole() {
		List<DRole> result = new ArrayList<DRole>();
		List<Map<String, Object>> rows =  (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.selectDRole);
		
//		result.addAll((Collection<? extends DRole>) rows);
		for(Map<String,Object> row:rows){
//			result.add((DRole) i.values());
			DRole dRole = new DRole();
			dRole.setRmemid(Integer.parseInt(row.get("rmemid").toString()));
			dRole.setRoleid(Integer.parseInt(row.get("roleid").toString()));
			dRole.setUsersid(Integer.parseInt(row.get("usersid").toString()));
			result.add(dRole);
	    }
//		
		return (Iterable<DRole>) result;
	}

	@Override
	public DRole getDRoleById(Integer rmemid) {
		DRole dRole = new DRole();
		Object[] parameter = new Object[] {new Integer(rmemid)};
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.findDRoleById, parameter);
		if (rows.size() > 0) {
			for (Map<String, Object> row: rows) {
				dRole.setRmemid(Integer.parseInt(row.get("rmemid").toString()));
				dRole.setRoleid(Integer.parseInt(row.get("roleid").toString()));
				dRole.setUsersid(Integer.parseInt(row.get("usersid").toString()));
			}
		}
		return dRole;
	}
	@Override
	public DRole updateDRole(DRole dRole, Integer rmemid) {
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.updateDRole, new String[] {"rmemid"});
			temp.setInt(1, dRole.getRoleid());
			temp.setInt(2, dRole.getUsersid());
			temp.setInt(3, rmemid);
			return temp;
		});
		DRole result = getDRoleById(rmemid);
		return result;
	}

	@Override
	public void deleteDRole(Integer rmemid) {
		Object[] parameter = new Object[] {new Integer(rmemid)};
		jdbcTemplate.update(AppConfig.deleteDRole, parameter);
	}
	
	

}
