package com.ecogo.ecomove_web_service.customer_support.domain.model.aggregates;

import com.ecogo.ecomove_web_service.customer_support.domain.model.valueobjects.EmailAddress;
import com.ecogo.ecomove_web_service.customer_support.domain.model.valueobjects.PersonName;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
@Entity
public class CustomerSupportAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private EmailAddress email;

    @Embedded
    private PersonName name;

    public CustomerSupportAgent(){

    }
    public CustomerSupportAgent(String email, String firstName, String lastName){
        this.email = new EmailAddress(email);
        this.name = new PersonName(firstName, lastName);
    }
    public CustomerSupportAgent(EmailAddress email, PersonName name){
        this.email = email;
        this.name = name;
    }



}
