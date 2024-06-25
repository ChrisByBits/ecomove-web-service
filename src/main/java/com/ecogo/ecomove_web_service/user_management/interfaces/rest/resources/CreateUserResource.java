package com.ecogo.ecomove_web_service.user_management.interfaces.rest.resources;

public record CreateUserResource(String username, String password, String email, String firstName, String lastName) {
    public CreateUserResource {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("username cannot be null or empty");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("email cannot be null or empty");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("password cannot be null or empty");
        }
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("firstName cannot be null or empty");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("lastName cannot be null or empty");
        }
    }
}
