package com.ecogo.ecomove_web_service.vehicle_management.domain.model.commands;

/**
 * CreateEcoVehicleCommand
 * <p> Command to create an EcoVehicle </p>
 * @param type the type of the vehicle
 * @param model the model of the vehicle
 * @param batteryLevel the battery level of the vehicle
 * @param location the location of the vehicle
 * @param status the status of the vehicle
 * @throws IllegalArgumentException if type, model, location or status are null or empty, or if batterylevel is not a value between 0 and 100
 */
public record CreateEcoVehicleCommand(String type, String model, int batteryLevel, String location, String status) {
    public CreateEcoVehicleCommand{
        if (type == null || type.isBlank()){
            throw new IllegalArgumentException("type cannot be null or empty");
        }
        if (model == null || model.isBlank()){
            throw new IllegalArgumentException("model cannot be null or empty");
        }
        if (batteryLevel < 0 || batteryLevel > 100){
            throw new IllegalArgumentException("batteryLevel needs to be between 0 and 100");
        }
        if (location == null || location.isBlank()){
            throw new IllegalArgumentException("location cannot be null or empty");
        }
        if (status == null || status.isBlank()){
            throw new IllegalArgumentException("status cannot be null or empty");
        }
    }
}
