package com.ecogo.ecomove_web_service.vehicle_management.domain.model.queries;

public record GetAllEcoVehicleByTypeQuery(String type) {
    public GetAllEcoVehicleByTypeQuery{
        if(type == null || type.isBlank()){
            throw new IllegalArgumentException("type cannot be null or empty");
        }
    }
}
