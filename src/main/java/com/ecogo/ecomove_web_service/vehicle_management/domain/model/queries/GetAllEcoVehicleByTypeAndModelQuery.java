package com.ecogo.ecomove_web_service.vehicle_management.domain.model.queries;

public record GetAllEcoVehicleByTypeAndModelQuery(String type, String model) {
    public GetAllEcoVehicleByTypeAndModelQuery{
        if (type == null || type.isBlank()){
            throw new IllegalArgumentException("type cannot be null");
        }
        if (model == null || model.isBlank()){
            throw new IllegalArgumentException("model cannot be null");
        }
    }
}
