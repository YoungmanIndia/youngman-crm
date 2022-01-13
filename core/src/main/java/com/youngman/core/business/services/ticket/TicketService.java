package com.youngman.core.business.services.ticket;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.model.crm.Ticket;

import java.util.List;

public interface TicketService {

    Ticket getById(Long id);

    void saveOrUpdate(Ticket ticket) throws ServiceException;

    void delete(Ticket ticket);

    List<Ticket> findAll();
}
