package com.ecogo.ecomove_web_service.customer_support.interfaces.rest.resources;

public record TicketResource(Long id, String ticketId, String title, String description, String category, String status, String assigneeID, String userID){
}
