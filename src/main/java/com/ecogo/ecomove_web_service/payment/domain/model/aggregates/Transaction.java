package com.ecogo.ecomove_web_service.payment.domain.model.aggregates;

import com.ecogo.ecomove_web_service.payment.domain.model.commands.CreateTransactionCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Transaction extends AbstractAggregateRoot<Transaction> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long transactionId;

    @Column(nullable = false)
    @Getter
    private Long userId;

    @Column(nullable = false)
    @Getter
    private Float amount;

    @CreatedDate
    @Column(nullable = false)
    @Getter
    private LocalDateTime date;

    protected Transaction() {}

    public Transaction(CreateTransactionCommand command) {
        this.userId = command.userId();
        this.amount = command.amount();
    }

}
