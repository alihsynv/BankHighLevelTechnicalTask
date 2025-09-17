package com.banking.entities.concretes;

import com.banking.entities.enums.CardType;

import java.time.LocalDate;

public class DebitCard extends Card {
    private Double balance;

    public DebitCard(String pan, String cardName, CardType cardType, String cvc, Double balance, LocalDate expiryDate, boolean blocked, String userFin) {
        super(pan, cardName, cardType, cvc, expiryDate, blocked, userFin);
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
