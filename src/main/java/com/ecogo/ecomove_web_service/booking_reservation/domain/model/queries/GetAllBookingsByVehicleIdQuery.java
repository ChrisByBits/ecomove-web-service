package com.ecogo.ecomove_web_service.booking_reservation.domain.model.queries;
/**
 * Query to get all bookings by vehicle id
 * @param vehicleId the id of the vehicle
 */
public record GetAllBookingsByVehicleIdQuery(Long vehicleId) {
}
