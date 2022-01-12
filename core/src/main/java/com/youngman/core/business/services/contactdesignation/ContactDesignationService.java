package com.youngman.core.business.services.contactdesignation;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.model.customerportal.BillingAddress;
import com.youngman.core.model.customerportal.ContactDesignation;

import java.util.List;

public interface ContactDesignationService {

    ContactDesignation getById(Long id);

    void saveOrUpdate(ContactDesignation contactDesignation) throws ServiceException;

    void delete(ContactDesignation contactDesignation);

    List<ContactDesignation> findAll();
}
