package com.ecogo.ecomove_web_service.vehicle_management.interfaces.rest.resources;

public record EcoVehicleResource(Long id, String type, String model, int batteryLevel, Double longitude, Double latitude, String status, String imageUrl) {
}
