package com.youngman.core.business.services.ticketContacts;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.repositories.ticketContacts.TicketContactsRepository;
import com.youngman.core.model.crm.TicketContacts;
import org.infinispan.factories.annotations.Inject;

import java.util.List;

public class TicketContactsServiceImpl implements TicketContactsService {

    @Inject
    private TicketContactsRepository ticketContactsRepository;

    public TicketContactsServiceImpl() {
    }

    @Override
    public void delete(TicketContacts caseContacts) {
        ticketContactsRepository.delete(caseContacts);
    }

    @Override
    public List<TicketContacts> findAll() {
        return ticketContactsRepository.findAll();
    }

    @Override
    public TicketContacts getById(Long id) {
        return ticketContactsRepository.getById(id);
    }

    @Override
    public void saveOrUpdate(TicketContacts ticketContacts) throws ServiceException {
        ticketContactsRepository.save(ticketContacts);
    }
}
