package com.ecogo.ecomove_web_service.booking_reservation.domain.services;

import com.ecogo.ecomove_web_service.booking_reservation.domain.model.aggregates.Booking;
import com.ecogo.ecomove_web_service.booking_reservation.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface BookingQueryService {
    List<Booking> handle(GetAllBookingsByUserIdQuery query);

    List<Booking> handle(GetAllBookingsByVehicleIdQuery query);

    List<Booking> handle(GetAllBookingsByUserIdAndVehicleIdQuery query);

    List<Booking> handle(GetAllBookingsQuery query);
    Optional<Booking> handle(GetBookingByIdQuery query);
}
