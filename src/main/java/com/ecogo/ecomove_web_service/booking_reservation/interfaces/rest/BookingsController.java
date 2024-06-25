package com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest;

import com.ecogo.ecomove_web_service.booking_reservation.domain.model.aggregates.Booking;
import com.ecogo.ecomove_web_service.booking_reservation.domain.model.queries.*;
import com.ecogo.ecomove_web_service.booking_reservation.domain.services.BookingCommandService;
import com.ecogo.ecomove_web_service.booking_reservation.domain.services.BookingQueryService;
import com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest.resources.BookingResource;
import com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest.resources.CreateBookingResource;
import com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest.transform.BookingResourceFromEntityAssembler;
import com.ecogo.ecomove_web_service.booking_reservation.interfaces.rest.transform.CreateBookingCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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

    @PostMapping
    public ResponseEntity<BookingResource> createBooking(@RequestBody CreateBookingResource resource){
        Optional<Booking> booking = bookingCommandService.handle(CreateBookingCommandFromResourceAssembler.toCommandFromResource(resource));
        return booking.map(source -> new ResponseEntity<>(BookingResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<BookingResource> getBookingById(@PathVariable Long id){
        Optional<Booking> booking = bookingQueryService.handle(new GetBookingByIdQuery(id));
        return booking.map(source -> new ResponseEntity<>(BookingResourceFromEntityAssembler.toResourceFromEntity(source), OK)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<BookingResource>> getBookings(){
        var getAllBookingsQuery = new GetAllBookingsQuery();
        var bookings = bookingQueryService.handle(getAllBookingsQuery);
        if (bookings.isEmpty()) return ResponseEntity.notFound().build();
        var bookingResources = bookings.stream().map(BookingResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(bookingResources);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<BookingResource>> getAllBookingsByUserId(@PathVariable Long userId){
        var getAllBookingsByUserIdQuery = new GetAllBookingsByUserIdQuery(userId);
        var bookings = bookingQueryService.handle(getAllBookingsByUserIdQuery);
        if (bookings.isEmpty()) return ResponseEntity.notFound().build();
        var bookingResources = bookings.stream().map(BookingResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(bookingResources);
    }

    @GetMapping("vehicle/{vehicleId}")
    public ResponseEntity<List<BookingResource>> getAllBookingsByVehicleId(@PathVariable Long vehicleId){
        var getAllBookingsByVehicleIdQuery = new GetAllBookingsByVehicleIdQuery(vehicleId);
        var bookings = bookingQueryService.handle(getAllBookingsByVehicleIdQuery);
        if (bookings.isEmpty()) return ResponseEntity.notFound().build();
        var bookingResources = bookings.stream().map(BookingResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(bookingResources);
    }

    @GetMapping("user/{userId}/vehicle/{vehicleId}")
    public ResponseEntity<List<BookingResource>> getAllBookingsByUserIdAndVehicleId(@PathVariable Long userId,@PathVariable Long vehicleId){
        var getAllBookingsByUserIdAndVehicleIdQuery = new GetAllBookingsByUserIdAndVehicleIdQuery(userId, vehicleId);
        var bookings = bookingQueryService.handle(getAllBookingsByUserIdAndVehicleIdQuery);
        if (bookings.isEmpty()) return ResponseEntity.notFound().build();
        var bookingResources = bookings.stream().map(BookingResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(bookingResources);
    }

//    @GetMapping
//    public ResponseEntity<?> getBookingsWithParameters(@RequestParam(name = "RequestParameters") Map<String, Long> params) {
//        if (params.containsKey("userId") && params.containsKey("vehicleId")) {
//            return getAllBookingsByUserIdAndVehicleId(params.get("userId"), params.get("vehicleId"));
//        } else if (params.containsKey("userId")) {
//            return getAllBookingsByUserId(params.get("userId"));
//        } else if (params.containsKey("vehicleId")) {
//            return getAllBookingsByVehicleId(params.get("vehicleId"));
//        } else {
//            return getBookings();
//        }
//    }
}


