package com.ecogo.ecomove_web_service.booking_reservation.application.internal.queryservices;

import com.ecogo.ecomove_web_service.booking_reservation.domain.model.aggregates.Booking;
import com.ecogo.ecomove_web_service.booking_reservation.domain.model.queries.*;
import com.ecogo.ecomove_web_service.booking_reservation.domain.services.BookingQueryService;
import com.ecogo.ecomove_web_service.booking_reservation.infrastructure.persistance.jpa.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingQueryServiceImpl implements BookingQueryService {
    private final BookingRepository bookingRepository;

    public BookingQueryServiceImpl(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> handle(GetAllBookingsByUserIdQuery query){
        return bookingRepository.findAllByUserId(query.userId());
    }

    @Override
    public List<Booking> handle(GetAllBookingsByVehicleIdQuery query){
        return bookingRepository.findAllByVehicleId(query.vehicleId());
    }

    @Override
    public List<Booking> handle(GetAllBookingsByUserIdAndVehicleIdQuery query){
        return bookingRepository.findAllByUserIdAndVehicleId(query.userId(), query.vehicleId());
    }

    @Override
    public List<Booking> handle(GetAllBookingsQuery query){
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> handle(GetBookingByIdQuery query){
        return bookingRepository.findById(query.id());
    }
}
