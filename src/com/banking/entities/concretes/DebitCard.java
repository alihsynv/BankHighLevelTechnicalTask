package com.banking.entities.concretes;

import com.banking.entities.enums.CardType;
import com.banking.entities.enums.CreditCategory;

import java.time.LocalDate;

public class DebitCard extends Card {
    private Double balance;

    public DebitCard(String pan, String cardName, CardType cardType, String cvc, Double balance, LocalDate createdDate, LocalDate expiryDate, boolean blocked, String userFin) {
        super(pan, cardName, cardType, cvc, balance, expiryDate, blocked, userFin);
    }
}
