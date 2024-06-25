package com.ecogo.ecomove_web_service.user_management.interfaces.rest.transform;

import com.ecogo.ecomove_web_service.user_management.domain.model.commands.CreateUserCommand;
import com.ecogo.ecomove_web_service.user_management.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand fromResource(CreateUserResource resource) {
        return new CreateUserCommand(resource.username(), resource.email(), resource.password(), resource.firstName(), resource.lastName());
    }
}
