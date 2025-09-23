package com.banking.business.concretes;

import com.banking.business.abstracts.TransactionService;
import com.banking.entities.concretes.Transaction;

import java.util.List;

public class TransactionManager implements TransactionService {
    @Override
    public Transaction createTransaction(Transaction transaction) {
        return null;
    }

    @Override
    public List<Transaction> getTransactionByCard(String pan) {
        return List.of();
    }

    @Override
    public Transaction getTransactionById(Integer id) {
        return null;
    }
}
