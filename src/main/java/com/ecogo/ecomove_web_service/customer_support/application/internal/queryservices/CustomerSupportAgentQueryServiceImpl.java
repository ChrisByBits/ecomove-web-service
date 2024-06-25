package com.ecogo.ecomove_web_service.customer_support.application.internal.queryservices;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates.CustomerSupportAgent;
import com.ecogo.ecomove_web_service.customer_support.domain.model.queries.GetAllCustomerSupportAgentQuery;
import com.ecogo.ecomove_web_service.customer_support.domain.model.queries.GetCustomerSupportAgentByIdQuery;
import com.ecogo.ecomove_web_service.customer_support.domain.services.CustomerSupportAgentQueryService;
import com.ecogo.ecomove_web_service.customer_support.infrastructure.persistance.jpa.CustomerSupportAgentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerSupportAgentQueryServiceImpl implements CustomerSupportAgentQueryService {

    private final CustomerSupportAgentRepository customerSupportAgentRepository;

    public CustomerSupportAgentQueryServiceImpl(CustomerSupportAgentRepository customerSupportAgentRepository) {
        this.customerSupportAgentRepository = customerSupportAgentRepository;
    }

    @Override
    public List<CustomerSupportAgent> handle(GetAllCustomerSupportAgentQuery query) {
        return customerSupportAgentRepository.findAll();
    }

    @Override
    public Optional<CustomerSupportAgent> handle(GetCustomerSupportAgentByIdQuery query) {
        return customerSupportAgentRepository.findById(query.id());
    }

}