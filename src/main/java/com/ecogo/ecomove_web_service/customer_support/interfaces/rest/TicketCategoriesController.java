package com.ecogo.ecomove_web_service.customer_support.interfaces.rest;

import com.ecogo.ecomove_web_service.customer_support.domain.model.entity.TicketCategory;
import com.ecogo.ecomove_web_service.customer_support.domain.model.queries.GetAllTicketCategoriesQuery;
import com.ecogo.ecomove_web_service.customer_support.domain.services.TicketCommandService;
import com.ecogo.ecomove_web_service.customer_support.domain.services.TicketQueryService;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources.CreateTicketCategoryResource;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources.TicketCategoryResource;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.transform.CreateTicketCategoryCommandFromResourceAssembler;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.transform.TicketCategoryResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/ticket-categories")
@CrossOrigin(origins = "*")
@Tag(name="Tickets Categories", description = "Tickets Categories Management Endpoints")
public class TicketCategoriesController {

    TicketQueryService ticketQueryService;
    TicketCommandService ticketCommandService;

    public TicketCategoriesController(TicketQueryService ticketQueryService, TicketCommandService ticketCommandService){
        this.ticketQueryService = ticketQueryService;
        this.ticketCommandService = ticketCommandService;
    }

    @Operation(summary = "Create new ticket category", description = "Create new ticket category with the specified data")
    @PostMapping
    public ResponseEntity<TicketCategoryResource> createTicketCategory(@RequestBody CreateTicketCategoryResource resource){
        Optional<TicketCategory> ticketCategory = ticketCommandService.handle(CreateTicketCategoryCommandFromResourceAssembler.toCommandFromResource(resource));
        return ticketCategory.map(source -> new ResponseEntity<>(TicketCategoryResourceFromEntityAssembler.toResourceFromEntity(source),CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Get all ticket categories", description = "Returns all the ticket categories saved in the database")
    @GetMapping
    public ResponseEntity<List<TicketCategoryResource>> getAllTicketCategories(){
        var getAllTicketCategoriesQuery = new GetAllTicketCategoriesQuery();
        var ticketCategories = ticketQueryService.handle(getAllTicketCategoriesQuery);
        if (ticketCategories.isEmpty()) return ResponseEntity.notFound().build();
        var ticketCategoriesResources = ticketCategories.stream().map(TicketCategoryResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(ticketCategoriesResources);
    }
}
