package com.ecogo.ecomove_web_service.vehicle_management.domain.services;

import com.ecogo.ecomove_web_service.vehicle_management.domain.model.aggregates.EcoVehicle;
import com.ecogo.ecomove_web_service.vehicle_management.domain.model.commands.CreateEcoVehicleCommand;

import java.util.Optional;

public interface EcoVehicleCommandService {
    Optional<EcoVehicle> handle(CreateEcoVehicleCommand command);
}
