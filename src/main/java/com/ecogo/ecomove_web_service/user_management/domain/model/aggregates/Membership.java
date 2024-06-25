package com.ecogo.ecomove_web_service.user_management.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class Membership extends AbstractAggregateRoot<Membership> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long membershipId;

    @Column(nullable = false)
    @Getter
    private Long userId;

    @Column(nullable = false)
    @Getter
    private Long categoryId;

    @Column(nullable = false)
    @Getter
    private LocalDateTime startDate;

    @Column(nullable = false)
    @Getter
    private LocalDateTime endDate;

    protected Membership() {}

    public Membership(Long userId, Long categoryId, LocalDateTime startDate, LocalDateTime endDate) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    protected Float CalculateDiscount(Float amount) {
        return amount * 0.1f;
    }
}
