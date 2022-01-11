package com.youngman.core.business.services.contactdesignation;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.repositories.contactdesignation.ContactDesignationRepository;
import com.youngman.core.business.services.common.generic.YoungmanEntityServiceImpl;
import com.youngman.core.model.customerportal.ContactDesignation;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ContactDesignationServiceImpl extends YoungmanEntityServiceImpl<Long, ContactDesignation> implements ContactDesignationService {

    private ContactDesignationRepository contactDesignationRepository;

    @Inject
    public ContactDesignationServiceImpl(ContactDesignationRepository contactDesignationRepository) {
        super(contactDesignationRepository);
        this.contactDesignationRepository = contactDesignationRepository;
    }

    @Override
    public void delete(ContactDesignation contactDesignation) throws ServiceException {
        ContactDesignation c = this.getById(contactDesignation.getId());
        super.delete(c);

    }

    @Override
    public void saveOrUpdate(ContactDesignation contactDesignation) throws ServiceException {
        contactDesignationRepository.save(contactDesignation);
    }
}
