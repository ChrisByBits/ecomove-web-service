package com.ecogo.ecomove_web_service.payment.domain.model.queries;

public record GetTransactionByTransactionIdQuery(Long transactionId) {
    public GetTransactionByTransactionIdQuery {
        if(transactionId == null) {
            throw new IllegalArgumentException("transactionId cannot be null");
        }
    }
}
