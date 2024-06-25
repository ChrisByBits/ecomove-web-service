package com.ecogo.ecomove_web_service.customer_support.application.internal.queryservices;


import com.ecogo.ecomove_web_service.customer_support.domain.model.aggrgates.Ticket;
import com.ecogo.ecomove_web_service.customer_support.domain.model.queries.GetTicketByIdQuery;
import com.ecogo.ecomove_web_service.customer_support.domain.services.TicketQueryService;
import com.ecogo.ecomove_web_service.customer_support.infrastructure.persistance.jpa.TicketRepository;
import com.ecogo.ecomove_web_service.user_management.domain.model.aggregates.User;
import com.ecogo.ecomove_web_service.user_management.domain.model.queries.GetUserByUsernameQuery;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketQueryServiceImpl implements TicketQueryService {

    private final TicketRepository ticketRepository;

    public TicketQueryServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Optional<Ticket> handle(GetTicketByIdQuery query) {
        return ticketRepository.findByTicketId(String.valueOf(query.id()));
    }

    @Override
    public Optional<User> handle(GetUserByUsernameQuery query) {
        return Optional.empty();
    }

}
