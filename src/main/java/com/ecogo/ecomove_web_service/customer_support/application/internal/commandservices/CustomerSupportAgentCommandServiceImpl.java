package com.ecogo.ecomove_web_service.customer_support.application.internal.commandservices;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates.CustomerSupportAgent;
import com.ecogo.ecomove_web_service.customer_support.domain.model.commands.CreateCustomerSupportAgentCommand;
import com.ecogo.ecomove_web_service.customer_support.domain.model.valueobjects.PersonName;
import com.ecogo.ecomove_web_service.customer_support.domain.services.CustomerSupportAgentCommandService;
import com.ecogo.ecomove_web_service.customer_support.infrastructure.persistance.jpa.CustomerSupportAgentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerSupportAgentCommandServiceImpl implements CustomerSupportAgentCommandService {

    private final CustomerSupportAgentRepository customerSupportAgentRepository;

    public CustomerSupportAgentCommandServiceImpl(CustomerSupportAgentRepository customerSupportAgentRepository){this.customerSupportAgentRepository = customerSupportAgentRepository;}

    @Override
    public Optional<CustomerSupportAgent> handle(CreateCustomerSupportAgentCommand command){
        if(customerSupportAgentRepository.existsByName(new PersonName(command.firstName(), command.lastName()))){
            throw new RuntimeException("There is already a customer support agent with that name");
        }
        CustomerSupportAgent customerSupportAgent = new CustomerSupportAgent(command.email(), command.firstName(), command.lastName());
        return Optional.of(customerSupportAgent);
    }

}
