package com.ecogo.ecomove_web_service.customer_support.domain.model.commands;

public record CreateCustomerSupportAgentCommand(String email, String firstName, String lastName) {
}
