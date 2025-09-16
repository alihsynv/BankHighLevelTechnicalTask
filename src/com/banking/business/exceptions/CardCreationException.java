package com.banking.business.exceptions;

import com.banking.core.exceptions.BaseException;

public class CardCreationException extends BaseException {
    public CardCreationException(String message) {
        super(message);
    }
}
