package com.ecogo.ecomove_web_service.vehicle_management.domain.model.queries;

public record GetAllEcoVehicleByBatteryLevelGreaterThanQuery(int batteryLevel) {
    public GetAllEcoVehicleByBatteryLevelGreaterThanQuery{
        if (batteryLevel < 0 || batteryLevel > 100){
            throw new IllegalArgumentException("batteryLevel needs to be a value between 0 and 100");
        }
    }
}
