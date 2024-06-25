package com.ecogo.ecomove_web_service.booking_reservation.domain.model.queries;
/**
 * Query to get all bookings by user id and vehicle id
 * @param userId the id of the user
 * @param vehicleId the id of the vehicle
 */
public record GetAllBookingsByUserIdAndVehicleIdQuery(Long userId, Long vehicleId) {
}
