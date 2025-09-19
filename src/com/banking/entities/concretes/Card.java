package com.banking.entities.concretes;

import com.banking.entities.abstarcts.BaseEntity;
import com.banking.entities.enums.CardType;

import java.time.LocalDate;
import java.util.List;

public abstract class Card implements BaseEntity {
    private final String pan;
    private final String cardName;
    private final CardType cardType;
    private final String cvc;
    private final LocalDate expiryDate;
    private boolean blocked;
    private String userFin;
    private List<String> operationHistories;

    public Card(String pan, String cardName, CardType cardType, String cvc, LocalDate expiryDate, boolean blocked, String userFin) {
        this.pan = pan;
        this.cardName = cardName;
        this.cardType = cardType;
        this.cvc = cvc;
        this.expiryDate = expiryDate;
        this.blocked = blocked;
        this.userFin = userFin;
    }

    public String getPan() {
        return pan;
    }


    public String getCardName() {
        return cardName;
    }

    public CardType getCardType() {
        return cardType;
    }


    public String getCvc() {
        return cvc;
    }


    public LocalDate getExpiryDate() {
        return expiryDate;
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
