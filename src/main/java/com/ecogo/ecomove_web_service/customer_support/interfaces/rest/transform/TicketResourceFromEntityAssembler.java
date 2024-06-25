package com.ecogo.ecomove_web_service.customer_support.interfaces.rest.transform;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates.Ticket;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources.TicketResource;

public class TicketResourceFromEntityAssembler {
    public static TicketResource toResourceFromEntity(Ticket entity){
        return new TicketResource(
                entity.getId(),
                entity.getUser().getId(),
                entity.getCustomerSupportAgent().getId(),
                entity.getCategory().getId(),
                entity.getTitle(),
                entity.getDescription());
    }
}
