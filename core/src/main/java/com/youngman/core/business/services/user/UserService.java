package com.youngman.core.business.services.user;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.services.common.generic.YoungmanEntityService;
import com.youngman.core.model.crm.Users;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService extends YoungmanEntityService<Long, Users>{

    Users getByUserName(String userName) throws ServiceException;

    List<Users> listUser() throws ServiceException;

    Users getById(Long id);

//    Users getByPasswordResetToken(String storeCode, String token);

    void saveOrUpdate(Users user) throws ServiceException;
}
