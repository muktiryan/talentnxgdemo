package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.MMenuAdmin;
import com.talentnxg.talentnxgapi.models.MMenuAdminToUser;

public interface MMenuAdminToUserDao {

	long saveMMenuAdminToUser(MMenuAdminToUser mMenuAdminToUser);

	Iterable<MMenuAdminToUser> getMMenuAdminToUser();

	Iterable<MMenuAdminToUser> findMMenuAdminToUserByUserId(Integer userId);

	void deleteMenuAdminByUserId(Integer userId);

	Iterable<MMenuAdmin> findMMenuAdminToUserByGroupName(String groupName);

}
