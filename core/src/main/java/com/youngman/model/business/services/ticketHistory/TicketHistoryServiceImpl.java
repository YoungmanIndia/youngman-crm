package com.youngman.model.business.services.ticketHistory;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.business.repositories.ticketHistory.TicketHistoryRepository;
import com.youngman.model.model.crm.TicketHistory;
import org.infinispan.factories.annotations.Inject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
