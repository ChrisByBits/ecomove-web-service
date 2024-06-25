package com.ecogo.ecomove_web_service.customer_support.interfaces.rest.transform;

import com.ecogo.ecomove_web_service.customer_support.domain.model.entity.TicketCategory;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources.TicketCategoryResource;

public class TicketCategoryResourceFromEntityAssembler {
    public static TicketCategoryResource toResourceFromEntity(TicketCategory entity){
        return new TicketCategoryResource(
                entity.getId(),
                entity.getName()
        );
    }
}
