package com.ecogo.ecomove_web_service.customer_support.interfaces.rest.transform;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates.CustomerSupportAgent;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources.CustomerSupportAgentResource;

public class CustomerSupportAgentResourceFromEntityAssembler {
    public static CustomerSupportAgentResource toResourceFromEntity(CustomerSupportAgent entity){
        return new CustomerSupportAgentResource(
                entity.getId(),
                entity.getName().firstName(),
                entity.getName().lastName(),
                entity.getEmail().address()
        );
    }
}
