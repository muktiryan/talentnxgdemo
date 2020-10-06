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
import com.talentnxg.talentnxgapi.dao.MApplicationDao;
import com.talentnxg.talentnxgapi.models.MApplication;
import com.talentnxg.talentnxgapi.models.MApplicationCustom1;

@Repository
public class MApplicationDaoImpl implements MApplicationDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public long save(MApplication mApplication) {
		KeyHolder mAppKey = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveMApplication, new String[]{"appid"});
			temp.setString(1, mApplication.getAppname());
			temp.setString(2, mApplication.getDescription());
			temp.setString(3, mApplication.getCreatedBy());
			temp.setInt(4, mApplication.getTenantid());
			return temp;
		}, mAppKey);
		
		return mAppKey.getKey().longValue();
	}

	@Override
	public Iterable<MApplication> getMApplication() {
		List<MApplication> result = new ArrayList<MApplication>();
		List<Map<String, Object>> rows =  (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.selectMApplication);
		for (Map<String, Object> row: rows) {
			MApplication mApplication = new MApplication();
			mApplication.setAppid(Integer.parseInt(row.get("appid").toString()));
			mApplication.setAppname((String)row.get("appname"));
			mApplication.setDescription((String)row.get("description"));
			mApplication.setCreatedBy((String)row.get("created_by"));
			mApplication.setCreatedDate((Date)row.get("created_date"));
			mApplication.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
			mApplication.setUpdatedBy((String)row.get("updated_by"));
			mApplication.setUpdatedDate((Date)row.get("updated_date"));
			result.add(mApplication);
		}
		return (Iterable<MApplication>) result;
	}
	

	@Override
	public Iterable<MApplicationCustom1> getMApplicationCustom1() {
		List<MApplicationCustom1> result = new ArrayList<MApplicationCustom1>();
		List<Map<String, Object>> rows = (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.selectMApplicationCustom1);
		for (Map<String, Object> row: rows) {
			MApplicationCustom1 mApplicationCustom1 = new MApplicationCustom1();
			mApplicationCustom1.setAppid(Integer.parseInt(row.get("appid").toString()));
			mApplicationCustom1.setAppname((String)row.get("appname"));
			mApplicationCustom1.setDescription((String)row.get("description"));
			mApplicationCustom1.setCreatedBy((String)row.get("created_by"));
			mApplicationCustom1.setCreatedDate((Date)row.get("created_date"));
			mApplicationCustom1.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
			mApplicationCustom1.setUpdatedBy((String)row.get("updated_by"));
			mApplicationCustom1.setUpdatedDate((Date)row.get("updated_date"));
			mApplicationCustom1.setTenantname((String)row.get("tenant_name"));
			mApplicationCustom1.setCompanyname((String)row.get("company_name"));
			result.add(mApplicationCustom1);
		}
		return (Iterable<MApplicationCustom1>) result;
	}
	
	@Override
	public Iterable<MApplicationCustom1> getMApplicationCustom1BySuperAdmin() {
		List<MApplicationCustom1> result = new ArrayList<MApplicationCustom1>();
		List<Map<String, Object>> rows = (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.selectMApplicationCustom1BySuperAdmin);
		for (Map<String, Object> row: rows) {
			MApplicationCustom1 mApplicationCustom1 = new MApplicationCustom1();
			mApplicationCustom1.setAppid(Integer.parseInt(row.get("appid").toString()));
			mApplicationCustom1.setAppname((String)row.get("appname"));
			mApplicationCustom1.setDescription((String)row.get("description"));
			mApplicationCustom1.setCreatedBy((String)row.get("created_by"));
			mApplicationCustom1.setCreatedDate((Date)row.get("created_date"));
			mApplicationCustom1.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
			mApplicationCustom1.setUpdatedBy((String)row.get("updated_by"));
			mApplicationCustom1.setUpdatedDate((Date)row.get("updated_date"));
			mApplicationCustom1.setTenantname((String)row.get("tenant_name"));
			mApplicationCustom1.setCompanyname((String)row.get("company_name"));
			result.add(mApplicationCustom1);
		}
		return (Iterable<MApplicationCustom1>) result;
	}

	@Override
	public MApplication getMApplicationById(Integer appid) {
		MApplication mApplication = new MApplication();
		Object[] parameter = new Object[] {new Integer(appid)};
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.findMApplicationById, parameter);
		if (rows.size() > 0) {
			for (Map<String, Object> row: rows) {
				mApplication.setAppid(Integer.parseInt(row.get("appid").toString()));
				mApplication.setAppname((String)row.get("appname"));
				mApplication.setDescription((String)row.get("description"));
				mApplication.setCreatedBy((String)row.get("created_by"));
				mApplication.setCreatedDate((Date)row.get("created_date"));
				mApplication.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
				mApplication.setUpdatedBy((String)row.get("updated_by"));
				mApplication.setUpdatedDate((Date)row.get("updated_date"));
			}
		}
		return mApplication;
	}

	@Override
	public MApplication updateMApplication(MApplication mApplication, Integer appid) {
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.updateMApplication, new String[] {"appid"});
			temp.setString(1, mApplication.getAppname());
			temp.setString(2, mApplication.getDescription());
			temp.setInt(3, mApplication.getTenantid());
			temp.setString(4,  mApplication.getUpdatedBy());
			temp.setInt(5, appid);
			return temp;
		});
		MApplication result = getMApplicationById(appid);
		return result;
	}

	@Override
	public void deleteMApplication(Integer appid) {
		Object[] parameter = new Object[] {new Integer(appid)};
		jdbcTemplate.update(AppConfig.deleteDApplicationByAppid, parameter);
		jdbcTemplate.update(AppConfig.deleteMApplication, parameter);
	}
	
	@Override
	public long deletMApplication(Integer appd) {
		// TODO Auto-generated method stub
		Object[] parameter = new Object[] {new Integer(appd)};
		jdbcTemplate.update(AppConfig.deleteDApplicationByAppid, parameter);
//		jdbcTemplate.update(connection -> {
//			PreparedStatement temp = connection.prepareStatement(AppConfig.deleteDApplicationByAppid, new String[] {"appid"});
//			temp.setInt(1, appd);
//			return temp;
//		});
		
		
		
		jdbcTemplate.update(AppConfig.deleteMApplication, parameter);
		return appd;
	}

	@Override
	public Iterable<MApplicationCustom1> getMApplicationByType(Integer typeid) {
		
		Object[] parameter = new Object[] {new Integer(typeid)};
		List<MApplicationCustom1> result = new ArrayList<MApplicationCustom1>();
		List<Map<String, Object>> rows = (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.selectMApplicationByType, parameter);
		for (Map<String, Object> row: rows) {
			MApplicationCustom1 mApplicationCustom1 = new MApplicationCustom1();
			mApplicationCustom1.setAppid(Integer.parseInt(row.get("appid").toString()));
			mApplicationCustom1.setAppname((String)row.get("appname"));
			mApplicationCustom1.setDescription((String)row.get("description"));
			mApplicationCustom1.setCreatedBy((String)row.get("created_by"));
			mApplicationCustom1.setCreatedDate((Date)row.get("created_date"));
			mApplicationCustom1.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
			mApplicationCustom1.setUpdatedBy((String)row.get("updated_by"));
			mApplicationCustom1.setUpdatedDate((Date)row.get("updated_date"));
			mApplicationCustom1.setTenantname((String)row.get("tenant_name"));
			mApplicationCustom1.setCompanyname((String)row.get("company_name"));
			result.add(mApplicationCustom1);
		}
		return (Iterable<MApplicationCustom1>) result;
	}

	@Override
	public Iterable<MApplication> getMApplicationByRoleId(Integer roleid) {
		String sql = AppConfig.selectMApplicationByRoleId;
		Object[] parameter = new Object [] {new Integer (roleid)};
		List<MApplication> result = new ArrayList<MApplication>();
		List<Map<String, Object>> temporary = (ArrayList<Map<String,Object>>)(jdbcTemplate.queryForList(sql, parameter));
		for(Map<String,Object> row:temporary){
			MApplication mApplication = new MApplication();
			mApplication.setAppid(Integer.parseInt(row.get("appid").toString()));
			mApplication.setAppname((String)row.get("appname"));
			mApplication.setDescription((String)row.get("description"));
			mApplication.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
			result.add(mApplication);
	    }
		return result;
	}

	



}
