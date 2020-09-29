package com.talentnxg.talentnxgapi.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.talentnxg.talentnxgapi.configs.AppConfig;
import com.talentnxg.talentnxgapi.dao.MSystemLicenseDao;
import com.talentnxg.talentnxgapi.models.MSystemLicense;

@Repository
public class MSystemLicenseDaoImpl implements MSystemLicenseDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer saveMSystemLicense(MSystemLicense mUserLicense) {
		Integer result = 0;
		String sql = AppConfig.saveMSystemLicense;
		result = jdbcTemplate.update(sql,
				mUserLicense.getCompanyCode(),
				mUserLicense.getCompanyName(),
				mUserLicense.getContactPerson(),
				mUserLicense.getContactPersonPhone(),
				mUserLicense.getCompanyLicense(),
				mUserLicense.getLicenseCode(),
				mUserLicense.getExpireDate(),
				mUserLicense.getActiveEmployee(),
				mUserLicense.getHcmUser(),
				mUserLicense.getRegisteredActiveEmployee(),
				mUserLicense.getRegisteredHcmUser(),
				mUserLicense.getRemarks(),
				mUserLicense.getEffectiveStartDate(),
				mUserLicense.getEffectiveEndDate(),
				mUserLicense.getCreatedBy()
		);
		return result;
	}
	

}
