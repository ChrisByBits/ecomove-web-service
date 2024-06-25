package com.ecogo.ecomove_web_service.vehicle_management.application.internal.queryservices;

import com.ecogo.ecomove_web_service.vehicle_management.domain.model.aggregates.EcoVehicle;
import com.ecogo.ecomove_web_service.vehicle_management.domain.model.queries.*;
import com.ecogo.ecomove_web_service.vehicle_management.domain.services.EcoVehicleQueryService;
import com.ecogo.ecomove_web_service.vehicle_management.infrastructure.persistence.jpa.EcoVehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EcoVehicleQueryServiceImpl implements EcoVehicleQueryService {

    public static EcoVehicleRepository ecoVehicleRepository;
    public EcoVehicleQueryServiceImpl(EcoVehicleRepository ecoVehicleRepository){
        this.ecoVehicleRepository = ecoVehicleRepository;
    }


    /**
     * Handles the GetAllEcoVehicleByBatteryLevelGreaterThanQuery query
     * @param query the GetAllEcoVehicleByBatteryLevelGreaterThanQuery query
     * @return - a List of EcoVehicle
     */
    @Override
    public List<EcoVehicle> handle(GetAllEcoVehicleByBatteryLevelGreaterThanQuery query){
        return ecoVehicleRepository.findAllByBatteryLevelGreaterThan(query.batteryLevel());
    }

    /**
     * Handles the GetAllEcoVehicleByTypeAndModelQuery query
     * @param query the GetAllEcoVehicleByTypeAndModelQuery query
     * @return - a List of EcoVehicle
     */
    @Override
    public List<EcoVehicle> handle(GetAllEcoVehicleByTypeAndModelQuery query){
        return ecoVehicleRepository.findAllByTypeAndModel(query.type(), query.model());
    }

    /**
     * Handles the GetAllEcoVehicleByTypeAndStatusQuery query
     * @param query the GetAllEcoVehicleByTypeAndStatusQuery query
     * @return - a List of EcoVehicle
     */
    @Override
    public List<EcoVehicle> handle(GetAllEcoVehicleByTypeAndStatusQuery query){
        return ecoVehicleRepository.findAllByTypeAndStatus(query.type(), query.status());
    }

    /**
     * Handles the GetAllEcoVehicleByTypeQuery query
     * @param query the GetAllEcoVehicleByTypeQuery query
     * @return - a List of EcoVehicle
     */
    @Override
    public List<EcoVehicle> handle(GetAllEcoVehicleByTypeQuery query){
        return ecoVehicleRepository.findAllByType(query.type());
    }

    /**
     * Handles the GetAllEcoVehicleQuery query
     * @param query the GetAllEcoVehicleQuery query
     * @return - a List of EcoVehicle
     */
    @Override
    public List<EcoVehicle> handle(GetAllEcoVehicleQuery query){
        return ecoVehicleRepository.findAll();
    }

    /**
     * Handles the GetEcoVehicleByIdQuery query
     * @param query the GetEcoVehicleByIdQuery query
     * @return - an Optional of EcoVehicle
     */
    @Override
    public Optional<EcoVehicle> handle(GetEcoVehicleByIdQuery query){
        return ecoVehicleRepository.findById(query.id());
    }

}
