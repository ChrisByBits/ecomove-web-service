package com.ecogo.ecomove_web_service.vehicle_management.interfaces.rest.resources;

import com.ecogo.ecomove_web_service.vehicle_management.domain.model.commands.CreateEcoVehicleCommand;

public record CreateEcoVehicleResource(String type, String model, int batteryLevel, Double longitude, Double latitude, String status, String imageUrl) {
    public CreateEcoVehicleResource{
        if (type == null || type.isBlank()){
            throw new IllegalArgumentException("type cannot be null or empty");
        }
        if (model == null || model.isBlank()){
            throw new IllegalArgumentException("model cannot be null or empty");
        }
        if (batteryLevel < 0 || batteryLevel > 100){
            throw new IllegalArgumentException("batteryLevel needs to be between 0 and 100");
        }
        if (status == null || status.isBlank()){
            throw new IllegalArgumentException("status cannot be null or empty");
        }
    }
}
