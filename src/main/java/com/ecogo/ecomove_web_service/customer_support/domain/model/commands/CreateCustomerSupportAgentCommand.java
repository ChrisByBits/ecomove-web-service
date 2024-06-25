package com.ecogo.ecomove_web_service.customer_support.domain.model.commands;
/**
 * CreateCustomerSupportAgentCommand
 * <p>Command to create a customer support agent</p>
 * @param email the email of the customer support agent
 * @param firstName the first name of the customer support agent
 * @param lastName the last name of the customer support agent
 */
public record CreateCustomerSupportAgentCommand(String email, String firstName, String lastName) {
}
