package com.example.transaction.controller;

import com.example.transaction.dto.TransactionResponse;
import com.example.transaction.model.Transaction;
import com.example.transaction.model.Status;
import com.example.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController {
    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions")
    public ResponseEntity<?> getTransactions() {
        try {
            List<Transaction> transactions = transactionService.getAllTransactions();
            List<Status> statuses = transactionService.getAllStatuses();
            return ResponseEntity.ok(new TransactionResponse(transactions, statuses));
        } catch (Exception e) {
            logger.error("Error fetching transactions", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching transactions");
        }
    }
}
