package com.ecogo.ecomove_web_service.customer_support.domain.model.queries;
/**
 * Query to get all tickets by user id and category id
 * @param userId the id of the user
 * @param categoryId the id of the category
 */
public record GetAllTicketsByUserIdAndCategoryId(Long userId, Long categoryId) {
}
