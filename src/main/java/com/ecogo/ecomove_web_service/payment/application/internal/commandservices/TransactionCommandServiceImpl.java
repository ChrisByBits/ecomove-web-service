package com.ecogo.ecomove_web_service.payment.application.internal.commandservices;

import com.ecogo.ecomove_web_service.payment.domain.model.aggregates.Transaction;
import com.ecogo.ecomove_web_service.payment.domain.model.commands.CreateTransactionCommand;
import com.ecogo.ecomove_web_service.payment.domain.services.TransactionCommandService;
import com.ecogo.ecomove_web_service.payment.infrastructure.persistance.jpa.TransactionRepository;
import com.ecogo.ecomove_web_service.shared.application.internal.outboundservices.acl.ExternalUserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionCommandServiceImpl implements TransactionCommandService {

    private final TransactionRepository transactionRepository;
    private final ExternalUserService externalUserService;

    public TransactionCommandServiceImpl(TransactionRepository transactionRepository, ExternalUserService externalUserService){
        this.transactionRepository = transactionRepository;
        this.externalUserService = externalUserService;
    }

    public Optional<Transaction> handle(CreateTransactionCommand command){
        return externalUserService.fetchUserById(command.userId()).map(user -> {
            var transaction = new Transaction(user, command.amount(), command.date());
            transactionRepository.save(transaction);
            return Optional.of(transaction);
        }).orElseThrow(()->new RuntimeException("User not found for specified id: " + command.userId()));
    }
}
