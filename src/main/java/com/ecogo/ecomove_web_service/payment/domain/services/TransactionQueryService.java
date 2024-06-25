package com.ecogo.ecomove_web_service.payment.domain.services;

import com.ecogo.ecomove_web_service.payment.domain.model.aggregates.Transaction;
import com.ecogo.ecomove_web_service.payment.domain.model.queries.GetAllTransactionsByDateQuery;
import com.ecogo.ecomove_web_service.payment.domain.model.queries.GetAllTransactionsByUserIdQuery;
import com.ecogo.ecomove_web_service.payment.domain.model.queries.GetTransactionByTransactionIdQuery;

import java.util.List;
import java.util.Optional;

public interface TransactionQueryService {
    Optional<Transaction> handle(GetTransactionByTransactionIdQuery query);
    List<Transaction> handle(GetAllTransactionsByUserIdQuery query);
    List<Transaction> handle(GetAllTransactionsByDateQuery query);
}
