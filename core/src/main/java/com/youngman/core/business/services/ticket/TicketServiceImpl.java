package com.youngman.core.business.services.ticket;

import com.youngman.core.business.exception.ServiceException;
import com.youngman.core.business.repositories.ticket.TicketRepository;
import com.youngman.core.model.crm.Ticket;
import org.infinispan.factories.annotations.Inject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Inject
    private TicketRepository ticketRepository;

    public TicketServiceImpl() {
    }

    @Override
    public void delete(Ticket ticket) {
        ticketRepository.delete(ticket);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getById(Long id) {
        return ticketRepository.getById(id);
    }

    @Override
    public void saveOrUpdate(Ticket ticket) throws ServiceException {
        ticketRepository.save(ticket);
    }
}
