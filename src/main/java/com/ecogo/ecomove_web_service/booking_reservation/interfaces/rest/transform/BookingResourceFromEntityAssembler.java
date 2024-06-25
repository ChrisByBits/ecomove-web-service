package com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest.transform;

import com.ecogo.ecomove_web_service.booking_reservation.domain.model.aggregates.Booking;
import com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest.resources.BookingResource;

public class BookingResourceFromEntityAssembler {
    public static BookingResource toResourceFromEntity(Booking entity){
        return new BookingResource(
                entity.getId(),
                entity.getUser().getId(),
                entity.getVehicle().getId(),
                entity.getStartTime(),
                entity.getEndTime(),
                entity.getStatus()
        );
    }
}
