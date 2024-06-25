package com.ecogo.ecomove_web_service.vehicle_management.interfaces.rest;

import com.ecogo.ecomove_web_service.vehicle_management.domain.model.aggregates.EcoVehicle;
import com.ecogo.ecomove_web_service.vehicle_management.domain.model.queries.*;
import com.ecogo.ecomove_web_service.vehicle_management.domain.services.EcoVehicleCommandService;
import com.ecogo.ecomove_web_service.vehicle_management.domain.services.EcoVehicleQueryService;
import com.ecogo.ecomove_web_service.vehicle_management.interfaces.rest.resources.CreateEcoVehicleResource;
import com.ecogo.ecomove_web_service.vehicle_management.interfaces.rest.resources.EcoVehicleResource;
import com.ecogo.ecomove_web_service.vehicle_management.interfaces.rest.transform.CreateEcoVehicleCommandFromResourceAssembler;
import com.ecogo.ecomove_web_service.vehicle_management.interfaces.rest.transform.EcoVehicleResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/eco-vehicles")
@CrossOrigin(origins = "*")
@Tag(name="EcoVehicles", description = "EcoVehicles Management Endpoints")
public class EcoVehicleController {

    private final EcoVehicleCommandService ecoVehicleCommandService;
    private final EcoVehicleQueryService ecoVehicleQueryService;

    public EcoVehicleController(EcoVehicleCommandService ecoVehicleCommandService, EcoVehicleQueryService ecoVehicleQueryService){
        this.ecoVehicleCommandService = ecoVehicleCommandService;
        this.ecoVehicleQueryService = ecoVehicleQueryService;
    }

    @Operation(summary = "Create a new eco vehicle", description = "Creates a new eco vehicle with the specified attributes")
    @PostMapping
    public ResponseEntity<EcoVehicleResource> createEcoVehicle(@RequestBody CreateEcoVehicleResource resource){
        Optional<EcoVehicle> ecoVehicle = ecoVehicleCommandService.handle(CreateEcoVehicleCommandFromResourceAssembler.toCommandFromResource(resource));
        return ecoVehicle.map(source -> new ResponseEntity<>(EcoVehicleResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Get eco vehicles by id", description = "Returns the eco vehicle with the specified id")
    @GetMapping("id/{id}")
    public ResponseEntity<EcoVehicleResource> getEcoVehicleById(@PathVariable Long id){
        Optional<EcoVehicle> ecoVehicle = ecoVehicleQueryService.handle(new GetEcoVehicleByIdQuery(id));
        return ecoVehicle.map(source -> new ResponseEntity<>(EcoVehicleResourceFromEntityAssembler.toResourceFromEntity(source), OK)).orElseGet(() -> ResponseEntity.notFound().build());
    }


    private ResponseEntity<List<EcoVehicleResource>> getAllEcoVehicles(){
        var getAllEcoVehiclesQuery = new GetAllEcoVehicleQuery();
        var ecoVehicles = ecoVehicleQueryService.handle(getAllEcoVehiclesQuery);
        if (ecoVehicles.isEmpty()) return ResponseEntity.notFound().build();
        var ecoVehicleResources = ecoVehicles.stream().map(EcoVehicleResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(ecoVehicleResources);
    }

    private ResponseEntity<List<EcoVehicleResource>> getAllEcoVehiclesByType(String type){
        var getAllEcoVehicleByTypeQuery = new GetAllEcoVehicleByTypeQuery(type);
        var ecoVehicles = ecoVehicleQueryService.handle(getAllEcoVehicleByTypeQuery);
        if (ecoVehicles.isEmpty()) return ResponseEntity.notFound().build();
        var ecoVehicleResources = ecoVehicles.stream().map(EcoVehicleResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(ecoVehicleResources);
    }

    private ResponseEntity<List<EcoVehicleResource>> getAllEcoVehiclesByTypeAndModel(String type, String model){
        var getAllEcoVehicleByTypeAndModelQuery = new GetAllEcoVehicleByTypeAndModelQuery(type, model);
        var ecoVehicles = ecoVehicleQueryService.handle(getAllEcoVehicleByTypeAndModelQuery);
        if (ecoVehicles.isEmpty()) return ResponseEntity.notFound().build();
        var ecoVehicleResources = ecoVehicles.stream().map(EcoVehicleResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(ecoVehicleResources);
    }

    private ResponseEntity<List<EcoVehicleResource>> getAllEcoVehiclesByTypeAndStatus(String type, String status){
        var getAllEcoVehicleByTypeAndStatusQuery = new GetAllEcoVehicleByTypeAndStatusQuery(type, status);
        var ecoVehicles = ecoVehicleQueryService.handle(getAllEcoVehicleByTypeAndStatusQuery);
        if (ecoVehicles.isEmpty()) return ResponseEntity.notFound().build();
        var ecoVehicleResources = ecoVehicles.stream().map(EcoVehicleResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(ecoVehicleResources);
    }

    private ResponseEntity<List<EcoVehicleResource>> getAllEcoVehiclesByBatteryLevelGreaterThan(int batteryLevel){
        var getAllEcoVehicleByBatteryLevelGreaterThanQuery = new GetAllEcoVehicleByBatteryLevelGreaterThanQuery(batteryLevel);
        var ecoVehicles = ecoVehicleQueryService.handle(getAllEcoVehicleByBatteryLevelGreaterThanQuery);
        if (ecoVehicles.isEmpty()) return ResponseEntity.notFound().build();
        var ecoVehicleResources = ecoVehicles.stream().map(EcoVehicleResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(ecoVehicleResources);
    }

    @Operation(summary="Get eco vehicles with parameters", description = "Returns the eco vehicles with the specified parameters")
    @GetMapping
    public ResponseEntity<?> getEcoVehiclesWithParameters(@RequestParam Map<String, String> params){
        if(params.containsKey("type") && params.containsKey("model")){
            return getAllEcoVehiclesByTypeAndModel(params.get("type"), params.get("model"));
        }
        else if (params.containsKey("type") && params.containsKey("status")){
            return getAllEcoVehiclesByTypeAndStatus(params.get("type"), params.get("status"));
        }
        else if (params.containsKey("type")){
            return getAllEcoVehiclesByType(params.get("type"));
        }
        else if (params.containsKey("batteryLevel")){
            return getAllEcoVehiclesByBatteryLevelGreaterThan(Integer.parseInt(params.get("batteryLevel")));
        }else{
            return getAllEcoVehicles();
        }
    }
}
