package com.ecogo.ecomove_web_service.vehicle_management.interfaces.rest.transform;

import com.ecogo.ecomove_web_service.vehicle_management.domain.model.aggregates.EcoVehicle;
import com.ecogo.ecomove_web_service.vehicle_management.interfaces.rest.resources.EcoVehicleResource;

public class EcoVehicleResourceFromEntityAssembler {
    public static EcoVehicleResource toResourceFromEntity(EcoVehicle entity){
        return new EcoVehicleResource(entity.getId(), entity.getType(), entity.getModel(), entity.getBatteryLevel(), entity.getLocation(), entity.getStatus());
    }
}
