package com.ecogo.ecomove_web_service.customer_support.interfaces.rest.transform;

import com.ecogo.ecomove_web_service.customer_support.domain.model.commands.CreateTicketCategoryCommand;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources.CreateTicketCategoryResource;

public class CreateTicketCategoryCommandFromResourceAssembler {
    public static CreateTicketCategoryCommand toCommandFromResource(CreateTicketCategoryResource resource){
        return new CreateTicketCategoryCommand(resource.name());
    }
}
