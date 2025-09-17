package com.banking.business.exceptions;

import com.banking.core.exceptions.BaseException;

public class CardNotFoundException extends BaseException {
    public CardNotFoundException(String message) {
        super(message);
    }
}
