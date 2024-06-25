package com.ecogo.ecomove_web_service.vehicle_management.application.internal.commandservices;

import com.ecogo.ecomove_web_service.vehicle_management.domain.model.aggregates.EcoVehicle;
import com.ecogo.ecomove_web_service.vehicle_management.domain.model.commands.CreateEcoVehicleCommand;
import com.ecogo.ecomove_web_service.vehicle_management.domain.services.EcoVehicleCommandService;
import com.ecogo.ecomove_web_service.vehicle_management.infrastructure.persistence.jpa.EcoVehicleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EcoVehicleCommandServiceImpl implements EcoVehicleCommandService {

    private final EcoVehicleRepository ecoVehicleRepository;

    public EcoVehicleCommandServiceImpl(EcoVehicleRepository ecoVehicleRepository){
        this.ecoVehicleRepository = ecoVehicleRepository;
    }

    @Override
    public Optional<EcoVehicle> handle(CreateEcoVehicleCommand command){
        var ecoVehicle = new EcoVehicle(command);
        var createdEcoVehicle = ecoVehicleRepository.save(ecoVehicle);
        return Optional.of(createdEcoVehicle);
    }
}
