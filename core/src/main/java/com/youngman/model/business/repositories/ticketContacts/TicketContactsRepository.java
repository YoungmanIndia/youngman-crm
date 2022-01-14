package com.youngman.model.business.repositories.ticketContacts;

import com.youngman.model.model.crm.TicketContacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TicketContactsRepository extends JpaRepository<TicketContacts, Long> {


}
