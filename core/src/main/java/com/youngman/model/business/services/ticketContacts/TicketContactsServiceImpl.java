package com.youngman.model.business.services.ticketContacts;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.business.repositories.ticketContacts.TicketContactsRepository;
import com.youngman.model.model.crm.TicketContacts;
import org.infinispan.factories.annotations.Inject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
