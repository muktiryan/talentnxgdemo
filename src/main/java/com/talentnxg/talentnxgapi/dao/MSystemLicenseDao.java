package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.MSystemLicense;

public interface MSystemLicenseDao {

	Integer saveMSystemLicense(MSystemLicense mSystemLicense);

	Iterable<MSystemLicense> retrieveMSystemLicense();

	MSystemLicense findMSystemLicenseById(Integer id);

	void deleteMSystemLicense(Integer id);

	MSystemLicense updateMSystemLicenseById(MSystemLicense mSystemLicense, Integer id);

}
