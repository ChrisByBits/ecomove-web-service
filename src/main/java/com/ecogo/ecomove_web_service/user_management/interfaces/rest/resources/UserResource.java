package com.ecogo.ecomove_web_service.user_management.interfaces.rest.resources;

public record UserResource(Long id, String username, String email, String password, String firstName, String lastName) { }
