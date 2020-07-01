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
import com.talentnxg.talentnxgapi.dao.MUserEmployeeDao;
import com.talentnxg.talentnxgapi.models.MUserEmployee;

@Repository
public class MUserEmployeeDaoImpl implements MUserEmployeeDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Iterable<MUserEmployee> getMUserEmployee() {
		ArrayList<MUserEmployee> result = new ArrayList<MUserEmployee>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.selectMUserEmployee);
		if (rows.size() > 0) {
			for (Map<String, Object> row: rows) {
				MUserEmployee mUseremployee = new MUserEmployee();
				mUseremployee.setUeid(Integer.parseInt(row.get("ueid").toString()));
				mUseremployee.setUserid(Integer.parseInt(row.get("userid").toString()));
				mUseremployee.setEmployeeid(Integer.parseInt(row.get("employeeid").toString()));
				result.add(mUseremployee);
			}
		}
		return result;
	}

	@Override
	public Integer saveMUserEmployee(MUserEmployee mUseremployee) {
		KeyHolder ueid = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.saveMUserEmployee, new String[] {"ueid"});
			temp.setInt(1, mUseremployee.getUserid());
			temp.setInt(2, mUseremployee.getEmployeeid());
			return temp;			
		}, ueid);
		return ueid.getKey().intValue();
	}


}
