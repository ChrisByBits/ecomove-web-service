package com.ecogo.ecomove_web_service.customer_support.infrastructure.persistance.jpa;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates.CustomerSupportAgent;
import com.ecogo.ecomove_web_service.customer_support.domain.model.valueobjects.PersonName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerSupportAgentRepository extends JpaRepository<CustomerSupportAgent, Long> {
    boolean existsByName(PersonName name);
}
