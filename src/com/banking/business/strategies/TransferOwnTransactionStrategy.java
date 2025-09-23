package com.banking.business.strategies;

import com.banking.business.abstracts.TransactionStrategy;
import com.banking.business.exceptions.CardBlockedException;
import com.banking.business.exceptions.InsufficientBalanceException;
import com.banking.entities.concretes.Card;
import com.banking.entities.concretes.DebitCard;
import com.banking.entities.concretes.Transaction;
import com.banking.entities.enums.TransactionType;

import java.time.LocalDate;

public class TransferOwnTransactionStrategy implements TransactionStrategy {
    private final Card receiverCard;

    public TransferOwnTransactionStrategy(Card receiverCard) {
        this.receiverCard = receiverCard;
    }

    @Override
    public Transaction execute(Card senderCard, Double amount) {
        if (senderCard.isBlocked() || receiverCard.isBlocked()) {
            throw new CardBlockedException("Kart blokdadır!");
        }

        Double senderInitial = ((DebitCard) senderCard).getBalance();
        if (senderInitial < amount) {
            throw new InsufficientBalanceException("Balans kifayət etmir!");
        }

        Double senderFinal = senderInitial - amount;
        ((DebitCard) senderCard).setBalance(senderFinal);

        Double receiverInitial = ((DebitCard) receiverCard).getBalance();
        Double receiverFinal = receiverInitial + amount;
        ((DebitCard) receiverCard).setBalance(receiverFinal);

        return new Transaction(
                null,
                senderCard.getPan(),
                receiverCard.getPan(),
                amount,
                0.0,
                senderInitial,
                senderFinal,
                LocalDate.now(),
                TransactionType.TRANSFER_OWN
        );
    }
}
