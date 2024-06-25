package com.ecogo.ecomove_web_service.payment.domain.model.queries;

public record GetAllTransactionsByUserIdQuery(Long userId) {
    public GetAllTransactionsByUserIdQuery {
        if (userId == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }
    }
}
