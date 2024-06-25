package com.ecogo.ecomove_web_service.customer_support.domain.model.aggrgates;

import com.ecogo.ecomove_web_service.customer_support.domain.model.commands.CreateTicketCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    private String ticketId;

    @Column(nullable = false)
    @Getter
    private String title;

    @Column(nullable = false)
    @Getter
    private String description;

    @Column(nullable = false)
    @Getter
    private String category;

    @Column(nullable = false)
    @Getter
    private String status;

    @Column(nullable = false)
    @Getter
    private String assigneeID;

    @Column(nullable = false)
    @Getter
    private String userID;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;

    protected Ticket() {}

    public Ticket(CreateTicketCommand command) {
        this.ticketId = command.ticketId();
        this.title = command.title();
        this.description = command.description();
        this.category = command.category();
        this.status = command.status();
        this.assigneeID = command.assigneeID();
        this.userID = command.userID();
    }
}
