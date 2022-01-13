package com.youngman.model.business.services.contactdesignation;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.model.customerportal.ContactDesignation;

import java.util.List;

public interface ContactDesignationService {

    ContactDesignation getById(Long id);

    void saveOrUpdate(ContactDesignation contactDesignation) throws ServiceException;

    void delete(ContactDesignation contactDesignation);

    List<ContactDesignation> findAll();
}
