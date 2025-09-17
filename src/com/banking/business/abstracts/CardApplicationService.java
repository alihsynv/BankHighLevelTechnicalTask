package com.banking.business.abstracts;

import com.banking.entities.concretes.Card;
import com.banking.entities.concretes.CreditCard;
import com.banking.entities.enums.CreditCategory;

public interface CardApplicationService {
    Card applyForDebitCard(String userFin, String cardName);

    Card applyForCreditCard(String userFin, String cardName, CreditCategory creditCategory, Double monthlyIncome);

    Card setCreditLimit(CreditCard CreditCard, Double chosenLimit);

    void cancelApplication(String userFin);
}
