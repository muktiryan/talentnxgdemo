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
import com.talentnxg.talentnxgapi.dao.MRoleDao;
import com.talentnxg.talentnxgapi.models.MRole;

@Repository
public class MRoleDaoImpl implements MRoleDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public long save(MRole mRole) {
		KeyHolder mRoleKey = new GeneratedKeyHolder();
		System.out.println("try");
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveMRole, new String[]{"rolesid"});
			temp.setString(1, mRole.getRolename());
			temp.setInt(2, mRole.getTenantid());
			temp.setString(3, mRole.getCreatedBy());
			temp.setInt(4, mRole.getIsadmin());
			return temp;
		}, mRoleKey);
		
		return mRoleKey.getKey().longValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<MRole> getMRole() {
		List<MRole> result = new ArrayList<MRole>();
		List<Map<String, Object>> rows =  (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.selectMRole);
		result.addAll((Collection<? extends MRole>) rows);
		return (Iterable<MRole>) result;
	}

	@Override
	public MRole getMRoleById(Integer rolesid) {
		MRole mRole = new MRole();
		Object[] parameter = new Object[] {new Integer(rolesid)};
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.findMRoleById, parameter);
		if (rows.size() > 0) {
			for (Map<String, Object> row: rows) {
				mRole.setRolesid(Integer.parseInt(row.get("rolesid").toString()));
				mRole.setRolename((String)row.get("rolename"));
				mRole.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
				mRole.setCreatedBy((String)row.get("created_by"));
				mRole.setCreatedDate((Date)row.get("created_date"));
				mRole.setUpdatedBy((String)row.get("updated_by"));
				mRole.setUpdatedDate((Date)row.get("updated_Date"));
				mRole.setIsadmin(Integer.parseInt(row.get("isadmin").toString()));
				mRole.setRoleidrtp(Integer.parseInt(row.get("roleidrpt").toString()));
			}
		}
		return mRole;
	}

	@Override
	public MRole updateMRole(MRole mRole, Integer rolesid) {
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.updateMRole, new String[] {"rolesid"});
			temp.setString(1, mRole.getRolename());
			temp.setInt(2, mRole.getTenantid());
			temp.setString(3,  mRole.getUpdatedBy());
			temp.setInt(4, mRole.getIsadmin());
			temp.setInt(5, rolesid);
			return temp;
		});
		MRole result = getMRoleById(rolesid);
		return result;
	}

	@Override
	public void deleteMRole(Integer rolesid) {
		Object[] parameter = new Object[] {new Integer(rolesid)};
		jdbcTemplate.update(AppConfig.deleteMRole, parameter);
	}
	

}
