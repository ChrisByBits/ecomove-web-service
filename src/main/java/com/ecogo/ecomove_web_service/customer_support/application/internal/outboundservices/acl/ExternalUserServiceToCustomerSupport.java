package com.ecogo.ecomove_web_service.customer_support.application.internal.outboundservices.acl;

import com.ecogo.ecomove_web_service.user_management.domain.model.aggregates.User;
import com.ecogo.ecomove_web_service.user_management.interfaces.acl.UserContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalUserServiceToCustomerSupport {
    private final UserContextFacade userContextFacade;

    public ExternalUserServiceToCustomerSupport(UserContextFacade userContextFacade){
        this.userContextFacade = userContextFacade;
    }

    public Optional<User> fetchUserById(Long userId){
        return userContextFacade.fetchUserById(userId);
    }
}
