package com.ecogo.ecomove_web_service.customer_support.domain.model.queries;
/**
 * Query to get all tickets by user id
 * @param userId the id of the user
 */
public record GetAllTicketsByUserIdQuery(Long userId) {
}
