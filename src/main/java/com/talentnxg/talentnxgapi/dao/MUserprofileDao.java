package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.MUserprofile;

public interface MUserprofileDao {

	long saveMUserProfile(MUserprofile mUserprofile);

	Iterable<MUserprofile> getMUserprofile();

	MUserprofile findMUserprofileById(Integer userid);

	MUserprofile updateMUserprofile(MUserprofile mUserprofile, Integer userid);

	void deleteMUserprofile(Integer userid);


}
