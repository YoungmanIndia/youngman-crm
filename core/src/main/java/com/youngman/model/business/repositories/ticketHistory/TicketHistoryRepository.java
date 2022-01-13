package com.youngman.model.business.repositories.ticketHistory;

import com.youngman.model.model.crm.TicketHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketHistoryRepository extends JpaRepository<TicketHistory, Long> {



}
