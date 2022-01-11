package com.youngman.core.business.services.user;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.repositories.user.PageableUserRepository;
import com.youngman.core.business.repositories.user.UserRepository;
import com.youngman.core.model.crm.Users;
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
    public void delete(Users users) {
        userRepository.delete(users);
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public void saveOrUpdate(Users users) throws ServiceException {
        userRepository.save(users);
    }
}
