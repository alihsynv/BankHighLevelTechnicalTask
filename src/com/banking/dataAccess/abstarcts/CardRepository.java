package com.banking.dataAccess.abstarcts;

import com.banking.entities.concretes.Card;

import java.util.List;

public interface CardRepository extends Repository<Card, String> {
    void save(String userFin, Card card);

    void update(Card card);

    void delete(String pan);

    Card findByPan(String pan);

    List<Card> findByUserFin(String userFin);
}
