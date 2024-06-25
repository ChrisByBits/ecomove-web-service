package com.ecogo.ecomove_web_service.customer_support.application.internal.commandservices;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggrgates.Ticket;
import com.ecogo.ecomove_web_service.customer_support.domain.model.commands.CreateTicketCommand;
import com.ecogo.ecomove_web_service.customer_support.domain.services.TicketCommandService;
import com.ecogo.ecomove_web_service.customer_support.infrastructure.persistance.jpa.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketCommandServiceImpl implements TicketCommandService {

    private final TicketRepository ticketRepository;

    public TicketCommandServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    /**
     * Handle the command to create a ticket.
     * @param command The command to create a ticket.
     * @return The created ticket.
     */

    @Override
    public Optional<Ticket> handle(CreateTicketCommand command) {
        if(ticketRepository.existsByTicketId(command.ticketId())) {
            throw new IllegalArgumentException("Ticket already exists.");
        }

        Ticket ticket = new Ticket(command);
        return Optional.of(ticketRepository.save(ticket));
    }
}
