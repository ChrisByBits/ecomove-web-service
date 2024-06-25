package com.ecogo.ecomove_web_service.vehicle_management.domain.model.queries;

public record GetAllEcoVehicleByTypeAndStatusQuery(String type, String status) {
    public GetAllEcoVehicleByTypeAndStatusQuery{
        if (type == null || type.isBlank()){
            throw new IllegalArgumentException("type cannot be null");
        }
        if(status == null || status.isBlank()){
            throw new IllegalArgumentException("status cannot be null");
        }
    }
}
