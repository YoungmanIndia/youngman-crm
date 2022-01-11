package com.youngman.core.business.services.contactdesignation;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.services.common.generic.YoungmanEntityService;
import com.youngman.core.model.customerportal.ContactDesignation;

public interface ContactDesignationService extends YoungmanEntityService<Long, ContactDesignation> {

    ContactDesignation getById(Long id);

    void saveOrUpdate(ContactDesignation contactDesignation) throws ServiceException;

}
