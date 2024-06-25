package com.ecogo.ecomove_web_service.customer_support.interfaces.rest.transform;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggrgates.Ticket;
import com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources.TicketResource;

public class TicketResourceFromEntityAssembler {
    public static TicketResource toResourceFromEntity(Ticket entity) {
        return new TicketResource(entity.getId(), entity.getTicketId(), entity.getTitle(), entity.getDescription(), entity.getCategory(), entity.getStatus(), entity.getAssigneeID(), entity.getUserID());
    }
}
