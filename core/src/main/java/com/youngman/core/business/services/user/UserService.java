package com.youngman.core.business.services.user;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.services.common.generic.YoungmanEntityService;
import com.youngman.core.model.crm.Users;
import com.youngman.core.model.customerportal.BillingAddress;

import java.util.List;

public interface UserService {

    Users getById(Long id);

    void saveOrUpdate(Users users) throws ServiceException;

    void delete(Users users);

    List<Users> findAll();
}
