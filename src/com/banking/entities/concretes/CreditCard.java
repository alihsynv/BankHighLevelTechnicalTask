package com.banking.entities.concretes;

import com.banking.entities.enums.CreditCategory;

import java.time.LocalDate;

public class CreditCard extends Card{
    private CreditCategory creditCategory;
    private Double creditLimit;

    public CreditCard(String cardName, String cardNumber, LocalDate createdDate, LocalDate expiryDate) {
        super(cardName, cardNumber, createdDate, expiryDate);
    }
}
