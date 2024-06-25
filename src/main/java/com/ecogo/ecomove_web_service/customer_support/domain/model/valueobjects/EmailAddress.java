package com.ecogo.ecomove_web_service.customer_support.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
/**
 * Value object for email addresses
 * @param address the email address
 */

@Embeddable
public record EmailAddress(@Email String address) {
    public EmailAddress() { this(null); }
}
