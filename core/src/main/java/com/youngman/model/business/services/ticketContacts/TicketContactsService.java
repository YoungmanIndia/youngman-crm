package com.youngman.model.business.services.ticketContacts;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.model.crm.TicketContacts;

import java.util.List;

public interface TicketContactsService {

    TicketContacts getById(Long id);

    void saveOrUpdate(TicketContacts ticketContacts) throws ServiceException;

    void delete(TicketContacts ticketContacts);

    List<TicketContacts> findAll();
}
