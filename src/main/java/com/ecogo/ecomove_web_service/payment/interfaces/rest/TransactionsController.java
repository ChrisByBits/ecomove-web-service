package com.ecogo.ecomove_web_service.payment.interfaces.rest;

import com.ecogo.ecomove_web_service.payment.domain.model.aggregates.Transaction;
import com.ecogo.ecomove_web_service.payment.domain.model.queries.GetAllTransactionsByDateQuery;
import com.ecogo.ecomove_web_service.payment.domain.model.queries.GetAllTransactionsByUserIdQuery;
import com.ecogo.ecomove_web_service.payment.domain.model.queries.GetAllTransactionsQuery;
import com.ecogo.ecomove_web_service.payment.domain.model.queries.GetTransactionByIdQuery;
import com.ecogo.ecomove_web_service.payment.domain.services.TransactionCommandService;
import com.ecogo.ecomove_web_service.payment.domain.services.TransactionQueryService;
import com.ecogo.ecomove_web_service.payment.interfaces.rest.resources.CreateTransactionResource;
import com.ecogo.ecomove_web_service.payment.interfaces.rest.resources.TransactionResource;
import com.ecogo.ecomove_web_service.payment.interfaces.rest.transform.CreateTransactionCommandFromResourceAssembler;
import com.ecogo.ecomove_web_service.payment.interfaces.rest.transform.TransactionResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/transactions")
@Tag(name="Transactions", description = "Transactions Management Endpoints")
public class TransactionsController {
    private final TransactionQueryService transactionQueryService;
    private final TransactionCommandService transactionCommandService;

    public TransactionsController(TransactionQueryService transactionQueryService, TransactionCommandService transactionCommandService){
        this.transactionQueryService = transactionQueryService;
        this.transactionCommandService = transactionCommandService;
    }

    @Operation(summary = "Create a new transaction", description = "Create a new transaction with the specified data")
    @PostMapping
    public ResponseEntity<TransactionResource> createTransaction(@RequestBody CreateTransactionResource resource){
        Optional<Transaction> transaction = transactionCommandService.handle(CreateTransactionCommandFromResourceAssembler.toCommandFromResource(resource));
        return transaction.map(source -> new ResponseEntity<>(TransactionResourceFromEntityAssembler.toResourceFromEntity(source), CREATED)).orElseGet(()->ResponseEntity.badRequest().build());
    }

    @Operation(summary = "Get all transactions", description = "Returns all the transactions in the database")
    @GetMapping
    public ResponseEntity<List<TransactionResource>> getAllTransactions(){
        var getAllTransactionsQuery = new GetAllTransactionsQuery();
        var transactions = transactionQueryService.handle(getAllTransactionsQuery);
        if (transactions.isEmpty()) return ResponseEntity.notFound().build();
        var transactionResources = transactions.stream().map(TransactionResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(transactionResources);
    }

    @Operation(summary = "Get transaction by transaction Id", description = "Returns the transactions with the specified id")
    @GetMapping("{transactionId}")
    public ResponseEntity<TransactionResource> getAllTransactions(@PathVariable Long transactionId){
        var getTransactionByIdQuery = new GetTransactionByIdQuery(transactionId);
        var transaction = transactionQueryService.handle(getTransactionByIdQuery);
        return transaction.map(source -> new ResponseEntity<>(TransactionResourceFromEntityAssembler.toResourceFromEntity(source), OK)).orElseGet(()->ResponseEntity.notFound().build());
    }

    @Operation(summary = "Get all transactions by user id", description = "Returns all the transactions made by the user with the specified id")
    @GetMapping("user/{userId}")
    public ResponseEntity<List<TransactionResource>> getAllTransactionsByUserId(@PathVariable Long userId){
        var getAllTransactionsByUserIdQuery = new GetAllTransactionsByUserIdQuery(userId);
        var transactions = transactionQueryService.handle(getAllTransactionsByUserIdQuery);
        if (transactions.isEmpty()) return ResponseEntity.notFound().build();
        var transactionResources = transactions.stream().map(TransactionResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(transactionResources);
    }

    @Operation(summary = "Get all transactions by date", description = "Returns all the transactions made during the specified date")
    @GetMapping("date/")
    public ResponseEntity<List<TransactionResource>> getAllTransactionsByUserId(@RequestParam LocalDateTime date){
        var getAllTransactionsByDateQuery = new GetAllTransactionsByDateQuery(date);
        var transactions = transactionQueryService.handle(getAllTransactionsByDateQuery);
        if (transactions.isEmpty()) return ResponseEntity.notFound().build();
        var transactionResources = transactions.stream().map(TransactionResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(transactionResources);
    }

}
