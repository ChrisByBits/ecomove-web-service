package com.ecogo.ecomove_web_service.customer_support.domain.services;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates.Ticket;
import com.ecogo.ecomove_web_service.customer_support.domain.model.entity.TicketCategory;
import com.ecogo.ecomove_web_service.customer_support.domain.model.queries.*;

import java.util.List;
import java.util.Optional;
/**
 * Service to handle ticket queries
 */
public interface TicketQueryService {

    List<Ticket> handle(GetAllTicketsQuery query);

    List<Ticket> handle(GetAllTicketsByCustomerSupportAgentIdQuery query);

    List<Ticket> handle(GetAllTicketsByUserIdQuery query);

    List<Ticket> handle(GetAllTicketsByUserIdAndCategoryId query);

    Optional<Ticket> handle(GetTicketByIdQuery query);

    List<TicketCategory> handle(GetAllTicketCategoriesQuery query);
}
