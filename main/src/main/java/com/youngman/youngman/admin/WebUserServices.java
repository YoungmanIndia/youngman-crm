package com.youngman.youngman.admin;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface WebUserServices extends UserDetailsService {

    void createDefaultAdmin() throws Exception;

}
