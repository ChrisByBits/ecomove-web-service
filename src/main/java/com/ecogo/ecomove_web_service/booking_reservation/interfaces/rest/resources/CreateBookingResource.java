package com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

import java.util.Date;
/**
 * Resource to represent a booking
 * @param userId the id of the user
 * @param vehicleId the id of the vehicle
 * @param startTime the start time of the booking
 * @param endTime the end time of the booking
 */
public record CreateBookingResource(
        @NotNull
        Long userId,
        @NotNull
        Long vehicleId,
        @NotNull
        Date startTime,
        @NotNull
        Date endTime

) {
}
