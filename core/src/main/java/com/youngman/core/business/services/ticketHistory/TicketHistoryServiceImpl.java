package com.youngman.core.business.services.ticketHistory;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.repositories.ticketHistory.TicketHistoryRepository;
import com.youngman.core.model.crm.TicketHistory;
import org.infinispan.factories.annotations.Inject;

import java.util.List;

public class TicketHistoryServiceImpl implements TicketHistoryService {

    @Inject
    private TicketHistoryRepository ticketHistoryRepository;

    public TicketHistoryServiceImpl() {
    }

    @Override
    public void delete(TicketHistory ticketHistory) {
        ticketHistoryRepository.delete(ticketHistory);
    }

    @Override
    public List<TicketHistory> findAll() {
        return ticketHistoryRepository.findAll();
    }

    @Override
    public TicketHistory getById(Long id) {
        return ticketHistoryRepository.getById(id);
    }

    @Override
    public void saveOrUpdate(TicketHistory ticketHistory) throws ServiceException {
        ticketHistoryRepository.save(ticketHistory);
    }
}
