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
import com.talentnxg.talentnxgapi.dao.MSystemLicenseDao;
import com.talentnxg.talentnxgapi.models.MSystemLicense;

@Repository
public class MSystemLicenseDaoImpl implements MSystemLicenseDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer saveMSystemLicense(MSystemLicense mSystemLicense) {
		long tmp = 0;
		if(mSystemLicense.getActiveEmployee() == null) {
			mSystemLicense.setActiveEmployee(tmp);
		}
		if(mSystemLicense.getHcmUser() == null) {
			mSystemLicense.setHcmUser(tmp);
		}
		if(mSystemLicense.getRegisteredActiveEmployee() == null) {
			mSystemLicense.setRegisteredActiveEmployee(tmp);
		}
		if(mSystemLicense.getRegisteredHcmUser() == null) {
			mSystemLicense.setRegisteredHcmUser(tmp);
		}
		
		String sql = AppConfig.saveMSystemLicense;
		KeyHolder id = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(sql, new String[] {"id"});
			temp.setLong(1, mSystemLicense.getTenantId());
			temp.setLong(2, mSystemLicense.getCompanyId());
			temp.setString(3, mSystemLicense.getContactPerson());
			temp.setString(4, mSystemLicense.getContactPersonPhone());
			temp.setLong(5, mSystemLicense.getCompanyLicense());
			temp.setString(6, mSystemLicense.getLicenseCode());
			temp.setDate(7, new java.sql.Date (mSystemLicense.getExpiredDate().getTime()));
			temp.setLong(8, mSystemLicense.getActiveEmployee());
			temp.setLong(9, mSystemLicense.getHcmUser());
			temp.setLong(10, mSystemLicense.getRegisteredActiveEmployee());
			temp.setLong(11, mSystemLicense.getRegisteredHcmUser());
			temp.setString(12, mSystemLicense.getRemarks());
			temp.setDate(13, new java.sql.Date (mSystemLicense.getEffectiveStartDate().getTime()));
			temp.setDate(14, (java.sql.Date) mSystemLicense.getEffectiveEndDate());
			temp.setLong(15, mSystemLicense.getCreatedBy());
			return temp;
		}, id);
		return id.getKey().intValue();
