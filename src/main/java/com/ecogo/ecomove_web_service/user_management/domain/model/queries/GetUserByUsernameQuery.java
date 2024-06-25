package com.ecogo.ecomove_web_service.user_management.domain.model.queries;
/**
 * Query to get a user by username
 * @param username the username of the user
 */
public record GetUserByUsernameQuery(String username) {
    public GetUserByUsernameQuery {
        if(username == null || username.isBlank()) {
            throw new IllegalArgumentException("username cannot be null or empty");
        }
    }
}
