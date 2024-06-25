package com.ecogo.ecomove_web_service.customer_support.domain.model.entity;

import com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates.Ticket;
import com.ecogo.ecomove_web_service.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class TicketCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public TicketCategory(){}

    public TicketCategory(String name){
        this.name = name;
    }

}
