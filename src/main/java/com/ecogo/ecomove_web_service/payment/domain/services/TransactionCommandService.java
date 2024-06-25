package com.ecogo.ecomove_web_service.payment.domain.services;

import com.ecogo.ecomove_web_service.payment.domain.model.aggregates.Transaction;
import com.ecogo.ecomove_web_service.payment.domain.model.commands.CreateTransactionCommand;

import java.util.Optional;

/**
 * Service to handle transaction commands
 */
public interface TransactionCommandService {
    Optional<Transaction> handle(CreateTransactionCommand command);
}
