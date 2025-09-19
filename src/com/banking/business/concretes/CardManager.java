package com.banking.business.concretes;

import com.banking.business.abstracts.CardService;
import com.banking.business.exceptions.CardNotFoundException;
import com.banking.business.exceptions.UserNotFoundException;
import com.banking.business.factories.CardFactory;
import com.banking.dataAccess.abstarcts.CardRepository;
import com.banking.dataAccess.abstarcts.UserRepository;
import com.banking.entities.concretes.Card;
import com.banking.entities.concretes.User;
import com.banking.entities.enums.CreditCategory;

import java.util.List;

public class CardManager implements CardService {
    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    public CardManager(CardRepository cardRepository, UserRepository userRepository) {
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
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
    public String getCardDetails(String pan, String fin, String password) {
        Card card = cardRepository.findByPan(pan);
        if (card == null) {
            throw new CardNotFoundException("Kart tapılmadı!");
        }

        User user = userRepository.getUserByFin(fin);
        if (user == null) {
            throw new UserNotFoundException("İstifadəçi tapılmadı!");
        }

        String details = "PAN: " + card.getPan() + "\n" + "Etibarlılıq müddəti: " + card.getExpiryDate();

        if (user.getPassword().equals(password)) {
            details += "\nCVC: " + card.getCvc();
        }

        return details;
    }

    @Override
    public void blockCard(String pan, String userFin) {
        Card card = CardFactory.createDebitCard(pan, userFin);
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
