package com.banking.business.abstracts;

import com.banking.entities.concretes.Card;
import com.banking.entities.concretes.Transaction;

public interface TransactionStrategy {
    Transaction execute(Card card, Double amount);
}
