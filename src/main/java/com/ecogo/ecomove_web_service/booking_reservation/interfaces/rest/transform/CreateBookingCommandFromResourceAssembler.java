package com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest.transform;

import com.ecogo.ecomove_web_service.booking_reservation.domain.model.aggregates.Booking;
import com.ecogo.ecomove_web_service.booking_reservation.domain.model.commands.CreateBookingCommand;
import com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest.resources.BookingResource;
import com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest.resources.CreateBookingResource;

public class CreateBookingCommandFromResourceAssembler {
    public static CreateBookingCommand toCommandFromResource(CreateBookingResource resource){
        return new CreateBookingCommand(resource.userId(), resource.vehicleId(), resource.startTime(), resource.endTime());
    }

}
