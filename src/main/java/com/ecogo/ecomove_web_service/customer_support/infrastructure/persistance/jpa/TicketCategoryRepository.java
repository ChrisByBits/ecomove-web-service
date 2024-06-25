package com.ecogo.ecomove_web_service.customer_support.infrastructure.persistance.jpa;

import com.ecogo.ecomove_web_service.customer_support.domain.model.entity.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketCategoryRepository extends JpaRepository<TicketCategory, Long> {
    boolean existsByName(String name);
}
