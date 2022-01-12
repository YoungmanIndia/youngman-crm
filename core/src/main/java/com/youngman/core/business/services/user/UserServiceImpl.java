package com.youngman.core.business.services.user;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.repositories.user.PageableUserRepository;
import com.youngman.core.business.repositories.user.UserRepository;
import com.youngman.core.model.crm.User;
import org.apache.commons.lang3.Validate;
import org.infinispan.factories.annotations.Inject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Inject
    private UserRepository userRepository;

    @Inject
    private PageableUserRepository pageableUserRepository;

    public UserServiceImpl() {
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByUserName(String userName) throws ServiceException {
        return userRepository.findByUserName(userName);
    }


    @Override
    public User findByResetPasswordToken(String userName, String token) throws ServiceException {
        Validate.notNull(userName, "User name cannot be null");
        Validate.notNull(token, "Token cannot be null");
        return null;
    }

    @Override
    public User getByPasswordResetToken(String token) {
        return userRepository.findByResetPasswordToken(token);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public void saveOrUpdate(User user) throws ServiceException {
        userRepository.save(user);
    }
}
