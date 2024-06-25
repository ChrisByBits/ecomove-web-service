package com.ecogo.ecomove_web_service.payment.interfaces.rest.resources;

public record CreateTransactionResource(Long userId, Float amount) {
    public CreateTransactionResource {
        if (userId == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }
        if (amount == null) {
            throw new IllegalArgumentException("amount cannot be null");
        }
    }
}
