package com.ecogo.ecomove_web_service.user_management.domain.model.commands;

/**
 * CreateUserCommand
 * <p> CreateUserCommand is a record class that represents the command to create a user. </p>
 * @param username The username of the user.
 * @param email The email of the user.
 * @param password The password of the user.
 * @param firstName The first name of the user.
 * @param lastName The last name of the user.
 * @throws IllegalArgumentException if username, email, password, firstName, or lastName is null or empty.
 */

public record CreateUserCommand(String username, String email, String password, String firstName, String lastName) {

    public CreateUserCommand {
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
