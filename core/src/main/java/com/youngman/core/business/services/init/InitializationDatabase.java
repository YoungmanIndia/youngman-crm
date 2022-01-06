package com.youngman.core.business.services.init;

import com.youngman.core.business.exception.ServiceException;

public interface InitializationDatabase {

    boolean isEmpty();

    void populate(String name) throws ServiceException;
}
