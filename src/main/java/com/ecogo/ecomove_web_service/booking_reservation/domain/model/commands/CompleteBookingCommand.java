package com.ecogo.ecomove_web_service.booking_reservation.domain.model.commands;
/**
 * CompleteBookingCommand
 * <p>Command to complete a booking</p>
 * @param bookingId the id of the booking to complete
 */
public record CompleteBookingCommand(Long bookingId) {
}
