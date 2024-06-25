package com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

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
