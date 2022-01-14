package com.youngman.model.business.services.ticket;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.model.crm.Ticket;

import java.util.List;

public interface TicketService {

    Ticket getById(Long id);

    void saveOrUpdate(Ticket ticket) throws ServiceException;

    void delete(Ticket ticket);

    List<Ticket> findAll();
}
