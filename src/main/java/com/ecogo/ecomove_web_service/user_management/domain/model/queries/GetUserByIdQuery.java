package com.ecogo.ecomove_web_service.user_management.domain.model.queries;
/**
 * Query to get a user by id
 * @param id the id of the user
 */
public record GetUserByIdQuery(Long id) {
    public GetUserByIdQuery{
        if (id == null){
            throw new IllegalArgumentException("id cannot be null");
        }
    }
}
