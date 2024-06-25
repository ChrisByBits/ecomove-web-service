package com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources;
/**
 * Resource to represent a customer support agent
 * @param customerSupportAgentId the id of the customer support agent
 * @param firstName the first name of the customer support agent
 * @param lastName the last name of the customer support agent
 * @param emailAddress the email address of the customer support agent
 */
public record CustomerSupportAgentResource(Long customerSupportAgentId, String firstName, String lastName, String emailAddress) {
}
