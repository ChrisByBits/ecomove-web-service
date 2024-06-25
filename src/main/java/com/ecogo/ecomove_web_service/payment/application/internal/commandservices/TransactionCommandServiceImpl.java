package com.ecogo.ecomove_web_service.payment.application.internal.commandservices;

import com.ecogo.ecomove_web_service.payment.domain.model.aggregates.Transaction;
import com.ecogo.ecomove_web_service.payment.domain.model.commands.CreateTransactionCommand;
import com.ecogo.ecomove_web_service.payment.domain.services.TransactionCommandService;
import com.ecogo.ecomove_web_service.payment.infrastructure.persistance.jpa.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionCommandServiceImpl implements TransactionCommandService {

    private final TransactionRepository transactionRepository;

    public TransactionCommandServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Optional<Transaction> handle(CreateTransactionCommand command) {
        Transaction transaction = new Transaction(command);
        return Optional.of(transactionRepository.save(transaction));
    }

}
