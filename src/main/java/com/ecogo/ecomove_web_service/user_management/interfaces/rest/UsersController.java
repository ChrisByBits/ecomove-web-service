package com.ecogo.ecomove_web_service.user_management.interfaces.rest;

import com.ecogo.ecomove_web_service.user_management.domain.model.aggregates.User;
import com.ecogo.ecomove_web_service.user_management.domain.model.queries.GetUserByUsernameQuery;
import com.ecogo.ecomove_web_service.user_management.domain.services.UserCommandService;
import com.ecogo.ecomove_web_service.user_management.domain.services.UserQueryService;
import com.ecogo.ecomove_web_service.user_management.interfaces.rest.resources.CreateUserResource;
import com.ecogo.ecomove_web_service.user_management.interfaces.rest.resources.UserResource;
import com.ecogo.ecomove_web_service.user_management.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import com.ecogo.ecomove_web_service.user_management.interfaces.rest.transform.UserResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public UsersController(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource createUserResource) {
        Optional<User> user = userCommandService.handle(CreateUserCommandFromResourceAssembler.fromResource(createUserResource));
        return user.map(u -> new ResponseEntity<>(UserResourceFromEntityAssembler.fromEntity(u), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @GetMapping("{username}")
    public ResponseEntity<UserResource> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userQueryService.handle(new GetUserByUsernameQuery(username));
        return user.map(u -> new ResponseEntity<>(UserResourceFromEntityAssembler.fromEntity(u), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
