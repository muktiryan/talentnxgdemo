package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.MUserToCompany;

public interface MUserToCompanyDao {

	Iterable<MUserToCompany> getMUserToCompany();

	Long saveMUserToCompany(MUserToCompany mUsertoCompany);

	MUserToCompany findMUserToCompanyById(Integer utcid);

	MUserToCompany updateMUserToCompany(MUserToCompany mUserToCompany, Integer utcid);

	void deleteMUserToCompany(Integer utcid);

}
