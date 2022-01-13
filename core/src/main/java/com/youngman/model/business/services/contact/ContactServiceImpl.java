package com.youngman.model.business.services.contact;


import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.business.repositories.contact.ContactRepository;
import com.youngman.model.business.repositories.contact.PageableContactRepository;
import com.youngman.model.model.customerportal.Contact;
import org.infinispan.factories.annotations.Inject;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactServiceImpl implements ContactService {

    @Inject
    private ContactRepository contactRepository;

    @Inject
    private PageableContactRepository pageableContactRepository;

    public ContactServiceImpl() {
    }

    @Override
    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getById(Long id) {
        return contactRepository.getById(id);
    }

    @Override
    public void saveOrUpdate(Contact contact) throws ServiceException {
        contactRepository.save(contact);
    }

}
