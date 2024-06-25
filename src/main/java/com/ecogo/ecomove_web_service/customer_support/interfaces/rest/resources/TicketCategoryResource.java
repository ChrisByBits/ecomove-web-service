package com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources;
/**
 * Resource to represent a ticket category
 * @param categoryId the id of the ticket category
 * @param name the name of the ticket category
 */
public record TicketCategoryResource(Long categoryId, String name) {
}
