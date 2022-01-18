package com.youngman.crm.controllers;

public class TicketNotFoundException extends RuntimeException {
    TicketNotFoundException(Long id) {
        super("Could not find ticket " + id);
    }
}
