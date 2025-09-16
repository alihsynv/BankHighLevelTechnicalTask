package com.banking.entities.concretes;

import com.banking.entities.enums.CreditCategory;

import java.time.LocalDate;

public class DebitCard extends Card {
    private Double balance;

    public DebitCard(String cardName, String cardNumber, LocalDate createdDate, LocalDate expiryDate) {
        super(cardName, cardNumber, createdDate, expiryDate);
    }
}
