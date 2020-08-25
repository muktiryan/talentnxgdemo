package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.MRole;
import com.talentnxg.talentnxgapi.models.MRoleCustom1;

public interface MRoleDao {

	long save(MRole mRole);

	Iterable<MRole> getMRole();
	
	Iterable<MRoleCustom1> getMRoleCustom1();

	MRole getMRoleById(Integer rolesid);

	MRole updateMRole(MRole mRole, Integer rolesid);

	void deleteMRole(Integer rolesid);

	Iterable<MRoleCustom1> getMRoleCustom1BySuperAdmin();

}
