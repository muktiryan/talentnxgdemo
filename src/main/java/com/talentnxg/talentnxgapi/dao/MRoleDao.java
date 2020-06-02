package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.MRole;

public interface MRoleDao {

	long save(MRole mRole);

	Iterable<MRole> getMRole();

	MRole getMRoleById(Integer rolesid);

	MRole updateMRole(MRole mRole, Integer rolesid);

	void deleteMRole(Integer rolesid);

}
