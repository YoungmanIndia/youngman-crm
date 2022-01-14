package com.youngman.youngman.services;


import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.enums.GroupType;
import com.youngman.model.model.common.Group;

import java.util.List;
import java.util.Set;


public interface GroupService {
	List<Group> listGroup(GroupType groupType) throws ServiceException;
	List<Group> listGroupByIds(Set<Integer> ids) throws ServiceException;
	List<Group> listGroupByNames(List<String> names) throws ServiceException;
	Group findByName(String groupName) throws ServiceException;

}
