package com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources;

public record CreateTicketResource(String ticketId, String title, String description, String category, String status, String assigneeID, String userID) {
    public CreateTicketResource {
        if (ticketId == null) {
            throw new IllegalArgumentException("ticketId cannot be null or empty");
        }
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (description == null) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null or empty");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null or empty");
        }
        if (assigneeID == null) {
            throw new IllegalArgumentException("AssigneeID cannot be null or empty");
        }
        if (userID == null) {
            throw new IllegalArgumentException("UserID cannot be null");
        }
    }
}
