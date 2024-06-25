package com.ecogo.ecomove_web_service.payment.domain.model.commands;

import java.time.LocalDateTime;

/**
 * CreateTransactionCommand
 * <p>Command to Create a Transaction</p>
 * @param userId the id of the user that made the transaction
 * @param amount the amount of money in the transaction
 * @param localDateTime the date when the transaction happened
 */

public record CreateTransactionCommand(Long userId, Float amount, LocalDateTime date) {
    public CreateTransactionCommand{
        if (userId == null || userId <= 0){
            throw new IllegalArgumentException("userId cannot be a null value or less than 1");
        }
        if (amount == null){
            throw new IllegalArgumentException("amount cannot be a null value");
        }
        if (date == null){
            throw new IllegalArgumentException("date cannot be a null value");
        }
    }
}
