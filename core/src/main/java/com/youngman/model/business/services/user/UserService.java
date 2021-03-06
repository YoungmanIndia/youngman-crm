package com.youngman.model.business.services.user;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.model.crm.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    void saveOrUpdate(User user) throws ServiceException;

    void delete(User user);

    List<User> findAll();

    User getByUserName(String userName) throws ServiceException;

    User getByPasswordResetToken(String token);

    User findByResetPasswordToken (String userName, String token) throws ServiceException;


}
