package com.ecogo.ecomove_web_service.customer_support.application.internal.queryservices;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates.Ticket;
import com.ecogo.ecomove_web_service.customer_support.domain.model.entity.TicketCategory;
import com.ecogo.ecomove_web_service.customer_support.domain.model.queries.*;
import com.ecogo.ecomove_web_service.customer_support.domain.services.TicketQueryService;
import com.ecogo.ecomove_web_service.customer_support.infrastructure.persistance.jpa.TicketCategoryRepository;
import com.ecogo.ecomove_web_service.customer_support.infrastructure.persistance.jpa.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketQueryServiceImpl implements TicketQueryService {
    private final TicketRepository ticketRepository;
    private final TicketCategoryRepository ticketCategoryRepository;

    public TicketQueryServiceImpl(TicketRepository ticketRepository, TicketCategoryRepository ticketCategoryRepository){
        this.ticketRepository = ticketRepository;
        this.ticketCategoryRepository = ticketCategoryRepository;
    }

    @Override
    public List<Ticket> handle(GetAllTicketsQuery query){
        return ticketRepository.findAll();
    }
    @Override
    public List<Ticket> handle(GetAllTicketsByCustomerSupportAgentIdQuery query){
        return ticketRepository.findAllByCustomerSupportAgentId(query.customerSupportAgentId());
    }
    @Override
    public List<Ticket> handle(GetAllTicketsByUserIdQuery query){
        return ticketRepository.findAllByUserId(query.userId());
    }
    @Override
    public List<Ticket> handle(GetAllTicketsByUserIdAndCategoryId query){
        return ticketRepository.findAllByUserIdAndCategoryId(query.userId(),query.userId());
    }
    @Override
    public Optional<Ticket> handle(GetTicketByIdQuery query){
        return ticketRepository.findById(query.id());
    }
    @Override
    public List<TicketCategory> handle(GetAllTicketCategoriesQuery query){
        return ticketCategoryRepository.findAll();
    }
}
