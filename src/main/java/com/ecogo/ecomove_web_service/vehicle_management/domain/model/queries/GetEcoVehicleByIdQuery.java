package com.ecogo.ecomove_web_service.vehicle_management.domain.model.queries;

public record GetEcoVehicleByIdQuery(Long id) {
    public GetEcoVehicleByIdQuery{
        if (id == null){
            throw new IllegalArgumentException("id cannot be null");
        }
    }
}
