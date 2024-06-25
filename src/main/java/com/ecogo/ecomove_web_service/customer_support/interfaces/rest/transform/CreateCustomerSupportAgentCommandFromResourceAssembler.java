package com.ecogo.ecomove_web_service.customer_support.interfaces.rest.transform;

import com.ecogo.ecomove_web_service.customer_support.domain.model.commands.CreateCustomerSupportAgentCommand;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources.CreateCustomerSupportAgentResource;

public class CreateCustomerSupportAgentCommandFromResourceAssembler {
    public static CreateCustomerSupportAgentCommand toCommandFromResource(CreateCustomerSupportAgentResource resource){
        return new CreateCustomerSupportAgentCommand(resource.emailAddress(), resource.firstName(), resource.lastName());
    }
}
