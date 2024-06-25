package com.ecogo.ecomove_web_service.user_management.application.internal.commandservices;

import com.ecogo.ecomove_web_service.user_management.domain.model.aggregates.User;
import com.ecogo.ecomove_web_service.user_management.domain.model.commands.CreateUserCommand;
import com.ecogo.ecomove_web_service.user_management.domain.services.UserCommandService;
import com.ecogo.ecomove_web_service.user_management.infrastructure.persistance.jpa.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(CreateUserCommand command) {
        if(userRepository.existsByUsername(command.username())) {
            throw new IllegalArgumentException("username already exists");
        }

        User user = new User(command);
        return Optional.of(userRepository.save(user));
    }
}
