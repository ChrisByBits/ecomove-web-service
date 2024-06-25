package com.ecogo.ecomove_web_service.booking_reservation.infrastructure.persistence.jpa;

import com.ecogo.ecomove_web_service.booking_reservation.domain.model.aggregates.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Repository for booking
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByUserId(Long userId);
    List<Booking> findAllByVehicleId(Long vehicleId);
    List<Booking> findAllByUserIdAndVehicleId(Long userId, Long vehicleId);
}
