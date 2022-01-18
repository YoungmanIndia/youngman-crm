package com.youngman.youngman.services;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.business.repositories.user.GroupRepository;
import com.youngman.model.enums.GroupType;
import com.youngman.model.model.common.Group;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service("groupService")
public class GroupServiceImpl implements GroupService {

  @Inject
  private GroupRepository groupRepository;


  @Override
  public List<Group> listGroup(GroupType groupType) throws ServiceException {
    try {
      return groupRepository.findByType(groupType);
    } catch (Exception e) {
      throw new ServiceException(e);
    }
  }

  public List<Group> listGroupByIds(Set<Integer> ids) throws ServiceException {

      try {
        return ids.isEmpty() ? new ArrayList<Group>() : groupRepository.findByIds(ids);
      } catch (Exception e) {
        throw new ServiceException(e);
      }

  }


  @Override
  public Group findByName(String groupName) throws ServiceException {
    return groupRepository.findByGroupName(groupName);
  }


  @Override
  public List<Group> listGroupByNames(List<String> names) throws ServiceException {
    return groupRepository.findByNames(names);
  }


}
