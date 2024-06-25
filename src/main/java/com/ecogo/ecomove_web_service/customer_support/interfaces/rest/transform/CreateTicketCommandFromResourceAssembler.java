package com.ecogo.ecomove_web_service.customer_support.interfaces.rest.transform;

import com.ecogo.ecomove_web_service.customer_support.domain.model.commands.CreateTicketCommand;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources.CreateTicketResource;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources.TicketResource;

public class CreateTicketCommandFromResourceAssembler {
    public static CreateTicketCommand toCommandFromResource(CreateTicketResource resource) {
        return new CreateTicketCommand(resource.ticketId(), resource.title(), resource.description(), resource.category(), resource.status(), resource.assigneeID(), resource.userID());
    }
}
