package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.LogGeneric;

public interface LogGenericDao {

	Iterable<LogGeneric> findLogGenericByLogTypeId(Integer logtypeid);
	Integer saveLogGeneric(LogGeneric logGeneric);


//	Integer saveUserLogger(LogGeneric userLogger);
//
//	Integer saveEventLogger(LogGeneric eventLogger);
//
//	Integer saveTaskLogger(LogGeneric taskLogger);


}
