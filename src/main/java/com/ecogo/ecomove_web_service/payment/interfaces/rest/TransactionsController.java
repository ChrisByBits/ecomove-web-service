package com.ecogo.ecomove_web_service.payment.interfaces.rest;

import com.ecogo.ecomove_web_service.payment.domain.model.aggregates.Transaction;
import com.ecogo.ecomove_web_service.payment.domain.model.queries.GetAllTransactionsByDateQuery;
import com.ecogo.ecomove_web_service.payment.domain.model.queries.GetAllTransactionsByUserIdQuery;
import com.ecogo.ecomove_web_service.payment.domain.model.queries.GetTransactionByTransactionIdQuery;
import com.ecogo.ecomove_web_service.payment.domain.services.TransactionCommandService;
import com.ecogo.ecomove_web_service.payment.domain.services.TransactionQueryService;
import com.ecogo.ecomove_web_service.payment.interfaces.rest.resources.CreateTransactionResource;
import com.ecogo.ecomove_web_service.payment.interfaces.rest.resources.TransactionResource;
import com.ecogo.ecomove_web_service.payment.interfaces.rest.transform.CreateTransactionCommandFromResourceAssembler;
import com.ecogo.ecomove_web_service.payment.interfaces.rest.transform.TransactionResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionsController {
    private final TransactionCommandService transactionCommandService;
    private final TransactionQueryService transactionQueryService;

    public TransactionsController(TransactionCommandService transactionCommandService, TransactionQueryService transactionQueryService) {
        this.transactionCommandService = transactionCommandService;
        this.transactionQueryService = transactionQueryService;
    }

    @PostMapping
    public ResponseEntity<TransactionResource> createTransaction(@RequestBody CreateTransactionResource createTransactionResource) {
        Optional<Transaction> transaction = transactionCommandService.handle(CreateTransactionCommandFromResourceAssembler.fromResource(createTransactionResource));
        return transaction.map(t -> new ResponseEntity<>(TransactionResourceFromEntityAssembler.fromEntity(t), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("{transactionId}")
    public ResponseEntity<TransactionResource> getTransactionById(@PathVariable Long transactionId) {
        Optional<Transaction> transaction = transactionQueryService.handle(new GetTransactionByTransactionIdQuery(transactionId));
        return transaction.map(t -> new ResponseEntity<>(TransactionResourceFromEntityAssembler.fromEntity(t), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<TransactionResource>> getAllTransactionsByUserId(@PathVariable Long userId) {
        var getAllTransactionsByUserIdQuery = new GetAllTransactionsByUserIdQuery(userId);
        var transactions = transactionQueryService.handle(getAllTransactionsByUserIdQuery);
        if (transactions.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var transactionResources = transactions.stream().map(TransactionResourceFromEntityAssembler::fromEntity).toList();
        return ResponseEntity.ok(transactionResources);
    }

    @GetMapping("date/{date}")
    public ResponseEntity<List<TransactionResource>> getAllTransactionsByDate(@PathVariable LocalDateTime date) {
        var getAllTransactionsByDateQuery = new GetAllTransactionsByDateQuery(date);
        var transactions = transactionQueryService.handle(getAllTransactionsByDateQuery);
        if (transactions.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var transactionResources = transactions.stream().map(TransactionResourceFromEntityAssembler::fromEntity).toList();
        return ResponseEntity.ok(transactionResources);
    }
}
