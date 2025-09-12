package com.electronbank.domain.value;

public class Phone {
    private final String countryCode = "+994";
    private final String providerCode;
    private final String number;

    public Phone(String providerCode, String number) {
        this.providerCode = providerCode;
        this.number = number;
    }

    public String getProviderCode() { return providerCode; }
    public String getNumber() { return number; }
    public String getCountryCode() { return countryCode; }

    @Override
    public String toString() { return countryCode + providerCode + number; }
}
