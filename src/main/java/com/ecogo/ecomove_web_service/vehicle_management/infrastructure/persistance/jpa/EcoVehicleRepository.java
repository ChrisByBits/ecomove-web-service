package com.ecogo.ecomove_web_service.vehicle_management.infrastructure.persistance.jpa;

import com.ecogo.ecomove_web_service.vehicle_management.domain.model.aggregates.EcoVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EcoVehicleRepository extends JpaRepository<EcoVehicle, Long> {

    List<EcoVehicle> findAllByType(String model);
    List<EcoVehicle> findAllByTypeAndStatus(String type, String status);
    List<EcoVehicle> findAllByBatteryLevelGreaterThan(int batteryLevel);
    List<EcoVehicle> findAllByTypeAndModel(String type, String model);

    //boolean existsByTypeAndModel(String type, String model);

}
