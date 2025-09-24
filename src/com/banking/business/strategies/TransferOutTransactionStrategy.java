package com.banking.business.strategies;

import com.banking.business.abstracts.TransactionStrategy;
import com.banking.business.exceptions.CardBlockedException;
import com.banking.business.exceptions.InsufficientBalanceException;
import com.banking.entities.concretes.Card;
import com.banking.entities.concretes.DebitCard;
import com.banking.entities.concretes.Transaction;
import com.banking.entities.enums.TransactionType;

import java.time.LocalDate;

public class TransferOutTransactionStrategy implements TransactionStrategy {
    private final String receiverPan;
    private final double commissionRate;

    public TransferOutTransactionStrategy(String receiverPan, double commissionRate) {
        this.receiverPan = receiverPan;
        this.commissionRate = commissionRate;
    }


    @Override
    public Transaction execute(Card senderCard, Double amount) {
        if (senderCard.isBlocked()) {
            throw new CardBlockedException("Kart blokdadır!");
        }

        Double commission = amount * commissionRate;
        Double initialBalance = ((DebitCard) senderCard).getBalance();

        if (initialBalance < amount + commission) {
            throw new InsufficientBalanceException("Balans kifayət etmir!");
        }

        Double finalBalance = initialBalance - (amount + commission);
        ((DebitCard) senderCard).setBalance(finalBalance);

        return new Transaction(
                null,
                senderCard.getPan(),
                receiverPan,
                amount,
                commission,
                initialBalance,
                finalBalance,
                LocalDate.now(),
                TransactionType.TRANSFER_OUT
        );
    }
}
