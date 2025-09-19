package com.banking.dataAccess.concretes.inmem;

import com.banking.business.exceptions.CardNotFoundException;
import com.banking.dataAccess.abstarcts.CardRepository;
import com.banking.entities.concretes.Card;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCardRepository implements CardRepository {
    private final List<Card> cards = new ArrayList<>();


    @Override
    public void save(String userFin, Card card) {
        cards.add(card);
    }

    @Override
    public void update(Card card) throws CardNotFoundException {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getUserFin().equals(card.getUserFin())) {
                cards.set(i, card);
                return;
            }
        }
        throw new CardNotFoundException("Kart tapılmadı!");
    }

    @Override
    public void delete(String pan) throws CardNotFoundException {
        Card card = findByPan(pan);
        if (card == null) {
            throw new CardNotFoundException("Kart tapılmadı!");
        }
        cards.remove(card);
    }

    @Override
    public Card findByPan(String pan) throws CardNotFoundException {
        for (Card card : cards) {
            if (card.getPan().equals(pan)) {
                return card;
            }
        }
        throw new CardNotFoundException("Kart tapılmadı: " + pan);
    }

    @Override
    public List<Card> findByUserFin(String userFin) throws CardNotFoundException {
        for (Card card : cards) {
            if (card.getUserFin().equals(userFin)) {
                return cards;
            }
        }
        throw new CardNotFoundException("İstifadəçinin FIN: " + userFin + " üçün heç bir kart tapılmadı.");
    }
}
