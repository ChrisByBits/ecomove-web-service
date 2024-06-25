package com.ecogo.ecomove_web_service.payment.domain.services;

import com.ecogo.ecomove_web_service.payment.domain.model.aggregates.Transaction;
import com.ecogo.ecomove_web_service.payment.domain.model.queries.GetAllTransactionsByDateQuery;
import com.ecogo.ecomove_web_service.payment.domain.model.queries.GetAllTransactionsByUserIdQuery;
import com.ecogo.ecomove_web_service.payment.domain.model.queries.GetAllTransactionsQuery;
import com.ecogo.ecomove_web_service.payment.domain.model.queries.GetTransactionByIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * Service to handle transaction queries
 */

public interface TransactionQueryService {
    List<Transaction> handle(GetAllTransactionsQuery query);
    List<Transaction> handle(GetAllTransactionsByUserIdQuery query);
    List<Transaction> handle(GetAllTransactionsByDateQuery query);

    Optional<Transaction> handle(GetTransactionByIdQuery query);
}
