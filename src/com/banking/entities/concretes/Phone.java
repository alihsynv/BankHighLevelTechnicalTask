package com.banking.entities.concretes;

import com.banking.business.exceptions.InvalidPhoneNumberException;
import com.banking.entities.abstarcts.BaseEntity;

import java.util.Arrays;
import java.util.List;

public class Phone implements BaseEntity {
    private final String countryCode = "+994";
    private final String providerCode;
    private final String number;

    public Phone(String providerCode, String number) {
        this.providerCode = providerCode;
        this.number = number;
    }

    public static Phone create(String providerCode, String number) {
        List<String> validProvider = Arrays.asList("50", "51", "10", "99", "55", "77", "70", "60");

        if (!validProvider.contains(providerCode)) {
            throw new InvalidPhoneNumberException("Yanlış provider kodu");
        }
        if (number == null || number.length() != 7) {
            throw new InvalidPhoneNumberException("Nömrə 7 rəqəm olmalıdır");
        }

        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new InvalidPhoneNumberException("Nömrə yalnız rəqəmlərdən ibarət olmalıdır");
            }
        }
        return new Phone(providerCode, number);
    }


    public String getProviderCode() {
        return providerCode;
    }

    public String getNumber() {
        return number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public String toString() {
        return countryCode + providerCode + number;
    }
}
