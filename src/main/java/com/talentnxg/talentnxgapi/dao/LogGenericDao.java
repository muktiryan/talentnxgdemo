package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.LogGeneric;
import com.talentnxg.talentnxgapi.models.LogGenericCustom1;

public interface LogGenericDao {

	Iterable<LogGeneric> findLogGenericByLogTypeId(Integer logtypeid);
	Integer saveLogGeneric(LogGeneric logGeneric);
	Iterable<LogGenericCustom1> findLogGenericByLogTypeIdCst1(Integer logtypeid);


	Integer saveUserLogger(LogGeneric userLogger);

	Integer saveEventLogger(LogGeneric eventLogger);

	Integer saveTaskLogger(LogGeneric taskLogger);


}
