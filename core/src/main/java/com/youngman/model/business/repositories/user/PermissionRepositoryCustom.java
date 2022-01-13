package com.youngman.model.business.repositories.user;


import com.youngman.model.model.crm.PermissionCriteria;
import com.youngman.model.model.crm.PermissionList;

public interface PermissionRepositoryCustom {
	PermissionList listByCriteria(PermissionCriteria criteria);


}
