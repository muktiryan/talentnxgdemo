package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.DRole;

public interface DRoleDao {

	long save(DRole dRole);

	Iterable<DRole> getDRole();

	DRole getDRoleById(Integer rmemid);

	DRole updateDRole(DRole dRole, Integer rmemid);

	void deleteDRole(Integer rmemid);

}
