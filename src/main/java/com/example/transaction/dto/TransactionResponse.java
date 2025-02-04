package com.example.transaction.dto;

import com.example.transaction.model.Transaction;
import com.example.transaction.model.Status;
import java.util.List;

public class TransactionResponse {
    private List<Transaction> data;
    private List<Status> status;

    public TransactionResponse(List<Transaction> data, List<Status> status) {
        this.data = data;
        this.status = status;
    }

    public List<Transaction> getData() {
        return data;
    }

    public void setData(List<Transaction> data) {
        this.data = data;
    }

    public List<Status> getStatus() {
        return status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }
}