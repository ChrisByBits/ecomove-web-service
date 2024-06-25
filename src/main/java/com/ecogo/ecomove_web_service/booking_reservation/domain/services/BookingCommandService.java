package com.ecogo.ecomove_web_service.booking_reservation.domain.services;

import com.ecogo.ecomove_web_service.booking_reservation.domain.model.aggregates.Booking;
import com.ecogo.ecomove_web_service.booking_reservation.domain.model.commands.CancelBookingCommand;
import com.ecogo.ecomove_web_service.booking_reservation.domain.model.commands.CompleteBookingCommand;
import com.ecogo.ecomove_web_service.booking_reservation.domain.model.commands.CreateBookingCommand;

import java.util.List;
import java.util.Optional;

/**
 * Service to handle booking commands
 */
public interface BookingCommandService {
    Optional<Booking> handle(CreateBookingCommand command);

    Optional<Booking> handle(CancelBookingCommand command);

    Optional<Booking> handle(CompleteBookingCommand command);
}
