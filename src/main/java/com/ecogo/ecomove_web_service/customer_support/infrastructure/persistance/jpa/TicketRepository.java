package com.ecogo.ecomove_web_service.customer_support.infrastructure.persistance.jpa;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates.Ticket;
import com.ecogo.ecomove_web_service.customer_support.domain.model.entity.TicketCategory;
import com.ecogo.ecomove_web_service.customer_support.domain.model.valueobjects.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Repository for tickets
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByUserId(Long userId);
    List<Ticket> findAllByCustomerSupportAgentId(Long customerSupportAgentId);
    List<Ticket> findAllByUserIdAndCategoryId(Long userId, Long categoryId);
    boolean existsByUserIdAndTitle(Long userId, String title);
}
