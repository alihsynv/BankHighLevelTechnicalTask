package com.banking.exceptions.custom;

import com.banking.exceptions.BaseException;

public class CreditCardCreationException extends BaseException {
    public CreditCardCreationException(String message) {
        super(message);
    }
}
