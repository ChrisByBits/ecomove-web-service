package com.ecogo.ecomove_web_service.user_management.interfaces.rest;

import com.ecogo.ecomove_web_service.user_management.domain.model.aggregates.User;
import com.ecogo.ecomove_web_service.user_management.domain.model.queries.GetUserByIdQuery;
import com.ecogo.ecomove_web_service.user_management.domain.model.queries.GetUserByUsernameQuery;
import com.ecogo.ecomove_web_service.user_management.domain.services.UserCommandService;
import com.ecogo.ecomove_web_service.user_management.domain.services.UserQueryService;
import com.ecogo.ecomove_web_service.user_management.interfaces.rest.resources.CreateUserResource;
import com.ecogo.ecomove_web_service.user_management.interfaces.rest.resources.UserResource;
import com.ecogo.ecomove_web_service.user_management.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import com.ecogo.ecomove_web_service.user_management.interfaces.rest.transform.UserResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name="Users", description = "Users Management Endpoints")
@CrossOrigin(origins = "*")
public class UsersController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public UsersController(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    @Operation(summary = "Create a new user", description = "Creates a new user with the specified attributes")
    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource createUserResource) {
        Optional<User> user = userCommandService.handle(CreateUserCommandFromResourceAssembler.fromResource(createUserResource));
        return user.map(u -> new ResponseEntity<>(UserResourceFromEntityAssembler.fromEntity(u), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @Operation(summary = "Get user by username", description = "Returns the user with the specified username")
    @GetMapping("username/{username}")
    public ResponseEntity<UserResource> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userQueryService.handle(new GetUserByUsernameQuery(username));
        return user.map(u -> new ResponseEntity<>(UserResourceFromEntityAssembler.fromEntity(u), OK))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Get user by id", description = "Returns the user with the specified id")
    @GetMapping("id/{id}")
    public ResponseEntity<UserResource> getUserById(@PathVariable Long id) {
        Optional<User> user = userQueryService.handle(new GetUserByIdQuery(id));
        return user.map(u -> new ResponseEntity<>(UserResourceFromEntityAssembler.fromEntity(u), OK))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
