package com.youngman.model.business.services.contact;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.model.customerportal.Contact;

import java.util.List;

public interface ContactService {

    Contact getById(Long id);

    void saveOrUpdate(Contact contact) throws ServiceException;

    void delete(Contact contact);

    List<Contact> findAll();

}
