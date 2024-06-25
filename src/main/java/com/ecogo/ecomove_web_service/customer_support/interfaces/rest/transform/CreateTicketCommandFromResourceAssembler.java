package com.ecogo.ecomove_web_service.customer_support.interfaces.rest.transform;

import com.ecogo.ecomove_web_service.customer_support.domain.model.commands.CreateTicketCommand;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources.CreateTicketResource;

public class CreateTicketCommandFromResourceAssembler {
    public static CreateTicketCommand toCommandFromResource(CreateTicketResource resource){
        return new CreateTicketCommand(resource.userId(),resource.customerSupportAgentId(),resource.categoryId(), resource.title(), resource.description());
    }
}
