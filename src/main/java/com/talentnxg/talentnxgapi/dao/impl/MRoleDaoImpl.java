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
import com.talentnxg.talentnxgapi.dao.MRoleDao;
import com.talentnxg.talentnxgapi.models.MRole;
import com.talentnxg.talentnxgapi.models.MRoleCustom1;

@Repository
public class MRoleDaoImpl implements MRoleDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public long save(MRole mRole) {
//		jdbcTemplate.update(AppConfig.initialMember1);
		KeyHolder mRoleKey = new GeneratedKeyHolder();
		System.out.println("############ "+mRole.getRolename());
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveMRole, new String[]{"rolesid"});
			temp.setString(1, mRole.getRolename());
			temp.setInt(2, mRole.getTenantid());
			temp.setInt(3, mRole.getRoleidrpt());
			temp.setInt(4, mRole.getIsadmin());
			return temp;
		}, mRoleKey);
		return mRoleKey.getKey().longValue();
	}

	@Override
	public Iterable<MRole> getMRole() {
		List<MRole> result = new ArrayList<MRole>();
		List<Map<String, Object>> rows =  (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.selectMRole);
		for (Map<String, Object> row: rows) {
			MRole mRole = new MRole();
			mRole.setRolesid(Integer.parseInt(row.get("rolesid").toString()));
			mRole.setRolename((String)row.get("rolename"));
			mRole.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
			mRole.setCreatedBy((String)row.get("created_by"));
			mRole.setCreatedDate((Date)row.get("created_date"));
			mRole.setUpdatedBy((String)row.get("updated_by"));
			mRole.setUpdatedDate((Date)row.get("updated_Date"));
			mRole.setIsadmin(Integer.parseInt(row.get("isadmin").toString()));
			mRole.setRoleidrpt(Integer.parseInt(row.get("roleidrpt").toString()));
			result.add(mRole);}
		return (Iterable<MRole>) result;
	}
	
	@Override
	public Iterable<MRoleCustom1> getMRoleCustom1() {
		List<MRoleCustom1> result = new ArrayList<MRoleCustom1>();
		List<Map<String, Object>> rows =  (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.selectMRoleCustom1);
		for (Map<String, Object> row: rows) {
			MRoleCustom1 mRole = new MRoleCustom1();
			mRole.setRolesid(Integer.parseInt(row.get("rolesid").toString()));
			mRole.setRolename((String)row.get("rolename"));
			mRole.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
			mRole.setCreatedBy((String)row.get("created_by"));
			mRole.setCreatedDate((Date)row.get("created_date"));
			mRole.setUpdatedBy((String)row.get("updated_by"));
			mRole.setUpdatedDate((Date)row.get("updated_Date"));
			mRole.setIsadmin(Integer.parseInt(row.get("isadmin").toString()));
			mRole.setRoleidrpt(Integer.parseInt(row.get("roleidrpt").toString()));
			mRole.setTenantname((String)row.get("tenant_name"));
			mRole.setIsadminStr((String)row.get("isadminstr"));
			mRole.setCompanyname((String)row.get("company_name"));
			result.add(mRole);
		}
		return (Iterable<MRoleCustom1>) result;
	}
	
	@Override
	public Iterable<MRoleCustom1> getMRoleCustom1BySuperAdmin() {
		List<MRoleCustom1> result = new ArrayList<MRoleCustom1>();
		List<Map<String, Object>> rows =  (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.selectMRoleCustom1BySuperAdmin);
		for (Map<String, Object> row: rows) {
			MRoleCustom1 mRole = new MRoleCustom1();
			mRole.setRolesid(Integer.parseInt(row.get("rolesid").toString()));
			mRole.setRolename((String)row.get("rolename"));
			mRole.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
			mRole.setCreatedBy((String)row.get("created_by"));
			mRole.setCreatedDate((Date)row.get("created_date"));
			mRole.setUpdatedBy((String)row.get("updated_by"));
			mRole.setUpdatedDate((Date)row.get("updated_Date"));
			mRole.setIsadmin(Integer.parseInt(row.get("isadmin").toString()));
			mRole.setRoleidrpt(Integer.parseInt(row.get("roleidrpt").toString()));
			mRole.setTenantname((String)row.get("tenant_name"));
			mRole.setIsadminStr((String)row.get("isadminstr"));
			mRole.setCompanyname((String)row.get("company_name"));
			result.add(mRole);
		}
		return (Iterable<MRoleCustom1>) result;
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
				mRole.setRoleidrpt(Integer.parseInt(row.get("roleidrpt").toString()));
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
			temp.setInt(5, mRole.getRoleidrpt());
			temp.setInt(6, rolesid);
			
			return temp;
		});
		MRole result = getMRoleById(rolesid);
		return result;
	}

	@Override
	public void deleteMRole(Integer rolesid) {
		Object[] parameter = new Object[] {new Integer(rolesid)};
		jdbcTemplate.update(AppConfig.deleteDRoleByRoleId, parameter);
		jdbcTemplate.update(AppConfig.deleteMRole, parameter);
	}

	@Override
	public Long checkRoleName(MRole mRole) {
		Long id;
		Object[] parameter = new Object[] {new String(mRole.getRolename())}; 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.findMRoleByRolename, parameter);
		if (rows.size() > 0) {
			for (Map<String, Object> row:rows) {
				id = (Long) row.get("rolesid");
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

	@Override
	public Long checkRoleNameForUpdate(MRole mRole, long updatedRolesid) {
		Object[] parameter = new Object[] {new Long(updatedRolesid)}; 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.findMRoleById, parameter);
		if (rows.size() > 0) {
			for (Map<String, Object> row:rows) {
				if((String) row.get("rolename") == mRole.getRolename()) {
					return (long) 1;
				}
				else {
					Long id;
					Object[] parameter1 = new Object[] {new String(mRole.getRolename())}; 
					List<Map<String, Object>> temps = jdbcTemplate.queryForList(AppConfig.findMRoleByRolename, parameter1);
					if (rows.size() > 0) {
						for (Map<String, Object> temp:temps) {
							id = (Long) temp.get("rolesid");
							if(id == updatedRolesid){
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
	public Long checkRoleMember(long checkrolesid) {
		Object[] parameter = new Object[] {new Integer ((int) checkrolesid)}; 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.findDRoleByRoleId, parameter);
		if (rows.size() > 0) {
			for (Map<String, Object> row:rows) {
				Long id = (Long) row.get("rolesid");
				if(id == null ) {
					return (long) 0;
				}
				else {
				}
			}
		}
		return (long) 1;
	}
	

}
