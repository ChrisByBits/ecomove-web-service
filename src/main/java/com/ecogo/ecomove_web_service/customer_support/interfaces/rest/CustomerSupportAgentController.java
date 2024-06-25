package com.ecogo.ecomove_web_service.customer_support.interfaces.rest;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates.CustomerSupportAgent;
import com.ecogo.ecomove_web_service.customer_support.domain.model.queries.GetAllCustomerSupportAgentQuery;
import com.ecogo.ecomove_web_service.customer_support.domain.model.queries.GetCustomerSupportAgentByIdQuery;
import com.ecogo.ecomove_web_service.customer_support.domain.services.CustomerSupportAgentCommandService;
import com.ecogo.ecomove_web_service.customer_support.domain.services.CustomerSupportAgentQueryService;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources.CreateCustomerSupportAgentResource;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources.CustomerSupportAgentResource;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.transform.CreateCustomerSupportAgentCommandFromResourceAssembler;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.transform.CustomerSupportAgentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/customer-support-agents")
@CrossOrigin(origins = "*")
@Tag(name="Customer Support Agents", description = "Customer Support Agents Management Endpoints")
public class CustomerSupportAgentController {
    CustomerSupportAgentCommandService customerSupportAgentCommandService;
    CustomerSupportAgentQueryService customerSupportAgentQueryService;

    public CustomerSupportAgentController(CustomerSupportAgentQueryService customerSupportAgentQueryService, CustomerSupportAgentCommandService customerSupportAgentCommandService){
        this.customerSupportAgentQueryService = customerSupportAgentQueryService;
        this.customerSupportAgentCommandService = customerSupportAgentCommandService;
    }

    @Operation(summary = "Create new customer support agent", description = "Create new customer support agent with the specified data")
    @PostMapping
    public ResponseEntity<CustomerSupportAgentResource> createCustomerSupportAgent(@RequestBody CreateCustomerSupportAgentResource resource){
        Optional<CustomerSupportAgent> customerSupportAgent = customerSupportAgentCommandService.handle(CreateCustomerSupportAgentCommandFromResourceAssembler.toCommandFromResource(resource));
        return customerSupportAgent.map(source -> new ResponseEntity<>(CustomerSupportAgentResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get all customer support agents", description = "Returns all the customer support agents stored in the database")
    @GetMapping
    public ResponseEntity<List<CustomerSupportAgentResource>> getAllCustomerSupportAgents(){
        var getAllCustomerSupportAgents = new GetAllCustomerSupportAgentQuery();
        var customerSupportAgents = customerSupportAgentQueryService.handle(getAllCustomerSupportAgents);
        if (customerSupportAgents.isEmpty()) return ResponseEntity.notFound().build();
        var customerSupportAgentsResources = customerSupportAgents.stream().map(CustomerSupportAgentResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(customerSupportAgentsResources);
    }

    @Operation(summary = "Get the customer support agent with the id", description = "Returns the customer support agent with the specified id")
    @GetMapping({"{customerSupportAgentId}"})
    public ResponseEntity<CustomerSupportAgentResource> getAllCustomerSupportAgentsById(@PathVariable Long customerSupportAgentId){
        Optional<CustomerSupportAgent> customerSupportAgent = customerSupportAgentQueryService.handle(new GetCustomerSupportAgentByIdQuery(customerSupportAgentId));
        return customerSupportAgent.map(source -> new ResponseEntity<>(CustomerSupportAgentResourceFromEntityAssembler.toResourceFromEntity(source),OK)).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
