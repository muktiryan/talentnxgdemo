package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.MUserEmployee;

public interface MUserEmployeeDao {

	Iterable<MUserEmployee> getMUserEmployee();

	Integer saveMUserEmployee(MUserEmployee mUseremployee);

}
