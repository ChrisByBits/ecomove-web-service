package com.ecogo.ecomove_web_service.customer_support.domain.model.entity;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates.Ticket;
import com.ecogo.ecomove_web_service.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;
/**
 * Entity for ticket categories
 */
@Getter
@Entity
public class TicketCategory {
    /** The unique identifier of the ticket category */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The name of the ticket category */
    @Column
    private String name;

    public TicketCategory(){}

    public TicketCategory(String name){
        this.name = name;
    }

}
