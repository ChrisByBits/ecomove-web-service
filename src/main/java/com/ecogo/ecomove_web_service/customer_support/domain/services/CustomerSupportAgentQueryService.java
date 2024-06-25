package com.ecogo.ecomove_web_service.customer_support.domain.services;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates.CustomerSupportAgent;
import com.ecogo.ecomove_web_service.customer_support.domain.model.queries.GetAllCustomerSupportAgentQuery;
import com.ecogo.ecomove_web_service.customer_support.domain.model.queries.GetCustomerSupportAgentByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CustomerSupportAgentQueryService {
    List<CustomerSupportAgent> handle(GetAllCustomerSupportAgentQuery query);

    Optional<CustomerSupportAgent> handle(GetCustomerSupportAgentByIdQuery query);
}
