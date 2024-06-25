package com.ecogo.ecomove_web_service.customer_support.domain.model.queries;
/**
 * Query to get all tickets by customer support agent id
 * @param customerSupportAgentId the id of the customer support agent
 */
public record GetAllTicketsByCustomerSupportAgentIdQuery(Long customerSupportAgentId) {
}
