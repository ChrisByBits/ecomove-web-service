package com.ecogo.ecomove_web_service.customer_support.domain.model.commands;
/**
 * CloseTicketCommand
 * <p> Command to cancel a ticket </p>
 * @param ticketId the id of the ticket
 */
public record CloseTicketCommand(Long ticketId) {
}
