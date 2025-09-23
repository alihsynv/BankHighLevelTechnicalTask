package com.banking.dataAccess.abstarcts;

import com.banking.entities.concretes.Transaction;

import java.util.List;

public interface TransactionRepository extends Repository<Transaction, String> {
    void add(Transaction transaction);

    void update(Transaction transaction);

    void delete(String id);

    Transaction getById(String id);

    List<Transaction> getByCardPan(String pan);
}
