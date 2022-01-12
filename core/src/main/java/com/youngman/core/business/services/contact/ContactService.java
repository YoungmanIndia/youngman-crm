package com.youngman.core.business.services.contact;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.model.customerportal.Contact;

import java.util.List;

public interface ContactService {

    Contact getById(Long id);

    void saveOrUpdate(Contact contact) throws ServiceException;

    void delete(Contact contact);

    List<Contact> findAll();

}
