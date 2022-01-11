package com.youngman.youngman.services;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.model.common.Group;
import com.youngman.core.model.common.Permission;
import com.youngman.core.model.crm.PermissionCriteria;
import com.youngman.core.model.crm.PermissionList;
import com.youngman.core.model.generic.YoungmanEntity;

import java.util.List;


public interface PermissionService {

  List<Permission> getByName();

  List<Permission> listPermission() throws ServiceException;

  Permission getById(Long permissionId);

  List<Permission> getPermissions(List<Integer> groupIds) throws ServiceException;

  void deletePermission(Permission permission) throws ServiceException;

  PermissionList listByCriteria(PermissionCriteria criteria) throws ServiceException;

  void removePermission(Permission permission, Group group) throws ServiceException;

}
