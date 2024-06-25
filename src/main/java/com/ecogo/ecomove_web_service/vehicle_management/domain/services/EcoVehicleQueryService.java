package com.ecogo.ecomove_web_service.vehicle_management.domain.services;

import com.ecogo.ecomove_web_service.vehicle_management.domain.model.aggregates.EcoVehicle;
import com.ecogo.ecomove_web_service.vehicle_management.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface EcoVehicleQueryService {
    List<EcoVehicle> handle(GetAllEcoVehicleByBatteryLevelGreaterThanQuery query);
    List<EcoVehicle> handle(GetAllEcoVehicleByTypeAndModelQuery query);
    List<EcoVehicle> handle(GetAllEcoVehicleByTypeAndStatusQuery query);
    List<EcoVehicle> handle(GetAllEcoVehicleByTypeQuery query);

    List<EcoVehicle> handle(GetAllEcoVehicleQuery query);
    Optional<EcoVehicle> handle(GetEcoVehicleByIdQuery query);

}
