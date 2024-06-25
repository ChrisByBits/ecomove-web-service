package com.ecogo.ecomove_web_service.payment.domain.model.queries;

import java.time.LocalDateTime;

public record GetAllTransactionsByDateQuery(LocalDateTime date) {
    public GetAllTransactionsByDateQuery {
        if(date == null){
            throw new IllegalArgumentException("date cannot be null");
        }
    }
}
