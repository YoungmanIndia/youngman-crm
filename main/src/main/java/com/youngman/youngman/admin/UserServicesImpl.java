package com.youngman.youngman.admin;

import com.youngman.core.business.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//@Service("userDetailsService")
public class UserServicesImpl implements WebUserServices{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServicesImpl.class);

    private static final String DEFAULT_INITIAL_PASSWORD = "password";

    @Inject
    private UserService userService;

    @Inject
    @Named("passwordEncoder")
    private PasswordEncoder passwordEncoder;

    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException, DataAccessException {

        com.youngman.core.model.crm.User user = null;
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        try {

            user = userService.getByUserName(userName);

            if(user==null) {
                return null;
            }

            GrantedAuthority role = new SimpleGrantedAuthority("");//required to login
            authorities.add(role);

        } catch (Exception e) {
            LOGGER.error("Exception while querrying user",e);
//            throw new SecurityDataAccessException("Exception while querrying user",e);
        }

        org.springframework.security.core.userdetails.User secUser = new User(userName, DEFAULT_INITIAL_PASSWORD, true, true,
                true, true, authorities);
        return secUser;
    }

    public void createDefaultAdmin() throws Exception {

        //TODO create all groups and permissions

        String password = passwordEncoder.encode(DEFAULT_INITIAL_PASSWORD);

        //creation of the super admin admin:password)
        com.youngman.core.model.crm.User user = new com.youngman.core.model.crm.User();
        user.setName("Admin");

        userService.saveOrUpdate(user);


    }

}
