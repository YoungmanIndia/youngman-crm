package com.youngman.core.business.services.ticketHistory;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.model.crm.TicketHistory;

import java.util.List;

public interface TicketHistoryService {

    TicketHistory getById(Long id);

    void saveOrUpdate(TicketHistory ticketHistory) throws ServiceException;

    void delete(TicketHistory ticketHistory);

    List<TicketHistory> findAll();
}
