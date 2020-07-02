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

import com.sun.corba.se.pept.transport.Connection;
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

	@Override
	public MUserEmployee findMUserEmployee(Integer ueid) {
		Object [] parameter = new Object[] {new Integer (ueid)};
		MUserEmployee mUserEmployee = new MUserEmployee();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(AppConfig.findMUserEmployeeById, parameter);
		if ( rows.size() > 0) {
			for ( Map<String, Object> row: rows) {
				mUserEmployee.setUeid(Integer.parseInt(row.get("ueid").toString()));
				mUserEmployee.setUserid(Integer.parseInt(row.get("userid").toString()));
				mUserEmployee.setEmployeeid(Integer.parseInt(row.get("employeeid").toString()));
			}
		}
		return mUserEmployee;
	}

	@Override
	public MUserEmployee updateMUserEmployee(MUserEmployee mUserEmployee, Integer ueid) {
		jdbcTemplate.update(connection -> {
			PreparedStatement temp = connection.prepareStatement(AppConfig.updateMUserEmployee);
			temp.setInt(1, mUserEmployee.getUserid());
			temp.setInt(2, mUserEmployee.getEmployeeid());
			temp.setInt(3, ueid);
			return temp;
		});
		MUserEmployee result = findMUserEmployee(ueid);
		return result;
	}

	@Override
	public void deleteMUserEmployee(Integer ueid) {
		Object[] parameter = new Object[] { new Integer (ueid)};
		jdbcTemplate.update(AppConfig.deleteMUserEmployee, parameter);
	}


}
