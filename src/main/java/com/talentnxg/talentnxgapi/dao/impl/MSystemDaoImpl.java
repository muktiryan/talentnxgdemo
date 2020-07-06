package com.talentnxg.talentnxgapi.dao.impl;

import java.sql.Date;
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
import com.talentnxg.talentnxgapi.dao.MSystemDao;
import com.talentnxg.talentnxgapi.models.MSystem;

@Repository
public class MSystemDaoImpl implements MSystemDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer saveMSystem(MSystem mSystem) {
		KeyHolder sysId = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveMSystem, new String[] {"sys_id"});
			temp.setString(1, mSystem.getAppName());
			temp.setInt(2, mSystem.getLanguage());
			temp.setInt(3, mSystem.getCalendarFmt());
			temp.setInt(4, mSystem.getDateInFmt());
			temp.setInt(5, mSystem.getDateOutFmt());
			temp.setInt(6, mSystem.getTimeFmt());
			temp.setInt(7, mSystem.getDecimalSeparator());
			temp.setInt(8, mSystem.getNumericFmt());
			temp.setInt(9, mSystem.getRowView());
			temp.setInt(10, mSystem.getRowFilter());
			temp.setString(11, mSystem.getPIC());
			temp.setInt(12, mSystem.getPageLogging());
			temp.setInt(13, mSystem.getUniqueChar());
			temp.setInt(14, mSystem.getKeepUserLog());
			temp.setInt(15, mSystem.getPeriodExpWeb());
			temp.setInt(16, mSystem.getPeriodExpMobile());
			temp.setInt(17, mSystem.getNewDeviceDetectEmail());
			temp.setInt(18, mSystem.getNewDeviceDetectSms());
			temp.setInt(19, mSystem.getNewDeviceDetectGoogle());
			temp.setInt(20, mSystem.getThemes());
			temp.setDate(21, (Date) mSystem.getEffectiveStartDate());
			temp.setDate(22, (Date) mSystem.getEffectiveEndDate());
			temp.setString(23, mSystem.getRemark());
			return temp;
		}, sysId);
		return sysId.getKey().intValue();
	}

	@Override
	public Iterable<MSystem> getMSystems() {
		ArrayList<MSystem> result = new ArrayList<MSystem>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.selectMSystem);
		if (rows.size() > 0) {
			for (Map<String, Object> row : rows) {
				MSystem mSystem = new MSystem();
				mSystem.setSysId(Integer.parseInt(row.get("sys_id").toString()));
				mSystem.setAppName((String)row.get("app_name"));
				mSystem.setLanguage(Integer.parseInt(row.get("language").toString()));
				mSystem.setCalendarFmt(Integer.parseInt(row.get("calendar_fmt").toString()));
				mSystem.setDateInFmt(Integer.parseInt(row.get("date_in_fmt").toString()));
				mSystem.setDateOutFmt(Integer.parseInt(row.get("date_out_fmt").toString()));
				mSystem.setTimeFmt(Integer.parseInt(row.get("time_fmt").toString()));
				mSystem.setDecimalSeparator(Integer.parseInt(row.get("decimal_separator").toString()));
				mSystem.setNumericFmt(Integer.parseInt(row.get("numeric_fmt").toString()));
				mSystem.setRowView(Integer.parseInt(row.get("row_view").toString()));
				mSystem.setRowFilter(Integer.parseInt(row.get("row_filter").toString()));
				mSystem.setPIC((String)row.get("PIC"));
				mSystem.setPageLogging(Integer.parseInt(row.get("page_logging").toString()));
				mSystem.setUniqueChar(Integer.parseInt(row.get("unique_char").toString()));
				mSystem.setKeepUserLog(Integer.parseInt(row.get("keep_user_log").toString()));
				mSystem.setPeriodExpWeb(Integer.parseInt(row.get("period_exp_web").toString()));
				mSystem.setPeriodExpMobile(Integer.parseInt(row.get("period_exp_mobile").toString()));
				mSystem.setNewDeviceDetectEmail(Integer.parseInt(row.get("new_device_detect_email").toString()));
				mSystem.setNewDeviceDetectSms(Integer.parseInt(row.get("new_device_detect_sms").toString()));
				mSystem.setNewDeviceDetectGoogle(Integer.parseInt(row.get("new_device_detect_google").toString()));
				mSystem.setThemes(Integer.parseInt(row.get("themes").toString()));
				mSystem.setEffectiveStartDate((Date)row.get("effective_start_date"));
				mSystem.setEffectiveEndDate((Date)row.get("effective_end_date"));
				mSystem.setRemark((String)row.get("remark"));
				result.add(mSystem);
			}
		}
		return result;
	}

	@Override
	public MSystem findMSystemById(Integer sysid) {
		MSystem mSystem = new MSystem();
		Object [] parameter = new Object [] {new Integer (sysid)};
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.findMSystemById, parameter);
		if (rows.size() > 0) {
			for(Map<String, Object> row: rows) {
				mSystem.setSysId(Integer.parseInt(row.get("sys_id").toString()));
				mSystem.setAppName((String)row.get("app_name"));
				mSystem.setLanguage(Integer.parseInt(row.get("language").toString()));
				mSystem.setCalendarFmt(Integer.parseInt(row.get("calendar_fmt").toString()));
				mSystem.setDateInFmt(Integer.parseInt(row.get("date_in_fmt").toString()));
				mSystem.setDateOutFmt(Integer.parseInt(row.get("date_out_fmt").toString()));
				mSystem.setTimeFmt(Integer.parseInt(row.get("time_fmt").toString()));
				mSystem.setDecimalSeparator(Integer.parseInt(row.get("decimal_separator").toString()));
				mSystem.setNumericFmt(Integer.parseInt(row.get("numeric_fmt").toString()));
				mSystem.setRowView(Integer.parseInt(row.get("row_view").toString()));
				mSystem.setRowFilter(Integer.parseInt(row.get("row_filter").toString()));
				mSystem.setPIC((String)row.get("PIC"));
				mSystem.setPageLogging(Integer.parseInt(row.get("page_logging").toString()));
				mSystem.setUniqueChar(Integer.parseInt(row.get("unique_char").toString()));
				mSystem.setKeepUserLog(Integer.parseInt(row.get("keep_user_log").toString()));
				mSystem.setPeriodExpWeb(Integer.parseInt(row.get("period_exp_web").toString()));
				mSystem.setPeriodExpMobile(Integer.parseInt(row.get("period_exp_mobile").toString()));
				mSystem.setNewDeviceDetectEmail(Integer.parseInt(row.get("new_device_detect_email").toString()));
				mSystem.setNewDeviceDetectSms(Integer.parseInt(row.get("new_device_detect_sms").toString()));
				mSystem.setNewDeviceDetectGoogle(Integer.parseInt(row.get("new_device_detect_google").toString()));
				mSystem.setThemes(Integer.parseInt(row.get("themes").toString()));
				mSystem.setEffectiveStartDate((Date)row.get("effective_start_date"));
				mSystem.setEffectiveEndDate((Date)row.get("effective_end_date"));
				mSystem.setRemark((String)row.get("remark"));
			}
		}
		return mSystem;
	}

	@Override
	public MSystem updateMSystem(MSystem mSystem, Integer sysid) {
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.updateMSystemById);
			temp.setString(1, mSystem.getAppName());
			temp.setInt(2, mSystem.getLanguage());
			temp.setInt(3, mSystem.getCalendarFmt());
			temp.setInt(4, mSystem.getDateInFmt());
			temp.setInt(5, mSystem.getDateOutFmt());
			temp.setInt(6, mSystem.getTimeFmt());
			temp.setInt(7, mSystem.getDecimalSeparator());
			temp.setInt(8, mSystem.getNumericFmt());
			temp.setInt(9, mSystem.getRowView());
			temp.setInt(10, mSystem.getRowFilter());
			temp.setString(11, mSystem.getPIC());
			temp.setInt(12, mSystem.getPageLogging());
			temp.setInt(13, mSystem.getUniqueChar());
			temp.setInt(14, mSystem.getKeepUserLog());
			temp.setInt(15, mSystem.getPeriodExpWeb());
			temp.setInt(16, mSystem.getPeriodExpMobile());
			temp.setInt(17, mSystem.getNewDeviceDetectEmail());
			temp.setInt(18, mSystem.getNewDeviceDetectSms());
			temp.setInt(19, mSystem.getNewDeviceDetectGoogle());
			temp.setInt(20, mSystem.getThemes());
			temp.setDate(21, (Date) mSystem.getEffectiveStartDate());
			temp.setDate(22, (Date) mSystem.getEffectiveEndDate());
			temp.setString(23, mSystem.getRemark());
			temp.setString(24, mSystem.getUpdatedBy());
			temp.setDate(25, (Date) mSystem.getUpdateDate());
			temp.setInt(26, sysid);
			return temp;
		});
		MSystem result = findMSystemById(sysid);
		return result;
	}

	@Override
	public void deleteMSystem(Integer sysid) {
		Object[] parameter = new Object [] { new Integer (sysid)};
		jdbcTemplate.update(AppConfig.deleteMSystem, parameter);
	}

}
