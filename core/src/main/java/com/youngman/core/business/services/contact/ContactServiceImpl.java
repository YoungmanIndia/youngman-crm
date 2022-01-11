package com.youngman.core.business.services.contact;


import com.youngman.core.business.repositories.contact.ContactRepository;
import com.youngman.core.business.services.common.generic.YoungmanEntityServiceImpl;
import com.youngman.core.model.customerportal.Contact;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ContactServiceImpl extends YoungmanEntityServiceImpl<Long, Contact> implements ContactService {

    private ContactRepository contactRepository;

    @Inject
    public ContactServiceImpl(ContactRepository contactRepository) {
        super(contactRepository);
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact getByName(String name) throws ServiceException {
        return contactRepository.findByName(name);
    }

    @Override
    public void delete(Contact contact) throws ServiceException {
        Contact c = this.getById(contact.getId());
        super.delete(c);

    }

    @Override
    public List<Contact> listContact() throws ServiceException {
        try {
            return contactRepository.findAll();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void saveOrUpdate(Contact contact) throws ServiceException {
        contactRepository.save(contact);
    }

}
