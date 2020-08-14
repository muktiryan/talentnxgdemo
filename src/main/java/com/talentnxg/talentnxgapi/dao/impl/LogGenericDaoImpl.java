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
import com.talentnxg.talentnxgapi.dao.LogGenericDao;
import com.talentnxg.talentnxgapi.models.LogGeneric;
import com.talentnxg.talentnxgapi.models.LogGenericCustom1;

@Repository
public class LogGenericDaoImpl implements LogGenericDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Iterable<LogGeneric> findLogGenericByLogTypeId(Integer logtypeid) {
		Object [] parameter = new Object[] { new Integer(logtypeid)};
		List<LogGeneric> result = new ArrayList<LogGeneric>();
		List<Map<String, Object>> rows =  (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.findLogGenericByTypeId, parameter);
		for (Map<String, Object> row : rows) {
			LogGeneric logGeneric = new LogGeneric();
			logGeneric.setId(Integer.parseInt(row.get("id").toString()));
			logGeneric.setLogDatetime((Date)row.get("log_datetime"));
			logGeneric.setLogTypeId(Integer.parseInt(row.get("log_type_id").toString()));
			logGeneric.setLogActionId(Integer.parseInt(row.get("log_action_id").toString()));
			logGeneric.setUserId(Integer.parseInt(row.get("user_id").toString()));
			logGeneric.setMenuId(Integer.parseInt(row.get("menu_id").toString()));
			logGeneric.setTrxId(Integer.parseInt(row.get("trx_id").toString()));
			logGeneric.setTenantId(Integer.parseInt(row.get("tenant_id").toString()));
			logGeneric.setCompanyId(Integer.parseInt(row.get("company_id").toString()));
			logGeneric.setDescription((String)row.get("description"));
			logGeneric.setIpcontroller((String)row.get("ipcontroller"));
			logGeneric.setLocation((String)row.get("location"));
			logGeneric.setCreatedBy((String)row.get("created_by"));
			logGeneric.setCreatedDate((Date)row.get("created_date"));
			result.add(logGeneric);
			}
		return (Iterable<LogGeneric>) result;
	}
	
	@Override
	public Integer saveLogGeneric(LogGeneric logGeneric) {
		KeyHolder idKey = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveLogGeneric, new String[]{"id"});
			temp.setInt(1, logGeneric.getLogTypeId());
			temp.setInt(2, logGeneric.getLogActionId());
			temp.setInt(3, logGeneric.getUserId());
			temp.setInt(4, logGeneric.getMenuId());
			temp.setInt(5, logGeneric.getTrxId());
			temp.setInt(6, logGeneric.getTenantId());
			temp.setInt(7, logGeneric.getCompanyId());
			temp.setString(8, logGeneric.getDescription());
			temp.setString(9, logGeneric.getIpcontroller());
			temp.setString(10, logGeneric.getLocation());
			return temp;
		}, idKey);
		
		return idKey.getKey().intValue();
	}

	@Override
	public Iterable<LogGenericCustom1> findLogGenericByLogTypeIdCst1(Integer logtypeid) {
		Object [] parameter = new Object[] { new Integer(logtypeid)};
		List<LogGenericCustom1> result = new ArrayList<LogGenericCustom1>();
		List<Map<String, Object>> rows =  (ArrayList<Map<String,Object>>) jdbcTemplate.queryForList(AppConfig.findLogGenericByTypeIdCustom1, parameter);
		for (Map<String, Object> row : rows) {
			LogGenericCustom1 logGenericCst1 = new LogGenericCustom1();
			logGenericCst1.setId(Integer.parseInt(row.get("id").toString()));
			logGenericCst1.setLogDatetime((Date)row.get("log_datetime"));
			logGenericCst1.setLogTypeId(Integer.parseInt(row.get("log_type_id").toString()));
			logGenericCst1.setLogActionId(Integer.parseInt(row.get("log_action_id").toString()));
			logGenericCst1.setLogActionString((String)row.get("log_action_string"));
			logGenericCst1.setUserId(Integer.parseInt(row.get("user_id").toString()));
			logGenericCst1.setUserName((String)row.get("username"));
//			logGenericCst1.setMenuId(Integer.parseInt(row.get("menu_id").toString()));
//			logGenericCst1.setTrxId(Integer.parseInt(row.get("trx_id").toString()));
			logGenericCst1.setTenantId(Integer.parseInt(row.get("tenant_id").toString()));
			logGenericCst1.setTenantName((String)row.get("tenant_name"));
			logGenericCst1.setCompanyId(Integer.parseInt(row.get("company_id").toString()));
			logGenericCst1.setDescription((String)row.get("description"));
			logGenericCst1.setIpcontroller((String)row.get("ipcontroller"));
			logGenericCst1.setLocation((String)row.get("location"));
			logGenericCst1.setCreatedBy((String)row.get("created_by"));
			logGenericCst1.setCreatedDate((Date)row.get("created_date"));
			result.add(logGenericCst1);
			}
		return (Iterable<LogGenericCustom1>) result;
	}

	@Override
	public Integer saveUserLogger(LogGeneric userLogger) {
		KeyHolder idKey = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveUserLogger, new String[]{"id"});
			temp.setInt(1, userLogger.getLogTypeId());
			temp.setInt(2, userLogger.getLogActionId());
			temp.setInt(3, userLogger.getUserId());
			temp.setInt(4, userLogger.getTenantId());
			temp.setInt(5, userLogger.getCompanyId());
			temp.setString(6, userLogger.getDescription());
			temp.setString(7, userLogger.getIpcontroller());
			temp.setString(8, userLogger.getLocation());
			return temp;
		}, idKey);
		
		return idKey.getKey().intValue();
	}

	@Override
	public Integer saveEventLogger(LogGeneric eventLogger) {
		KeyHolder idKey = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveEventLogger, new String[]{"id"});
			temp.setInt(1, eventLogger.getLogTypeId());
			temp.setInt(2, eventLogger.getLogActionId());
			temp.setInt(3, eventLogger.getUserId());
			temp.setInt(4, eventLogger.getMenuId());
			temp.setInt(5, eventLogger.getTrxId());
			temp.setInt(6, eventLogger.getTenantId());
			temp.setInt(7, eventLogger.getCompanyId());
			temp.setString(8, eventLogger.getDescription());
			temp.setString(9, eventLogger.getIpcontroller());
			temp.setString(10, eventLogger.getLocation());
			return temp;
		}, idKey);
		
		return idKey.getKey().intValue();
	}

	@Override
	public Integer saveTaskLogger(LogGeneric taskLogger) {
		KeyHolder idKey = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveEventLogger, new String[]{"id"});
			temp.setInt(1, taskLogger.getLogTypeId());
			temp.setInt(2, taskLogger.getLogActionId());
			temp.setInt(3, taskLogger.getUserId());
			temp.setInt(4, taskLogger.getMenuId());
			temp.setInt(5, taskLogger.getTrxId());
			temp.setInt(6, taskLogger.getTenantId());
			temp.setInt(7, taskLogger.getCompanyId());
			temp.setString(8, taskLogger.getDescription());
			temp.setString(9, taskLogger.getIpcontroller());
			temp.setString(10, taskLogger.getLocation());
			return temp;
		}, idKey);
		
		return idKey.getKey().intValue();
	}

}
