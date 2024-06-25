package com.ecogo.ecomove_web_service.customer_support.interfaces.rest;


import com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates.Ticket;
import com.ecogo.ecomove_web_service.customer_support.domain.model.queries.GetTicketByIdQuery;
import com.ecogo.ecomove_web_service.customer_support.domain.services.TicketCommandService;
import com.ecogo.ecomove_web_service.customer_support.domain.services.TicketQueryService;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources.CreateTicketResource;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources.TicketResource;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.transform.CreateTicketCommandFromResourceAssembler;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.transform.TicketResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

    private final TicketCommandService ticketCommandService;

    private final TicketQueryService ticketQueryService;

    public TicketController(TicketCommandService ticketCommandService, TicketQueryService ticketQueryService) {
        this.ticketCommandService = ticketCommandService;
        this.ticketQueryService = ticketQueryService;
    }

    @PostMapping
    public ResponseEntity<TicketResource> createTicket(@RequestBody CreateTicketResource resource) {
        Optional<Ticket> ticket = ticketCommandService.handle(CreateTicketCommandFromResourceAssembler.toCommandFromResource(resource));
        return ticket.map(source -> new ResponseEntity<>(TicketResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @GetMapping("{id}")
    public ResponseEntity<TicketResource> getTicketById(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketQueryService.handle(new GetTicketByIdQuery(id));
        return ticket.map(source -> ResponseEntity.ok(TicketResourceFromEntityAssembler.toResourceFromEntity(source))).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
