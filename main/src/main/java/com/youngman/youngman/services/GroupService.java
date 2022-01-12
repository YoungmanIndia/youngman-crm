package com.youngman.youngman.services;


import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.enums.GroupType;
import com.youngman.core.model.common.Group;

import java.util.List;
import java.util.Set;


public interface GroupService {
	List<Group> listGroup(GroupType groupType) throws ServiceException;
	List<Group> listGroupByIds(Set<Integer> ids) throws ServiceException;
	List<Group> listGroupByNames(List<String> names) throws ServiceException;
	Group findByName(String groupName) throws ServiceException;

}
