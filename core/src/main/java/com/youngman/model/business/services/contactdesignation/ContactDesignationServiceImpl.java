package com.youngman.model.business.services.contactdesignation;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.business.repositories.contactdesignation.ContactDesignationRepository;
import com.youngman.model.model.customerportal.ContactDesignation;
import org.infinispan.factories.annotations.Inject;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactDesignationServiceImpl implements ContactDesignationService {

    @Inject
    private ContactDesignationRepository contactDesignationRepository;

    public ContactDesignationServiceImpl() {
    }

    @Override
    public void delete(ContactDesignation contactDesignation) {
        contactDesignationRepository.delete(contactDesignation);
    }

    @Override
    public List<ContactDesignation> findAll() {
        return contactDesignationRepository.findAll();
    }

    @Override
    public ContactDesignation getById(Long id) {
        return contactDesignationRepository.getById(id);
    }

    @Override
    public void saveOrUpdate(ContactDesignation contactDesignation) throws ServiceException {
        contactDesignationRepository.save(contactDesignation);
    }
}
