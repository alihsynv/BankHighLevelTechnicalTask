package com.banking.dataAccess.concretes.inmem;

import com.banking.business.exceptions.TransactionNotFoundException;
import com.banking.dataAccess.abstarcts.TransactionRepository;
import com.banking.entities.concretes.Transaction;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTransactionRepository implements TransactionRepository {
    List<Transaction> transactions = new ArrayList<>();

    @Override
    public void add(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public void update(Transaction transaction) throws TransactionNotFoundException {
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getId().equals(transaction.getId())) {
                transactions.set(i, transaction);
            }
        }
        throw new TransactionNotFoundException("Tranzaksiya tapılmadı!");
    }

    @Override
    public void delete(Integer id) throws TransactionNotFoundException {
        Transaction transaction = getById(id);
        if (transaction == null) {
            throw new TransactionNotFoundException("Tranzaksiya tapılmadı!");
        }
        transactions.remove(transaction);
    }

    @Override
    public Transaction getById(Integer id) throws TransactionNotFoundException {
        for (Transaction transaction : transactions) {
            if (transaction.getId().equals(id)) {
                return transaction;
            }
        }
        throw new TransactionNotFoundException("Tranzaksiya tapılmadı!");
    }

    @Override
    public List<Transaction> getByCardPan(String pan) throws TransactionNotFoundException {
        for (Transaction transaction : transactions) {
            if (transaction.getSenderCardPan().equals(pan) || transaction.getReceiverCardName().equals(pan)) {
                return transactions;
            }
        }
        throw new TransactionNotFoundException("Tranzaksiya tapılmadı!");
    }
}
