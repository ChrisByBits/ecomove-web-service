package com.ecogo.ecomove_web_service.vehicle_management.domain.model.aggregates;

import com.ecogo.ecomove_web_service.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.ecogo.ecomove_web_service.vehicle_management.domain.model.commands.CreateEcoVehicleCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class EcoVehicle extends AuditableAbstractAggregateRoot<EcoVehicle> {

    /** The unique identifier of the EcoVehicle */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    /** The type of the EcoVehicle */
    @Column(nullable = false)
    @Getter
    private String type;

    /** The model of the EcoVehicle */
    @Column(nullable = false)
    @Getter
    private String model;

    /** The batteryLevel of the EcoVehicle */
    @Column(nullable = false)
    @Getter
    private int batteryLevel;

    /** The location of the EcoVehicle */
    @Column(nullable = false)
    @Getter
    private Double longitude;

    @Column(nullable = false)
    @Getter
    private Double latitude;

    /** The status of the EcoVehicle */
    @Column(nullable = false)
    @Getter
    private String status;

    /** The imageUrl of the EcoVehicle */
    @Column(nullable = false)
    @Getter
    private String imageUrl;

    /** The date when the EcoVehicle was created */
//    @CreatedDate
//    @Column(nullable = false, updatable = false)
//    private Date createdAt;
//
//    /** The date when the EcoVehicle was last updated */
//    @LastModifiedDate
//    @Column(nullable = false, updatable = false)
//    private Date updatedAt;
//

    protected EcoVehicle(){}

    /**
     * Create an EcoVehicle
     * @param command the CreateEcoVehicleCommand command containing the data to create an EcoVehicle
     */
    public EcoVehicle(CreateEcoVehicleCommand command){
        this.type = command.type();
        this.model = command.model();
        this.batteryLevel = command.batteryLevel();
        this.longitude = command.longitude();
        this.latitude = command.latitude();
        this.status = command.status();
        this.imageUrl = command.imageUrl();
    }
}
