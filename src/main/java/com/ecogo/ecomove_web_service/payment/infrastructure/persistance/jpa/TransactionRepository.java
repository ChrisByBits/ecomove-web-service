package com.ecogo.ecomove_web_service.payment.infrastructure.persistance.jpa;

import com.ecogo.ecomove_web_service.payment.domain.model.aggregates.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByUserId(Long userId);
    List<Transaction> findAllByDate(LocalDateTime date);
}
