package com.banking.dataAccess.concretes.inmem;

import com.banking.dataAccess.abstarcts.CardRepository;
import com.banking.entities.concretes.Card;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCardRepository implements CardRepository {
    private final List<Card> cards = new ArrayList<>();
}
