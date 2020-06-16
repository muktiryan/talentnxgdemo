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
import com.talentnxg.talentnxgapi.dao.DApplicationDao;
import com.talentnxg.talentnxgapi.models.DApplication;

@Repository
public class DApplicationDaoImpl implements DApplicationDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public long save(DApplication dApplication) {
		KeyHolder dAppKey = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveDApplication, new String[]{"appid"});
			temp.setInt(1, dApplication.getAppid());
			temp.setInt(2, dApplication.getModid());
			temp.setString(3, dApplication.getCreatedBy());
			return temp;
		}, dAppKey);
		
		return dAppKey.getKey().longValue();
	}

	@Override
	public Iterable<DApplication> getDApplication() {
		List<DApplication> result = new ArrayList<DApplication>();
		List<Map<String, Object>> rows =  (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.selectDApplication);
		for (Map<String, Object> row: rows) {
			DApplication dApplication = new DApplication();
			dApplication.setIntegid(Integer.parseInt(row.get("integid").toString()));
			dApplication.setAppid(Integer.parseInt(row.get("appid").toString()));
			dApplication.setModid(Integer.parseInt(row.get("modid").toString()));
			dApplication.setCreatedBy((String)row.get("created_by"));
			dApplication.setCreatedDate((Date)row.get("created_date"));
			dApplication.setUpdatedBy((String)row.get("updated_by"));
			dApplication.setUpdatedDate((Date)row.get("updated_date"));
			result.add(dApplication);
		}
		return (Iterable<DApplication>) result;
	}

	@Override
	public DApplication getDApplicationById(Integer integid) {
		DApplication dApplication = new DApplication();
		Object[] parameter = new Object[] {new Integer(integid)};
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.findDApplicationById, parameter);
		if (rows.size() > 0) {
			for (Map<String, Object> row: rows) {
				dApplication.setIntegid(Integer.parseInt(row.get("integid").toString()));
				dApplication.setAppid(Integer.parseInt(row.get("appid").toString()));
				dApplication.setModid(Integer.parseInt(row.get("modid").toString()));
				dApplication.setCreatedBy((String)row.get("created_by"));
				dApplication.setCreatedDate((Date)row.get("created_date"));
				dApplication.setUpdatedBy((String)row.get("updated_by"));
				dApplication.setUpdatedDate((Date)row.get("updated_date"));
			}
		}
		return dApplication;
	}

	@Override
	public DApplication updateDApplication(DApplication dApplication, Integer integid) {
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.updateDApplication, new String[] {"integid"});
			temp.setInt(1, dApplication.getAppid());
			temp.setInt(2, dApplication.getModid());
			temp.setString(3,  dApplication.getUpdatedBy());
			temp.setInt(4, integid);
			return temp;
		});
		DApplication result = getDApplicationById(integid);
		return result;
	}

	@Override
	public void deleteDApplication(Integer integid) {
		Object[] parameter = new Object[] {new Integer(integid)};
		jdbcTemplate.update(AppConfig.deleteDApplication, parameter);
	}

	@Override
	public void deleteDApplicationByAppid(Integer appid) {
		Object[] parameter = new Object[] {new Integer(appid)};
		jdbcTemplate.update(AppConfig.deleteDApplicationByAppid, parameter);
		
	}

}
