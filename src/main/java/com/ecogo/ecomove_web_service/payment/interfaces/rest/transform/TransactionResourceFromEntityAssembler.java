package com.ecogo.ecomove_web_service.payment.interfaces.rest.transform;

import com.ecogo.ecomove_web_service.payment.domain.model.aggregates.Transaction;
import com.ecogo.ecomove_web_service.payment.interfaces.rest.resources.TransactionResource;

public class TransactionResourceFromEntityAssembler {
    public static TransactionResource fromEntity(Transaction transaction) {
        return new TransactionResource(transaction.getTransactionId(), transaction.getUserId(), transaction.getAmount());
    }
}
