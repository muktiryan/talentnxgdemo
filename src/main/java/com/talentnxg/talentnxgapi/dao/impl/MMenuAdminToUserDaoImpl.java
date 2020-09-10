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
import com.talentnxg.talentnxgapi.dao.MMenuAdminToUserDao;
import com.talentnxg.talentnxgapi.models.MMenuAdmin;
import com.talentnxg.talentnxgapi.models.MMenuAdminToUser;

@Repository
public class MMenuAdminToUserDaoImpl implements MMenuAdminToUserDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public long saveMMenuAdminToUser(MMenuAdminToUser mMenuAdminToUser) {
		KeyHolder idKey = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveMMenuAdminToUser, new String[]{"id"});
			temp.setInt(1, mMenuAdminToUser.getUserId());
			temp.setInt(2, mMenuAdminToUser.getMenuAdminId());
			return temp;
		}, idKey);
		
		return idKey.getKey().longValue();
	}

	@Override
	public Iterable<MMenuAdminToUser> getMMenuAdminToUser() {
		List<MMenuAdminToUser> result = new ArrayList<MMenuAdminToUser>();
		List<Map<String, Object>> rows =  (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.selectMMenuAdminToUser);
		for (Map<String, Object> row: rows) {
			MMenuAdminToUser mMenuAdminToUser = new MMenuAdminToUser();
			mMenuAdminToUser.setId(Integer.parseInt(row.get("id").toString()));
			mMenuAdminToUser.setUserId(Integer.parseInt(row.get("user_id").toString()));
			mMenuAdminToUser.setMenuAdminId(Integer.parseInt(row.get("menu_admin_id").toString()));
			mMenuAdminToUser.setMenuAdminName((String)row.get("menu_admin_name"));
			mMenuAdminToUser.setCreatedBy(Integer.parseInt(row.get("created_by").toString()));
			mMenuAdminToUser.setCreatedDate((Date)row.get("created_date"));
//			mMenuAdminToUser.setUpdatedBy(Integer.parseInt(row.get("updated_by").toString()));
//			mMenuAdminToUser.setUpdatedDate((Date)row.get("updated_date"));
			result.add(mMenuAdminToUser);
		}
		return (Iterable<MMenuAdminToUser>) result;
	}

	@Override
	public Iterable<MMenuAdminToUser> findMMenuAdminToUserByUserId(Integer userId) {
		Object[] parameter = new Object [] {new Integer (userId)};
		List<MMenuAdminToUser> result = new ArrayList<MMenuAdminToUser>();
		List<Map<String, Object>> rows =  (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.findMMenuAdminToUserByUserId, parameter);
		for (Map<String, Object> row: rows) {
			MMenuAdminToUser mMenuAdminToUser = new MMenuAdminToUser();
			mMenuAdminToUser.setId(Integer.parseInt(row.get("id").toString()));
			mMenuAdminToUser.setUserId(Integer.parseInt(row.get("user_id").toString()));
			mMenuAdminToUser.setMenuAdminId(Integer.parseInt(row.get("menu_admin_id").toString()));
			mMenuAdminToUser.setMenuAdminName((String)row.get("menu_admin_name"));
			mMenuAdminToUser.setCreatedBy(Integer.parseInt(row.get("created_by").toString()));
			mMenuAdminToUser.setCreatedDate((Date)row.get("created_date"));
//			mMenuAdminToUser.setUpdatedBy(Integer.parseInt(row.get("updated_by").toString()));
//			mMenuAdminToUser.setUpdatedDate((Date)row.get("updated_date"));
			result.add(mMenuAdminToUser);
		}
		return (Iterable<MMenuAdminToUser>) result;
	}

	@Override
	public void deleteMenuAdminByUserId(Integer userId) {
		Object[] parameter = new Object[] {new Integer(userId)};
		jdbcTemplate.update(AppConfig.deleteMenuAdminById, parameter);	
	}

	@Override
	public Iterable<MMenuAdmin> findMMenuAdminToUserByGroupName(String groupName) {
		Object[] parameter = new Object [] {new String (groupName)};
		List<MMenuAdmin> result = new ArrayList<MMenuAdmin>();
		List<Map<String, Object>> rows =  (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.findMMenuAdminToUserByGroupName, parameter);
		for (Map<String, Object> row: rows) {
			MMenuAdmin mMenuAdmin = new MMenuAdmin();
			mMenuAdmin.setId(Integer.parseInt(row.get("id").toString()));
			mMenuAdmin.setMenuAdminName((String)row.get("menu_admin_name"));
			mMenuAdmin.setCreatedBy(Integer.parseInt(row.get("created_by").toString()));
			mMenuAdmin.setCreatedDate((Date)row.get("created_date"));
//			mMenuAdminToUser.setUpdatedBy(Integer.parseInt(row.get("updated_by").toString()));
//			mMenuAdminToUser.setUpdatedDate((Date)row.get("updated_date"));
			result.add(mMenuAdmin);
		}
		return (Iterable<MMenuAdmin>) result;
	}
	
	

}
