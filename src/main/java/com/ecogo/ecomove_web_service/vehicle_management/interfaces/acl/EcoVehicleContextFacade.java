package com.ecogo.ecomove_web_service.vehicle_management.interfaces.acl;

import com.ecogo.ecomove_web_service.vehicle_management.domain.model.aggregates.EcoVehicle;
import com.ecogo.ecomove_web_service.vehicle_management.domain.model.queries.GetEcoVehicleByIdQuery;
import com.ecogo.ecomove_web_service.vehicle_management.domain.services.EcoVehicleCommandService;
import com.ecogo.ecomove_web_service.vehicle_management.domain.services.EcoVehicleQueryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EcoVehicleContextFacade {
    private final EcoVehicleCommandService ecoVehicleCommandService;
    private final EcoVehicleQueryService ecoVehicleQueryService;

    public EcoVehicleContextFacade(EcoVehicleCommandService ecoVehicleCommandService, EcoVehicleQueryService ecoVehicleQueryService){
        this.ecoVehicleCommandService = ecoVehicleCommandService;
        this.ecoVehicleQueryService = ecoVehicleQueryService;
    }

    public Optional<EcoVehicle> fetchEcoVehicleById(Long vehicleId){
        var getEcoVehicleByIdQuery = new GetEcoVehicleByIdQuery(vehicleId);
        return ecoVehicleQueryService.handle(getEcoVehicleByIdQuery);
    }



}
