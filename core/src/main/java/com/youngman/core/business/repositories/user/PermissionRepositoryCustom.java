package com.youngman.core.business.repositories.user;


import com.youngman.core.model.crm.PermissionCriteria;
import com.youngman.core.model.crm.PermissionList;

public interface PermissionRepositoryCustom {
	PermissionList listByCriteria(PermissionCriteria criteria);


}
