package com.youngman.crm.controllers.tickets;

import com.youngman.model.business.services.ticket.TicketService;
import com.youngman.model.model.crm.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@RestController
public class TicketController {

    @Inject
    private TicketService ticketService;

    private Logger logger = LoggerFactory.getLogger(TicketController.class);

    @GetMapping("/tickets")
    @ResponseBody
    public List<Ticket> all()
    {
        return ticketService.findAll();
    }

    @PostConstruct
    public void log() {
        logger.info("TicketController initialized");
    }

}
