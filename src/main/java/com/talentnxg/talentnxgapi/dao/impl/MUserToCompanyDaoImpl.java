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
import com.talentnxg.talentnxgapi.dao.MUserToCompanyDao;
import com.talentnxg.talentnxgapi.models.MUserToCompany;

@Repository
public class MUserToCompanyDaoImpl implements MUserToCompanyDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Iterable<MUserToCompany> getMUserToCompany() {
		ArrayList<MUserToCompany> result = new ArrayList<MUserToCompany>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.selectMUserToCompany);
		if ( rows.size() > 0) {
			for (Map<String, Object> row : rows) {
				MUserToCompany mUserToCompany = new MUserToCompany();
				mUserToCompany.setUtcid(Integer.parseInt(row.get("utcid").toString()));
				mUserToCompany.setUserid(Integer.parseInt(row.get("userid").toString()));
				mUserToCompany.setUsername((String)row.get("username"));
				mUserToCompany.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
				mUserToCompany.setTenantname((String)row.get("tenant_name"));
				mUserToCompany.setCompanyid(Integer.parseInt(row.get("companyid").toString()));
				mUserToCompany.setCompanyname((String)row.get("company_name"));
				result.add(mUserToCompany);
			}			
		}
		return result;
	}

	@Override
	public Long saveMUserToCompany(MUserToCompany mUsertoCompany) {
		KeyHolder utcid = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveMUserToCompany, new String [] {"utcid"});
			temp.setInt(1, mUsertoCompany.getUserid());
			temp.setInt(2, mUsertoCompany.getTenantid());
			temp.setInt(3, mUsertoCompany.getCompanyid());
			return temp;
		}, utcid);
		return utcid.getKey().longValue();
	}

	@Override
	public MUserToCompany findMUserToCompanyById(Integer utcid) {
		MUserToCompany mUserToCompany = new MUserToCompany();
		Object[] parameter = new Object[] { new Integer (utcid) };
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.findMUserToCompanyById, parameter);
		if ( rows.size() > 0 ) {
			for (Map<String, Object> row : rows) {
			mUserToCompany.setUtcid(Integer.parseInt(row.get("utcid").toString()));
			mUserToCompany.setUserid(Integer.parseInt(row.get("userid").toString()));
			mUserToCompany.setUsername((String)row.get("username"));
			mUserToCompany.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
			mUserToCompany.setTenantname((String)row.get("tenant_name"));
			mUserToCompany.setCompanyid(Integer.parseInt(row.get("companyid").toString()));
			mUserToCompany.setCompanyname((String)row.get("company_name"));
			} 
		}
		return mUserToCompany;
	}

	@Override
	public MUserToCompany updateMUserToCompany(MUserToCompany mUserToCompany, Integer utcid) {
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.updateMUserToCompany, new String [] {"utcid"});
			temp.setInt(1, mUserToCompany.getUserid());
			temp.setInt(2, mUserToCompany.getTenantid());
			temp.setInt(3, mUserToCompany.getCompanyid());
			temp.setInt(4, utcid);
			return temp;
		});
		MUserToCompany result = findMUserToCompanyById(utcid);
		return result;
	}

	@Override
	public void deleteMUserToCompany(Integer utcid) {
		Object [] parameter = new Object [] { new Integer (utcid)};
		jdbcTemplate.update(AppConfig.deleteMUserToCompany, parameter);
	}
	
	

}
