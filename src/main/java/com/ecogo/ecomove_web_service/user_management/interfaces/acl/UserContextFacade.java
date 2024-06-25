package com.ecogo.ecomove_web_service.user_management.interfaces.acl;

import com.ecogo.ecomove_web_service.user_management.domain.model.aggregates.User;
import com.ecogo.ecomove_web_service.user_management.domain.model.queries.GetUserByIdQuery;
import com.ecogo.ecomove_web_service.user_management.domain.services.UserCommandService;
import com.ecogo.ecomove_web_service.user_management.domain.services.UserQueryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserContextFacade {
    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    public UserContextFacade(UserCommandService userCommandService, UserQueryService userQueryService){
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    public Optional<User> fetchUserById(Long userId){
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        return userQueryService.handle(getUserByIdQuery);
    }

}
