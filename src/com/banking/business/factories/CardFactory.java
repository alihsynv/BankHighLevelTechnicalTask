package com.banking.business.factories;

import com.banking.business.exceptions.CreditCardCreationException;
import com.banking.entities.concretes.CreditCard;
import com.banking.entities.concretes.DebitCard;
import com.banking.entities.enums.CardType;
import com.banking.entities.enums.CreditCategory;

import java.time.LocalDate;
import java.util.Random;

public class CardFactory {
    private static final Random RANDOM = new Random();

    public static DebitCard createDebitCard(String cardName, String userFin) {
        return new DebitCard(
                generatePan(),
                cardName,
                CardType.DEBIT,
                generateCvc(),
                0.0,
                LocalDate.now().plusYears(2),
                false,
                userFin);
    }

    public static CreditCard createCreditCard(String cardName, String userFin, CreditCategory creditCategory, Double monthlyIncome) {
        return new CreditCard(
                generatePan(),
                cardName,
                CardType.CREDIT,
                generateCvc(),
                LocalDate.now().plusYears(2),
                false,
                userFin,
                creditCategory,
                calculateCreditLimit(creditCategory, monthlyIncome),
                monthlyIncome);
    }

    private static String generatePan() {
        StringBuilder pan = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            pan.append(RANDOM.nextInt(10));
        }
        return pan.toString();
    }

    private static String generateCvc() {
        int cvc = RANDOM.nextInt(1000);
        return String.format("%03d", cvc);
    }

    public static Double calculateCreditLimit(CreditCategory creditCategory, Double monthlyIncome) throws CreditCardCreationException {
        return switch (creditCategory) {
            case STUDENT, PENSIONER -> monthlyIncome * 2;
            case EMPLOYEE -> monthlyIncome * 4;
            case UNEMPLOYED -> throw new CreditCardCreationException("İşsiz üçün kredit kartı verilmir!");
        };
    }
}

