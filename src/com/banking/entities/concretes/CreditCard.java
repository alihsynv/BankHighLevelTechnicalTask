package com.banking.entities.concretes;

import com.banking.entities.enums.CardType;
import com.banking.entities.enums.CreditCategory;

import java.time.LocalDate;

public class CreditCard extends Card{
    private CreditCategory creditCategory;
    private Double creditLimit;
    private Double monthlyIncome;

    public CreditCard(String pan, String cardName, CardType cardType, String cvc, Double balance, LocalDate createdDate,
                      LocalDate expiryDate, boolean blocked, String userFin, CreditCategory creditCategory, Double creditLimit, Double monthlyIncome) {
        super(pan, cardName, cardType, cvc, balance, expiryDate, blocked, userFin);
        this.creditCategory = creditCategory;
        this.creditLimit = creditLimit;
        this.monthlyIncome = monthlyIncome;
    }

    public CreditCategory getCreditCategory() {
        return creditCategory;
    }

    public void setCreditCategory(CreditCategory creditCategory) {
        this.creditCategory = creditCategory;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }
}
