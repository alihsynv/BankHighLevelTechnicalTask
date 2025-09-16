package com.banking.entities.concretes;

import com.banking.dataAccess.abstarcts.UserRepository;
import com.banking.entities.abstarcts.BaseEntity;

import java.time.LocalDate;

public abstract class Card implements BaseEntity {
    private String cardName;
    private String cardNumber;
    private LocalDate createdDate;
    private LocalDate expiryDate;

    public Card(String cardName, String cardNumber, LocalDate createdDate, LocalDate expiryDate) {
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.createdDate = createdDate;
        this.expiryDate = expiryDate;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
