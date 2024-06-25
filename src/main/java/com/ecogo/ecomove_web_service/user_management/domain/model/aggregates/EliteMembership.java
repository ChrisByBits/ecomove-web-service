package com.ecogo.ecomove_web_service.user_management.domain.model.aggregates;

import java.time.LocalDateTime;

public class EliteMembership extends Membership {
    public EliteMembership(Long userId, Long membershipCategoryId, LocalDateTime startDate, LocalDateTime endDate) {
        super(userId, membershipCategoryId, startDate, endDate);
    }

    public Float CalculateDiscount(Float amount) {
        return amount * 0.75f;
    }

}

