package com.youngman.youngman.services;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.model.common.Group;
import com.youngman.model.model.common.Permission;
import com.youngman.model.model.crm.PermissionCriteria;
import com.youngman.model.model.crm.PermissionList;

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
