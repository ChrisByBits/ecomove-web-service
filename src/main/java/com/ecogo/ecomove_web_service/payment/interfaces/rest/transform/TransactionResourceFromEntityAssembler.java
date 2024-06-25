package com.ecogo.ecomove_web_service.payment.interfaces.rest.transform;

import com.ecogo.ecomove_web_service.payment.domain.model.aggregates.Transaction;
import com.ecogo.ecomove_web_service.payment.interfaces.rest.resources.TransactionResource;

public class TransactionResourceFromEntityAssembler {
    public static TransactionResource toResourceFromEntity(Transaction entity){
        return new TransactionResource(
                entity.getId(),
                entity.getUser().getId(),
                entity.getAmount(),
                entity.getDate()
        );
    }
}
