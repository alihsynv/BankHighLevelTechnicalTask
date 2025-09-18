package com.banking.business.concretes;

import com.banking.business.abstracts.CardApplicationService;
import com.banking.business.exceptions.CardNotFoundException;
import com.banking.business.exceptions.InvalidFinException;
import com.banking.business.exceptions.InvalidLimitException;
import com.banking.business.exceptions.UserNotFoundException;
import com.banking.business.factories.CardFactory;
import com.banking.dataAccess.abstarcts.UserRepository;
import com.banking.entities.concretes.Card;
import com.banking.entities.concretes.CreditCard;
import com.banking.entities.enums.CreditCategory;

public class CardApplicationManager implements CardApplicationService {
    private final UserRepository userRepository;
    private final CardManager cardManager;

    public CardApplicationManager(UserRepository userRepository, CardManager cardManager) {
        this.userRepository = userRepository;
        this.cardManager = cardManager;
    }

    @Override
    public Card applyForDebitCard(String userFin, String cardName) throws UserNotFoundException {
        if (!userRepository.findByFin(userFin)) {
            throw new UserNotFoundException("İstifadəçi tapılmadı: " + userFin);
        }
        return cardManager.createDebitCard(userFin, cardName);
    }

    @Override
    public Card applyForCreditCard(String userFin, String cardName, CreditCategory creditCategory, Double monthlyIncome) {
        if (!userRepository.findByFin(userFin)) {
            throw new UserNotFoundException("İstifadəçi tapılmadı: " + userFin);
        }
        return cardManager.createCreditCard(userFin, cardName, creditCategory, monthlyIncome);
    }

    @Override
    public Card setCreditLimit(CreditCard creditCard, Double chosenLimit) throws InvalidLimitException {
        if (chosenLimit <= 0) {
            throw new InvalidLimitException("Kredit limiti mənfi və ya 0 ola bilməz!");
        }
        if (chosenLimit > CardFactory.calculateCreditLimit(creditCard.getCreditCategory(), creditCard.getMonthlyIncome())) {
            throw new InvalidLimitException("Seçilmiş limit maksimum təklif olunan limitdən böyük ola bilməz!");
        }
        creditCard.setCreditLimit(chosenLimit);
        return creditCard;
    }

    @Override
    public void cancelApplication(String userFin) {
        var user = userRepository.getUserByFin(userFin);
        if (user == null) {
            throw new InvalidFinException("Belə FIN ilə istifadəçi tapılmadı!");
        }
        if (user.getCards().isEmpty()) {
            throw new CardNotFoundException("İstifadəçinin heç bir kart müraciəti yoxdur!");
        }
        user.getCards().clear();
        userRepository.update(user);
    }
}
