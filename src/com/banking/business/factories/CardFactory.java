package com.banking.business.factories;

import com.banking.business.exceptions.CreditCardCreationException;
import com.banking.entities.concretes.Card;
import com.banking.entities.enums.CardType;
import com.banking.entities.enums.CreditCategory;

import java.time.LocalDate;
import java.util.Random;

public class CardFactory {
    private static final Random RANDOM = new Random();

    public static Card createDebitCard(String cardName) {
        String pan = generatePan();
        String cvc = generateCvc();
        return new Card(
                pan,
                cardName,
                CardType.DEBIT,
                cvc,
                0.0,
                LocalDate.now().plusYears(2),
                false,
                null) {
        };
    }

    public static Card createCreditCard(String cardName, CreditCategory creditCategory, Double monthlyIncome) {
        double limit = calculateCreditLimit(creditCategory, monthlyIncome);
        String pan = generatePan();
        String cvc = generateCvc();
        return new Card(
                pan,
                cardName,
                CardType.CREDIT,
                cvc,
                limit,
                LocalDate.now().plusYears(2),
                true,
                null) {
        };
    }

    private static String generatePan() {
        StringBuilder pan = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            pan.append(RANDOM.nextInt(10));
        }
        return pan.toString();
    }

    private static String generateCvc() {
        int cvc = RANDOM.nextInt(1000); // 0 - 999
        return String.format("%03d", cvc);
    }

    private static Double calculateCreditLimit(CreditCategory creditCategory, Double monthlyIncome) throws CreditCardCreationException {
        return switch (creditCategory) {
            case STUDENT, PENSIONER -> monthlyIncome * 2;
            case EMPLOYEE -> monthlyIncome * 4;
            case UNEMPLOYED -> throw new CreditCardCreationException("İşsiz üçün kredit kartı verilmir!");
        };
    }
}

