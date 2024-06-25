package com.ecogo.ecomove_web_service.booking_reservation.domain.model.queries;
/**
 * Query to get all bookings by user id
 * @param userId the id of the user
 */
public record GetAllBookingsByUserIdQuery(Long userId) {
}
