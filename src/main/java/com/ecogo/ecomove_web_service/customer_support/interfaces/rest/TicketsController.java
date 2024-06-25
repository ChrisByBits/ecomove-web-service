package com.ecogo.ecomove_web_service.customer_support.interfaces.rest;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates.Ticket;
import com.ecogo.ecomove_web_service.customer_support.domain.model.commands.CancelTicketCommand;
import com.ecogo.ecomove_web_service.customer_support.domain.model.commands.CloseTicketCommand;
import com.ecogo.ecomove_web_service.customer_support.domain.model.commands.SolveTicketCommand;
import com.ecogo.ecomove_web_service.customer_support.domain.model.queries.*;
import com.ecogo.ecomove_web_service.customer_support.domain.services.TicketCommandService;
import com.ecogo.ecomove_web_service.customer_support.domain.services.TicketQueryService;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources.CreateTicketResource;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources.TicketResource;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.transform.CreateTicketCommandFromResourceAssembler;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.transform.TicketResourceFromEntityAssembler;
import com.ecogo.ecomove_web_service.shared.interfaces.rest.resources.MessageResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/tickets")
@Tag(name="Tickets", description = "Tickets Management Endpoints")
public class TicketsController {

    private final TicketCommandService ticketCommandService;
    private final TicketQueryService ticketQueryService;

    public TicketsController(TicketCommandService ticketCommandService, TicketQueryService ticketQueryService){
        this.ticketCommandService = ticketCommandService;
        this.ticketQueryService = ticketQueryService;
    }

    @Operation(summary = "Create a new ticket", description = "Creates a new ticket with the specified attributes")
    @PostMapping
    public ResponseEntity<TicketResource> createTicketCategory(@RequestBody CreateTicketResource resource){
        Optional<Ticket> ticket = ticketCommandService.handle(CreateTicketCommandFromResourceAssembler.toCommandFromResource(resource));
        return ticket.map(source -> new ResponseEntity<>(TicketResourceFromEntityAssembler.toResourceFromEntity(source),CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Get all tickets", description = "Returns all the tickets in the database")
    @GetMapping
    public ResponseEntity<List<TicketResource>> getAllTickets(){
        var getAllTicketsQuery = new GetAllTicketsQuery();
        var tickets = ticketQueryService.handle(getAllTicketsQuery);
        if (tickets.isEmpty()) return ResponseEntity.notFound().build();
        var ticketsResources = tickets.stream().map(TicketResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(ticketsResources);
    }

    @Operation(summary = "Get ticket by id", description = "Returns the ticket with the specified id")
    @GetMapping("{ticketId}")
    public ResponseEntity<TicketResource> getTicketById(@PathVariable Long ticketId){
        Optional<Ticket> ticket = ticketQueryService.handle(new GetTicketByIdQuery(ticketId));
        return ticket.map(source -> new ResponseEntity<>(TicketResourceFromEntityAssembler.toResourceFromEntity(source), OK)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get tickets by userId", description = "Returns all the tickets made by the user with the specified id")
    @GetMapping("user/{userId}")
    public ResponseEntity<List<TicketResource>> getAllTicketsByUserId(@PathVariable Long userId){
        var getAllTicketsByUserIdQuery = new GetAllTicketsByUserIdQuery(userId);
        var tickets = ticketQueryService.handle(getAllTicketsByUserIdQuery);
        if (tickets.isEmpty()) return ResponseEntity.notFound().build();
        var ticketsResources = tickets.stream().map(TicketResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(ticketsResources);
    }

    @Operation(summary = "Get tickets by userId and categoryId", description = "Returns all the tickets made by the user with the specified id and from the category with the specified id")
    @GetMapping("user/{userId}/category/{categoryId}")
    public ResponseEntity<List<TicketResource>> getAllTicketsByUserId(@PathVariable Long userId, @PathVariable Long categoryId){
        var getAllTicketsByUserIdAndCategoryId = new GetAllTicketsByUserIdAndCategoryId(userId, categoryId);
        var tickets = ticketQueryService.handle(getAllTicketsByUserIdAndCategoryId);
        if (tickets.isEmpty()) return ResponseEntity.notFound().build();
        var ticketsResources = tickets.stream().map(TicketResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(ticketsResources);
    }

    @Operation(summary = "Get tickets by customerSupportAgentId", description = "Returns all the tickets assigned to the customer support agent with the specified id")
    @GetMapping("customer-support-agent/{customerSupportAgentId}")
    public ResponseEntity<List<TicketResource>> getAllTicketsByCustomerSupportAgentId(@PathVariable Long customerSupportAgentId){
        var getAllTicketsByCustomerSupportAgentIdQuery = new GetAllTicketsByCustomerSupportAgentIdQuery(customerSupportAgentId);
        var tickets = ticketQueryService.handle(getAllTicketsByCustomerSupportAgentIdQuery);
        if (tickets.isEmpty()) return ResponseEntity.notFound().build();
        var ticketsResources = tickets.stream().map(TicketResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(ticketsResources);
    }

    @Operation(summary = "Marks the ticket as cancelled", description = "Changes the status of the ticket with the specified id to Cancelled")
    @PostMapping("/{ticketId}/cancellations")
    public ResponseEntity<MessageResource> cancelTicket(@PathVariable Long ticketId){
        var cancelTicketCommand = new CancelTicketCommand(ticketId);
        ticketCommandService.handle(cancelTicketCommand);
        return ResponseEntity.ok(new MessageResource("Cancelled ticketId: " + ticketId));
    }

    @Operation(summary = "Marks the ticket as solved", description = "Changes the status of the ticket with the specified id to Solved")
    @PostMapping("/{ticketId}/solutions")
    public ResponseEntity<MessageResource> solveTicket(@PathVariable Long ticketId){
        var solveTicketCommand = new SolveTicketCommand(ticketId);
        ticketCommandService.handle(solveTicketCommand);
        return ResponseEntity.ok(new MessageResource("Solved ticketId: " + ticketId));
    }

    @Operation(summary = "Marks the ticket as closed", description = "Changes the status of the ticket with the specified id to Closed")
    @PostMapping("/{ticketId}/closures")
    public ResponseEntity<MessageResource> closeTicket(@PathVariable Long ticketId){
        var closeTicketCommand = new CloseTicketCommand(ticketId);
        ticketCommandService.handle(closeTicketCommand);
        return ResponseEntity.ok(new MessageResource("Close ticketId: " + ticketId));
    }
}
