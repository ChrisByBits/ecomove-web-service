package com.ecogo.ecomove_web_service.customer_support.domain.services;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates.Ticket;
import com.ecogo.ecomove_web_service.customer_support.domain.model.commands.*;
import com.ecogo.ecomove_web_service.customer_support.domain.model.entity.TicketCategory;

import java.util.Optional;
/**
 * Service to handle ticket commands
 */
public interface TicketCommandService {
    Optional<Ticket> handle(CreateTicketCommand command);
    Optional<Ticket> handle(CloseTicketCommand command);
    Optional<Ticket> handle(CancelTicketCommand command);
    Optional<Ticket> handle(SolveTicketCommand command);
    Optional<TicketCategory> handle(CreateTicketCategoryCommand command);
}
