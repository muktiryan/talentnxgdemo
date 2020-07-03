package com.talentnxg.talentnxgapi.dao.impl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.talentnxg.talentnxgapi.configs.AppConfig;
import com.talentnxg.talentnxgapi.dao.DProfileDao;
import com.talentnxg.talentnxgapi.models.DProfile;

@Repository
public class DProfileDaoImpl implements DProfileDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public long save(DProfile dProfile) {
		KeyHolder dProfileKey = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveDProfile, new String[]{"objid"});
			temp.setInt(1, dProfile.getAppid());
			temp.setInt(2, dProfile.getRolesid());
			temp.setInt(3, dProfile.getProfileid());
			return temp;
		}, dProfileKey);
		
		return dProfileKey.getKey().longValue();
	}

	@Override
	public Iterable<DProfile> getDProfile() {
		List<DProfile> result = new ArrayList<DProfile>();
		List<Map<String, Object>> rows =  (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.selectDProfile);
		for (Map<String, Object> row: rows) {
			DProfile dProfile = new DProfile();
			dProfile.setObjid(Integer.parseInt(row.get("objid").toString()));
			dProfile.setAppid(Integer.parseInt(row.get("appid").toString()));
			dProfile.setAppname((String)row.get("appname"));
			dProfile.setRolesid(Integer.parseInt(row.get("rolesid").toString()));
			dProfile.setRolename((String)row.get("rolename"));
			dProfile.setProfileid(Integer.parseInt(row.get("profileid").toString()));
			dProfile.setProfilename((String)row.get("profilesname"));
			result.add(dProfile);
		}
		return (Iterable<DProfile>) result;
	}
	
//	@Override
//	public Iterable<DProfile> getDProfileNew() {
//		List<DProfile> result = new ArrayList<DProfile>();
//		List<Map<String, Object>> rows =  (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.selectDProfileNew);
//		for (Map<String, Object> row: rows) {
//			DProfile dProfile = new DProfile();
//			dProfile.setObjid(Integer.parseInt(row.get("objid").toString()));
//			dProfile.setAppid(Integer.parseInt(row.get("appid").toString()));
//			dProfile.setAppname((String)row.get("appname"));
//			dProfile.setRolesid(Integer.parseInt(row.get("rolesid").toString()));
//			dProfile.setRolename((String)row.get("rolename"));
//			dProfile.setProfileid(Integer.parseInt(row.get("profileid").toString()));
//			dProfile.setProfilename((String)row.get("profilesname"));
//			result.add(dProfile);
//		}
//		return (Iterable<DProfile>) result;
//	}

	@Override
	public Iterable<DProfile> getDProfileByProfileid(Integer profileid) {
		ArrayList<DProfile> result = new ArrayList<DProfile>();
		Object[] parameter = new Object[] {new Integer(profileid)};
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.findDProfileByProfileId, parameter);
		if (rows.size() > 0) {
			for (Map<String, Object> row: rows) {
				DProfile dProfile = new DProfile();
				dProfile.setObjid(Integer.parseInt(row.get("objid").toString()));
				dProfile.setAppid(Integer.parseInt(row.get("appid").toString()));
				dProfile.setAppname((String)row.get("appname"));
				dProfile.setRolesid(Integer.parseInt(row.get("rolesid").toString()));
				dProfile.setRolename((String)row.get("rolename"));
				dProfile.setProfileid(Integer.parseInt(row.get("profileid").toString()));
				dProfile.setProfilename((String)row.get("profilesname"));
				result.add(dProfile);
			}
			return result;
		}
		return result;
	}
	
	@Override
	public DProfile getDProfileById(Integer objid) {
		DProfile dProfile = new DProfile();
		Object [] parameter = new Object [] { new Integer ( objid )};
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.findDProfileById, parameter);
		if (rows.size() > 0) {
			for (Map<String, Object> row: rows) {
				dProfile.setObjid(Integer.parseInt(row.get("objid").toString()));
				dProfile.setAppid(Integer.parseInt(row.get("appid").toString()));
				dProfile.setAppname((String)row.get("appname"));
				dProfile.setRolesid(Integer.parseInt(row.get("rolesid").toString()));
				dProfile.setRolename((String)row.get("rolename"));
				dProfile.setProfileid(Integer.parseInt(row.get("profileid").toString()));
				dProfile.setProfilename((String)row.get("profilesname"));
			}
		}
		return dProfile;
	}

	@Override
	public DProfile updateDProfile(DProfile dProfile, Integer objid) {
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.updateDProfile, new String[] {"objid"});
			temp.setInt(1, dProfile.getAppid());
			temp.setInt(2, dProfile.getRolesid());
			temp.setInt(3,  dProfile.getProfileid());
			temp.setInt(4, objid);
			return temp;
		});
		DProfile result = getDProfileById(objid);
		return result;
	}

	@Override
	public void deleteDProfile(Integer objid) {
		Object[] parameter = new Object[] {new Integer(objid)};
		jdbcTemplate.update(AppConfig.deleteDProfile, parameter);
	}

	
	
}
