package com.ecogo.ecomove_web_service.customer_support.domain.model.commands;
/**
 * CreateTicketCategoryCommand
 * <p>Command to create a ticket category</p>
 * @param name the name of the ticket category
 */
public record CreateTicketCategoryCommand(String name) {
}
