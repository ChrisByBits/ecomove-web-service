package com.ecogo.ecomove_web_service.payment.application.internal.queryservices;

import com.ecogo.ecomove_web_service.payment.domain.model.aggregates.Transaction;
import com.ecogo.ecomove_web_service.payment.domain.model.queries.GetAllTransactionsByDateQuery;
import com.ecogo.ecomove_web_service.payment.domain.model.queries.GetAllTransactionsByUserIdQuery;
import com.ecogo.ecomove_web_service.payment.domain.model.queries.GetTransactionByTransactionIdQuery;
import com.ecogo.ecomove_web_service.payment.domain.services.TransactionQueryService;
import com.ecogo.ecomove_web_service.payment.infrastructure.persistance.jpa.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionQueryServiceImpl implements TransactionQueryService {
    private final TransactionRepository transactionRepository;

    public TransactionQueryServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Optional<Transaction> handle(GetTransactionByTransactionIdQuery query) {
        return transactionRepository.findById(query.transactionId());
    }

    @Override
    public List<Transaction> handle(GetAllTransactionsByUserIdQuery query) {
        return transactionRepository.findAllByUserId(query.userId());
    }

    @Override
    public List<Transaction> handle(GetAllTransactionsByDateQuery query) {
        return transactionRepository.findAllByDate(query.date());
    }
}
