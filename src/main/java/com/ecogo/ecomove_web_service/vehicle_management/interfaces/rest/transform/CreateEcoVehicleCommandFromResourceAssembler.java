package com.ecogo.ecomove_web_service.vehicle_management.interfaces.rest.transform;

import com.ecogo.ecomove_web_service.vehicle_management.domain.model.commands.CreateEcoVehicleCommand;
import com.ecogo.ecomove_web_service.vehicle_management.interfaces.rest.resources.CreateEcoVehicleResource;

public class CreateEcoVehicleCommandFromResourceAssembler {
    public static CreateEcoVehicleCommand toCommandFromResource(CreateEcoVehicleResource resource){
        return new CreateEcoVehicleCommand(resource.type(), resource.model(), resource.batteryLevel(), resource.longitude(), resource.latitude(), resource.status(), resource.imageUrl());
    }
}
