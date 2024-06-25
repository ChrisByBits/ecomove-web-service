package com.ecogo.ecomove_web_service.payment.domain.model.aggregates;

import com.ecogo.ecomove_web_service.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.ecogo.ecomove_web_service.user_management.domain.model.aggregates.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class Transaction extends AuditableAbstractAggregateRoot<Transaction> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(nullable = false)
    private Float amount;

    @Column(nullable = false, updatable = false)
    private LocalDateTime date;

    public Transaction(){

    }
    public Transaction(User user, Float amount, LocalDateTime date){
        this.user = user;
        this.amount = amount;
        this.date = date;
    }
}
