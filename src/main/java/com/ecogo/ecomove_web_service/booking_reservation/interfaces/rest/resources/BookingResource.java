package com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest.resources;

import java.util.Date;

public record BookingResource(Long bookingId, Long userId, Long vehicleId, Date startTime, Date endTime,String status) {

}
