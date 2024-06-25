package com.ecogo.ecomove_web_service.customer_support.domain.model.commands;

/**
 * CreateTicketCommand
 * <p> CreateTicketCommand is a record class that represents the command to create a ticket. </p>
 * @param ticketId The id of the ticket.
 * @param title The title of the ticket.
 * @param description The description of the ticket.
 * @param category The category of the ticket.
 * @param status The status of the ticket.
 * @param assigneeID The user assigned to the ticket.
 * @param userID The user who created the ticket.
 * @throws IllegalArgumentException if any of the fields are null.
 */
public record CreateTicketCommand(String ticketId, String title, String description, String category, String status, String assigneeID, String userID){

        public CreateTicketCommand {
            if (ticketId == null) {
                throw new IllegalArgumentException("ticketId cannot be null");
            }
            if (title == null) {
                throw new IllegalArgumentException("Title cannot be null");
            }
            if (description == null) {
                throw new IllegalArgumentException("Description cannot be null");
            }
            if (category == null) {
                throw new IllegalArgumentException("Category cannot be null");
            }
            if (status == null) {
                throw new IllegalArgumentException("Status cannot be null");
            }
            if (assigneeID == null) {
                throw new IllegalArgumentException("AssigneeID cannot be null");
            }
            if (userID == null) {
                throw new IllegalArgumentException("UserID cannot be null");
            }
        }
}
