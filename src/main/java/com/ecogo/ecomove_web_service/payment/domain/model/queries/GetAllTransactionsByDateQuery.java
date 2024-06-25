package com.ecogo.ecomove_web_service.payment.domain.model.queries;


import java.time.LocalDateTime;
/**
 * Query to get all transactions by Date
 */
public record GetAllTransactionsByDateQuery(LocalDateTime date) {
}
