package com.ecogo.ecomove_web_service.customer_support.domain.model.commands;
/**
 * CreateTicketCommand
 * <p> Command to create a ticket </p>
 * @param userId the id of the user
 * @param customerSupportAgentId the id of the customer support agent
 * @param categoryId the id of the category
 * @param title the title of the ticket
 * @param description the description of the ticket
 */
public record CreateTicketCommand(Long userId, Long customerSupportAgentId, Long categoryId, String title, String description) {
}
