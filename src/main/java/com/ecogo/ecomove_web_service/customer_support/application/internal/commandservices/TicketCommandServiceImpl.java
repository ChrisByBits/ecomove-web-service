package com.ecogo.ecomove_web_service.customer_support.application.internal.commandservices;

import com.ecogo.ecomove_web_service.customer_support.application.internal.outboundservices.acl.ExternalUserServiceToCustomerSupport;
import com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates.CustomerSupportAgent;
import com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates.Ticket;
import com.ecogo.ecomove_web_service.customer_support.domain.model.commands.*;
import com.ecogo.ecomove_web_service.customer_support.domain.model.entity.TicketCategory;
import com.ecogo.ecomove_web_service.customer_support.domain.services.TicketCommandService;
import com.ecogo.ecomove_web_service.customer_support.infrastructure.persistance.jpa.CustomerSupportAgentRepository;
import com.ecogo.ecomove_web_service.customer_support.infrastructure.persistance.jpa.TicketCategoryRepository;
import com.ecogo.ecomove_web_service.customer_support.infrastructure.persistance.jpa.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketCommandServiceImpl implements TicketCommandService {

    private final TicketRepository ticketRepository;
    private final TicketCategoryRepository ticketCategoryRepository;
    private final ExternalUserServiceToCustomerSupport externalUserService;
    private final CustomerSupportAgentRepository customerSupportAgentRepository;

    public TicketCommandServiceImpl(TicketRepository ticketRepository, TicketCategoryRepository ticketCategoryRepository, CustomerSupportAgentRepository customerSupportAgentRepository, ExternalUserServiceToCustomerSupport externalUserService){
        this.ticketRepository = ticketRepository;
        this.ticketCategoryRepository = ticketCategoryRepository;
        this.externalUserService = externalUserService;
        this.customerSupportAgentRepository = customerSupportAgentRepository;
    }

    @Override
    public Optional<Ticket> handle(CreateTicketCommand command){
        if(ticketRepository.existsByUserIdAndTitle(command.userId(), command.title())){
            throw new RuntimeException("A ticket with that title already exists for this user.");
        }
        return externalUserService.fetchUserById(command.userId()).map(user -> {
            CustomerSupportAgent customerSupportAgent = customerSupportAgentRepository.findById(command.customerSupportAgentId())
                    .orElseThrow(() -> new RuntimeException("Customer Support Agent not found"));
            TicketCategory category = ticketCategoryRepository.findById(command.categoryId())
                    .orElseThrow(() -> new RuntimeException("Ticket Category not found"));
            Ticket ticket = new Ticket(user,customerSupportAgent,category, command.title(), command.description());
            ticketRepository.save(ticket);
            return Optional.of(ticket);
        }).orElseThrow(()-> new RuntimeException("User not found"));
    }
    @Override
    public Optional<Ticket> handle(CloseTicketCommand command){
        return ticketRepository.findById(command.ticketId()).map(ticket -> {
            ticket.close();
            ticketRepository.save(ticket);
            return Optional.of(ticket);
        }).orElseThrow(()->new RuntimeException("Ticket not found"));

    }
    @Override
    public Optional<Ticket> handle(CancelTicketCommand command){
        return ticketRepository.findById(command.ticketId()).map(ticket -> {
            ticket.cancel();
            ticketRepository.save(ticket);
            return Optional.of(ticket);
        }).orElseThrow(()->new RuntimeException("Ticket not found"));
    }
    @Override
    public Optional<Ticket> handle(SolveTicketCommand command){
        return ticketRepository.findById(command.ticketId()).map(ticket -> {
            ticket.solve();
            ticketRepository.save(ticket);
            return Optional.of(ticket);
        }).orElseThrow(()->new RuntimeException("Ticket not found"));
    }

    @Override
    public Optional<TicketCategory> handle(CreateTicketCategoryCommand command){
        if (ticketCategoryRepository.existsByName(command.name())){
            throw new RuntimeException("There is already an existing category with that title");
        }
        var ticketCategory = new TicketCategory(command.name());
        ticketCategoryRepository.save(ticketCategory);
        return Optional.of(ticketCategory);
    }
}
