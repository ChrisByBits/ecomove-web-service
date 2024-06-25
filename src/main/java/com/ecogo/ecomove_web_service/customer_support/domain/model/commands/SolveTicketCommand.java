package com.ecogo.ecomove_web_service.customer_support.domain.model.commands;
/**
 * SolveTicketCommand
 * <p>Command to solve a ticket</p>
 * @param ticketId the id of the ticket
 */
public record SolveTicketCommand(Long ticketId) {
}
