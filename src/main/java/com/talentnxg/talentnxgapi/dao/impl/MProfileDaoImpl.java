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
import com.talentnxg.talentnxgapi.dao.MProfileDao;
import com.talentnxg.talentnxgapi.models.MProfile;

@Repository
public class MProfileDaoImpl implements MProfileDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public long save(MProfile mProfile) {
		KeyHolder mProfileKey = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveMProfile, new String[]{"profilesid"});
			temp.setString(1, mProfile.getProfilesname());
			temp.setInt(2, mProfile.getTenantid());
			temp.setString(3, mProfile.getCreatedBy());
			return temp;
		}, mProfileKey);
		
		return mProfileKey.getKey().longValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<MProfile> getMProfile() {
		List<MProfile> result = new ArrayList<MProfile>();
		List<Map<String, Object>> rows =  (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.selectMProfile);
		result.addAll((Collection<? extends MProfile>) rows);
		return (Iterable<MProfile>) result;
	}

	@Override
	public MProfile getMProfileById(Integer profilesid) {
		MProfile mProfile = new MProfile();
		Object[] parameter = new Object[] {new Integer(profilesid)};
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.findMProfileById, parameter);
		if (rows.size() > 0) {
			for (Map<String, Object> row: rows) {
				mProfile.setProfilesid(Integer.parseInt(row.get("profilesid").toString()));
				mProfile.setProfilesname((String)row.get("profilesname"));
				mProfile.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
				mProfile.setCreatedBy((String)row.get("created_by"));
				mProfile.setCreatedDate((Date)row.get("created_date"));
				mProfile.setUpdatedBy((String)row.get("updated_by"));
				mProfile.setUpdatedDate((Date)row.get("updated_date"));
			}
		}
		return mProfile;
	}

	@Override
	public MProfile updateMProfile(MProfile mProfile, Integer profilesid) {
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.updateMProfile, new String[] {"profilesid"});
			temp.setString(1, mProfile.getProfilesname());
			temp.setInt(2, mProfile.getTenantid());
			temp.setString(3,  mProfile.getUpdatedBy());
			temp.setInt(4, profilesid);
			return temp;
		});
		MProfile result = getMProfileById(profilesid);
		return result;
	}

	@Override
	public void deleteMProfile(Integer profilesid) {
		Object[] parameter = new Object[] {new Integer(profilesid)};
		jdbcTemplate.update(AppConfig.deleteMProfile, parameter);
	}

}
