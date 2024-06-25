package com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest;

import com.ecogo.ecomove_web_service.booking_reservation.domain.model.aggregates.Booking;
import com.ecogo.ecomove_web_service.booking_reservation.domain.model.queries.*;
import com.ecogo.ecomove_web_service.booking_reservation.domain.services.BookingCommandService;
import com.ecogo.ecomove_web_service.booking_reservation.domain.services.BookingQueryService;
import com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest.resources.BookingResource;
import com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest.resources.CreateBookingResource;
import com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest.transform.BookingResourceFromEntityAssembler;
import com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest.transform.CreateBookingCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value="/api/v1/bookings")
@Tag(name="Bookings", description = "Bookings Management Endpoints")
public class BookingsController {
    private final BookingCommandService bookingCommandService;
    private final BookingQueryService bookingQueryService;

    BookingsController(BookingCommandService bookingCommandService, BookingQueryService bookingQueryService){
        this.bookingCommandService = bookingCommandService;
        this.bookingQueryService = bookingQueryService;
    }

    @Operation(summary = "Create a new booking", description = "Creates a new booking with the specified attributes")
    @PostMapping
    public ResponseEntity<BookingResource> createBooking(@RequestBody CreateBookingResource resource){
        Optional<Booking> booking = bookingCommandService.handle(CreateBookingCommandFromResourceAssembler.toCommandFromResource(resource));
        return booking.map(source -> new ResponseEntity<>(BookingResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Get booking by Id", description = "Returns the booking with the specified id")
    @GetMapping("{id}")
    public ResponseEntity<BookingResource> getBookingById(@PathVariable Long id){
        Optional<Booking> booking = bookingQueryService.handle(new GetBookingByIdQuery(id));
        return booking.map(source -> new ResponseEntity<>(BookingResourceFromEntityAssembler.toResourceFromEntity(source), OK)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation (summary = "Get all bookings", description = "Returns all the bookings in the database")
    @GetMapping
    public ResponseEntity<List<BookingResource>> getBookings(){
        var getAllBookingsQuery = new GetAllBookingsQuery();
        var bookings = bookingQueryService.handle(getAllBookingsQuery);
        if (bookings.isEmpty()) return ResponseEntity.notFound().build();
        var bookingResources = bookings.stream().map(BookingResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(bookingResources);
    }

    @Operation (summary = "Get all bookings by user id", description = "Returns all the bookings in the database by user id")
    @GetMapping("user/{userId}")
    public ResponseEntity<List<BookingResource>> getAllBookingsByUserId(@PathVariable Long userId){
        var getAllBookingsByUserIdQuery = new GetAllBookingsByUserIdQuery(userId);
        var bookings = bookingQueryService.handle(getAllBookingsByUserIdQuery);
        if (bookings.isEmpty()) return ResponseEntity.notFound().build();
        var bookingResources = bookings.stream().map(BookingResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(bookingResources);
    }

    @Operation (summary = "Get all bookings by vehicle id", description = "Returns all the bookings in the database by vehicle id")
    @GetMapping("vehicle/{vehicleId}")
    public ResponseEntity<List<BookingResource>> getAllBookingsByVehicleId(@PathVariable Long vehicleId){
        var getAllBookingsByVehicleIdQuery = new GetAllBookingsByVehicleIdQuery(vehicleId);
        var bookings = bookingQueryService.handle(getAllBookingsByVehicleIdQuery);
        if (bookings.isEmpty()) return ResponseEntity.notFound().build();
        var bookingResources = bookings.stream().map(BookingResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(bookingResources);
    }

    @Operation (summary = "Get all bookings by user id and vehicle id", description = "Returns all the bookings in the database by user id and vehicle id")
    @GetMapping("user/{userId}/vehicle/{vehicleId}")
    public ResponseEntity<List<BookingResource>> getAllBookingsByUserIdAndVehicleId(@PathVariable Long userId,@PathVariable Long vehicleId){
        var getAllBookingsByUserIdAndVehicleIdQuery = new GetAllBookingsByUserIdAndVehicleIdQuery(userId, vehicleId);
        var bookings = bookingQueryService.handle(getAllBookingsByUserIdAndVehicleIdQuery);
        if (bookings.isEmpty()) return ResponseEntity.notFound().build();
        var bookingResources = bookings.stream().map(BookingResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(bookingResources);
    }
}


