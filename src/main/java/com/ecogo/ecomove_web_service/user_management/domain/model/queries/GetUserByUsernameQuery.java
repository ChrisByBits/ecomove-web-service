package com.ecogo.ecomove_web_service.user_management.domain.model.queries;

public record GetUserByUsernameQuery(String username) {
    public GetUserByUsernameQuery {
        if(username == null || username.isBlank()) {
            throw new IllegalArgumentException("username cannot be null or empty");
        }
    }
}
