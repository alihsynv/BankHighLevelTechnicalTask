package com.banking.dataAccess.abstarcts;

import com.banking.entities.concretes.Transaction;

import java.util.List;

public interface TransactionRepository extends Repository<Transaction, String> {
    void add(Transaction transaction);

    void update(Transaction transaction);

    void delete(Integer id);

    Transaction getById(Integer id);

    List<Transaction> getByCardPan(String pan);
}
