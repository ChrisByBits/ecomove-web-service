package com.ecogo.ecomove_web_service.user_management.domain.services;

import com.ecogo.ecomove_web_service.user_management.domain.model.aggregates.User;
import com.ecogo.ecomove_web_service.user_management.domain.model.queries.GetUserByUsernameQuery;

import java.util.Optional;

public interface UserQueryService {
    Optional<User> handle(GetUserByUsernameQuery query);
}
