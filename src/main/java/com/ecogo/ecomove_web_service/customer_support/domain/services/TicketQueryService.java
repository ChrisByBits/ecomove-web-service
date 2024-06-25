package com.ecogo.ecomove_web_service.customer_support.domain.services;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggrgates.Ticket;
import com.ecogo.ecomove_web_service.customer_support.domain.model.queries.GetTicketByIdQuery;
import com.ecogo.ecomove_web_service.user_management.domain.model.aggregates.User;
import com.ecogo.ecomove_web_service.user_management.domain.model.queries.GetUserByUsernameQuery;

import java.util.Optional;

public interface TicketQueryService {
    Optional<Ticket> handle(GetTicketByIdQuery query);

    Optional<User> handle(GetUserByUsernameQuery query);
}
