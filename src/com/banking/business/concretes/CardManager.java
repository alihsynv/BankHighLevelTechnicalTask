package com.banking.business.concretes;

import com.banking.business.abstracts.CardService;
import com.banking.business.factories.CardFactory;
import com.banking.dataAccess.abstarcts.CardRepository;
import com.banking.entities.concretes.Card;
import com.banking.entities.enums.CreditCategory;

import java.util.List;

public class CardManager implements CardService {
    private final CardRepository cardRepository;

    public CardManager(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card createDebitCard(String userFin, String cardName) {
        Card card = CardFactory.createDebitCard(cardName, userFin);
        cardRepository.save(userFin, card);
        return card;
    }

    @Override
    public Card createCreditCard(String userFin, String cardName, CreditCategory creditCategory, Double monthlyIncome) {
        Card card = CardFactory.createCreditCard(cardName, userFin, creditCategory, monthlyIncome);
        cardRepository.save(userFin, card);
        return card;
    }

    @Override
    public List<Card> getUserCards(String userFin) {
        return cardRepository.findByUserFin(userFin);
    }

    @Override
    public Card getCardByPan(String pan) {
        return cardRepository.findByPan(pan);
    }

    @Override
    public void blockCard(String pan , String userFin) {
        Card card = CardFactory.createDebitCard(pan,  userFin);
        if (!card.isBlocked()) {
            card.setBlocked(true);
        }
    }

    @Override
    public void unblockCard(String pan, String userFin) {
        Card card = CardFactory.createDebitCard(pan, userFin);
        if (card.isBlocked()) {
            card.setBlocked(false);
        }
    }
}
