package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.MUserprofile;

public interface MUserprofileDao {

	long saveMUserProfile(MUserprofile mUserprofile);

	Iterable<MUserprofile> getMUserprofile();
	Iterable<MUserprofile> getMUserprofileSelected(int idrole);

	MUserprofile findMUserprofileById(Integer userid);

	MUserprofile updateMUserprofile(MUserprofile mUserprofile, Integer userid);

	void deleteMUserprofile(Integer userid);

	Iterable<MUserprofile> getMUserprofileBySuperAdmin();

	Iterable<MUserprofile> getMUserprofileSelectedBySuperUser(Integer roleid);

	long checkUsername(MUserprofile mUserprofile);

	Long checkUsernameForUpdate(MUserprofile mUserprofile, Long userid);



}
