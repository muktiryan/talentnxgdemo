package com.talentnxg.talentnxgapi.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.talentnxg.talentnxgapi.configs.AppConfig;
import com.talentnxg.talentnxgapi.dao.DSystemLicenseDao;
import com.talentnxg.talentnxgapi.models.DSystemLicense;
import com.talentnxg.talentnxgapi.models.MApplicationCustom2;

@Repository
public class DSystemLicenseDaoImpl implements DSystemLicenseDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Iterable<DSystemLicense> retrieveDSystemLicense() {
		String sql = AppConfig.selectDSystemLicense;
		List<DSystemLicense> result = new ArrayList<DSystemLicense>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		if(rows.size() > 0) {
			for(Map<String, Object> row: rows) {
				DSystemLicense dSystemLicense = new DSystemLicense();
				dSystemLicense.setId((Integer)row.get("id"));
				dSystemLicense.setLicenseId((Long)row.get("license_id"));
				dSystemLicense.setModuleId((Long)row.get("module_id"));
				result.add(dSystemLicense);
			}
		}
		return result;
	}

	@Override
	public Integer saveDSystemLicense(DSystemLicense dSystemLicense) {
		String sql = AppConfig.saveDSystemLicense;
		Integer result = 0;
		result = jdbcTemplate.update(sql,
				dSystemLicense.getLicenseId(),
				dSystemLicense.getModuleId()
				);
		return result;
	}

	@Override
	public DSystemLicense findDSystemLicenseById(Integer id) {
		String sql = AppConfig.findDSystemLicenseById;
		Object [] parameter = new Object [] {new Integer (id)};
		DSystemLicense dSystemLicense = new DSystemLicense();
		List<Map<String , Object>> rows = jdbcTemplate.queryForList(sql, parameter);
		if(rows.size() > 0) {
			for(Map<String, Object> row: rows) {
				dSystemLicense.setId((Integer)row.get("id"));
				dSystemLicense.setLicenseId((Long)row.get("license_id"));
				dSystemLicense.setModuleId((Long)row.get("module_id"));
			}
		}
		return dSystemLicense;
	}

	@Override
	public void deleteDSystemLicenseById(Integer id) {
		String sql = AppConfig.deleteDSystemLicenseById;
		Object [] parameter = new Object [] { new Integer (id)};
		jdbcTemplate.update(sql, parameter);
	}

	@Override
	public void deleteDSystemLicenseByLicenseId(Integer licenseid) {
		String sql = AppConfig.deleteDSystemLicenseByLicenseId;
		Object [] parameter = new Object [] {new Integer (licenseid)};
		jdbcTemplate.update(sql, parameter);
	}

	@Override
	public Iterable<MApplicationCustom2> findDSystemLicenseByLicenseId(Integer licenseid) {
		String sql = AppConfig.findDSystemLicenseByLicenseId;
		Object [] parameter = new Object [] {new Integer (licenseid)};
		List<MApplicationCustom2> result = new ArrayList<MApplicationCustom2>();
		List<Map<String , Object>> rows = jdbcTemplate.queryForList(sql, parameter);
		if(rows.size() > 0) {
			for(Map<String, Object> row: rows) {
				MApplicationCustom2 mApplicationCustom2 = new MApplicationCustom2();
				mApplicationCustom2.setAppid(Integer.parseInt(row.get("appid").toString()));
				mApplicationCustom2.setAppname((String)row.get("appname"));
				mApplicationCustom2.setDescription((String)row.get("description"));
				mApplicationCustom2.setCreatedBy((String)row.get("created_by"));
				mApplicationCustom2.setCreatedDate((Date)row.get("created_date"));
				mApplicationCustom2.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
				mApplicationCustom2.setUpdatedBy((String)row.get("updated_by"));
				mApplicationCustom2.setUpdatedDate((Date)row.get("updated_date"));
				mApplicationCustom2.setLicenseId((Long)row.get("license_id"));
				result.add(mApplicationCustom2);
			}
		}
		return result;
	}

}
