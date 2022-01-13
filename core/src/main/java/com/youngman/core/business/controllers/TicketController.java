package com.youngman.core.business.controllers;

import com.youngman.core.business.services.ticket.TicketService;
import com.youngman.core.model.crm.Ticket;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
public class TicketController {

    @Inject
    private TicketService ticketService;

    @GetMapping("/tickets")
    @ResponseBody
    public List<Ticket> all()
    {
        return ticketService.findAll();
    }

}