//		Integer result = 0;
//		String sql = AppConfig.saveMSystemLicense;
//		result = jdbcTemplate.update(sql,
//				mSystemLicense.getTenantId(),
//				mSystemLicense.getCompanyId(),
//				mSystemLicense.getContactPerson(),
//				mSystemLicense.getContactPersonPhone(),
//				mSystemLicense.getCompanyLicense(),
//				mSystemLicense.getLicenseCode(),
//				mSystemLicense.getExpiredDate(),
//				mSystemLicense.getActiveEmployee(),
//				mSystemLicense.getHcmUser(),
//				mSystemLicense.getRegisteredActiveEmployee(),
//				mSystemLicense.getRegisteredHcmUser(),
//				mSystemLicense.getRemarks(),
//				mSystemLicense.getEffectiveStartDate(),
//				mSystemLicense.getEffectiveEndDate(),
//				mSystemLicense.getCreatedBy()
//		);
//		return result;
	}

	@Override
	public Iterable<MSystemLicense> retrieveMSystemLicense() {
		String sql = AppConfig.selectMSystemLicense;
		List<MSystemLicense> result = new ArrayList<MSystemLicense>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		if (rows.size() > 0) {
			for (Map<String, Object> row: rows) {
				MSystemLicense mSystemLicense = new MSystemLicense();
				mSystemLicense.setId((Integer)row.get("id"));
				mSystemLicense.setTenantId((Long)row.get("tenant_id"));
				mSystemLicense.setCompanyId((Long)row.get("company_id"));
				mSystemLicense.setCompanyCode((String)row.get("company_code"));
				mSystemLicense.setCompanyName((String)row.get("company_name"));
				mSystemLicense.setContactPerson((String)row.get("contact_person").toString());
				mSystemLicense.setContactPersonPhone((String)row.get("contact_person_phone").toString());
				mSystemLicense.setCompanyLicense((Long)row.get("company_license"));
				mSystemLicense.setLicenseCode((String)row.get("license_code").toString());
				mSystemLicense.setExpiredDate((Date)row.get("expired_date"));
				mSystemLicense.setActiveEmployee((Long)row.get("active_employee"));
				mSystemLicense.setHcmUser((Long)row.get("hcm_user"));
				mSystemLicense.setRegisteredActiveEmployee((Long)row.get("registered_active_employee"));
				mSystemLicense.setRegisteredHcmUser((Long)row.get("registered_hcm_user"));
				mSystemLicense.setRemarks((String)row.get("remarks").toString());
				mSystemLicense.setEffectiveStartDate((Date)row.get("effective_start_date"));
				mSystemLicense.setEffectiveEndDate((Date)row.get("effective_end_date"));
				mSystemLicense.setCreatedBy((Long)row.get("created_by"));
				mSystemLicense.setCreatedDate((Date)row.get("created_date"));
				mSystemLicense.setUpdatedBy((Long)row.get("updated_by"));
				mSystemLicense.setUpdatedDate((Date)row.get("updated_date"));
				mSystemLicense.setDeletedBy((Long)row.get("deleted_by"));
				mSystemLicense.setDeletedDate((Date)row.get("deleted_date"));
				mSystemLicense.setTenantName((String)row.get("tenant_name"));
				result.add(mSystemLicense);
			}
		}
		return result;
	}

	@Override
	public MSystemLicense findMSystemLicenseById(Integer id) {
		String sql = AppConfig.findMSystemLicenseById;
		Object [] parameter = new Object [] {new Integer (id)};
		MSystemLicense mSystemLicense = new MSystemLicense();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, parameter);
		if ( rows.size() > 0 ) {
			for(Map<String, Object> row: rows) {
				mSystemLicense.setId((Integer)row.get("id"));
				mSystemLicense.setTenantId((Long)row.get("tenant_id"));
				mSystemLicense.setCompanyId((Long)row.get("company_id"));
				mSystemLicense.setContactPerson((String)row.get("contact_person").toString());
				mSystemLicense.setContactPersonPhone((String)row.get("contact_person_phone").toString());
				mSystemLicense.setCompanyLicense((Long)row.get("company_license"));
				mSystemLicense.setLicenseCode((String)row.get("license_code").toString());
				mSystemLicense.setExpiredDate((Date)row.get("expired_date"));
				mSystemLicense.setActiveEmployee((Long)row.get("active_employee"));
				mSystemLicense.setHcmUser((Long)row.get("hcm_user"));
				mSystemLicense.setRegisteredActiveEmployee((Long)row.get("registered_active_employee"));
				mSystemLicense.setRegisteredHcmUser((Long)row.get("registered_hcm_user"));
				mSystemLicense.setRemarks((String)row.get("remarks").toString());
				mSystemLicense.setEffectiveStartDate((Date)row.get("effective_start_date"));
				mSystemLicense.setEffectiveEndDate((Date)row.get("effective_end_date"));
				mSystemLicense.setCreatedBy((Long)row.get("created_by"));
				mSystemLicense.setCreatedDate((Date)row.get("created_date"));
				mSystemLicense.setUpdatedBy((Long)row.get("updated_by"));
				mSystemLicense.setUpdatedDate((Date)row.get("updated_date"));
				mSystemLicense.setDeletedBy((Long)row.get("deleted_by"));
				mSystemLicense.setDeletedDate((Date)row.get("deleted_date"));
			}
		}
		return mSystemLicense;
	}

	@Override
	public void deleteMSystemLicense(Integer id) {
		String sql = AppConfig.deleteMSystemLicenseById;
		Object [] parameter = new Object [] { new Integer (id)};
		jdbcTemplate.update(sql, parameter);	
	}

	@Override
	public MSystemLicense updateMSystemLicenseById(MSystemLicense mSystemLicense, Integer id) {
		String sql = AppConfig.updateMSystemLicenseById;
		jdbcTemplate.update(sql, 
				mSystemLicense.getTenantId(),
				mSystemLicense.getCompanyId(),
				mSystemLicense.getContactPerson(),
				mSystemLicense.getContactPersonPhone(),
				mSystemLicense.getCompanyLicense(),
				mSystemLicense.getLicenseCode(),
				mSystemLicense.getExpiredDate(),
				mSystemLicense.getActiveEmployee(),
				mSystemLicense.getHcmUser(),
				mSystemLicense.getRegisteredActiveEmployee(),
				mSystemLicense.getRegisteredHcmUser(),
				mSystemLicense.getRemarks(),
				mSystemLicense.getEffectiveStartDate(),
				mSystemLicense.getEffectiveEndDate(),
				mSystemLicense.getUpdatedBy(),
				id
				);
		return mSystemLicense;
	}
	

}
