package com.ecogo.ecomove_web_service.payment.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateTransactionResource(
        @NotNull
        Long userId,
        @NotNull
        Float amount,
        @NotNull
        LocalDateTime date
) {
}
