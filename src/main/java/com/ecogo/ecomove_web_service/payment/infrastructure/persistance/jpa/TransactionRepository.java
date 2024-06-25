package com.ecogo.ecomove_web_service.payment.infrastructure.persistance.jpa;

import com.ecogo.ecomove_web_service.payment.domain.model.aggregates.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<Transaction> findByTransactionId(Long transactionId);
    List<Transaction> findAllByUserId(Long userId);
    List<Transaction> findAllByDate(LocalDateTime date);
}
