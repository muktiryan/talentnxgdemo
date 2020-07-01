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
import com.talentnxg.talentnxgapi.dao.MTenantDao;
import com.talentnxg.talentnxgapi.models.MTenant;

@Repository
public class MTenantDaoImpl implements MTenantDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public long save(MTenant mTenant) {
		KeyHolder idKey = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveMTenant, new String[]{"id"});
			temp.setString(1, mTenant.getTenantCode());
			temp.setString(2, mTenant.getTenantActivationCode());
			temp.setBoolean(3, mTenant.getIsActive());
			temp.setString(4, mTenant.getCreatedBy());
			temp.setString(5, mTenant.getTenantName());
			return temp;
		}, idKey);
		
		return idKey.getKey().longValue();
	}

	@Override
	public Iterable<MTenant> getMTenant() {
		List<MTenant> result = new ArrayList<MTenant>();
		List<Map<String, Object>> rows =  (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.selectMTenant);
		for (Map<String, Object> row : rows) {
			MTenant mTenant = new MTenant();
			mTenant.setId(Integer.parseInt(row.get("id").toString()));
			mTenant.setTenantCode((String)row.get("tenant_code"));
			mTenant.setTenantActivationCode((String)row.get("tenant_activation_code"));
			mTenant.setIsActive((Boolean)row.get("is_active"));
			mTenant.setCreatedBy((String)row.get("created_by"));
			mTenant.setCreatedDate((Date)row.get("created_date"));
			mTenant.setUpdatedBy((String)row.get("updated_by"));
			mTenant.setUpdatedDate((Date)row.get("updated_date"));
			mTenant.setTenantName((String)row.get("tenant_name"));
			result.add(mTenant);}
		return (Iterable<MTenant>) result;
	}

	@Override
	public MTenant getMTenantById(Integer id) {
		MTenant mTenant = new MTenant();
		Object[] parameter = new Object[] {new Integer(id)};
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.findMTenantById, parameter);
		if (rows.size() > 0) {
			for (Map<String, Object> row: rows) {
				mTenant.setId(Integer.parseInt(row.get("id").toString()));
				mTenant.setTenantCode((String)row.get("tenant_code"));
				mTenant.setTenantActivationCode((String)row.get("tenant_activation_code"));
				mTenant.setIsActive((Boolean)row.get("is_active"));
				mTenant.setCreatedBy((String)row.get("created_by"));
				mTenant.setCreatedDate((Date)row.get("created_date"));
				mTenant.setUpdatedBy((String)row.get("updated_by"));
				mTenant.setUpdatedDate((Date)row.get("updated_date"));
				mTenant.setTenantName((String)row.get("tenant_name"));
			}
		}
		return mTenant;
	}

	@Override
	public MTenant updateMTenant(MTenant mTenant, Integer id) {
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.updateMTenant, new String[] {"id"});
			temp.setString(1, mTenant.getTenantCode());
			temp.setString(2, mTenant.getTenantActivationCode());
			temp.setBoolean(3, mTenant.getIsActive());
			temp.setString(4, mTenant.getUpdatedBy());
			temp.setString(5, mTenant.getTenantName());
			temp.setInt(6, id);
			return temp;
		});
		MTenant result = getMTenantById(id);
		return result;
	}

	@Override
	public void deleteMTenant(Integer id) {
		Object[] parameter = new Object[] {new Integer(id)};
		jdbcTemplate.update(AppConfig.deleteMTenant, parameter);
	}
	
	
	

}
