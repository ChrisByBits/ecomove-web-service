package com.ecogo.ecomove_web_service.customer_support.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
/**
 * Value object for person names
 * @param firstName the first name
 * @param lastName the last name
 */
@Embeddable
public record PersonName(String firstName, String lastName) {
    public PersonName() { this(null, null); }

    public PersonName {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or blank");
        }
    }
    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}