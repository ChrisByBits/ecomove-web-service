package com.ecogo.ecomove_web_service.payment.interfaces.rest.transform;

import com.ecogo.ecomove_web_service.payment.domain.model.commands.CreateTransactionCommand;
import com.ecogo.ecomove_web_service.payment.interfaces.rest.resources.CreateTransactionResource;

public class CreateTransactionCommandFromResourceAssembler {
    public static CreateTransactionCommand fromResource(CreateTransactionResource createTransactionResource) {
        return new CreateTransactionCommand(createTransactionResource.userId(), createTransactionResource.amount());
    }
}
