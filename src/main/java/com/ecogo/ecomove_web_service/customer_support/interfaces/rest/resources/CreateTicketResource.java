package com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources;
import jakarta.validation.constraints.NotNull;
/**
 * Resource to create a ticket
 * @param userId the id of the user creating the ticket
 * @param customerSupportAgentId the id of the customer support agent assigned to the ticket
 * @param categoryId the id of the category of the ticket
 * @param title the title of the ticket
 * @param description the description of the ticket
 */

public record CreateTicketResource(
        @NotNull Long userId,
        @NotNull Long customerSupportAgentId,
        @NotNull Long categoryId,
        @NotNull String title,
        @NotNull String description
) {
}
