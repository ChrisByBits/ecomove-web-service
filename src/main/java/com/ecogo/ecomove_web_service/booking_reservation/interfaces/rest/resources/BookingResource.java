package com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest.resources;

import java.util.Date;
/**
 * Resource to represent a booking
 * @param bookingId the id of the booking
 * @param userId the id of the user
 * @param vehicleId the id of the vehicle
 * @param startTime the start time of the booking
 * @param endTime the end time of the booking
 * @param status the status of the booking
 */
public record BookingResource(Long bookingId, Long userId, Long vehicleId, Date startTime, Date endTime,String status) {

}
