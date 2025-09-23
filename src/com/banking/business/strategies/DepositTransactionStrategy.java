package com.banking.business.strategies;

import com.banking.business.abstracts.TransactionStrategy;
import com.banking.business.exceptions.CardBlockedException;
import com.banking.business.exceptions.InvalidCardTypeException;
import com.banking.core.exceptions.BaseException;
import com.banking.entities.concretes.Card;
import com.banking.entities.concretes.CreditCard;
import com.banking.entities.concretes.DebitCard;
import com.banking.entities.concretes.Transaction;
import com.banking.entities.enums.CardType;
import com.banking.entities.enums.TransactionType;

import java.time.LocalDate;

public class DepositTransactionStrategy implements TransactionStrategy {
    @Override
    public Transaction execute(Card card, Double amount) throws BaseException {
        if (card.isBlocked()) {
            throw new CardBlockedException("Kart blokdadır!");
        }

        Double initialBalance;
        Double finalBalance;

        if (card.getCardType() == CardType.DEBIT) {
            DebitCard debitCard = (DebitCard) card;
            initialBalance = debitCard.getBalance();
            finalBalance = initialBalance + amount;
            debitCard.setBalance(finalBalance);
        } else if (card.getCardType() == CardType.CREDIT) {
            CreditCard creditCard = (CreditCard) card;
            initialBalance = creditCard.getCreditLimit();
            finalBalance = initialBalance + amount;
            creditCard.setCreditLimit(finalBalance);
        } else {
            throw new InvalidCardTypeException("Naməlum kart tipi!");
        }

        return new Transaction(
                null,
                null,
                card.getPan(),
                amount,
                0.0,
                initialBalance,
                finalBalance,
                LocalDate.now(),
                TransactionType.DEPOSIT
        );
    }
}
