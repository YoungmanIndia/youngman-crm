package com.youngman.youngman.services;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.business.repositories.user.PermissionRepository;
import com.youngman.model.model.common.Group;
import com.youngman.model.model.common.Permission;
import com.youngman.model.model.crm.PermissionCriteria;
import com.youngman.model.model.crm.PermissionList;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service("permissionService")
public class PermissionServiceImpl  implements PermissionService {

	@Inject
	private PermissionRepository permissionRepository;

	@Override
	public List<Permission> getByName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Permission getById(Long permissionId) {
		return permissionRepository.findOne(permissionId);

	}


	@Override
	public void deletePermission(Permission permission) throws ServiceException {
		permission = this.getById(permission.getId());//Prevents detached entity error
		permission.setGroups(null);
		permissionRepository.delete(permission);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> getPermissions(List<Integer> groupIds)
			throws ServiceException {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Set ids = new HashSet(groupIds);
		return permissionRepository.findByGroups(ids);
	}

	@Override
	public PermissionList listByCriteria(PermissionCriteria criteria)
			throws ServiceException {
		return permissionRepository.listByCriteria(criteria);
	}

	@Override
	public void removePermission(Permission permission, Group group) throws ServiceException {
		permission = this.getById(permission.getId());//Prevents detached entity error
	
		permission.getGroups().remove(group);
		

	}

	@Override
	public List<Permission> listPermission() throws ServiceException {
		return permissionRepository.findAll();
	}



}
