package com.ecogo.ecomove_web_service.payment.domain.model.commands;

public record CreateTransactionCommand(Long userId, Float amount) {
    public CreateTransactionCommand {
        if (userId == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }
        if (amount == null) {
            throw new IllegalArgumentException("amount cannot be null");
        }
    }
}
