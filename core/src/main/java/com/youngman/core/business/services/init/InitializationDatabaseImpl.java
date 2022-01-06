package com.youngman.core.business.services.init;

import com.youngman.core.business.exception.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("initializationDatabase")
public class InitializationDatabaseImpl implements InitializationDatabase {

    private String name;

    public boolean isEmpty() {
        return false;
    }

    @Transactional
    public void populate(String contextName) throws ServiceException {
        this.name =  contextName;

//        createSecurityGroups();

    }
}
