package com.ecogo.ecomove_web_service.payment.interfaces.rest.resources;

import java.time.LocalDateTime;

public record TransactionResource(Long transactionId, Long userId, Float amount, LocalDateTime date) {

}
