package com.youngman.model.business.services.ticket;

import com.youngman.model.business.exception.ServiceException;
import com.youngman.model.business.repositories.ticket.TicketRepository;
import com.youngman.model.model.crm.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    private Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);

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

    @PostConstruct
    public void log() {
        logger.info("TicketServiceImpl initialized");
    }
}
