package com.ecogo.ecomove_web_service.payment.domain.model.queries;

/**
 * Query to get a transaction with an Id
 */
public record GetTransactionByIdQuery(Long transactionId) {
}
