package com.ecogo.ecomove_web_service.booking_reservation.application.internal.outboundservices.acl;

import com.ecogo.ecomove_web_service.vehicle_management.domain.model.aggregates.EcoVehicle;
import com.ecogo.ecomove_web_service.vehicle_management.interfaces.acl.EcoVehicleContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalEcoVehicleServiceToBooking {
    private final EcoVehicleContextFacade ecoVehicleContextFacade;

    public ExternalEcoVehicleServiceToBooking(EcoVehicleContextFacade ecoVehicleContextFacade){
        this.ecoVehicleContextFacade = ecoVehicleContextFacade;
    }

    public Optional<EcoVehicle> fetchEcoVehicleById(Long vehicleId){
        return this.ecoVehicleContextFacade.fetchEcoVehicleById(vehicleId);
    }
}
