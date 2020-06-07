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
import com.talentnxg.talentnxgapi.dao.MUserprofileDao;
import com.talentnxg.talentnxgapi.models.MUserprofile;

@Repository
public class MUserprofileDaoImpl implements MUserprofileDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public long saveMUserProfile(MUserprofile mUserprofile) {
		KeyHolder useridKey = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveMUserprofile, new String[] {"userid"});
			temp.setString(1, mUserprofile.getUsername());
			temp.setString(2, mUserprofile.getFullname());
			temp.setString(3, mUserprofile.getSecretpwd());
			temp.setString(4, mUserprofile.getEmail());
			temp.setString(5, mUserprofile.getPhone());
			temp.setString(6, mUserprofile.getMobile());
			temp.setString(7, mUserprofile.getFax());
			temp.setInt(8, mUserprofile.getTenantid().intValue());
			temp.setString(9, mUserprofile.getEmployeecode());
			temp.setString(10, mUserprofile.getCity());
			return temp;
		}, useridKey);
		return useridKey.getKey().longValue();
	}

	@Override
	public Iterable<MUserprofile> getMUserprofile() {
		List<MUserprofile> result = new ArrayList<MUserprofile>();
		List<Map<String, Object>> rows = (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.selectMUserprofile);
		for (Map<String, Object> row : rows) {
			MUserprofile mUserprofile = new MUserprofile();
			mUserprofile.setUserid(Integer.parseInt(row.get("userid").toString()));
			mUserprofile.setUsername((String)row.get("username"));
			mUserprofile.setFullname((String)row.get("fullname"));
			mUserprofile.setActive(Integer.parseInt(row.get("active").toString()));
			mUserprofile.setSecretpwd((String)row.get("secretpwd"));
			mUserprofile.setAvatarname((String)row.get("avatarname"));
			mUserprofile.setEmail((String)row.get("email"));
			mUserprofile.setAddress((String)row.get("address"));
			mUserprofile.setAlias((String)row.get("alias"));
			mUserprofile.setPhone((String)row.get("phone"));
			mUserprofile.setMobile((String)row.get("mobile"));
			mUserprofile.setFax((String)row.get("fax"));
			mUserprofile.setCity((String)row.get("city"));
			mUserprofile.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
			mUserprofile.setEmployeecode((String)row.get("employeecode"));
			mUserprofile.setCreatedBy((String)row.get("created_by"));
			mUserprofile.setCreatedDate((Date)row.get("created_date"));
			mUserprofile.setUpdatedBy((String)row.get("updated_by"));
			mUserprofile.setUpdatedDate((Date)row.get("updated_date"));
            result.add(mUserprofile);
        }
		return (Iterable<MUserprofile>) result;
	}

	@Override
	public MUserprofile findMUserprofileById(Integer userid) {
		MUserprofile mUserprofile = new MUserprofile();
		Object[] parameter = new Object[] {new Integer(userid)}; 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.findMUserprofileById, parameter);
		if (rows.size() > 0) {
			for (Map<String, Object> row:rows) {
				mUserprofile.setUserid(Integer.parseInt(row.get("userid").toString()));
				mUserprofile.setUsername((String)row.get("username"));
				mUserprofile.setFullname((String)row.get("fullname"));
				mUserprofile.setActive(Integer.parseInt(row.get("active").toString()));
				mUserprofile.setSecretpwd((String)row.get("secretpwd"));
				mUserprofile.setAvatarname((String)row.get("avatarname"));
				mUserprofile.setEmail((String)row.get("email"));
				mUserprofile.setAddress((String)row.get("address"));
				mUserprofile.setAlias((String)row.get("alias"));
				mUserprofile.setPhone((String)row.get("phone"));
				mUserprofile.setMobile((String)row.get("mobile"));
				mUserprofile.setFax((String)row.get("fax"));
				mUserprofile.setCity((String)row.get("city"));
				mUserprofile.setTenantid(Integer.parseInt(row.get("tenantid").toString()));
				mUserprofile.setEmployeecode((String)row.get("employeecode"));
				mUserprofile.setCreatedBy((String)row.get("created_by"));
				mUserprofile.setCreatedDate((Date)row.get("created_date"));
				mUserprofile.setUpdatedBy((String)row.get("updated_by"));
				mUserprofile.setUpdatedDate((Date)row.get("updated_date"));
			}
		}		
		return mUserprofile;
	}

	@Override
	public MUserprofile updateMUserprofile(MUserprofile mUserprofile, Integer userid) {
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.updateMUserprofile, new String[] {"userid"});
			temp.setString(1, mUserprofile.getUsername());
			temp.setString(2, mUserprofile.getFullname());
			temp.setInt(3, mUserprofile.getActive());
			temp.setString(4, mUserprofile.getSecretpwd());
			temp.setString(5, mUserprofile.getAvatarname());
			temp.setString(6, mUserprofile.getEmail());
			temp.setString(7, mUserprofile.getAddress());
			temp.setString(8, mUserprofile.getAlias());
			temp.setString(9, mUserprofile.getPhone());
			temp.setString(10, mUserprofile.getMobile());
			temp.setString(11, mUserprofile.getFax());
			temp.setString(12, mUserprofile.getCity());
			temp.setInt(13, mUserprofile.getTenantid());
			temp.setString(14, mUserprofile.getEmployeecode());
			temp.setString(15, mUserprofile.getUpdatedBy());
			temp.setInt(16, userid);
			return temp;
		});
		MUserprofile result = findMUserprofileById(userid);
		return result;
	}

	@Override
	public void deleteMUserprofile(Integer userid) {
		Object[] parameter = new Object[] {new Integer(userid)};
		jdbcTemplate.update(AppConfig.deleteMUserprofile, parameter);
	}

}
