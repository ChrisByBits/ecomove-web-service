package com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources;
/**
 * Resource to represent a ticket
 * @param ticketId the id of the ticket
 * @param userId the id of the user who created the ticket
 * @param customerSupportAgentId the id of the customer support agent assigned to the ticket
 * @param categoryId the id of the category of the ticket
 * @param title the title of the ticket
 * @param description the description of the ticket
 */
public record TicketResource(Long ticketId, Long userId, Long customerSupportAgentId, Long categoryId, String title, String description) {
}
