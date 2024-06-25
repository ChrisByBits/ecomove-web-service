package com.ecogo.ecomove_web_service.customer_support.domain.services;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates.CustomerSupportAgent;
import com.ecogo.ecomove_web_service.customer_support.domain.model.commands.CreateCustomerSupportAgentCommand;

import java.util.Optional;

public interface CustomerSupportAgentCommandService {
    Optional<CustomerSupportAgent> handle(CreateCustomerSupportAgentCommand command);
}
