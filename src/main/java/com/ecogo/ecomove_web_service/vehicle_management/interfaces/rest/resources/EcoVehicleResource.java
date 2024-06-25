package com.ecogo.ecomove_web_service.vehicle_management.interfaces.rest.resources;

public record EcoVehicleResource(Long id, String type, String model, int batteryLevel, String location, String status) {
}
