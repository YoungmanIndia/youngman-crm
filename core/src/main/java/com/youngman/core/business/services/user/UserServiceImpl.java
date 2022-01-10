package com.youngman.core.business.services.user;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.repositories.user.PageableUserRepository;
import com.youngman.core.business.repositories.user.UserRepository;
import com.youngman.core.business.services.common.generic.YoungmanEntityServiceImpl;
import com.youngman.core.model.crm.Users;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserServiceImpl extends YoungmanEntityServiceImpl<Long, Users> implements UserService{

    private UserRepository userRepository;

    private PageableUserRepository pageableUserRepository;

    @Inject
    public UserServiceImpl(UserRepository userRepository, PageableUserRepository pageableUserRepository) {
        super(userRepository);
        this.userRepository = userRepository;
        this.pageableUserRepository = pageableUserRepository;
    }

    @Override
    public Users getByUserName(String userName) throws ServiceException {
        return userRepository.findByUserName(userName);
    }

    @Override
    public void delete(Users user) throws ServiceException {
        Users u = this.getById(user.getId());
        super.delete(u);

    }

    @Override
    public List<Users> listUser() throws ServiceException {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Users getByPasswordResetToken(String storeCode, String token) {
        return userRepository.findByResetPasswordToken(token, storeCode);
    }

    @Override
    public void saveOrUpdate(Users user) throws ServiceException {
        userRepository.save(user);
    }
}
