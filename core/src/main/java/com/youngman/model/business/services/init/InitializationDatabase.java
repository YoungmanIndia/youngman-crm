package com.youngman.model.business.services.init;

import com.youngman.model.business.exception.ServiceException;

public interface InitializationDatabase {

    boolean isEmpty();

    void populate(String name) throws ServiceException;
}
