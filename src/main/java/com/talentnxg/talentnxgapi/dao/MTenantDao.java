package com.talentnxg.talentnxgapi.dao;

import com.talentnxg.talentnxgapi.models.MTenant;

public interface MTenantDao {

	long save(MTenant mTenant);

	Iterable<MTenant> getMTenant();

	MTenant getMTenantById(Integer id);

	MTenant updateMTenant(MTenant mTenant, Integer id);

	void deleteMTenant(Integer id);

}
