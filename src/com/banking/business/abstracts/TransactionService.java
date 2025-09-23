package com.banking.business.abstracts;

import com.banking.entities.concretes.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);

    List<Transaction> getTransactionByCard(String pan);

    Transaction getTransactionById(Integer id);


}
