package com.ecogo.ecomove_web_service.customer_support.domain.model.queries;

public record GetTicketByIdQuery(Long id) {

        public GetTicketByIdQuery {
            if(id == null) {
                throw new IllegalArgumentException("id cannot be null");
            }
        }
}
