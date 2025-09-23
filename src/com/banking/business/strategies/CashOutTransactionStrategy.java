package com.banking.business.strategies;

import com.banking.business.abstracts.TransactionStrategy;
import com.banking.business.exceptions.CardBlockedException;
import com.banking.business.exceptions.InsufficientBalanceException;
import com.banking.business.exceptions.InsufficientLimitException;
import com.banking.business.exceptions.InvalidCardTypeException;
import com.banking.core.exceptions.BaseException;
import com.banking.entities.concretes.Card;
import com.banking.entities.concretes.CreditCard;
import com.banking.entities.concretes.DebitCard;
import com.banking.entities.concretes.Transaction;
import com.banking.entities.enums.CardType;
import com.banking.entities.enums.TransactionType;

import java.time.LocalDate;

public class CashOutTransactionStrategy implements TransactionStrategy {
    private final Double commissionRate;

    public CashOutTransactionStrategy(Double commissionRate) throws BaseException {
        this.commissionRate = commissionRate;
    }


    @Override
    public Transaction execute(Card card, Double amount) {
        if (card.isBlocked()) {
            throw new CardBlockedException("Kart blokdadır!");
        }

        Double commission = amount * commissionRate;
        Double initialBalance;
        Double finalBalance;

        if (card.getCardType() == CardType.DEBIT) {
            DebitCard debitCard = (DebitCard) card;
            initialBalance = debitCard.getBalance();

            if (initialBalance < amount + commission) {
                throw new InsufficientBalanceException("Balans kifayət etmir!");
            }

            finalBalance = initialBalance - (amount + commission);
            debitCard.setBalance(finalBalance);
        } else if (card.getCardType() == CardType.CREDIT) {
            CreditCard creditCard = (CreditCard) card;
            initialBalance = creditCard.getCreditLimit();

            if (initialBalance < amount + commission) {
                throw new InsufficientLimitException("Kredit limiti kifayət etmir!");
            }

            finalBalance = initialBalance - (amount + commission);
            creditCard.setCreditLimit(finalBalance);
        } else {
            throw new InvalidCardTypeException("Naməlum kart tipi!");
        }

        return new Transaction(
                null,
                card.getPan(),
                null,
                amount,
                commission,
                initialBalance,
                finalBalance,
                LocalDate.now(),
                TransactionType.CASH_OUT
        );
    }
}
