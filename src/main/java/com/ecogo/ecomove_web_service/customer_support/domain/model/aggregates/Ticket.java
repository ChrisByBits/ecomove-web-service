package com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates;

import com.ecogo.ecomove_web_service.customer_support.domain.model.entity.TicketCategory;
import com.ecogo.ecomove_web_service.customer_support.domain.model.valueobjects.TicketStatus;
import com.ecogo.ecomove_web_service.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.ecogo.ecomove_web_service.user_management.domain.model.aggregates.User;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Ticket extends AuditableAbstractAggregateRoot<Ticket> {
    /** The unique identifier of the ticket */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="customerSupportAgent_id")
    private CustomerSupportAgent customerSupportAgent;

    @ManyToOne
    @JoinColumn(name="category_id")
    private TicketCategory category;

    @Column(nullable = false)
    private TicketStatus status;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    public Ticket(){

    }

    public Ticket(User user,CustomerSupportAgent assignee, TicketCategory category, String title, String description){
        this.user = user;
        this.customerSupportAgent = assignee;
        this.category = category;
        this.title = title;
        this.description = description;
        this.status = TicketStatus.REQUESTED;
    }

    public void solve(){
        this.status = TicketStatus.SOLVED;
    }
    public void cancel(){
        this.status = TicketStatus.CANCELLED;
    }
    public void close(){this.status = TicketStatus.CLOSED;}

    public String getStatus() {
        return this.status.name().toLowerCase();
    }
}
