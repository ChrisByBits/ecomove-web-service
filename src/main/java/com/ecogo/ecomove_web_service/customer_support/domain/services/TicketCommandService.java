package com.ecogo.ecomove_web_service.customer_support.domain.services;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggrgates.Ticket;
import com.ecogo.ecomove_web_service.customer_support.domain.model.commands.CreateTicketCommand;

import java.util.Optional;

public interface TicketCommandService {
    Optional<Ticket> handle(CreateTicketCommand command);
}
