package com.example.transaction.service;

import com.example.transaction.model.Transaction;
import com.example.transaction.model.Status;
import com.example.transaction.repository.TransactionRepository;
import com.example.transaction.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
public class TransactionService {
    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private StatusRepository statusRepository;

    public List<Transaction> getAllTransactions() {
        try {
            List<Transaction> transactions = transactionRepository.findAll();
            logger.info("Total transactions retrieved: {}", transactions.size());
            return transactions;
        } catch (Exception e) {
            logger.error("Error retrieving transactions", e);
            throw new RuntimeException("Failed to fetch transactions");
        }
    }

    public List<Status> getAllStatuses() {
        try {
            List<Status> statuses = statusRepository.findAll();
            logger.info("Total statuses retrieved: {}", statuses.size());
            return statuses;
        } catch (Exception e) {
            logger.error("Error retrieving statuses", e);
            throw new RuntimeException("Failed to fetch statuses");
        }
    }
}
