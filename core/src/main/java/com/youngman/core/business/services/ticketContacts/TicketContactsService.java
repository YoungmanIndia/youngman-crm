package com.youngman.core.business.services.ticketContacts;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.model.crm.TicketContacts;

import java.util.List;

public interface TicketContactsService {

    TicketContacts getById(Long id);

    void saveOrUpdate(TicketContacts ticketContacts) throws ServiceException;

    void delete(TicketContacts ticketContacts);

    List<TicketContacts> findAll();
}
