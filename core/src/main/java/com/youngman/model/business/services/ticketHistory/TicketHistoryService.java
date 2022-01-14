package com.youngman.model.business.services.ticketHistory;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.model.crm.TicketHistory;

import java.util.List;

public interface TicketHistoryService {

    TicketHistory getById(Long id);

    void saveOrUpdate(TicketHistory ticketHistory) throws ServiceException;

    void delete(TicketHistory ticketHistory);

    List<TicketHistory> findAll();
}
