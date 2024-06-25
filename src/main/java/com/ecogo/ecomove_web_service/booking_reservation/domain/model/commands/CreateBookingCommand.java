package com.ecogo.ecomove_web_service.booking_reservation.domain.model.commands;

import java.util.Date;
/**
 * CreateBookingCommand
 * <p> Command to create a booking </p>
 * @param userId the id of the user that creates the booking
 * @param vehicleId the id of the vehicle that is booked
 * @param startTime the start time of the booking
 * @param endTime the end time of the booking
 */
public record CreateBookingCommand(Long userId, Long vehicleId, Date startTime, Date endTime) {

}
