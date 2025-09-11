package com.electronbank.domain.value;

import com.electronbank.domain.exception.InvaliidPhoneNumberException;

import java.util.Arrays;
import java.util.List;

public class Phone {
    private final String countryCode;
    private final String providerCode;
    private final String number;

    public Phone(String providerCode, String number) {
        this.countryCode = "+994";
        this.providerCode = providerCode;
        this.number = number;
    }

    public static Phone create(String providerCode, String number) throws InvaliidPhoneNumberException {
        List<String> validProvider = Arrays.asList("50", "51", "10", "99", "55", "77", "70", "60");

        if (!validProvider.contains(providerCode)) {
            throw new InvaliidPhoneNumberException("Yanlış provider kodu");
        }
        if(number == null || number.length() != 7) {
            throw new InvaliidPhoneNumberException("Nömrə 7 rəqəm olmalıdır");
        }

        for (char c : number.toCharArray()) {
            if(!Character.isDigit(c)) {
                throw new InvaliidPhoneNumberException("Nömrə yalnız rəqəmlərdən ibarət olmalıdır");
            }
        }

        return new Phone(providerCode, number);
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getNumber() {
        return number;
    }

    public String getProviderCode() {
        return providerCode;
    }

    @Override
    public String toString() {
        return countryCode + providerCode + number;
    }
}
