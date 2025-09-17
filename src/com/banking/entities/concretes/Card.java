package com.banking.entities.concretes;

import com.banking.entities.abstarcts.BaseEntity;
import com.banking.entities.enums.CardType;

import java.time.LocalDate;

public abstract class Card implements BaseEntity {
    private String pan;
    private String cardName;
    private CardType cardType;
    private String cvc;
    private Double balance;
    private LocalDate expiryDate;
    private boolean blocked;
    private String userFin;

    public Card(String pan, String cardName, CardType cardType, String cvc, Double balance, LocalDate expiryDate, boolean blocked, String userFin) {
        this.pan = pan;
        this.cardName = cardName;
        this.cardType = cardType;
        this.cvc = cvc;
        this.balance = balance;
        this.expiryDate = expiryDate;
        this.blocked = blocked;
        this.userFin = userFin;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getUserFin() {
        return userFin;
    }

    public void setUserFin(String userFin) {
        this.userFin = userFin;
    }
}
