package com.youngman.crm.controllers.tickets;

public class TicketNotFoundException extends RuntimeException {
    TicketNotFoundException(Long id) {
        super("Could not find ticket " + id);
    }
}
