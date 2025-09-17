package com.banking.business.exceptions;

import com.banking.core.exceptions.BaseException;

public class CreditCardCreationException extends BaseException {
    public CreditCardCreationException(String message) {
        super(message);
    }
}
