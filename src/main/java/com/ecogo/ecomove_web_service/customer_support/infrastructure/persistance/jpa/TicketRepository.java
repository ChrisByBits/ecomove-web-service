package com.ecogo.ecomove_web_service.customer_support.infrastructure.persistance.jpa;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggrgates.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    boolean existsByTicketId(String ticketId);
    Optional<Ticket> findByTicketId(String ticketId);

}
