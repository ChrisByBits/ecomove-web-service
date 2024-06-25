package com.ecogo.ecomove_web_service.user_management.application.internal.queryservices;

import com.ecogo.ecomove_web_service.user_management.domain.model.aggregates.User;
import com.ecogo.ecomove_web_service.user_management.domain.model.queries.GetUserByUsernameQuery;
import com.ecogo.ecomove_web_service.user_management.domain.services.UserQueryService;
import com.ecogo.ecomove_web_service.user_management.infrastructure.persistance.jpa.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(GetUserByUsernameQuery query) {
        return userRepository.findByUsername(query.username());
    }

}
