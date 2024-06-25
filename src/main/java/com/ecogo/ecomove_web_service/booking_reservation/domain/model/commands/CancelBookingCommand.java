package com.ecogo.ecomove_web_service.booking_reservation.domain.model.commands;
/**
 * CancelBookingCommand
 * <p> Command to cancel a booking </p>
 * @param bookingId the id of the booking to cancel
 */
public record CancelBookingCommand(Long bookingId) {

}
