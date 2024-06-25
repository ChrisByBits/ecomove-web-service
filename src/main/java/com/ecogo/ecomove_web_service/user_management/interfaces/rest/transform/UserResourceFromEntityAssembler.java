package com.ecogo.ecomove_web_service.user_management.interfaces.rest.transform;

import com.ecogo.ecomove_web_service.user_management.domain.model.aggregates.User;
import com.ecogo.ecomove_web_service.user_management.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource fromEntity(User user) {
        return new UserResource(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName());
    }
}
