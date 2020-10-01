package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.DSystemLicense;
import com.talentnxg.talentnxgapi.models.MApplicationCustom2;

public interface DSystemLicenseDao {

	Iterable<DSystemLicense> retrieveDSystemLicense();

	Integer saveDSystemLicense(DSystemLicense dSystemLicense);

	DSystemLicense findDSystemLicenseById(Integer id);

	void deleteDSystemLicenseById(Integer id);

	void deleteDSystemLicenseByLicenseId(Integer licenseid);

	Iterable<MApplicationCustom2> findDSystemLicenseByLicenseId(Integer licenseid);

}
