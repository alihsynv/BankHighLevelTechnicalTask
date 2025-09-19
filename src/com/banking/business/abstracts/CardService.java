package com.banking.business.abstracts;

import com.banking.entities.concretes.Card;
import com.banking.entities.enums.CreditCategory;

import java.util.List;

public interface CardService {
    Card createDebitCard(String userFin, String cardName);

    Card createCreditCard(String userFin, String cardName, CreditCategory creditCategory, Double monthlyIncome);

    List<Card> getUserCards(String userFin);

    String getCardDetails(String pan, String fin, String password);

    void blockCard(String pan, String userFin);

    void unblockCard(String pan, String userFin);
}
