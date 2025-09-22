package com.banking.entities.concretes;

import com.banking.entities.abstarcts.BaseEntity;
import com.banking.entities.enums.TransactionType;

import java.time.LocalDate;

public class Transaction implements BaseEntity {
    private final String id;
    private final String senderCardPan;
    private final String receiverCardPan;
    private final Double amount;
    private final Double commission;
    private final Double initialBalance;
    private final Double finalBalance;
    private final LocalDate transactionDate;
    private final TransactionType transactionType;

    public Transaction(String id, String senderCardPan, String receiverCardPan, Double amount, Double commission,
                       Double initialBalance, Double finalBalance, LocalDate transactionDate, TransactionType transactionType) {
        this.id = id;
        this.senderCardPan = senderCardPan;
        this.receiverCardPan = receiverCardPan;
        this.amount = amount;
        this.commission = commission;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
    }

    public String getId() {
        return id;
    }

    public String getSenderCardPan() {
        return senderCardPan;
    }

    public String getReceiverCardName() {
        return receiverCardPan;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getCommission() {
        return commission;
    }

    public Double getInitialBalance() {
        return initialBalance;
    }

    public Double getFinalBalance() {
        return finalBalance;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}
