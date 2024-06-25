package com.ecogo.ecomove_web_service.booking_reservation.domain.model.commands;

import java.util.Date;

public record CreateBookingCommand(Long userId, Long vehicleId, Date startTime, Date endTime) {

}
