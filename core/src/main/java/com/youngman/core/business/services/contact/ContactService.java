package com.youngman.core.business.services.contact;

import com.youngman.core.model.customerportal.Contact;

import java.util.List;

public interface ContactService extends YoungmanEntityService<Long, Contact>{

    Contact getByName(String name) throws ServiceException;

    List<Contact> listContact throws ServiceException;

    Contact getById(Long id);

    void saveOrUpdate(Contact contact) throws ServiceException;

}
