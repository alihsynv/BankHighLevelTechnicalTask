package com.banking.service.strategies;

import com.banking.service.abstracts.TransactionStrategy;
import com.banking.exceptions.custom.CardBlockedException;
import com.banking.entities.concretes.Card;
import com.banking.entities.concretes.DebitCard;
import com.banking.entities.concretes.Transaction;
import com.banking.entities.enums.TransactionType;

import java.time.LocalDate;

public class TransferInStrategy implements TransactionStrategy {
    private final String senderPan;

    public TransferInStrategy(String senderPan) {
        this.senderPan = senderPan;
    }

    @Override
    public Transaction execute(Card receiverCard, Double amount) {
        if (receiverCard.isBlocked()) {
            throw new CardBlockedException("Kart blokdadır!");
        }

        Double initialBalance = ((DebitCard) receiverCard).getBalance();
        Double finalBalance = initialBalance + amount;
        ((DebitCard) receiverCard).setBalance(finalBalance);

        return new Transaction(
                null,
                senderPan,
                receiverCard.getPan(),
                amount,
                0.0,
                initialBalance,
                finalBalance,
                LocalDate.now(),
                TransactionType.TRANSFER_IN
        );
    }
}
