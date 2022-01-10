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
}
